import Estrutura.User;
import Telas.Home;

import javax.swing.*;
import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {

            ArrayList<User> users = new ArrayList<>();


            //Create and set up the window.
            JFrame frame = new JFrame("Lojinha");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create and set up the content pane.
            Home home = new Home(frame, users);
            home.setOpaque(true); //content panes must be opaque
            frame.setContentPane(home);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        });
    }
}
