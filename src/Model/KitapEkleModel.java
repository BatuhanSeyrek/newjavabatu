package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KitapEkleModel {

    public static boolean addKitap(String kitap_ad, String kitap_yazar, String kitap_konu){

        String insertQuery = "INSERT INTO kitap (kitap_adi, kitap_durum,kitap_yazar,kitap_konu) VALUES (?, 'kütüphanede', ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Değerleri ayarla
            preparedStatement.setString(1, kitap_ad);
            preparedStatement.setString(2, kitap_yazar);
            preparedStatement.setString(3, kitap_konu);


            // Sorguyu çalıştır
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
