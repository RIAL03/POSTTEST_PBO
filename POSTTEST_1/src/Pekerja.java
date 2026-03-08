public class Pekerja {
    private String id;
    private String nama;
    private String jabatan;

    public Pekerja(String id, String nama, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    // Getter dan Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    // Untuk menampilkan data dengan rapi
    @Override
    public String toString() {
        return "ID Pekerja: " + id + " | Nama: " + nama + " | Jabatan: " + jabatan;
    }
}