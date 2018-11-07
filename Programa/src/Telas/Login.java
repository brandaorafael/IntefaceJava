package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends JPanel implements ActionListener {

    private JFrame frame;
    private JButton voltar;
    private JLabel usernameL;
    private JTextField usernameTF;
    private JLabel passwordL;
    private JPasswordField passwordTF;
    private JButton logar;
    ArrayList<User> users;

    public Login(JFrame frame, ArrayList<User> users){
        this.frame = frame;
        this.users = users;

        Box box = Box.createVerticalBox();    // vertical box

        voltar = new JButton("Voltar");
        usernameL = new JLabel("Username");
        usernameTF = new JTextField();
        passwordL = new JLabel("Senha");
        passwordTF = new JPasswordField();
        logar = new JButton("Logar");

        voltar.addActionListener(this);
        logar.addActionListener(this);

        box.add(voltar);
        box.add(usernameL);
        box.add(usernameTF);
        box.add(passwordL);
        box.add(passwordTF);
        box.add(logar);

        add(box);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(voltar)) {
            Initial initial = new Initial(frame, users);
            initial.setOpaque(true); //content panes must be opaque
            frame.setContentPane(initial);
            frame.pack();
            frame.setVisible(true);
        } else if(e.getSource().equals(logar) && !usernameTF.getText().isEmpty() && passwordTF.getPassword().length > 0){
            User user = User.login(users,usernameTF.getText(), new String(passwordTF.getPassword()));
            if(user != null){
                Home home = null;
                try {
                    home = new Home(frame, user, users);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                home.setOpaque(true); //content panes must be opaque
                frame.setContentPane(home);
                frame.pack();
                frame.setVisible(true);
            }
        }
    }
}
