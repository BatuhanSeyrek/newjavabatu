package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KullanicilarModel {
    public boolean addKullanicilar(String kul_adi, String kul_sifre, String kul_mail) {

        String insertQuery = "INSERT INTO kayit (kul_ad, kul_sifre, kul_mail, kul_rol) VALUES (?, ?, ?, 'ogr')";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Değerleri ayarla
            preparedStatement.setString(1, kul_adi);
            preparedStatement.setString(2, kul_sifre);
            preparedStatement.setString(3, kul_mail);


            // Sorguyu çalıştır
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


