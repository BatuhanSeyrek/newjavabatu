package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ekleAdminModel {

    public static boolean addekleAdmin(String kullaniciAdi, String sifre, String mail, String rol){

        String insertQuery = "INSERT INTO kayit (kul_ad, kul_sifre, kul_mail, kul_rol) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Değerleri ayarla
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, sifre);
            preparedStatement.setString(3, mail);
            preparedStatement.setString(4, rol);

            // Sorguyu çalıştır
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
