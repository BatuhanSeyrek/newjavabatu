# Kütüphane Yönetim Sistemi (Java Swing Tabanlı)  

Bu proje, Java Swing kullanılarak geliştirilmiş bir kütüphane yönetim sistemidir. Proje, bir kütüphane yönetiminde gerekli olan *kullanıcı yönetimi, **kitap envanter yönetimi, **kitap ödünç alma/iade işlemleri* gibi işlevleri içerir. Üç farklı kullanıcı türü bulunmaktadır: *Admin, **Personel, ve **Kullanıcı*. Her kullanıcı tipi, kütüphane sistemindeki iş akışına göre belirli yetkilere sahiptir.  

---

## Projenin Amacı  

Bu proje, yazılım geliştirme sürecinde *Object-Oriented Design (OOD)* prensiplerini ve *Tasarım Desenlerini* etkin bir şekilde kullanmayı amaçlamaktadır. Proje, bir yandan gerçek bir kütüphane yönetim sisteminin işlevlerini sunarken, diğer yandan iyi yapılandırılmış bir yazılımın nasıl geliştirileceğine dair bir örnek teşkil eder.  

---

## Özellikler  

### Genel Özellikler  
- Kullanıcı yetkilendirme ve giriş sistemleri.  
- Kullanıcı rolleri ve yetkilere göre farklı ekranlar.  
- Kitap envanter yönetimi (ekleme, silme, güncelleme).  
- Kitap ödünç alma ve iade işlemleri.  
- Esnek ve genişletilebilir bir yazılım mimarisi.  

### Detaylı Özellikler  

#### Kayıt İşlemleri  
- Kullanıcılar, sisteme kayıt olarak hesap oluşturabilir.  
- Kayıt sırasında kullanıcı adı, şifre ve e-posta doğrulaması yapılır.  

#### Giriş İşlemleri  
- Kayıtlı kullanıcılar, kimlik doğrulaması yaparak sisteme giriş yapabilir.  
- Admin ve personel için özel giriş kontrolü mevcuttur.  

#### Admin İşlevleri  
- *Kullanıcı Yönetimi*: Kullanıcı ekleme, silme, güncelleme ve rollerini düzenleme.  
- *Personel Yönetimi*: Yeni personel ekleme ve yetkilendirme.  
- *Kütüphane Envanter Yönetimi*: Kitapların eklenmesi, güncellenmesi ve silinmesi.  

#### Personel İşlevleri  
- Kitap ödünç verme ve iade işlemlerini yönetir.  
- Sisteme yeni kitaplar ekler, mevcut kitapları günceller veya siler.  

#### Kullanıcı İşlevleri  
- Mevcut kitapları görüntüleyebilir.  
- Kitap ödünç alabilir ve geri iade edebilir.  

---

## Tasarım Desenleri  

Projede, iyi yapılandırılmış bir yazılım geliştirmek amacıyla çeşitli tasarım desenleri kullanılmıştır:  

### Kullanılan Tasarım Desenleri  

1. *Factory Pattern*  
   - Admin ve Personel nesnelerinin oluşturulmasında kullanılmıştır.  
   - Esnek bir şekilde farklı kullanıcı türleri oluşturulabilir.  

2. *Strategy Pattern*  
   - Farklı kullanıcıların arayüz davranışlarını dinamik bir şekilde değiştirmek için uygulanmıştır.  
   - Örneğin, Admin ve Kullanıcı arayüzleri farklı stratejilerle yönetilir.  

3. *State Pattern*  
   - Kullanıcı durumu değişikliklerini (örneğin, kayıt başarılı/başarısız) yönetmek için kullanılmıştır.  
   - Kayıt ve giriş işlemlerinde farklı durumlara göre davranış belirlenir.  

4. *Observer Pattern*  
   - Örneğin, yeni bir kullanıcı kaydedildiğinde veya bir kitap ödünç alındığında ilgili bileşenlere bildirim yapılır.  
   - Kullanıcılar ve kitap stok durumu gibi dinamik veriler bu desenle güncellenir.  

5. *Singleton Pattern*  
   - GirisController gibi sınıfların yalnızca bir kez oluşturulmasını sağlamak için kullanılmıştır.  
   - Sistemin genel davranışını yöneten sınıflarda tercih edilmiştir.  

6. *Template Method Pattern*  
   - Kullanıcı ve kitap yönetimi gibi tekrarlayan iş akışlarını soyutlamak için uygulanmıştır.  
   - Her kullanıcı türü için ortak iş akışları bir şablon halinde oluşturulmuştur.  

---

## Proje Yapısı  

Projede, kodların düzenli ve anlaşılır bir şekilde ayrılması için *MVC (Model-View-Controller)* mimarisi kullanılmıştır:  

- *Model*  
  - Uygulama verileri ve iş mantığını içerir.  
  - Örneğin: Kullanıcı, Kitap gibi sınıflar burada tanımlanır.  

- *View*  
  - Kullanıcı arayüzü bileşenlerini içerir.  
  - Örneğin: Swing tabanlı giriş, kayıt ve admin panelleri.  

- *Controller*  
  - View ile Model arasında köprü görevi görür.  
  - İş mantığını yönetir ve kullanıcı girdilerini işler.  

---

## Kurulum ve Çalıştırma  

### Gereksinimler  
- *Java JDK*: 8 veya üzeri  
- *Java IDE*: IntelliJ IDEA, Eclipse veya NetBeans  
- Gerekli Swing kütüphaneleri (standart JDK ile gelir).  

### Çalıştırma Adımları  
1. Depoyu klonlayın:  
   ```bash
   git clone https://github.com/kullanici-adi/kutuphane-yonetim-sistemi.git
