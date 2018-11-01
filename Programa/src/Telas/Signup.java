package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Signup extends JPanel implements ActionListener {

    private JFrame frame;
    private JButton voltar;
    private JLabel usernameL;
    private JTextField usernameTF;
    private JLabel passwordL;
    private JPasswordField passwordTF;
    private JButton cadastrar;
    ArrayList<User> users;

    public Signup(JFrame frame, ArrayList<User> users){
        this.frame = frame;
        this.users = users;

        Box box = Box.createVerticalBox();    // vertical box

        voltar = new JButton("Voltar");
        usernameL = new JLabel("Username");
        usernameTF = new JTextField();
        passwordL = new JLabel("Senha");
        passwordTF = new JPasswordField();
        cadastrar = new JButton("Cadastrar");

        voltar.addActionListener(this);
        cadastrar.addActionListener(this);

        box.add(voltar);
        box.add(usernameL);
        box.add(usernameTF);
        box.add(passwordL);
        box.add(passwordTF);
        box.add(cadastrar);

        add(box);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean aux = false;

        if (e.getSource().equals(voltar)) {
            aux = true;
        } else if(e.getSource().equals(cadastrar) && !usernameTF.getText().isEmpty() && !passwordTF.getPassword().toString().isEmpty()){
            users.add(new User(usernameTF.getText(), passwordTF.getPassword().toString()));
            System.out.println("Estrutura.User: " + usernameTF.getText());
            frame.remove(this);
            aux = true;
        }

        if(aux){
            Home home = new Home(frame, users);
            home.setOpaque(true); //content panes must be opaque
            frame.setContentPane(home);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
