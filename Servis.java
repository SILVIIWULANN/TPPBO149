import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Servis {
    private static final Map<String, Integer> daftarServis = new HashMap<>();

    static {
        daftarServis.put("Ganti Oli", 50000);
        daftarServis.put("Tune Up", 150000);
        daftarServis.put("Service Rem", 100000);
    }

    public static void tampilkanServis() {
        System.out.println("Daftar Servis:");
        int i = 1;
        for (Map.Entry<String, Integer> entry : daftarServis.entrySet()) {
            System.out.println(i++ + ". " + entry.getKey() + " - Rp " + entry.getValue());
        }
    }

    public static int getHarga(String jenis) {
        return daftarServis.getOrDefault(jenis, 0);
    }

    public static String getJenisByIndex(int index) {
        List<String> keys = new ArrayList<>(daftarServis.keySet());
        return (index >= 0 && index < keys.size()) ? keys.get(index) : null;
    }
}