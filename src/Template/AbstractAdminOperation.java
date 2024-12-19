package Template;

import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractAdminOperation {

    public final boolean execute(String kullaniciAdi, String sifre, String mail, String rol) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = getQuery();
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                setParameters(preparedStatement, kullaniciAdi, sifre, mail, rol);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    protected abstract String getQuery(); // Alt sınıfın sorguyu tanımlaması gerekiyor.

    protected abstract void setParameters(PreparedStatement preparedStatement, String kullaniciAdi, String sifre, String mail, String rol) throws SQLException;
}

//Abstract class (Soyut sınıf), tamamlanmamış (eksik) bir sınıf olup, başka sınıflar tarafından miras alınarak tamamlanması gereken bir tasarım sunar.
// Soyut sınıflar, hem tamamlanmış hem de tamamlanmamış (soyut) metotlar içerebilir.

