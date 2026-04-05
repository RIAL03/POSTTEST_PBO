package data;

// Subclass Ketiga
// Hierarchical Inheritance, SupirTruk JUGA anak dari Pekerja
public class SupirTruk extends Pekerja {

    private String platTruk;

    public SupirTruk(String id, String nama, String platTruk) {
        super(id, nama, "Supir Truk");
        this.platTruk = platTruk;
    }

    public String getPlatTruk() {
        return platTruk;
    }

    public void setPlatTruk(String platTruk) {
        this.platTruk = platTruk;
    }

    @Override
    public String toString() {
        return super.toString() + " | Plat Truk: " + platTruk;
    }
}