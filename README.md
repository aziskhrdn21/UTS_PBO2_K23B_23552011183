# PEMROGRAMAN BERORIENTASI OBJEK 2
* mata kuliah: Pemrograman Berorientasi Obeyek 2 
* Dosen Pengampu: Muhammad Ikhwan Fathulloh
# Profil
* Nama: Noer Azis Khaerudin 
* NIM: 23552011183
* Studi Kasus: Kasir untuk pengelolaan pembayaran administrasi kuliah.
# Judul Studi Kasus
Kasir untuk pengelolaan pembayaran administrasi kuliah.
# Penjelasan Studi Kasus 
Membuat sebuah program sederhana menggunakan bahasa java tentang sebuah sistem kasir untuk pembayaran administrasi kuliah
# Penjelasan 4 pilar OOP dalam studi kasus
## 1. inheritance
### Civitas sebagai kelas dasar (superclass).
### Mahasiswa dan Dosen sebagai subclass dari Civitas.

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
## Polymorphisme
### Metode hitungTagihan() yang dimiliki oleh Class Civitas dan di override oleh subclass Mahasiswa dan Dosen.
public double hitungTagihan() {
        // Implementasi default (bisa di-override oleh subclass)
        return 0.0;
    }
## Abstract
### Sivitas sebagai abstract class yang digunakan sebagai superclass untuk Civitas
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
