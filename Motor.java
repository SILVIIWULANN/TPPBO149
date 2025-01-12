// Kelas Motor (Subclass dari Kendaraan)
public class Motor extends Kendaraan {
    private int cc; // Kapasitas mesin motor

    // Constructor
    public Motor(String nomorPlat, String merek, String model, int tahun, int cc) {
        super(nomorPlat, merek, model, tahun);
        this.cc = cc;
    }

    // Override toString
    @Override
    public String toString() {
        return super.toString() + "\nCC: " + cc;
    }
}