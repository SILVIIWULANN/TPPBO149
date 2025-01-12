import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Pelanggan> pelangganMap = new HashMap<>();
    private static final Map<String, Kendaraan> kendaraanMap = new HashMap<>();
    private static int pelangganCounter = 1;

    public static void main(String[] args) {
        System.out.println("|===================================================================|");
        System.out.println("|                                                                   |");
        System.out.println("|       SELAMAT DATANG DI LAYANAN SERVIS KENDARAAN ALENATARA        |");
        System.out.println("|     Jl. Magetan No.17 Boyolali Jawa Tengah telp(0273)876543       |");
        System.out.println("|                                                                   |");
        System.out.println("|===================================================================|");
        System.out.println("\nSilahkan pilih menu 1. Pendaftaran Pelanggan baru jika belum pernah Servis, ");
        System.out.println("dan jika sudah pernah Servis Silahkan Memilih menu 2. Pendaftaran Kendaraan dan Servis.");
        while (true) {
            System.out.println("=== Menu Utama ===");
            System.out.println("1. Pendaftaran Pelanggan Baru");
            System.out.println("2. Pendaftaran Kendaraan dan Servis");
            System.out.println("3. Pembayaran");
            System.out.println("4. Keluar");
            System.out.print("Masukan Pilih Menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Menghapus newline dari input

            switch (pilihan) {
                case 1 -> pendaftaranPelangganBaru();
                case 2 -> pendaftaranKendaraanDanServis();
                case 3 -> pembayaran();
                case 4 -> {
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    return;
                }
                default -> System.out.println("Pilihan tidak tersedia.");
            }
        }
    }

    private static void pendaftaranPelangganBaru() {
        System.out.println("\n=== Pendaftaran Pelanggan Baru ===");
        String id = "PLG" + pelangganCounter++;
        System.out.println("ID Pelanggan Anda: " + id);
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan No. Telpon: ");
        String noTelpon = scanner.nextLine();

        Pelanggan pelanggan = new Pelanggan(id, nama, alamat, noTelpon);
        pelangganMap.put(id, pelanggan);

        System.out.println("Pendaftaran anda berhasil. Data pelanggan:");
        System.out.println(pelanggan);
    }

    private static void pendaftaranKendaraanDanServis() {
        System.out.println("\n=== Pendaftaran Kendaraan dan Servis ===");
        System.out.print("Masukkan ID Pelanggan: ");
        String id = scanner.nextLine();

        Pelanggan pelanggan = pelangganMap.get(id);
        if (pelanggan == null) {
            System.out.println("ID Pelanggan tidak ditemukan. Silakan daftar pelanggan baru terlebih dahulu.");
            return;
        }

        System.out.println("Selamat datang, " + pelanggan.toString());

        // Pendaftaran kendaraan
        System.out.print("Masukkan jenis kendaraan (1 untuk Motor, 2 untuk Mobil): ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan Nomor Plat: ");
        String nomorPlat = scanner.nextLine();
        System.out.print("Masukkan Merek: ");
        String merek = scanner.nextLine();
        System.out.print("Masukkan Model: ");
        String model = scanner.nextLine();
        System.out.print("Masukkan Tahun: ");
        int tahun = scanner.nextInt();
        scanner.nextLine();

        Kendaraan kendaraan;
        if (jenis == 1) {
            System.out.print("Masukkan Kapasitas Mesin (CC): ");
            int cc = scanner.nextInt();
            scanner.nextLine();
            kendaraan = new Motor(nomorPlat, merek, model, tahun, cc);
        } else if (jenis == 2) {
            System.out.print("Masukkan Tipe Mobil (SUV, Sedan, dll): ");
            String tipe = scanner.nextLine();
            kendaraan = new Mobil(nomorPlat, merek, model, tahun, tipe);
        } else {
            System.out.println("Jenis kendaraan tidak valid.");
            return;
        }

        kendaraanMap.put(id, kendaraan);

        System.out.println("\nData kendaraan berhasil didaftarkan:");
        System.out.println(kendaraan);

        // Pendaftaran servis
        int totalBiaya = 0;
        while (true) {
            Servis.tampilkanServis();
            System.out.print("Pilih jenis servis (atau ketik '0' untuk selesai): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 0) {
                break;
            }

            String jenisServis = Servis.getJenisByIndex(pilihan - 1);
            if (jenisServis != null) {
                int harga = Servis.getHarga(jenisServis);
                totalBiaya += harga;
                System.out.println(jenisServis + " berhasil ditambahkan dengan biaya Rp " + harga);
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("Total biaya servis untuk ID " + id + ": Rp " + totalBiaya);
    }

    private static void pembayaran() {
        System.out.println("\n=== Pembayaran ===");
        System.out.print("Masukkan ID Pelanggan: ");
        String id = scanner.nextLine();

        Pelanggan pelanggan = pelangganMap.get(id);
        if (pelanggan == null) {
            System.out.println("ID pelanggan tidak ditemukan.");
            return;
        }

        Kendaraan kendaraan = kendaraanMap.get(id);
        if (kendaraan == null) {
            System.out.println("Kendaraan tidak ditemukan untuk pelanggan ini.");
            return;
        }

        System.out.print("Masukkan total biaya: Rp ");
        int totalBiaya = scanner.nextInt();
        System.out.print("Masukkan jumlah yang dibayar: Rp ");
        int dibayar = scanner.nextInt();
        scanner.nextLine(); // Menghapus newline dari input

        if (dibayar < totalBiaya) {
            System.out.println("Jumlah yang dibayar tidak cukup.");
            return;
        }

        int kembalian = dibayar - totalBiaya;

        System.out.println("\n=== Struk Pembayaran ===");
        System.out.println(pelanggan);
        System.out.println(kendaraan);
        System.out.println("Total Biaya: Rp " + totalBiaya);
        System.out.println("Dibayar: Rp " + dibayar);
        System.out.println("Kembalian: Rp " + kembalian);
        System.out.println("Terima kasih telah menggunakan layanan kami!");
    }
}