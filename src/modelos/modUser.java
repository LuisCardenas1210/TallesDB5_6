/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
/**
 *
 * @author jovan
 */
public class modUser {
    private static modUser instance;
    private String userId;
    private String username;
    private String lastName;
    private String password;

    public modUser() {
    }
    
    public static modUser getInstance() {
        if (instance == null) {
            instance = new modUser(); // Crea la instancia solo cuando se necesita
        }
        return instance;
    }
    
    
    public modUser(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public void clearSession() {
        username = null;
        lastName = null;
        password = null;
    }
}