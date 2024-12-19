package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KullaniciOduncModel {
    public static void guncelleKullaniciKitapDurumu(String kullaniciAdi, String kitap_id) throws SQLException {
        String updateQuery = "UPDATE kayit SET kul_sahip = ? WHERE kul_ad = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false); // Otomatik commit kapatılır

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, kitap_id); // Kitap adını ayarla
                preparedStatement.setString(2, kullaniciAdi); // Kitap ID'sini ayarla
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    connection.commit(); // İlgili işlemi commit et
                    System.out.println("Kitap adı ve durumu başarıyla güncellendi!");
                    // Paneli güncelleme işlemi burada yapılabilir
                } else {
                    connection.rollback(); // Rollback işlemi
                    System.err.println("Kitap adı güncellenemedi. ID bulunamadı.");
                }
            } catch (SQLException e) {
                connection.rollback(); // Rollback işlemi hatada
                System.err.println("Veritabanı bağlantısı sırasında bir hata oluştu:");
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true); // Otomatik commit tekrar açılır
            }


        }
    }
}
