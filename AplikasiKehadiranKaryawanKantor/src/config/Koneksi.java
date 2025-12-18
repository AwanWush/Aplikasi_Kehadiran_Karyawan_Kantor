/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 'USER'
 */
public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/aplikasi_kehadiran";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Koneksi() {
        
    }
           
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.err.println("Koneksi database gagal!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
