package data;

public class Mandor extends Pekerja {
    private String areaTugas;

    public Mandor(String id, String nama, String areaTugas) {
        super(id, nama, "Mandor");
        this.areaTugas = areaTugas;
    }

    public String getAreaTugas() { return areaTugas; }
    public void setAreaTugas(String areaTugas) { this.areaTugas = areaTugas; }

    // PENERAPAN POLYMORPHISM: OVERRIDING

    @Override
    public void bekerja() {
        System.out.println("Mandor " + getNama() + " sedang berkeliling mengawasi area " + areaTugas + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Area Tugas: " + areaTugas;
    }
}