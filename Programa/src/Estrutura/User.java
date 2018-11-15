package Estrutura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private String password;
    private Map<String, Integer> carrinho;
//    private ArrayList<Carrinho> carrinho;


    public User(String username, String password) {
        carrinho = new HashMap<>();

        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    static public User login (ArrayList<User> users, String userName, String psswrd){
        for(User user : users){
            if(user.getUsername().equals(userName) && user.getPassword().equals(psswrd)){
                return user;
            }
        }
        return null;
    }

    public void addItemCarrinho(Produto produto, int quantidade){
        if(carrinho.containsKey(produto.getNome())){
            quantidade += carrinho.get(produto.getNome());
        }
            carrinho.put(produto.getNome(), quantidade);
    }

}
