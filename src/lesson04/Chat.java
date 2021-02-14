package lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Chat extends JFrame{

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_POSITION_X = 650;
    private static final int WINDOW_POSITION_Y = 250;

    JPanel jPanelChat = new JPanel(new GridLayout());
    JPanel jPanelSendMessage = new JPanel(new GridLayout());

    JButton jButton = new JButton("Отправить");

    JTextArea jTextArea = new JTextArea();
    JScrollPane jScrollPane = new JScrollPane(jTextArea);
    JTextField jTextField = new JTextField();

    Chat() {
        super("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSITION_X, WINDOW_POSITION_Y);

        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);

        jButton.addActionListener(e -> {
            sendMessage();
        });

        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });

        jPanelChat.add(jScrollPane);
        jPanelSendMessage.add(jTextField);
        jPanelSendMessage.add(jButton);

        add(jPanelChat);
        add("South", jPanelSendMessage);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void sendMessage() {
        String out = jTextField.getText();
        jTextArea.append(out + "\n");
        jTextField.setText("");
        jTextField.grabFocus();
    }

}
