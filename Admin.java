/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.admin;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PROGRAM PEMBAYARAN ADMIN KAMPUS ===");
        System.out.println("Login Sebagai:");
        System.out.println("1. Mahasiswa");
        System.out.println("2. Dosen");
        System.out.print("Pilih (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        Civitas civitas = null;

        if (pilihan == 1) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Masukkan Jurusan: ");
            String jurusan = scanner.nextLine();
            System.out.print("Jumlah SKS: ");
            int sks = scanner.nextInt();

            civitas = new Mahasiswa(nama, nim, jurusan, sks);
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIDN: ");
            String nidn = scanner.nextLine();
            System.out.print("Masukkan Jurusan: ");
            String jurusan = scanner.nextLine();
            scanner.nextLine(); // Clear buffer
            System.out.print("Masukkan Jabatan (Lektor/Guru Besar/Lainnya): ");
            String jabatan = scanner.nextLine();

            civitas = new Dosen(nama, nidn, jurusan, jabatan);
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        // Buat objek pembayaran
        Pembayaran pembayaran = new Pembayaran(civitas);

        // Input jumlah uang dibayar
        System.out.print("Masukkan Jumlah Uang Dibayar: Rp ");
        double uangDibayar = scanner.nextDouble();
        pembayaran.setUangDibayar(uangDibayar);

        // Tampilkan struk
        pembayaran.tampilkanStruk();

        // Simpan transaksi ke database
        pembayaran.simpanTransaksi();

        scanner.close();
    }
}
