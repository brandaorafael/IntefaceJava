package Telas;

import Estrutura.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.SwingConstants.LEADING;

public class Produto extends JPanel implements ActionListener {
    private JButton voltar;
    private JLabel nome;
    private JLabel preco;
    private JButton adicionar;
    private Estrutura.Produto produto;
    private JRadioButton qnt1;
    private JRadioButton qnt2;
    ButtonGroup group;

    public Produto(Estrutura.Produto produto){
        this.produto = produto;

        Box verticalBox = Box.createVerticalBox();    // vertical box

        voltar = new JButton("Voltar");

        ImageIcon imageIcon = new ImageIcon(Produto.class.getResource("./assets/" + produto.getImage()));
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back


        nome = new JLabel("Produto: " + produto.getNome(), imageIcon, LEADING);
        nome.setToolTipText("Clique para zoom");
        nome.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //Create and set up the window.
                JFrame frame = new JFrame("Imagem");

                JPanel panel = new JPanel();

                ImageIcon imc = new ImageIcon(Produto.class.getResource("./assets/" + produto.getImage()));
                Image im = imc.getImage(); // transform it
                Image newim = im.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                imc = new ImageIcon(newim);  // transform it back

                JLabel label = new JLabel(imc);
                panel.add(label);
                panel.setOpaque(true); //content panes must be opaque
                frame.setContentPane(panel);

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        preco = new JLabel("Preço: " + produto.getValor());
        adicionar = new JButton("Adicionar ao Carrinho");

        voltar.addActionListener(this);
        adicionar.addActionListener(this);

        qnt1 = new JRadioButton("1", true);
        qnt2 = new JRadioButton("2", false);

        group = new ButtonGroup();
        group.add(qnt1);
        group.add(qnt2);

        Box horizontalBox = Box.createHorizontalBox();

        horizontalBox.add(qnt1);
        horizontalBox.add(qnt2);

        verticalBox.add(voltar);
        verticalBox.add(nome);
        verticalBox.add(preco);
        verticalBox.add(horizontalBox);
        verticalBox.add(adicionar);

        add(verticalBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(voltar)) {
            Coordinator.goToHomeScreen();
        } else if (e.getSource().equals(adicionar)) {
            int quantidade = 0;
            if(qnt1.isSelected())
                quantidade = 1;
            else if (qnt2.isSelected()){
                quantidade = 2;
            }
            Coordinator.getLoggedUser().addItemCarrinho(produto, quantidade);

            Coordinator.goToHomeScreen();
        }
    }
}
