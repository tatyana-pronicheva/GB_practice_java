
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Console console;

    public Server() {
        try {
            openConnection();
            console = new Console("Server",1200,300,createConsoleListener());
            subscribeOnMessages();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void openConnection() throws IOException{
        Socket socket = null;
        ServerSocket serverSocket = new ServerSocket(8889);
        socket = serverSocket.accept();
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    private void subscribeOnMessages(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String message = inputStream.readUTF();
                        console.addMessage("Клиент: "+message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private ActionListener createConsoleListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    outputStream.writeUTF(console.getNewMessage());
                    console.addMessage("Вы написали: "+ console.getNewMessage());
                    console.clearInputField();
                }
                catch(IOException io){
                  io.printStackTrace();
                }
            }
        };
    }

}

