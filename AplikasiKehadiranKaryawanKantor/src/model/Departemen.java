/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 'USER'
 */
public class Departemen {
    private int idDepartemen;
    private String namaDepartemen;
    private Perusahaan perusahaan;

    public Departemen(int id, String nama, Perusahaan perusahaan) {
        this.idDepartemen = id;
        this.namaDepartemen = nama;
        this.perusahaan = perusahaan;
    }

    public String getNama() {
        return namaDepartemen;
    }
}
