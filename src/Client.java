import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Console console;

    public Client(){
        try {
            openConnection();
            console = new Console("Client",600,300,createConsoleListener());
            subscribeOnMessages();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void openConnection() throws IOException{
            Socket socket = new Socket("localhost", 8889);
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
                        console.addMessage("Сервер: "+message);
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


