package Telas;

import Estrutura.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends JPanel implements ActionListener {
    private JLabel l;
    private JButton selecionar;
    private JButton deslogar;
    private JComboBox<Produto> comboBox;
    private ArrayList<Produto> produtos;

    public Home() {

        Box box = Box.createVerticalBox();    // vertical box

        produtos = Coordinator.getProdutos();

        comboBox = new JComboBox<>();

        comboBox.setModel(new DefaultComboBoxModel(produtos.toArray()));

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
            Coordinator.logout();
        } else if (e.getSource().equals(selecionar)){
            Coordinator.goToProdutoScreen((Produto)comboBox.getSelectedItem());
//            Telas.Produto produto = new Telas.Produto(frame, user, users, (Produto)comboBox.getSelectedItem());
//            produto.setOpaque(true); //content panes must be opaque
//            frame.setContentPane(produto);
//            frame.pack();
//            frame.setVisible(true);
        }
    }
}
