package Telas;

import Estrutura.Produto;
import Estrutura.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Coordinator implements ActionListener {
    private static Coordinator instance;

    JMenuItem ver;
    JMenuItem limpar;
    JMenuItem logout;

    private JFrame frame;
    private static ArrayList<User> users;
    private static User loggedUser;
    private ArrayList<Produto> produtos;

    private Coordinator(ArrayList<User> users){
        this.users = users;
        frame = new JFrame("Lojinha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu carrinhoMenu = new JMenu("Carrinho");

        ver = new JMenuItem("Ver");
        ver.addActionListener(this);

        limpar = new JMenuItem("Limpar");
        limpar.addActionListener(this);

        carrinhoMenu.add(ver);
        carrinhoMenu.addSeparator();
        carrinhoMenu.add(limpar);

        JMenu perfilMenu = new JMenu("Perfil");

        logout = new JMenuItem("Logout");
        logout.addActionListener(e -> Coordinator.logout());

        perfilMenu.add(logout);

        menuBar.add(carrinhoMenu);
        menuBar.add(perfilMenu);

        Initial initial = new Initial();
        initial.setOpaque(true);
        frame.setContentPane(initial);

        frame.setVisible(true);
        frame.setSize( 300, 300 );
    }

    public static void start(ArrayList<User> users){
        instance = new Coordinator(users);
    }

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
                String filename = new File("").getAbsolutePath() + "/Programa/src/produtos.txt";

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
        String fileName = new File("").getAbsolutePath() +  "/Programa/src/usuarios.txt";
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Coordinator.loggedUser != null){
            if(e.getSource().equals(ver)) {
                String prods = "";
                for (Map.Entry<String, Integer> c : loggedUser.getCarrinho().entrySet())
                {
                    prods += (c.getKey() + ": " + c.getValue() + "\n");
                }
                if(prods.equals("")){
                    prods = "Você ainda não possui produtos no carrinho!";
                }
                JOptionPane.showMessageDialog(null, prods, "Carrinho", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource().equals(limpar)){
                loggedUser.limpaCarrinho();
            }
        } else {
            Coordinator.goToLoginScren();
        }
    }
}
