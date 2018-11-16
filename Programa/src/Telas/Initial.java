package Telas;

import javax.swing.*;


public class Initial extends JPanel {

    private JButton signupButton;
    private JButton loginButton;

    public Initial(){

        signupButton = new JButton("Registrar");
        loginButton = new JButton("Logar");

        loginButton.addActionListener(e -> Coordinator.goToLoginScren());
        signupButton.addActionListener(e -> Coordinator.goToSignupScreen());

        add(signupButton);
        add(loginButton);
    }
}
