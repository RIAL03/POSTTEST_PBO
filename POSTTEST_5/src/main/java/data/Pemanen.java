package data;

public class Pemanen extends Pekerja {
    private int targetHarian;

    public Pemanen(String id, String nama, int targetHarian) {
        super(id, nama, "Pemanen");
        this.targetHarian = targetHarian;
    }

    public int getTargetHarian() { return targetHarian; }
    public void setTargetHarian(int targetHarian) { this.targetHarian = targetHarian; }

    // PENERAPAN POLYMORPHISM: OVERRIDING

    @Override
    public void bekerja() {
        System.out.println("Pemanen " + getNama() + " sedang memanen sawit untuk mencapai target " + targetHarian + " tandan.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Target Harian: " + targetHarian + " Tandan";
    }
}