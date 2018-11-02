package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Initial extends JPanel implements ActionListener {

    private JButton signupButton;
    private JButton loginButton;
    private JFrame frame;
    ArrayList<User> users;

    public Initial(JFrame frame, ArrayList<User> users){

        this.frame = frame;
        this.users = users;

        signupButton = new JButton("Registrar");
        loginButton = new JButton("Logar");

        signupButton.addActionListener(this);
        loginButton.addActionListener(this);

        add(signupButton);
        add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginButton)) {
            Login login = new Login(frame, users);
            login.setOpaque(true); //content panes must be opaque
            frame.remove(this);
            frame.setContentPane(login);
            frame.pack();
            frame.setVisible(true);
        } else if (e.getSource().equals(signupButton)) {
            Signup signup = new Signup(frame, users);
            signup.setOpaque(true); //content panes must be opaque
            frame.remove(this);
            frame.setContentPane(signup);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
