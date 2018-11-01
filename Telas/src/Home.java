import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel implements ActionListener {

    private JButton signup;
    private JButton login;

    public Home(){
        signup = new JButton("Registrar");
        login = new JButton("Logar");

        add(signup);
        add(login);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
