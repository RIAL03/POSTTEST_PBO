package data;

// Subclass Kedua
// Hierarchical Inheritance, Pemanen JUGA anak dari Pekerja
public class Pemanen extends Pekerja {

    private int targetHarian;

    public Pemanen(String id, String nama, int targetHarian) {
        super(id, nama, "Pemanen");
        this.targetHarian = targetHarian;
    }

    public int getTargetHarian() {
        return targetHarian;
    }

    public void setTargetHarian(int targetHarian) {
        this.targetHarian = targetHarian;
    }

    @Override
    public String toString() {
        return super.toString() + " | Target Harian: " + targetHarian + " Tandan";
    }
}