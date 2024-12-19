package Controller;

import Model.GirisModel;

public class GirisController {
    private static GirisController instance;
    private GirisModel girisModel;

    private GirisController() {
        this.girisModel = GirisModel.getInstance(); // Singleton instance
    }

    public static GirisController getInstance() {
        if (instance == null) {
            synchronized (GirisController.class) {
                if (instance == null) {
                    instance = new GirisController();
                }
            }
        }
        return instance;
    }

    public boolean contGiris(String kul_adi, String kul_sifre) {
        boolean isAdded = girisModel.contGiris(kul_adi, kul_sifre);

        if (isAdded) {
            System.out.println("Kullanıcı başarıyla giriş yaptı.");
        } else {
            System.out.println("Giriş sırasında bir hata oluştu.");
        }

        return isAdded;
    }
}
