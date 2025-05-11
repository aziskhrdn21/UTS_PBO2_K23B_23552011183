/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin;

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Pembayaran {
    private Civitas civitas;
    private double totalBiaya;
    private double uangDibayar;

    public Pembayaran(Civitas civitas) {
        this.civitas = civitas;
        this.totalBiaya = civitas.hitungTagihan();
    }

    public void setUangDibayar(double uangDibayar) {
        this.uangDibayar = uangDibayar;
    }

    public double hitungKembalian() {
        return uangDibayar - totalBiaya;
    }

    public boolean cekPembayaran() {
        return uangDibayar >= totalBiaya;
    }

    public void simpanTransaksi() {
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO transaksi (id_tagihan, tanggal_bayar, jumlah_bayar, kembalian, status) VALUES (?, ?, ?, ?, ?)"
            );

            // Simpan data transaksi ke database
            int idTagihan = getIdTagihanByNIM(civitas.getIdentitas());
            ps.setInt(1, idTagihan);
            ps.setDate(2, new java.sql.Date(new Date().getTime()));
            ps.setDouble(3, uangDibayar);
            ps.setDouble(4, hitungKembalian());
            ps.setString(5, cekPembayaran() ? "Lunas" : "Belum Lunas");

            ps.executeUpdate();

            System.out.println("Transaksi berhasil disimpan ke database.");
        } catch (SQLException e) {
            System.out.println("Error menyimpan transaksi: " + e.getMessage());
        }
    }

    private int getIdTagihanByNIM(String nim) {
        try {
            Connection conn = DBconnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT id_tagihan FROM tagihan WHERE nim = ? ORDER BY id_tagihan DESC LIMIT 1"
            );
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_tagihan");
            }
        } catch (SQLException e) {
            System.out.println("Error mendapatkan ID tagihan: " + e.getMessage());
        }

        return -1; // Jika tidak ditemukan
    }

    public void tampilkanStruk() {
        System.out.println("====== STRUK PEMBAYARAN ======");
        System.out.println("Nama         : " + civitas.getNama());
        System.out.println("Identitas    : " + civitas.getIdentitas());
        System.out.println("Jenis        : " + (civitas instanceof Mahasiswa ? "Mahasiswa" : "Dosen"));
        System.out.println("Total Biaya  : Rp " + totalBiaya);
        System.out.println("Dibayar      : Rp " + uangDibayar);
        if (cekPembayaran()) {
            System.out.println("Status       : LUNAS");
            System.out.println("Kembalian    : Rp " + hitungKembalian());
        } else {
            System.out.println("Status       : BELUM LUNAS");
            System.out.println("Kekurangan   : Rp " + (totalBiaya - uangDibayar));
        }
        System.out.println("==============================");
    }
}
