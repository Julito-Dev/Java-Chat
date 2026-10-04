package ui;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.*;


public class ChatWindow {
    public static void main(String[] args) {
        
        //main window
        JFrame window = new JFrame();
        

        window.setSize(800,600);
        window.setLocationRelativeTo(null);
        window.setTitle("Basic Chat");
        window.setLayout(new BorderLayout(3,3));;
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        // Title

        JPanel titleContainer = new JPanel();
        JLabel title = new JLabel("Chat Window");
        title.setAlignmentX(JLabel.CENTER);
        titleContainer.add(title);
        window.add(titleContainer, BorderLayout.NORTH);
        

        // Text Area

        JTextArea textBox = new JTextArea("Hello");
        textBox.setEditable(false);
        JScrollPane scroll = new JScrollPane(textBox);
        window.add(scroll, BorderLayout.CENTER);


        //Insert text area

        JPanel textArea = new JPanel();
        textArea.setLayout(new BorderLayout(3,3));

        JTextField chatBar = new JTextField("Enter Message");
        chatBar.setAlignmentX(JTextField.CENTER_ALIGNMENT);

        chatBar.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (chatBar.getText().equals("Enter Message")) {
                chatBar.setText("");
                }
            }
        });

        JButton sendButton = new JButton("Send");

        textArea.add(chatBar, BorderLayout.CENTER);
        textArea.add(sendButton, BorderLayout.EAST);
        window.add(textArea, BorderLayout.SOUTH);

        window.setVisible(true);

    }
}


