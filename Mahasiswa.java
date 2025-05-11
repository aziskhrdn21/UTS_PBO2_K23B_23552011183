/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin;

/**
 *
 * @author ASUS
 */
public class Mahasiswa extends Civitas {
    private int jumlahSKS;

    public Mahasiswa(String nama, String nim, String jurusan, int jumlahSKS) {
        super(nama, nim, jurusan);
        this.jumlahSKS = jumlahSKS;
    }

    public int getJumlahSKS() {
        return jumlahSKS;
    }

    @Override
    public double hitungTagihan() {
        // Tagihan mahasiswa berdasarkan jumlah SKS
        final double biayaPerSKS = 500000; // Biaya per SKS
        return jumlahSKS * biayaPerSKS;
    }
}
