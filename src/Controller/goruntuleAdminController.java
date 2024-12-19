package Controller;

import Strategy.AbstractGoruntuleAdmin;

import java.util.List;

public class goruntuleAdminController {
    private static AbstractGoruntuleAdmin goruntuleAdmin;

    public goruntuleAdminController(AbstractGoruntuleAdmin goruntuleAdmin) {
        this.goruntuleAdmin = goruntuleAdmin;
    }

    public static List<String[]> getKullaniciListesi() {
        return goruntuleAdmin.getKullaniciListesi();
    }
}
