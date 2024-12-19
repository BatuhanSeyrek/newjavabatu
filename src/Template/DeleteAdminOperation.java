package Template;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAdminOperation extends AbstractAdminOperation {

    @Override
    protected String getQuery() {
        return "DELETE FROM kayit WHERE kul_ad = ? AND kul_sifre = ? AND kul_mail = ? AND kul_rol = ?";
    }

    @Override
    protected void setParameters(PreparedStatement preparedStatement, String kullaniciAdi, String sifre, String mail, String rol) throws SQLException {
        preparedStatement.setString(1, kullaniciAdi);
        preparedStatement.setString(2, sifre);
        preparedStatement.setString(3, mail);
        preparedStatement.setString(4, rol);
    }
}

    //Template Method Design Pattern, bir algoritmanın iskeletini tanımlayan ve bazı adımlarını alt sınıflar tarafından özelleştirilmesine olanak tanıyan bir davranışsal tasarım desenidir. Ana algoritma yapısı değişmeden, bazı parçalarının alt sınıflarda özelleştirilmesi gerektiği durumlarda kullanılır.

        //Ne İşe Yarar?
        //Ortak Algoritma Yapısını Korur: Algoritmanın genel akışını üst sınıfta tanımlar ve alt sınıfların sadece gerekli adımları özelleştirmesine izin verir.
        //Kod Tekrarını Azaltır: Ortak algoritma yapısını bir yerde toplar, tekrarlayan kodları ortadan kaldırır.
        //Kontrollü Özelleştirme: Alt sınıfların algoritmanın belirli kısımlarını değiştirmesine olanak tanır, ancak tüm algoritmayı bozmasını engeller.
        //Ne Gibi Kolaylıklar Sağlar?
        //Kodun Yeniden Kullanılabilirliği: Ortak algoritma mantığını tek bir yerde tutarak, farklı alt sınıfların bunu kullanmasını sağlar.
        //Esneklik: Alt sınıfların, yalnızca özelleştirilmesi gereken adımları geçersiz kılarak algoritmayı değiştirmesine izin verir.
        //Tutarlılık: Tüm alt sınıflar için aynı algoritma yapısını zorunlu kılarak tutarlı davranış sağlar.
        //Bakım Kolaylığı: Algoritma akışı değişirse, yalnızca üst sınıfta düzenleme yapmak yeterli olur.

