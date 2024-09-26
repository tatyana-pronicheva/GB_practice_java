package clientpart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class Client {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    boolean authorized;
    AuthUI authUI;
    ChatUI chatUI;

    void setAuthorized(boolean b){
        authorized = b;
    }

    public Client(){
        try {
        socket = new Socket("localhost", 8189);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        authUI = new AuthUI(createAuthButtonListener());
        setAuthorized(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if(strFromServer.startsWith("/authok")) {
                            setAuthorized(true);
                            authUI.dispose();
                            chatUI = new ChatUI(createSendButtonListener());
                            break;
                        }
                        if(strFromServer.startsWith("/end")) {
                            authUI.dispose();
                        }
                        authUI.appendText(strFromServer);
                    }
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        chatUI.addMessage(strFromServer);
                    }
                } catch (EOFException e) {
                    System.out.println("DataInputStream закрыт");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    } catch (IOException e) {
        e.printStackTrace();
    }}


    private void onAuthClick() {
        try {
            out.writeUTF("/auth " + authUI.getLogin() + " " + authUI.getPassword());
            authUI.clearLoginField();
            authUI.clearPasswordField();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ActionListener createAuthButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAuthClick();
            }
        };
    }
        private ActionListener createSendButtonListener(){
            return new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        out.writeUTF(chatUI.getNewMessage());
                        if (chatUI.getNewMessage().equals("/end")){
                            chatUI.dispose();
                        }
                        chatUI.clearInputField();
                    }
                    catch(IOException io){
                        io.printStackTrace();
                    }
                }
            };
        }

    }

