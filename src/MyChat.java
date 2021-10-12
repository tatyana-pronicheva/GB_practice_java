import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyChat extends JFrame {
    public MyChat(){
        setTitle("MyChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,600,600);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        add(jPanel);
        jPanel.setBackground(Color.CYAN);

        JLabel label1 = new JLabel("Введите сообщение для отправки");
        label1.setBounds(100,50,300,10);
        jPanel.add(label1);

        JTextField input = new JTextField();
        input.setBounds(100,75,300,100);
        jPanel.add(input);

        JLabel label2 = new JLabel("Последнее отправленное сообщение");
        label2.setBounds(100,325,300,10);
        jPanel.add(label2);

        JTextField output = new JTextField();
        output.setBounds(100,350,300,100);
        jPanel.add(output);
        output.disable();


        JButton jButton = new JButton("Отправить сообщение");
        jButton.setBounds(100,225,300,50);
        jPanel.add(jButton);
    jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        output.setText(input.getText());
        input.setText("");
        }
    });

        setVisible(true);
    }
}
