import Estrutura.User;
import Telas.Initial;

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
            Initial initial = new Initial(frame, users);
            initial.setOpaque(true); //content panes must be opaque
            frame.setContentPane(initial);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
