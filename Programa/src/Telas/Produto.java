package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Produto extends JPanel implements ActionListener {
    private JFrame frame;
    private JButton voltar;
    private JLabel nome;
    private JLabel preco;
    private JButton adicionar;
    private ArrayList<User> users;
    private Estrutura.Produto produto;
    private User user;

    public Produto(JFrame frame, User user, ArrayList<User> users, Estrutura.Produto produto){
        this.frame = frame;
        this.users = users;
        this.produto = produto;
        this.user = user;

        Box box = Box.createVerticalBox();    // vertical box

        voltar = new JButton("Voltar");
        nome = new JLabel("Produto: " + produto.getNome());
        preco = new JLabel("Preço: " + produto.getValor());
        adicionar = new JButton("Adicionar ao Carrinho");

        voltar.addActionListener(this);
        adicionar.addActionListener(this);

        box.add(voltar);
        box.add(nome);
        box.add(preco);
        box.add(adicionar);

        add(box);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(voltar)) {
            try {
                Home home = new Home(frame, user, users);
                home.setOpaque(true); //content panes must be opaque
                frame.setContentPane(home);
                frame.pack();
                frame.setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource().equals(adicionar)) {
            try {
                Home home = new Home(frame, user, users);
                home.setOpaque(true); //content panes must be opaque
                frame.setContentPane(home);
                frame.pack();
                frame.setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
