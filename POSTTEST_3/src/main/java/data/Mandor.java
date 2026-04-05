package data;

// Subclass Pertama
// Hierarchical Inheritance, Mandor adalah anak dari Pekerja
public class Mandor extends Pekerja {

    private String areaTugas;

    public Mandor(String id, String nama, String areaTugas) {
        super(id, nama, "Mandor");

        this.areaTugas = areaTugas;
    }

    public String getAreaTugas() {
        return areaTugas;
    }

    public void setAreaTugas(String areaTugas) {
        this.areaTugas = areaTugas;
    }

    @Override
    public String toString() {
        // super.toString() akan memanggil hasil print dari class Pekerja
        return super.toString() + " | Area Tugas: " + areaTugas;
    }
}