// Kelas Mobil (Subclass dari Kendaraan)
public class Mobil extends Kendaraan {
    private String tipe; // Tipe mobil (SUV, Sedan, dll)

    // Constructor
    public Mobil(String nomorPlat, String merek, String model, int tahun, String tipe) {
        super(nomorPlat, merek, model, tahun); // Memanggil constructor superclass
        this.tipe = tipe;
    }

    // Override toString
    @Override
    public String toString() {
        return super.toString() + "\nTipe: " + tipe;
    }
}