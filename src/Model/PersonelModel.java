package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonelModel {
    public static boolean contGiris(String kul_adi, String kul_sifre) {

        String selectQuery = "SELECT * FROM kayit WHERE kul_ad = ? AND kul_sifre = ? AND kul_rol='personel'";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            // Değerleri ayarla
            preparedStatement.setString(1, kul_adi);
            preparedStatement.setString(2, kul_sifre);

            // Sorguyu çalıştır
            ResultSet resultSet = preparedStatement.executeQuery();

            // Kullanıcı bulundu mu kontrol et
            if (resultSet.next()) {
                System.out.println("Kullanıcı bulundu.");
                return true;
            } else {
                System.out.println("Kullanıcı bulunamadı.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
