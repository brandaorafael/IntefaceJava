import Estrutura.User;
import Telas.Initial;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa {
    public static void main(String[] args) throws IOException {
        javax.swing.SwingUtilities.invokeLater(() -> {

            ArrayList<User> users = new ArrayList<>();

            String filename = "/Users/rafaelbrandao/Documents/Projetos/IntefaceJava/Programa/src/usuarios.txt";

            try {
                FileReader fileReader = new FileReader(filename);

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                List<String> lines = new ArrayList<>();
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    lines.add(line);
                }

                bufferedReader.close();

                for(String l:lines){
                    List<String> words = Arrays.asList(l.split(","));

                    users.add(new User(words.get(0), words.get(1)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


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
