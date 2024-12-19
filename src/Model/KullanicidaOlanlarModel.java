package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KullanicidaOlanlarModel {
    public static List<String> getAllKullanicidaOlanlar() {
        String selectQuery = "SELECT kitap_id, kitap_adi, kitap_yazar, kitap_konu, kitap_durum FROM kitap WHERE kitap_id IN (SELECT kul_sahip FROM kayit WHERE kul_sahip IS NOT NULL AND kul_rol='ogr')";

        List<String> kitaplar = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String kitapAdi = resultSet.getString("kitap_adi");
                String kitapYazar = resultSet.getString("kitap_yazar");
                String kitapKonu = resultSet.getString("kitap_konu");
                String kitapDurum = resultSet.getString("kitap_durum");

                // Kitap bilgilerini listeye ekle
                kitaplar.add("---------------------------------------------------"+",\nKitabın adı:  "+kitapAdi + ",\nKitabın yazarı:  " +kitapYazar + ",\nKitabın Konusu:  " + kitapKonu + ",\n(" + kitapDurum + ")" +"\n---------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Veritabanı sorgusu sırasında bir hata oluştu:");
            e.printStackTrace();
        }

        return kitaplar;
    }
}
