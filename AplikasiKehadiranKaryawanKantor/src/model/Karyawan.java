/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 'USER'
 */
public class Karyawan extends User {
    private String nip;
    private String namaLengkap;
    private Jabatan jabatan;
    private Departemen departemen;
    private String alamat;
    private String nomorTelepon;
    private Role role;

    public Karyawan(int idUser, String username, String email, String password,
                    String nip, String namaLengkap,
                    Jabatan jabatan, Departemen departemen,
                    String alamat, String nomorTelepon, Role role) {

        super(username, email, password);
        this.id = idUser;
        this.nip = nip;
        this.namaLengkap = namaLengkap;
        this.jabatan = jabatan;
        this.departemen = departemen;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.role = role;
    }
    
    public Karyawan(
            int idUser,
            String username,
            String email,

            String nip,
            String namaLengkap,
            Jabatan jabatan,
            Departemen departemen,
            String alamat,
            String nomorTelepon,
            Role role
    ) {
        super(username, email, null); // password tidak diperlukan untuk READ
        this.id = idUser;

        this.nip = nip;
        this.namaLengkap = namaLengkap;
        this.jabatan = jabatan;
        this.departemen = departemen;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.role = role;
    }
    
    public enum Role {
        ADMIN, KARYAWAN
    }

    @Override
    public String getRole() {
        return role.name();
    }

    public int getId() {
        return super.id;
    }

    public String getNip() {
        return nip;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public Departemen getDepartemen() {
        return departemen;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }
}
