/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import model.Perusahaan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 'USER'
 */
public class PerusahaanDAO {
    public void insert(Perusahaan p) {
        String sql = "INSERT INTO perusahaan (nama_perusahaan, alamat) VALUES (?,?)";

        try (Connection c = Koneksi.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getNamaPerusahaan());
            ps.setString(2, p.getAlamat());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Perusahaan> findAll() {
        List<Perusahaan> list = new ArrayList<>();
        String sql = "SELECT * FROM perusahaan";

        try (Connection c = Koneksi.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Perusahaan(
                        rs.getInt("id_perusahaan"),
                        rs.getString("nama_perusahaan"),
                        rs.getString("alamat")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void delete(int id) {
        String sql = "DELETE FROM perusahaan WHERE id_perusahaan=?";

        try (Connection c = Koneksi.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
