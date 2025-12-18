/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author 'USER'
 */
public class Perusahaan {
    private int idPerusahaan;
    private String namaPerusahaan;
    private String alamat;
    private List<Departemen> daftarDepartemen;

    public Perusahaan(int id, String nama, String alamat) {
        this.idPerusahaan = id;
        this.namaPerusahaan = nama;
        this.alamat = alamat;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
    
    public void setNamaPerusahaan(String nama) {
        this.namaPerusahaan = nama;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
