package serverpart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    final Logger LOGGER_CLIENTHANDLER = LogManager.getLogger(ClientHandler.class);

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
                authentication();
                readMessages();
        } catch (IOException e) {
            LOGGER_CLIENTHANDLER.debug("Обработчик клиента закрыт");
            closeConnection();
        }
    }

    private void timeoutChecker(int timeout) {
        new Thread(() -> {
            LOGGER_CLIENTHANDLER.debug("Отсчет таймаута авторизации начался");
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
                LOGGER_CLIENTHANDLER.debug(e);
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
                        LOGGER_CLIENTHANDLER.debug("Попытка авторизации на занятую учетку");
                        sendMsg("Учетная запись уже используется");
                    }
                } else {
                    LOGGER_CLIENTHANDLER.debug("Попытка авторизации с неверным логпассом");
                    sendMsg("Неверные логин/пароль");
                }
            }

        }
    }

    public void readMessages() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            if (strFromClient.equals("/end")) {
                LOGGER_CLIENTHANDLER.debug("Клиент "+name+" прислал команду "  + strFromClient);
                return;
            }
            if (strFromClient.startsWith("/w")) {
                String[] parts = strFromClient.split("\\s",3);
                myServer.privateMsg( parts[2], parts[1], this);
                LOGGER_CLIENTHANDLER.debug("Клиент "+name+" прислал личное сообщение " + strFromClient);
            } else {
                myServer.broadcastMsg(strFromClient, this);
                LOGGER_CLIENTHANDLER.debug("Клиент "+name+" прислал сообщение " + strFromClient);
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            LOGGER_CLIENTHANDLER.debug("Ошибка при отправке сообщения клиенту "+e);
        }
    }

    public void closeConnection() {
        if (!socket.isClosed()){sendMsg("/end");}
        myServer.unsubscribe(this);
        if (clientIsAuthorized) myServer.logoutMsg(this);
        try {
            in.close();
        } catch (IOException e) {
            LOGGER_CLIENTHANDLER.debug("Ошибка при закрытии DataInputStream" + e);
        }
        try {
            out.close();
        } catch (IOException e) {
            LOGGER_CLIENTHANDLER.debug("Ошибка при закрытии DataOutputStream" + e);
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER_CLIENTHANDLER.debug("Ошибка при закрытии сокета, к которому подключен клиент" + e);
        }
    }
}
