package Strategy;

import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DefaultGoruntuleAdmin extends AbstractGoruntuleAdmin {

    @Override
    public List<String[]> getKullaniciListesi() {
        List<String[]> kullaniciListesi = new ArrayList<>();

        String selectQuery = "SELECT kul_ad, kul_sifre, kul_mail, kul_rol FROM kayit";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Her bir satırı listeye ekle
            while (resultSet.next()) {
                String kullaniciAdi = resultSet.getString("kul_ad");
                String sifre = resultSet.getString("kul_sifre");
                String mail = resultSet.getString("kul_mail");
                String rol = resultSet.getString("kul_rol");

                kullaniciListesi.add(new String[]{kullaniciAdi, sifre, mail, rol});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kullaniciListesi;
    }
}
