import javax.swing.*;

public class Programa {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            //Create and set up the window.
            JFrame frame = new JFrame("ButtonDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Create and set up the content pane.
            Home home = new Home();
            home.setOpaque(true); //content panes must be opaque
            frame.setContentPane(home);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        });
    }
}
