/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author siesiek
 */
public class User {
    private String name;
    private String login;
    private String password;
    private int id;
    private int deleted;
    
    public User(int id){
        this.id = id;
    }
    
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    
    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
    
    public void setName(String username){
        this.name = username;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    
    /**
     * Metoda "usuwajaca" z bazy uzytkownika, ustawia flage deleted na 1 i uaktualnia baze danych
     * @todo aktualizacja bazy danych
     */
    public void deleteUser(){
        this.deleted = 1;
    }
    
    public int getId(){
        return this.id;
    }
    
    /**
     * Metoda logowania uzytkownika
     * @todo wszystko co potrzebne do logowania i aktualizacja danych w bazie
     */
    public boolean loginUser() throws SQLException{
        Statement stat = Database.getConnection().createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM users WHERE login='"+this.login+"' AND deleted=0");
        if(result.next() && result.getString("password").equals(this.password)){
            this.name = result.getString("name");
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Metoda rejestracji uzytkownika
     * @todo warunek do execute
     */
    public boolean registerUser() throws SQLException{
       Statement stat = Database.getConnection().createStatement();
       boolean result = stat.execute("INSERT INTO users (name, login, password, deleted) VALUES ('"+this.name+"','"+this.login+"','"+this.password+"','0')");
       return true;     
    }
    
    /**
     * Metoda wczytujaca uzytkownika z bazy danych
     */
    public void loadUser(){
        
    }
    
    /**
     * Metoda zapisujaca nowe dane o uzytkowniku
     */
    public void saveUser(){
        
    }
}
