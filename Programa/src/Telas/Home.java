package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Home extends JPanel implements ActionListener {

    private JButton signup;
    private JButton login;
    private JFrame frame;
    ArrayList<User> users;

    public Home(JFrame frame, ArrayList<User> users){

        this.frame = frame;
        this.users = users;

        signup = new JButton("Registrar");
        login = new JButton("Logar");

        signup.addActionListener(this);
        login.addActionListener(this);

        add(signup);
        add(login);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Signup signup = new Signup(frame, users);
        signup.setOpaque(true); //content panes must be opaque
        frame.remove(this);
        frame.setContentPane(signup);
        frame.pack();
        frame.setVisible(true);
    }
}
