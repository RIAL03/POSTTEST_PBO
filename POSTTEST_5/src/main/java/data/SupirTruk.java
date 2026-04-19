package data;

public class SupirTruk extends Pekerja {
    private String platTruk;

    public SupirTruk(String id, String nama, String platTruk) {
        super(id, nama, "Supir Truk");
        this.platTruk = platTruk;
    }

    public String getPlatTruk() { return platTruk; }
    public void setPlatTruk(String platTruk) { this.platTruk = platTruk; }

    // PENERAPAN POLYMORPHISM: OVERRIDING

    @Override
    public void bekerja() {
        System.out.println("Supir Truk " + getNama() + " sedang memanaskan mesin dan mengemudikan truk " + platTruk + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Plat Truk: " + platTruk;
    }
}