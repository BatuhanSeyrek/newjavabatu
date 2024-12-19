package Controller;

import Model.guncelleAdminModel;
public class guncelleAdminController {

    private guncelleAdminModel guncelleadminModel;

    public guncelleAdminController() {

        this.guncelleadminModel = new guncelleAdminModel();
    }

    public boolean updateguncelleAdmin(String yenikullaniciAdi, String yenisifre, String yenimail, String yenirol) {
        return guncelleadminModel.updateguncelleAdmin(yenikullaniciAdi, yenisifre, yenimail, yenirol);
    }
}
