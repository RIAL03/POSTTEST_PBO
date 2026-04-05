package data;

public class Pekerja {
    //MENERAPKAN 4 JENIS ACCESS MODIFIER ===

    // 1. Modifier 'private': Hanya bisa diakses di dalam class ini
    private String id;

    // 2. Modifier 'default' (tanpa keyword): Hanya bisa diakses di package 'data'
    String nama;

    // 3. Modifier 'protected': Bisa diakses di package 'data' dan class turunannya
    protected String jabatan;

    // 4. Modifier 'public': Bisa diakses dari mana saja (termasuk dari package 'utama')
    public Pekerja(String id, String nama, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    // METODE GETTER DAN SETTER (ENCAPSULATION) ===

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    @Override
    public String toString() {
        return "ID Pekerja: " + id + " | Nama: " + nama + " | Jabatan: " + jabatan;
    }
}