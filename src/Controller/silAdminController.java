package Controller;

import Template.DeleteAdminOperation;

public class silAdminController {

    private final DeleteAdminOperation deleteAdminOperation;

    public silAdminController() {
        this.deleteAdminOperation = new DeleteAdminOperation();
    }

    public boolean deletesilAdmin(String kullaniciAdi, String sifre, String mail, String rol) {
        boolean isDeleted = deleteAdminOperation.execute(kullaniciAdi, sifre, mail, rol);
        if (isDeleted) {
            System.out.println("Kullanıcı başarıyla silindi.");
        } else {
            System.out.println("Kullanıcı silinirken bir hata oluştu.");
        }
        return isDeleted;
    }
}
