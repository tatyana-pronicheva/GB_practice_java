import clientpart.Client;
import serverpart.MyServer;

public class ServerApp {
    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                new MyServer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        }).start();

            new Client();
    }
}
