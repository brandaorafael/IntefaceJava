package Telas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JPanel implements ActionListener {

    private JFrame frame;
    private JButton voltar;
    private JLabel usernameL;
    private JTextField usernameTF;
    private JLabel passwordL;
    private JPasswordField passwordTF;
    private JButton logar;

    public Login(JFrame frame){
        this.frame = frame;

        Box box = Box.createVerticalBox();    // vertical box

        voltar = new JButton("Voltar");
        usernameL = new JLabel("Username");
        usernameTF = new JTextField();
        passwordL = new JLabel("Senha");
        passwordTF = new JPasswordField();
        logar = new JButton("Logar");

        voltar.addActionListener(e -> Coordinator.goToInitialScreen());
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
        if(e.getSource().equals(logar) && !usernameTF.getText().isEmpty() && passwordTF.getPassword().length > 0){
            try {
                Coordinator.login(usernameTF.getText(), new String(passwordTF.getPassword()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
