package serverpart;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {
    private final int PORT = 8189;

    private List<ClientHandler> clients;
    private BaseAuthService authService;
    private DatabaseReader dbReader;

    public BaseAuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            dbReader = new DatabaseReader();
            dbReader.start();
            authService = new BaseAuthService(dbReader);
            authService.start();
            ExecutorService service = Executors.newCachedThreadPool();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                service.execute(()-> new ClientHandler(this, socket,120000));
            }
        } catch (IOException e) {
            System.out.println("Ошибка в работе сервера");
        } finally {
            if (authService != null) {
                authService.stop();
            }
            dbReader.stop();
        }
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void broadcastMsg(String msg, ClientHandler from) {
        for (ClientHandler o : clients) {
            if (o.getName() != from.getName()){o.sendMsg(from.getName() + ": " + msg);}
        }
        from.sendMsg("Вы написали: " + msg);
    }
    public synchronized void authMsg(ClientHandler from) {
        for (ClientHandler o : clients) {
            if (o.getName() != from.getName()){o.sendMsg(from.getName() + " зашел в чат");}
        }
    }
    public synchronized void logoutMsg(ClientHandler from) {
        for (ClientHandler o : clients) {
            if (o.getName() != from.getName()){o.sendMsg(from.getName() + " вышел из чата");}
        }
    }
    public synchronized void privateMsg(String msg, String nickTo, ClientHandler from){
        if (nickTo.equals(from.getName())){
            from.sendMsg("Вы не можете отправить личное сообщение себе");
            return;
        }
        for (ClientHandler o : clients) {
            if (o.getName().equals(nickTo)){
                o.sendMsg("Личное сообщение от " + from.getName() + ": " +msg);
                from.sendMsg("Клиенту " + nickTo + ": " + msg);
                return;
             }
        }
        from.sendMsg("Участника с ником " + nickTo + " нет в чат-комнате");
    }

    public synchronized void unsubscribe(ClientHandler o) {
        clients.remove(o);
    }

    public synchronized void subscribe(ClientHandler o) {
        clients.add(o);
    }
}

