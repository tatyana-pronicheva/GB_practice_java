package clientpart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AuthUI extends JFrame {

    private JTextField loginField;
    private JTextField passwordField;
    private JLabel serverMessage;
            
    public AuthUI(ActionListener authButtonlistner){
        // Параметры окна
        setBounds(600, 300, 400, 400);
        setTitle("Окно авторизации");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box,BoxLayout.X_AXIS));
        box.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        add(box);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(6, 1, 5, 12));
        box.add(grid, BorderLayout.CENTER);

        JLabel loginLabel = new JLabel();
        loginLabel.setText("login:");
        grid.add(loginLabel);
        loginField = new JTextField();
        grid.add(loginField);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("password:");
        grid.add(passwordLabel);
        passwordField = new JPasswordField();
        grid.add(passwordField);

        JButton loginButton = new JButton();
        loginButton.setText("Log in");
        grid.add(loginButton);
        serverMessage = new JLabel();
        grid.add(serverMessage);

        loginButton.addActionListener(authButtonlistner);

        setVisible(true);
    }
    public void appendText(String str){
        serverMessage.setText(str);
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }
    public void clearLoginField(){
        loginField.setText("");
    }
    public void clearPasswordField(){
        passwordField.setText("");
    }


}
