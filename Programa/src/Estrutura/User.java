package Estrutura;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
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

}
