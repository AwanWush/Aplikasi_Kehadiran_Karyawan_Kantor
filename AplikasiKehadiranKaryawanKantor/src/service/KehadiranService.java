/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.KehadiranDAO;
import model.Karyawan;
import model.Kehadiran;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author 'USER'
 */
public class KehadiranService {
    private final KehadiranDAO kehadiranDAO;

    public KehadiranService() {
        this.kehadiranDAO = new KehadiranDAO();
    }

    public boolean presensiMasuk(Karyawan karyawan) {

        // Cek apakah sudah presensi hari ini
        if (kehadiranDAO.existsHariIni(karyawan.getId())) {
            return false;
        }

        Kehadiran kehadiran = new Kehadiran(
                karyawan,
                LocalDate.now()
        );

        kehadiran.setJamMasuk(LocalTime.now());
        kehadiranDAO.insert(kehadiran);

        return true;
    }

    public boolean presensiPulang(Karyawan karyawan) {

        if (!kehadiranDAO.existsHariIni(karyawan.getId())) {
            return false;
        }

        kehadiranDAO.updateJamPulang(
                karyawan.getId(),
                LocalDate.now(),
                LocalTime.now()
        );

    return true;
}
