package data;

public class Panen {
    private String idPanen;
    private String tanggal;
    private double totalTon;

    public Panen(String idPanen, String tanggal, double totalTon) {
        this.idPanen = idPanen;
        this.tanggal = tanggal;
        this.totalTon = totalTon;
    }

    public String getIdPanen() { return idPanen; }
    public void setIdPanen(String idPanen) { this.idPanen = idPanen; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public double getTotalTon() { return totalTon; }
    public void setTotalTon(double totalTon) { this.totalTon = totalTon; }

    // PENERAPAN POLYMORPHISM: OVERLOADING 2
    // Nama fungsi sama, beda jumlah parameter

    public void updateHasil(double tambahanTon) {
        this.totalTon += tambahanTon;
    }

    public void updateHasil(double tambahanTon, String catatanKualitas) {
        this.totalTon += tambahanTon;
        System.out.println("Hasil panen " + idPanen + " ditambah " + tambahanTon + " Ton. Kualitas: " + catatanKualitas);
    }

    @Override
    public String toString() {
        return "ID Panen: " + idPanen + " | Tanggal: " + tanggal + " | Hasil: " + totalTon + " Ton";
    }
}