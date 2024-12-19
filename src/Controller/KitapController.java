package Controller;

import Model.KitapModel;

import javax.swing.*;
import java.util.List;

public class KitapController {
    public void listAllKitap(JTextArea kitapListesi, String searchQuery) {
        List<String> kitaplar = KitapModel.getFilteredKutuphane(searchQuery);
        kitapListesi.setText("");  // Clear existing text
        if (!kitaplar.isEmpty()) {
            for (String kitap : kitaplar) {
                kitapListesi.append(kitap + "\n");
            }
        } else {
            kitapListesi.append("Hiç kayıt bulunamadı.");
        }

        // JScrollPane ekleme kısmı (gerekirse)
    }
}
