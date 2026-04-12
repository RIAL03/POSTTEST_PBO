package data;

public class BlokKebun {

    private String idBlok;
    private double luasHektar;
    private int jumlahPohon;

    public BlokKebun(String idBlok, double luasHektar, int jumlahPohon) {
        this.idBlok = idBlok;
        this.luasHektar = luasHektar;
        this.jumlahPohon = jumlahPohon;
    }

    public String getIdBlok() { return idBlok; }
    public void setIdBlok(String idBlok) { this.idBlok = idBlok; }

    public double getLuasHektar() { return luasHektar; }
    public void setLuasHektar(double luasHektar) { this.luasHektar = luasHektar; }

    public int getJumlahPohon() { return jumlahPohon; }
    public void setJumlahPohon(int jumlahPohon) { this.jumlahPohon = jumlahPohon; }

    @Override
    public String toString() {
        return "Blok: " + idBlok + " | Luas: " + luasHektar + " Ha | Jumlah Pohon: " + jumlahPohon + " pokok";
    }
}