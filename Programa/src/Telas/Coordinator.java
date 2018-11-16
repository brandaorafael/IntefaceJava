package Telas;

import Estrutura.Produto;
import Estrutura.User;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coordinator {
    private static Coordinator instance;

    private JFrame frame;
    private static ArrayList<User> users;
    private static User loggedUser;
    private ArrayList<Produto> produtos;

    private Coordinator(ArrayList<User> users){
        this.users = users;
        frame = new JFrame("Lojinha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Initial initial = new Initial();
        initial.setOpaque(true);
        frame.setContentPane(initial);

        frame.pack();
        frame.setVisible(true);
        frame.setSize( 300, 300 );
    }

    public static void start(ArrayList<User> users){
        instance = new Coordinator(users);
    }

//    public static Coordinator getInstance(){
//        if(instance == null){
//            instance = new Coordinator(new ArrayList<>());
//        }
//        return instance;
//    }


    public static User getLoggedUser() {
        return instance.loggedUser;
    }

    public static ArrayList<Produto> getProdutos() {
        return instance.produtos;
    }

    public static void login(String name, String password) throws IOException {
        for(User user : users){
            if(user.getUsername().equals(name) && user.getPassword().equals(password)){
                loggedUser = user;
                String filename = "/Users/rafaelbrandao/Documents/Projetos/IntefaceJava/Programa/src/produtos.txt";

                FileReader fileReader = new FileReader(filename);

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                List<String> lines = new ArrayList<>();
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    lines.add(line);
                }

                bufferedReader.close();

                instance.produtos = new ArrayList<>();

                for(String l:lines){
                    List<String> words = Arrays.asList(l.split(","));

                    instance.produtos.add(new Produto(words.get(0), Double.parseDouble(words.get(1)), words.get(2)));
                }

                goToHomeScreen();
            }
        }
    }

    public static void logout() {
        loggedUser = null;
        goToInitialScreen();
    }

    public static void signup(String name, String password) throws IOException {
        String fileName = "/Users/rafaelbrandao/Documents/Projetos/IntefaceJava/Programa/src/usuarios.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append("\n"+name+","+password);
        writer.close();
        users.add(new User(name, password));
        goToInitialScreen();
    }

    public static void goToSignupScreen() {
        Signup signup = new Signup();
        instance.goTo(signup);
    }

    public static void goToHomeScreen() {
        Home home = new Home();
        instance.goTo(home);
    }

    public static void goToLoginScren(){
        Login login = new Login(new JFrame());
        instance.goTo(login);
    }

    public static void goToInitialScreen(){
        Initial initial = new Initial();
        instance.goTo(initial);
    }

    public static void goToProdutoScreen(Estrutura.Produto produto){
        Telas.Produto produtoScreen = new Telas.Produto(produto);
        instance.goTo(produtoScreen);
    }

    private void goTo(JPanel panel){
        frame.setContentPane(panel);
        frame.invalidate();
        frame.validate();
    }
}