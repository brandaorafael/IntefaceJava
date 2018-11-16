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

    private JButton voltar;
    private JLabel usernameL;
    private JTextField usernameTF;
    private JLabel passwordL;
    private JPasswordField passwordTF;
    private JButton cadastrar;

    public Signup(){

        Box box = Box.createVerticalBox();    // vertical box

        voltar = new JButton("Voltar");
        usernameL = new JLabel("Username");
        usernameTF = new JTextField();
        passwordL = new JLabel("Senha");
        passwordTF = new JPasswordField();
        cadastrar = new JButton("Cadastrar");

        voltar.addActionListener(e -> Coordinator.goToInitialScreen());
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
        if(e.getSource().equals(cadastrar)){
            if (!usernameTF.getText().isEmpty() && passwordTF.getPassword().length > 0){
                try {
                    Coordinator.signup(usernameTF.getText(), new String(passwordTF.getPassword()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor coloque um usuário e uma senha!");
            }
        }
    }
}
