package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends JPanel implements ActionListener {
    private JFrame frame;
    private JLabel l;
    private JButton deslogar;
    private User user;
    private ArrayList<User> users;

    public Home(JFrame frame, User user, ArrayList<User> users){
        this.frame = frame;
        this.user = user;
        this.users = users;

        Box box = Box.createVerticalBox();    // vertical box

        l = new JLabel(user.getUsername() + ", você está logado!");
        deslogar = new JButton("Deslogar");

        deslogar.addActionListener(this);

        box.add(l);
        box.add(deslogar);

        add(box);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(deslogar)) {
            Initial initial = new Initial(frame, users);
            initial.setOpaque(true); //content panes must be opaque
            frame.setContentPane(initial);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
