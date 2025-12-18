/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UserDAO;
import dao.KaryawanDAO;
import model.Karyawan;
import model.User;

/**
 *
 * @author 'USER'
 */
public class AuthService {
    private final UserDAO userDAO;
    private final KaryawanDAO karyawanDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
        this.karyawanDAO = new KaryawanDAO();
    }

    public Karyawan login(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            return null;
        }
        if (!user.login(password)) {
            return null;
        }
        return karyawanDAO.findByUserId(user.getId());
    }    
}
