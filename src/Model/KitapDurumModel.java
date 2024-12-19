// KitapDurumModel sınıfı
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KitapDurumModel {
    public static void guncelleKitapDurumu(String id) {
        String updateQuery = "UPDATE kitap SET kitap_durum = 'ödünç' WHERE kitap_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setInt(1, Integer.parseInt(id));
            int rowsAffected = preparedStatement.executeUpdate(); // executeQuery() yerine executeUpdate() kullan

            if (rowsAffected > 0) {
                System.out.println("Kitap durumu başarıyla güncellendi!");
            } else {
                System.err.println("Kitap durumu güncellenemedi. ID bulunamadı.");
            }

        } catch (SQLException e) {
            System.err.println("Veritabanı bağlantısı sırasında bir hata oluştu:");
            e.printStackTrace();
        }
    }
}
