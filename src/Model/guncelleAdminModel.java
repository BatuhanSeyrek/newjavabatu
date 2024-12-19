package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class guncelleAdminModel {

    public boolean updateguncelleAdmin(String yenikullaniciAdi, String yenisifre, String yenimail, String yenirol) {
        String insertQuery = "INSERT INTO kayit (kul_ad, kul_sifre, kul_mail, kul_rol) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Değerleri ayarla
            preparedStatement.setString(1, yenikullaniciAdi);
            preparedStatement.setString(2, yenisifre);
            preparedStatement.setString(3, yenimail);
            preparedStatement.setString(4, yenirol);

            // Sorguyu çalıştır
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
