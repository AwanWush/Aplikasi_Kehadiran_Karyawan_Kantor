/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author 'USER'
 */
public class Kehadiran {
    private int idKehadiran;
    private Karyawan karyawan;
    private LocalDate tanggal;
    private LocalTime jamMasuk;
    private LocalTime jamPulang;
    private boolean terlambat;
    private int menitLembur;

    public Kehadiran(Karyawan karyawan, LocalDate tanggal) {
        this.karyawan = karyawan;
        this.tanggal = tanggal;
    }

    public void setJamMasuk(LocalTime waktu) {
        this.jamMasuk = waktu;
        this.terlambat = waktu.isAfter(LocalTime.of(8, 0));
    }

    public void setJamPulang(LocalTime waktu) {
        this.jamPulang = waktu;
        hitungLembur();
    }

    private void hitungLembur() {
        LocalTime jamStandar = LocalTime.of(17, 0);
        if (jamPulang.isAfter(jamStandar)) {
            menitLembur = (int) java.time.Duration.between(jamStandar, jamPulang).toMinutes();
        }
    }
}
