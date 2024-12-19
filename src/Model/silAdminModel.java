package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class silAdminModel {
    public static boolean deletesilAdmin(String kullaniciAdi, String sifre, String mail, String rol){

        String deleteQuery = "DELETE FROM kayit WHERE kul_ad = ? AND kul_sifre = ? AND kul_mail = ? AND kul_rol = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

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
