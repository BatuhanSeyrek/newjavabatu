package Controller;

import Model.PersonelModel;
import Observer.Subject;

public class PersonelController extends Subject {
    private PersonelModel personelModel;

    public PersonelController() {
        this.personelModel = new PersonelModel();
    }

    public boolean contPersonelGiris(String kul_adi, String kul_sifre) {
        boolean isSuccessful = PersonelModel.contGiris(kul_adi, kul_sifre);

        if (isSuccessful) {
            notifyObservers("Giriş Başarılı! Hoş geldiniz, " + kul_adi);
        } else {
            notifyObservers("Giriş Başarısız! Kullanıcı adı veya şifre yanlış.");
        }

        return isSuccessful;
    }
}
