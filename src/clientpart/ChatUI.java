package clientpart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

public class ChatUI extends JFrame {
    private JTextArea chatArea;
    private JTextField msgInputField;

    public ChatUI(ActionListener sendButtonListener, WindowAdapter windowAdapter){
    // Параметры окна
    setBounds(300,400, 500, 500);
    setTitle("Чат");
    this.addWindowListener(windowAdapter);

    // Текстовое поле для вывода сообщений
    chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
    add(new JScrollPane(chatArea), BorderLayout.CENTER);

    // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
    JPanel bottomPanel = new JPanel(new BorderLayout());
    JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(sendButtonListener);
        msgInputField.addActionListener(sendButtonListener);
    setVisible(true);

    }
    public void addMessage(String message){
        chatArea.setText(chatArea.getText() + message + "\n");
    }
    public String getNewMessage(){
        return msgInputField.getText();
    }
    public void clearInputField(){
        msgInputField.setText("");
    }

    public void addMessages(ArrayList<String> messagesArray){
        String messagesText = "";
        for (String message : messagesArray) {
            messagesText= messagesText + message + "\n";
        }
        chatArea.setText(messagesText);
    }
    public String[] getAllMessages(){
        String[] messages = chatArea.getText().split("\\n");
        return messages;
    }
}
