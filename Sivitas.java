/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.admin;

/**
 *
 * @author ASUS
 */
public abstract class Sivitas {
    protected String nama;
    protected String identitas;

    public Sivitas(String nama, String identitas) {
        this.nama = nama;
        this.identitas = identitas;
    }

    public String getNama() {
        return nama;
    }

    public String getIdentitas() {
        return identitas;
    }

    // Method abstrak yang harus diimplementasikan oleh subclass
    public abstract double hitungTagihan();
}
