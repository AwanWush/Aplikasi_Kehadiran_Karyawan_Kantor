/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author 'USER'
 */
public class PengajuanIzin {
    private int id;
    private Karyawan karyawan;
    private LocalDate tanggalMulai;
    private LocalDate tanggalSelesai;
    private JenisIzin jenisIzin;
    private String keterangan;
    private StatusPengajuan status;

    public PengajuanIzin(Karyawan karyawan, LocalDate mulai,
                         LocalDate selesai, JenisIzin jenis, String keterangan) {

        this.karyawan = karyawan;
        this.tanggalMulai = mulai;
        this.tanggalSelesai = selesai;
        this.jenisIzin = jenis;
        this.keterangan = keterangan;
        this.status = StatusPengajuan.PENDING;
    }
    
    public enum JenisIzin {
        IZIN, SAKIT, CUTI
    }
    
    public enum StatusPengajuan {
        PENDING, DISETUJUI, DITOLAK
    }

    public void setujui() {
        status = StatusPengajuan.DISETUJUI;
    }

    public void tolak() {
        status = StatusPengajuan.DITOLAK;
    }
}
