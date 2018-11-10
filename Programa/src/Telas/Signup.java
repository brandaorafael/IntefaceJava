package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        if (e.getSource().equals(voltar)) {
            goToInitial();
        } else if(e.getSource().equals(cadastrar)){
            if (!usernameTF.getText().isEmpty() && passwordTF.getPassword().length > 0){
                try {
                    String fileName = "/Users/rafaelbrandao/Documents/Projetos/IntefaceJava/Programa/src/usuarios.txt";
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                    writer.append("\n"+usernameTF.getText()+","+new String(passwordTF.getPassword()));
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                users.add(new User(usernameTF.getText(), new String(passwordTF.getPassword())));
                frame.remove(this);
                goToInitial();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor coloque um usuário e uma senha!");
            }
        }
    }

    public void goToInitial(){
        Initial initial = new Initial(frame, users);
        initial.setOpaque(true); //content panes must be opaque
        frame.setContentPane(initial);
        frame.pack();
        frame.setVisible(true);
    }
}
