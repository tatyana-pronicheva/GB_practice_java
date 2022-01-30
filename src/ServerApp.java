import clientpart.Client;
import serverpart.MyServer;

public class ServerApp {
    public static void main(String[] args){

        //task1
        ABCThreads abcThreads = new ABCThreads();
        Thread thread1 = new Thread(() -> {
            abcThreads.printLetter('A','B');
        });
        Thread thread2 = new Thread(() -> {
            abcThreads.printLetter('B','C');
        });
        Thread thread3 = new Thread(() -> {
            abcThreads.printLetter('C','A');
        });
        thread1.start();
        thread3.start();
        thread2.start();


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
