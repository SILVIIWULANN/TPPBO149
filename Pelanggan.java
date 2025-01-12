class Pelanggan {
    private String id;
    private String nama;
    private String alamat;
    private String noTelpon;

    public Pelanggan(String id, String nama, String alamat, String noTelpon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelpon = noTelpon;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelpon() {
        return noTelpon;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Alamat: " + alamat + ", No. Telpon: " + noTelpon;
    }
}