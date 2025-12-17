/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;

/**
 *
 * @author 'USER'
 */
public abstract class User {
    protected int id;
    protected String username;
    protected String email;
    protected String passwordHash;
    protected boolean aktif;
    protected LocalDateTime createdAt;

    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.aktif = true;
        this.createdAt = LocalDateTime.now();
    }

    public boolean login(String passwordInput) {
        return passwordHash.equals(passwordInput);
    }

    public String getRole() {
        return "USER";
    }
}
