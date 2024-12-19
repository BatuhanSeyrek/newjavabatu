package Controller;

import Factory.ekleAdminFactory;
import Model.ekleAdminModel;

public class ekleAdminController {
    private ekleAdminModel ekleadminModel;

    public ekleAdminController(ekleAdminFactory factory) {
        this.ekleadminModel = factory.createekleAdminModel();
    }

    public void addekleAdmin(String kullaniciAdi, String sifre, String mail, String rol) {
        boolean isAdded = ekleadminModel.addekleAdmin(kullaniciAdi, sifre, mail, rol);

        if (isAdded) {
            System.out.println("Kullanıcı başarıyla eklendi.");
        } else {
            System.out.println("Kullanıcı eklenirken bir hata oluştu.");
        }
    }
}
