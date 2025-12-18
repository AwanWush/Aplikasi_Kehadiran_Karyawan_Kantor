/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.PengajuanIzinDAO;
import model.Karyawan;
import model.PengajuanIzin;
import model.enums.JenisIzin;
import model.enums.StatusPengajuan;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 'USER'
 */
public class PengajuanService {
    private final PengajuanIzinDAO pengajuanDAO;

    public PengajuanService() {
        this.pengajuanDAO = new PengajuanIzinDAO();
    }

    public void ajukanIzin(Karyawan karyawan,
                           LocalDate mulai,
                           LocalDate selesai,
                           JenisIzin jenis,
                           String keterangan) {

        PengajuanIzin izin = new PengajuanIzin(
                karyawan,
                mulai,
                selesai,
                jenis,
                keterangan
        );

        pengajuanDAO.insert(izin);
    }

    public void konfirmasiIzin(int idIzin, boolean setujui) {
        if (setujui) {
            pengajuanDAO.updateStatus(idIzin, StatusPengajuan.DISETUJUI);
        } else {
            pengajuanDAO.updateStatus(idIzin, StatusPengajuan.DITOLAK);
        }
    }

    public List<PengajuanIzin> getSemuaPengajuan() {
        return pengajuanDAO.findAll();
    }
}
