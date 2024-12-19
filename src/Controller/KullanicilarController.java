package Controller;

import State.KayitState;
import State.KayitBasariliState;
import State.KayitBasarisizState;

public class KullanicilarController {
    private KayitState state; // Mevcut durumu tutar

    public KullanicilarController() {
        this.state = null; // Başlangıç durumu yok
    }

    public void setState(KayitState state) {
        this.state = state; // Durumu değiştir
    }

    public void addKullanicilar(String kul_adi, String kul_sifre, String kul_mail) {
        if (state != null) {
            state.handle(kul_adi, kul_sifre, kul_mail); // Duruma göre işlem yap
        } else {
            System.out.println("Bir durum ayarlanmadı.");
        }
    }
}
