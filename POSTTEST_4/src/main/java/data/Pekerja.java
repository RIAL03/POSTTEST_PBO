package data;

public class Pekerja {
    private String id;
    String nama;
    protected String jabatan;

    public Pekerja(String id, String nama, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    // PENERAPAN POLYMORPHISM: OVERRIDING

    public void bekerja() {
        System.out.println("Pekerja " + nama + " sedang melakukan pekerjaan umum di kebun.");
    }

    // PENERAPAN POLYMORPHISM: OVERLOADING 1
    // Nama fungsi sama, beda jumlah/tipe parameter

    public void beriBonus(double nominal) {
        System.out.println("Pekerja " + nama + " mendapatkan bonus sebesar Rp" + nominal);
    }

    public void beriBonus(double nominal, String alasan) {
        System.out.println("Pekerja " + nama + " mendapatkan bonus sebesar Rp" + nominal + " karena: " + alasan);
    }

    @Override
    public String toString() {
        return "ID Pekerja: " + id + " | Nama: " + nama + " | Jabatan: " + jabatan;
    }
}