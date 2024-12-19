package Controller;

import Model.KullanicidaOlanlarModel;

import javax.swing.*;
import java.util.List;

public class KullanicidaOlanlarController {
    public void listAllKitap(JTextArea kullanicidaolanlarlistesi) {
        List<String> kitaplar = KullanicidaOlanlarModel.getAllKullanicidaOlanlar();
        if (!kitaplar.isEmpty()) {
            for (String kitap : kitaplar) {
                kullanicidaolanlarlistesi.append(kitap + "\n");
            }
        } else {
            kullanicidaolanlarlistesi.append("Hiç kayıt bulunamadı.");
        }

        // JScrollPane ekleme kısmı (gerekirse)
    }
}
