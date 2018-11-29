import Estrutura.User;
import Telas.Coordinator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ArrayList<User> users = new ArrayList<>();

            String filename = new File("").getAbsolutePath() + "/Programa/src/usuarios.txt";

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

            Coordinator.start(users);

        });
    }
}
