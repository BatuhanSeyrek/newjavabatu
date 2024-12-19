package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OduncModel {
    public static List<String> getAllOdunc() {
        return getFilteredOdunc(null);
    }

    public static List<String> getFilteredOdunc(String searchQuery) {
        String selectQuery = "SELECT * FROM kitap WHERE kitap_durum='ödünç'";
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            selectQuery += " AND (kitap_adi LIKE ? OR kitap_yazar LIKE ?)";
        }
        List<String> kitaplar = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                String searchPattern = "%" + searchQuery + "%";
                preparedStatement.setString(1, searchPattern);
                preparedStatement.setString(2, searchPattern);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String kitap_adi = resultSet.getString("kitap_adi");
                String kitap_durum = resultSet.getString("kitap_durum");
                String kitap_yazar = resultSet.getString("kitap_yazar");
                String kitap_konu = resultSet.getString("kitap_konu");

                // Add data to the list
                kitaplar.add("---------------------------------------------------\nKitabın adı: " + kitap_adi + "\nKitabın yazarı: " + kitap_yazar + "\nKitabın Konusu: " + kitap_konu + "\n(" + kitap_durum + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kitaplar;
    }
}
