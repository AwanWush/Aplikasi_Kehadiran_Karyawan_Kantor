/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import model.*;
import model.enums.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 'USER'
 */
public class KaryawanDAO {
    public void insert(Karyawan k) {
        String sql = """
            INSERT INTO karyawan
            (id_user, nip, nama_lengkap, id_jabatan, id_departemen, alamat, nomor_telepon, role)
            VALUES (?,?,?,?,?,?,?,?)
        """;

        try (Connection c = Koneksi.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, k.getId());
            ps.setString(2, k.getNip());
            ps.setString(3, k.getNamaLengkap());
            ps.setInt(4, k.getJabatan().getIdJabatan());
            ps.setInt(5, k.getDepartemen().getIdDepartemen());
            ps.setString(6, k.getAlamat());
            ps.setString(7, k.getNomorTelepon());
            ps.setString(8, k.getRole());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Karyawan> findAll() {
        List<Karyawan> list = new ArrayList<>();
        String sql = """
            SELECT k.*, d.nama_departemen, j.nama
            FROM karyawan k
            JOIN departemen d ON k.id_departemen=d.id_departemen
            JOIN jabatan j ON k.id_jabatan=j.id_jabatan
        """;

        try (Connection c = Koneksi.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Karyawan(
                        null, null, null,
                        rs.getString("nip"),
                        rs.getString("nama_lengkap"),
                        new Jabatan(rs.getInt("id_jabatan"), rs.getString("nama")),
                        new Departemen(rs.getInt("id_departemen"), rs.getString("nama_departemen"), null),
                        rs.getString("alamat"),
                        rs.getString("nomor_telepon"),
                        Role.valueOf(rs.getString("role"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Karyawan findByUserId(int userId) {

        String sql = """
            SELECT u.id AS user_id, u.username, u.email,
                   k.nip, k.nama_lengkap, k.alamat, k.nomor_telepon, k.role,
                   d.id_departemen, d.nama_departemen,
                   j.id_jabatan, j.nama
            FROM karyawan k
            JOIN user u ON k.id_user = u.id
            JOIN departemen d ON k.id_departemen = d.id_departemen
            JOIN jabatan j ON k.id_jabatan = j.id_jabatan
            WHERE k.id_user = ?
        """;

        try (Connection c = Koneksi.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Departemen departemen = new Departemen(
                        rs.getInt("id_departemen"),
                        rs.getString("nama_departemen"),
                        null
                );

                Jabatan jabatan = new Jabatan(
                        rs.getInt("id_jabatan"),
                        rs.getString("nama")
                );

                return new Karyawan(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),

                        rs.getString("nip"),
                        rs.getString("nama_lengkap"),
                        jabatan,
                        departemen,
                        rs.getString("alamat"),
                        rs.getString("nomor_telepon"),
                        Role.valueOf(rs.getString("role"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(int idUser) {
        String sql = "DELETE FROM karyawan WHERE id_user=?";

        try (Connection c = Koneksi.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
