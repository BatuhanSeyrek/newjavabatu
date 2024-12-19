package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GirisModel {
    private static GirisModel instance;

    public static GirisModel getInstance() {
        if (instance == null) {
            synchronized (GirisModel.class) {
                if (instance == null) {
                    instance = new GirisModel();
                }
            }
        }
        return instance;
    }

    public boolean contGiris(String kul_adi, String kul_sifre) {
        String selectQuery = "SELECT * FROM kayit WHERE kul_ad = ? AND kul_sifre = ? AND kul_rol='ogr'";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            preparedStatement.setString(1, kul_adi);
            preparedStatement.setString(2, kul_sifre);

            ResultSet resultSet = preparedStatement.executeQuery();

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
