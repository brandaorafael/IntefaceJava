package Telas;

import Estrutura.Produto;
import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends JPanel implements ActionListener {
    private JFrame frame;
    private JLabel l;
    private JButton selecionar;
    private JButton deslogar;
    private User user;
    private ArrayList<User> users;
    private ArrayList<Produto> produtos;
    private JComboBox<Produto> comboBox;

    public Home(JFrame frame, User user, ArrayList<User> users) throws IOException {
        this.frame = frame;
        this.user = user;
        this.users = users;

        Box box = Box.createVerticalBox();    // vertical box

        // The text file location of your choice
        String filename = "/Users/rafaelbrandao/Documents/Projetos/IntefaceJava/Programa/src/produtos.txt";

        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            lines.add(line);
        }

        bufferedReader.close();

        produtos = new ArrayList<>();

        for(String l:lines){
            List<String> words = Arrays.asList(l.split(","));

            produtos.add(new Produto(words.get(0),Double.parseDouble(words.get(1))));
        }

        comboBox = new JComboBox<>();

        comboBox.setModel(new DefaultComboBoxModel(produtos.toArray()));

        comboBox.addActionListener(this);

        l = new JLabel("Selecione um produto");
        selecionar = new JButton("Selecionar");
        deslogar = new JButton("Deslogar");

        selecionar.addActionListener(this);
        deslogar.addActionListener(this);

        box.add(l);
        box.add(comboBox);
        box.add(selecionar);
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
        } else if (e.getSource().equals(selecionar)){
            Telas.Produto produto = new Telas.Produto(frame, user, users, (Produto)comboBox.getSelectedItem());
            produto.setOpaque(true); //content panes must be opaque
            frame.setContentPane(produto);
            frame.pack();
            frame.setVisible(true);
        }
    }
}
