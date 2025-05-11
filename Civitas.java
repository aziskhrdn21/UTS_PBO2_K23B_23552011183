/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin;

/**
 *
 * @author ASUS
 */
public class Civitas extends Sivitas {
    protected String jurusan;

    public Civitas(String nama, String identitas, String jurusan) {
        super(nama, identitas);
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }

    @Override
    public double hitungTagihan() {
        // Implementasi default (bisa di-override oleh subclass)
        return 0.0;
    }
}