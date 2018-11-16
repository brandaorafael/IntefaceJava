package Estrutura;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private String password;
    private Map<String, Integer> carrinho;

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

    public Map<String, Integer> getCarrinho() {
        return carrinho;
    }

    public void limpaCarrinho(){
        carrinho = new HashMap<>();
    }

    public void addItemCarrinho(Produto produto, int quantidade){
        if(carrinho.containsKey(produto.getNome())){
            quantidade += carrinho.get(produto.getNome());
        }
            carrinho.put(produto.getNome(), quantidade);
    }

}
