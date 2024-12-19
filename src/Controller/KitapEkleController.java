package Controller;

import Model.KitapEkleModel;
import Model.KitapModel;
import Model.ekleAdminModel;

public class KitapEkleController {
    private KitapEkleModel kitapEkleModel;

    public KitapEkleController (){

        this.kitapEkleModel = new KitapEkleModel();
    }

    public void addKitap(String kitap_ad, String kitap_yazar, String kitap_konu){

        boolean isAdded = kitapEkleModel.addKitap(kitap_ad, kitap_yazar, kitap_konu);

        if (isAdded) {
            System.out.println("Kitap başarıyla eklendi.");
        } else {
            System.out.println("Kitap eklenirken bir hata oluştu.");
        }
    }
}
