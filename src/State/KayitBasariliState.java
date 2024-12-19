package State;

import Model.KullanicilarModel;

public class KayitBasariliState implements KayitState {
    private KullanicilarModel kullanicilarModel;

    public KayitBasariliState() {
        this.kullanicilarModel = new KullanicilarModel();
    }

    @Override
    public void handle(String kul_adi, String kul_sifre, String kul_mail) {
        boolean isAdded = kullanicilarModel.addKullanicilar(kul_adi, kul_sifre, kul_mail);

        if (isAdded) {
            System.out.println("Kullanıcı başarıyla eklendi.");
        } else {
            System.out.println("Durum değişti: Başarısız duruma geçiliyor.");
        }
    }
}
