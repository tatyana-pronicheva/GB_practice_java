import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Console  extends JFrame {
    private JTextArea chatArea;
    private JTextField msgInputField;

    public Console(String title, int x, int y, ActionListener listener) {
        // Параметры окна

        setBounds(x, y, 500, 500);
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        btnSendMsg.addActionListener(listener);
        msgInputField.addActionListener(listener);
        setVisible(true);
    }

    public void addMessage(String message){
        chatArea.setText(chatArea.getText()+"\n"+message);
    }
    public String getNewMessage(){
        return msgInputField.getText();
    }
    public void clearInputField(){
        msgInputField.setText("");
    }
}
