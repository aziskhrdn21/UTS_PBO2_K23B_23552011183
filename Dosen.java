/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin;

/**
 *
 * @author ASUS
 */
public class Dosen extends Civitas {
    private String jabatan;

    public Dosen(String nama, String nidn, String jurusan, String jabatan) {
        super(nama, nidn, jurusan);
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    @Override
    public double hitungTagihan() {
        // Tagihan dosen berdasarkan jabatan
        if ("Lektor".equalsIgnoreCase(jabatan)) {
            return 1000000;
        } else if ("Guru Besar".equalsIgnoreCase(jabatan)) {
            return 1500000;
        } else {
            return 800000; // Default untuk jabatan lain
        }
    }
}
