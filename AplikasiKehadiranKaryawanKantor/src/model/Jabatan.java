/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 'USER'
 */
public class Jabatan {
    private int idJabatan;
    private String nama;

    public Jabatan(int id, String nama) {
        this.idJabatan = id;
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }

    public int getIdJabatan() {
        return idJabatan;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
}
