package serverpart;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String name;
    boolean clientIsAuthorized;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket, int timeout) {
       timeoutChecker(timeout);

        try{
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    private void timeoutChecker(int timeout) {
        new Thread(() -> {
            System.out.println("Отсчет таймаута начался");
            try {
                long startTime = System.currentTimeMillis();
                while (true) {
                    if (clientIsAuthorized) {
                        break;
                    }
                    long deltaTime = System.currentTimeMillis() - startTime;
                    if (deltaTime > timeout && !clientIsAuthorized) {
                        throw new RuntimeException("Клиент не успел авторизоваться, соединение разорвано");
                    }
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                closeConnection();
            }
        }).start();
        }


    public void authentication() throws IOException {

        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                    String[] parts = str.split("\\s");
                String nick = myServer.getAuthService().getNickByLoginPass(parts[1], parts[2]);
                if (nick != null) {
                    if (!myServer.isNickBusy(nick)) {
                        sendMsg("/authok " );
                        name = nick;
                        myServer.authMsg(this);
                        myServer.subscribe(this);
                        clientIsAuthorized = true;
                        return;
                    } else {
                        sendMsg("Учетная запись уже используется");
                    }
                } else {
                    sendMsg("Неверные логин/пароль");
                }
            }
        }
    }

    public void readMessages() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            if (strFromClient.equals("/end")) {
                return;
            }
            if (strFromClient.startsWith("/w")) {
                String[] parts = strFromClient.split("\\s",3);
                myServer.privateMsg( parts[2], parts[1], this);
            } else {
                myServer.broadcastMsg(strFromClient, this);
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        sendMsg("/end");
        myServer.unsubscribe(this);
        if (clientIsAuthorized) myServer.logoutMsg(this);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
