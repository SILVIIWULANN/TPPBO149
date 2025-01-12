// Kelas Kendaraan
public class Kendaraan {
    protected String nomorPlat;
    protected String merek;
    protected String model;
    protected int tahun;

    // Constructor
    public Kendaraan(String nomorPlat, String merek, String model, int tahun) {
        this.nomorPlat = nomorPlat;
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
    }

    // Method toString
    @Override
    public String toString() {
        return "Nomor Plat: " + nomorPlat +
                "\nMerek: " + merek +
                "\nModel: " + model +
                "\nTahun: " + tahun;
    }
}