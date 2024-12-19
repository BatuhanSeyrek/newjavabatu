package Factory;

import Model.ekleAdminModel;

public interface ekleAdminFactory {
    ekleAdminModel createekleAdminModel();
}

//Factory Design Pattern, nesne oluşturma sürecini merkezi bir yerde toplayarak kodunuzu daha esnek ve yönetilebilir hale getiren bir tasarım desenidir.
// Özellikle hangi sınıfın örneğinin oluşturulacağına dinamik olarak karar verilmesi gereken durumlarda kullanılır.
//
//Ne İşe Yarar?
//Nesne Oluşturmayı Soyutlar: Nesne oluşturma mantığını, doğrudan kodda değil, bir fabrika sınıfında toplar.
//Kodun Esnekliğini Artırır: Hangi türde nesne oluşturulacağını bilmek istemeyen kodun, bu nesneleri kolayca kullanmasını sağlar.
//Kod Tekrarını Azaltır: Tekrarlayan nesne oluşturma kodlarını merkezi bir yerde toplar.