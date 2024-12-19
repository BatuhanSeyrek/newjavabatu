package Controller;

import Model.OduncModel;

import javax.swing.*;
import java.util.List;

public class OduncController {
    public static void listAllOdunc(JTextArea oduncListesi, String searchQuery) {
        List<String> kitaplar = OduncModel.getFilteredOdunc(searchQuery);
        oduncListesi.setText("");  // Clear existing text
        if (!kitaplar.isEmpty()) {
            for (String kitap : kitaplar) {
                oduncListesi.append(kitap + "\n");
            }
        } else {
            oduncListesi.append("Hiç kayıt bulunamadı.");
        }
    }
}
