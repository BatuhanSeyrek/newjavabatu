package View;

import Controller.*;
import Factory.ConcreteEkleAdminFactory;
import Model.*;
import State.KayitBasariliState;
import State.KayitBasarisizState;
import Strategy.AbstractGoruntuleAdmin;
import Strategy.DefaultGoruntuleAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static int sayi = 0;


    public static void main(String[] args) {

        // JFrame oluşturuluyor
        JFrame frame = new JFrame("Kullanıcı İşlemleri");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // JTabbedPane oluşturuluyor
        JTabbedPane tabbedPane = new JTabbedPane();

        // Kayıt Paneli
        JPanel kayitPanel = new JPanel();
        kayitPanel.setLayout(new GridLayout(5, 2));

        JLabel kulLabel = new JLabel("Kullanıcı Kayıt Ekranı");
        kulLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel kul_bosLabel = new JLabel("");
        JLabel kul_adiLabel = new JLabel("Kullanıcı Adı:");
        JTextField kul_adiField = new JTextField();
        JLabel kul_sifreLabel = new JLabel("Kullanıcı Şifre:");
        JTextField kul_sifreField = new JTextField();
        JLabel kul_mailLabel = new JLabel("Kullanıcı Mail:");
        JTextField kul_mailField = new JTextField();

        JButton addButton = new JButton("Kayıt");

        // Controller nesnesi
        KullanicilarController kullanicilarController = new KullanicilarController();
        KayitBasariliState basariliState = new KayitBasariliState();
        KayitBasarisizState basarisizState = new KayitBasarisizState();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kul_ad = kul_adiField.getText();
                String kul_sifre = kul_sifreField.getText();
                String kul_mail = kul_mailField.getText();

                // Başarılı veya başarısız durumuna göre işlem yap
                kullanicilarController.setState(basariliState);

                // Controller üzerinden kaydı ekle
                kullanicilarController.addKullanicilar(kul_ad, kul_sifre, kul_mail);

                JOptionPane.showMessageDialog(frame, "Kayıt başarıyla eklendi.");
                kul_adiField.setText("");
                kul_sifreField.setText("");
                kul_mailField.setText("");

            }
        });

        kayitPanel.add(kulLabel);
        kayitPanel.add(kul_bosLabel);
        kayitPanel.add(kul_adiLabel);
        kayitPanel.add(kul_adiField);
        kayitPanel.add(kul_sifreLabel);
        kayitPanel.add(kul_sifreField);
        kayitPanel.add(kul_mailLabel);
        kayitPanel.add(kul_mailField);

        kayitPanel.add(addButton);

        // Giriş Paneli
        JPanel girisPanel = new JPanel();
        girisPanel.setLayout(new GridLayout(3, 2));

        JLabel kullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
        JTextField kullaniciAdiField = new JTextField();
        JLabel sifreLabel = new JLabel("Şifre:");
        JPasswordField sifreField = new JPasswordField();
        JButton girisButton = new JButton("Giriş");

        GirisController girisController = GirisController.getInstance();

        girisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = kullaniciAdiField.getText();
                String sifre = new String(sifreField.getPassword());
                // Kullanıcı adı ve şifre kontrolü
                if (kullaniciAdi.equals("admin") && sifre.equals("admin")) {

                    tabbedPane.removeAll();

                    JOptionPane.showMessageDialog(null, "Giriş Başarılı!");

                    // Yeni bir panel oluştur
                    JPanel adminPanel = new JPanel();
                    adminPanel.setLayout(new GridLayout(5, 4));
                    JLabel hosgeldinLabel = new JLabel("Hoş geldiniz, " + kullaniciAdi + "!");
                    hosgeldinLabel.setFont(new Font("Arial", Font.BOLD, 35));
                    adminPanel.add(hosgeldinLabel);

                    JPanel adminKullaniciPanel = new JPanel();
                    adminKullaniciPanel.setLayout(new GridLayout(6, 5));

                    tabbedPane.addTab("Admin Sayfası", adminPanel);
                    tabbedPane.addTab("Kullanıcı İşlemleri", adminKullaniciPanel);

                    // Kullanıcı İşlemleri Paneli
                    JLabel kullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
                    JTextField kullaniciAdiField = new JTextField();
                    JLabel sifreLabel = new JLabel("Kullanıcı Şifre:");
                    JPasswordField sifreField = new JPasswordField();
                    JLabel mailLabel = new JLabel("Kullanıcı mail:");
                    JTextField mailField = new JTextField();
                    JLabel rolLabel = new JLabel("Kullanıcı rolü:");
                    JTextField rolField = new JTextField();

                    JButton ekleButton = new JButton("Kullanıcı Ekle");
                    JButton guncelleButton = new JButton("Kullanıcı Güncelle");
                    JButton silButton = new JButton("Kullanıcı Sil");
                    JButton goruntuleButton = new JButton("Kullanıcı Görüntüle");

                    // Kullanıcı İşlemleri Formu
                    adminKullaniciPanel.add(kullaniciAdiLabel);
                    adminKullaniciPanel.add(kullaniciAdiField);
                    adminKullaniciPanel.add(sifreLabel);
                    adminKullaniciPanel.add(sifreField);
                    adminKullaniciPanel.add(mailLabel);
                    adminKullaniciPanel.add(mailField);
                    adminKullaniciPanel.add(rolLabel);
                    adminKullaniciPanel.add(rolField);
                    adminKullaniciPanel.add(ekleButton);
                    adminKullaniciPanel.add(guncelleButton);
                    adminKullaniciPanel.add(silButton);
                    adminKullaniciPanel.add(goruntuleButton);
                    ////////////////////////////////////////////////////////////////////////////////////////////////////
                    //EKLE
                    // Controller nesnesi
                    ConcreteEkleAdminFactory factory = new ConcreteEkleAdminFactory();
                    ekleAdminController ekleadminController = new ekleAdminController(factory);

                    // Buton Olayları
                    ekleButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı ekleme işlemleri

                            String kullaniciAdi = kullaniciAdiField.getText();
                            String sifre = new String(sifreField.getPassword());
                            String mail = mailField.getText();
                            String rol = rolField.getText();

                            // Controller üzerinden kaydı ekle
                            ekleadminController.addekleAdmin(kullaniciAdi, sifre, mail, rol);
                            JOptionPane.showMessageDialog(frame, "Kayıt başarıyla eklendi.");
                            kullaniciAdiField.setText("");
                            sifreField.setText("");
                            mailField.setText("");
                            rolField.setText("");
                        }
                    });
                    ////////////////////////////////////////////////////////////////////////////////////////////////////

                    //SİL
                    // Controller nesnesi
                    silAdminController siladminController = new silAdminController();

                    // Buton Olayları
                    silButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı silme işlemleri

                            String kullaniciAdi = kullaniciAdiField.getText();
                            String sifre = new String(sifreField.getPassword());
                            String mail = mailField.getText();
                            String rol = rolField.getText();

                            // Controller üzerinden kaydı sil
                            siladminController.deletesilAdmin(kullaniciAdi, sifre, mail, rol);
                            JOptionPane.showMessageDialog(frame, "Kayıt başarıyla silindi.");
                            kullaniciAdiField.setText("");
                            sifreField.setText("");
                            mailField.setText("");
                            rolField.setText("");
                        }
                    });
                    ////////////////////////////////////////////////////////////////////////////////////////////////////

                    //GÜNCELLE

                    // Buton Olayları
                    guncelleButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı güncelleme işlemleri

                            String kullaniciAdi = kullaniciAdiField.getText();
                            String sifre = new String(sifreField.getPassword());
                            String mail = mailField.getText();
                            String rol = rolField.getText();

                            // Girilen kullanıcı adına göre güncelle
                            boolean success = siladminController.deletesilAdmin(kullaniciAdi, sifre, mail, rol);

                            if (success) {
                                JOptionPane.showMessageDialog(frame, "Kullanıcı güncelleme ekranı.");

                                // Yeni tab oluştur ve "Kullanıcı İşlemleri" tabını kaldır
                                tabbedPane.remove(adminKullaniciPanel);
                                JPanel guncellemePanel = new JPanel();
                                guncellemePanel.setLayout(new GridLayout(5, 2));

                                // Yeni tabdaki alanları oluştur
                                JLabel yenikullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
                                JTextField yenikullaniciAdiField = new JTextField();

                                JLabel yenisifreLabel = new JLabel("Kullanıcı Şifre:");
                                JPasswordField yenisifreField = new JPasswordField();

                                JLabel yenimailLabel = new JLabel("Kullanıcı Mail:");
                                JTextField yenimailField = new JTextField();

                                JLabel yenirolLabel = new JLabel("Kullanıcı Rol:");
                                JTextField yenirolField = new JTextField();

                                JButton yeniGuncelleButton = new JButton("Güncelle");

                                // Yeni tabı oluştur
                                guncellemePanel.add(yenikullaniciAdiLabel);
                                guncellemePanel.add(yenikullaniciAdiField);
                                guncellemePanel.add(yenisifreLabel);
                                guncellemePanel.add(yenisifreField);
                                guncellemePanel.add(yenimailLabel);
                                guncellemePanel.add(yenimailField);
                                guncellemePanel.add(yenirolLabel);
                                guncellemePanel.add(yenirolField);
                                guncellemePanel.add(new JLabel()); // Boş alan
                                guncellemePanel.add(yeniGuncelleButton);

                                tabbedPane.addTab("Kullanıcı Güncelleme", guncellemePanel);
                                tabbedPane.setSelectedComponent(guncellemePanel); // Yeni tabı aktif yap

                                guncelleAdminController guncelleadminController = new guncelleAdminController();

                                // Yeni Güncelle Buton Olayı
                                yeniGuncelleButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Yeni tabdaki bilgileri al
                                        String yenikullaniciAdi = yenikullaniciAdiField.getText();
                                        String yenisifre = new String(yenisifreField.getPassword());
                                        String yenimail = yenimailField.getText();
                                        String yenirol = yenirolField.getText();

                                        // Güncellemeyi gerçekleştir
                                        boolean yeniBasari = guncelleadminController.updateguncelleAdmin(yenikullaniciAdi, yenisifre, yenimail, yenirol);

                                        if (yeniBasari) {
                                            JOptionPane.showMessageDialog(frame, "Kullanıcı bilgileri başarıyla güncellendi.");
                                            tabbedPane.remove(guncellemePanel); // guncelleme panel tabını siler
                                            tabbedPane.addTab("Kullanıcı İşlemleri", adminKullaniciPanel);
                                            tabbedPane.setSelectedComponent(adminKullaniciPanel);

                                            yenikullaniciAdiField.setText("");
                                            yenisifreField.setText("");
                                            yenimailField.setText("");
                                            yenirolField.setText("");
                                        }

                                        else {
                                            JOptionPane.showMessageDialog(frame, "Kullanıcı güncellenemedi.", "Hata", JOptionPane.ERROR_MESSAGE);
                                        }

                                    }
                                });


                            } else {
                                JOptionPane.showMessageDialog(frame, "Kullanıcı güncellenemedi. Lütfen bilgileri kontrol edin.", "Hata", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });
                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    //Kullanıcı Kayıtlarını Görüntüle
                    AbstractGoruntuleAdmin goruntuleAdmin = new DefaultGoruntuleAdmin();
                    goruntuleAdminController goruntuleadminController = new goruntuleAdminController(goruntuleAdmin);

                    // Buton Olayları
                    goruntuleButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı verilerini al
                            List<String[]> kullaniciListesi = goruntuleAdminController.getKullaniciListesi();

                            // "Kullanıcı Listesi" adındaki eski tabı kontrol et ve varsa kaldır
                            int tabCount = tabbedPane.getTabCount();
                            for (int i = 0; i < tabCount; i++) {
                                if (tabbedPane.getTitleAt(i).equals("Kullanıcı Listesi")) {
                                    tabbedPane.removeTabAt(i);
                                    break;
                                }

                            }

                            // Yeni bir tab oluştur
                            JPanel goruntulePanel = new JPanel(new BorderLayout());

                            // Tablo sütunları
                            String[] columnNames = {"Kullanıcı Adı", "Şifre", "Mail", "Rol"};

                            // Veriler
                            String[][] data = kullaniciListesi.toArray(new String[0][]);

                            // JTable oluştur
                            JTable table = new JTable(data, columnNames);
                            JScrollPane scrollPane = new JScrollPane(table);

                            // Tabloyu panele ekle
                            goruntulePanel.add(scrollPane, BorderLayout.CENTER);

                            // Yeni tab ekle
                            tabbedPane.addTab("Kullanıcı Listesi", goruntulePanel);
                            tabbedPane.setSelectedComponent(goruntulePanel);
                        }
                    });
                }
                else if (girisController.contGiris(kullaniciAdi, sifre)) {
                    JOptionPane.showMessageDialog(frame, "Giriş Başarılı!");

                    // Yeni bir panel oluştur
                    JPanel yeniPanel = new JPanel();
                    yeniPanel.setLayout(new FlowLayout());
                    JPanel kutuphane = new JPanel();
                    JPanel odunc = new JPanel();
                    JPanel kullaniciOlanlar = new JPanel();
                    kutuphane.setLayout(new BorderLayout());
                    kullaniciOlanlar.setLayout(new BorderLayout());
                    odunc.setLayout(new BorderLayout());
                    JLabel hosgeldinLabel = new JLabel("Hoş geldiniz, " + kullaniciAdi + "!");
                    hosgeldinLabel.setFont(new Font("Arial", Font.BOLD, 35));
                    yeniPanel.add(hosgeldinLabel);
// ... (diğer kodlarınız)

// Kütüphane paneli oluşturma ve kitapları listeleme kısmı

                    JTextArea kitapListesi = new JTextArea(10, 20);
                    kitapListesi.setEditable(false);
                    JTextArea oduncListesi = new JTextArea(10, 20);
                    kitapListesi.setEditable(false);
                    JTextArea kullanicidaOlanlarListesi = new JTextArea(10, 20);
                    kullanicidaOlanlarListesi.setEditable(false);
                    KullanicidaOlanlarController kullanicidaOlanlarController= new KullanicidaOlanlarController();
                    OduncController oduncController=new OduncController();
                    KitapController kitapController = new KitapController();
                    kullanicidaOlanlarController.listAllKitap(kullanicidaOlanlarListesi);
                    kitapController.listAllKitap(kitapListesi,null);
                    oduncController.listAllOdunc(oduncListesi,null);

                    JPanel searchPanel = new JPanel();
                    JLabel searchLabel = new JLabel("Arama Motoru: ");
                    JTextField searchField = new JTextField(15);
                    JButton searchButton = new JButton("Ara");

                    JPanel oduncSearchPanel = new JPanel();
                    JLabel oduncSearchLabel = new JLabel("Arama Motoru:");
                    JTextField oduncSearchField = new JTextField(15);
                    JButton oduncSearchButton = new JButton("Ara");
                    searchButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String searchQuery = searchField.getText();
                            kitapController.listAllKitap(kitapListesi, searchQuery);
                        }
                    });
                    oduncSearchButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String searchQuery = oduncSearchField.getText();
                            oduncController.listAllOdunc(oduncListesi, searchQuery);
                        }
                    });
                    searchPanel.add(searchLabel);
                    searchPanel.add(searchField);
                    searchPanel.add(searchButton);

                    kutuphane.add(searchPanel, BorderLayout.NORTH);


                    frame.add(tabbedPane);
                    frame.pack();
                    frame.setVisible(true);

                    JScrollPane scrollPane = new JScrollPane(kitapListesi);
                    JScrollPane scrollOlanlar = new JScrollPane(kullanicidaOlanlarListesi);
                    JScrollPane scrollodunc = new JScrollPane(oduncListesi);

                    oduncSearchPanel.add(oduncSearchLabel);
                    oduncSearchPanel.add(oduncSearchField);
                    oduncSearchPanel.add(oduncSearchButton);
                    odunc.add(oduncSearchPanel, BorderLayout.NORTH);


                    kutuphane.add(scrollPane, BorderLayout.CENTER);
                    kullaniciOlanlar.add(scrollOlanlar, BorderLayout.CENTER);
                    odunc.add(scrollodunc, BorderLayout.CENTER);
                    // Eski paneli gizle ve yeni paneli göster
                    tabbedPane.removeAll();
                    tabbedPane.addTab("Giriş", yeniPanel);
                    tabbedPane.addTab("Kütüphane", kutuphane);
                    tabbedPane.addTab("Ödünç Kitablar", odunc);
                    tabbedPane.addTab("Aldıklarım", kullaniciOlanlar);
                    tabbedPane.setSelectedIndex(0);
                    frame.add(tabbedPane);
                    frame.pack();
                    frame.setVisible(true);

                    KitapDurumModel kitapDurumModel=new KitapDurumModel();
                    KullaniciOduncModel kullaniciOduncModel=new KullaniciOduncModel();

                    kitapListesi.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            if (sayi >= 1) {
                                JOptionPane.showMessageDialog(null, "Bu işlem yalnızca bir kez gerçekleştirilebilir.");
                            } else {sayi++;
                            try {
                                // Metni alıyoruz ve bloklara ayırıyoruz
                                String metin = kitapListesi.getText();
                                String[] bloklar = metin.split("---------------------------------------------------");

                                // Tıklanan satırı buluyoruz
                                int offset = kitapListesi.viewToModel(e.getPoint());
                                int satirNumarasi = kitapListesi.getLineOfOffset(offset);

                                // Tıklanan satırın hangi bloğa ait olduğunu bul
                                int satirSayaci = 0;
                                for (String blok : bloklar) {
                                    if (blok.trim().isEmpty()) continue; // Boş blokları atla
                                    int satirSayisi = blok.split("\\n").length; // Bu bloktaki toplam satır sayısı

                                    // Tıklanan satır bu blokta mı?
                                    if (satirNumarasi < satirSayaci + satirSayisi) {
                                        // Bu bloğun içindeki ID'yi al
                                        Pattern pattern = Pattern.compile("ID:\\s*(\\d+),");
                                        Matcher matcher = pattern.matcher(blok);

                                        if (matcher.find()) {
                                            String id = matcher.group(1);
                                            System.out.println("Tıklanan bölümdeki ID: " + id);
                                            kitapDurumModel.guncelleKitapDurumu(id);
                                            kullaniciOduncModel.guncelleKullaniciKitapDurumu(kullaniciAdi,id);
                                            kitapController.listAllKitap(kitapListesi,null);
                                            oduncController.listAllOdunc(oduncListesi,null);
                                            kullanicidaOlanlarController.listAllKitap(kullanicidaOlanlarListesi);
                                        } else {
                                            System.err.println("Bu blokta bir ID bulunamadı.");
                                        }
                                        return;
                                    }

                                    satirSayaci += satirSayisi; // Sonraki bloğa geç
                                }

                                System.err.println("Hiçbir blok bulunamadı.");
                            } catch (Exception ex) {
                                System.err.println("Bir hata oluştu.");
                                ex.printStackTrace();
                            }System.out.println("Mouse entered multiple times.");}
                        }
                    });

                }
                else {
                    JOptionPane.showMessageDialog(frame, "Giriş Başarısız!");
                }
            }
        });


        girisPanel.add(kullaniciAdiLabel);
        girisPanel.add(kullaniciAdiField);
        girisPanel.add(sifreLabel);
        girisPanel.add(sifreField);
        girisPanel.add(girisButton);

        JPanel personelgirisPanel = new JPanel();
        personelgirisPanel.setLayout(new GridLayout(3, 2));

        JLabel personelAdiLabel = new JLabel("Personel Adı:");
        JTextField personelAdiField = new JTextField();
        JLabel personelsifreLabel = new JLabel("Personel Şifre:");
        JPasswordField personelsifreField = new JPasswordField();
        JButton personelgirisButton = new JButton("Giriş");

        PersonelController personelController = new PersonelController();
        LoginObserver loginObserver = new LoginObserver(frame);
        personelController.addObserver(loginObserver);

        personelgirisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = personelAdiField.getText();
                String sifre = new String(personelsifreField.getPassword());
                // Kullanıcı adı ve şifre kontrolü
                if (kullaniciAdi.equals("admin") && sifre.equals("admin")) {

                    tabbedPane.removeAll();

                    JOptionPane.showMessageDialog(null, "Giriş Başarılı!");

                    // Yeni bir panel oluştur
                    JPanel adminPanel = new JPanel();
                    adminPanel.setLayout(new GridLayout(5, 4));
                    JLabel hosgeldinLabel = new JLabel("Hoş geldiniz, " + kullaniciAdi + "!");
                    hosgeldinLabel.setFont(new Font("Arial", Font.BOLD, 35));
                    adminPanel.add(hosgeldinLabel);

                    JPanel adminKullaniciPanel = new JPanel();
                    adminKullaniciPanel.setLayout(new GridLayout(6, 5));

                    tabbedPane.addTab("Admin Sayfası", adminPanel);
                    tabbedPane.addTab("Kullanıcı İşlemleri", adminKullaniciPanel);

                    // Kullanıcı İşlemleri Paneli
                    JLabel kullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
                    JTextField kullaniciAdiField = new JTextField();
                    JLabel sifreLabel = new JLabel("Kullanıcı Şifre:");
                    JPasswordField sifreField = new JPasswordField();
                    JLabel mailLabel = new JLabel("Kullanıcı mail:");
                    JTextField mailField = new JTextField();
                    JLabel rolLabel = new JLabel("Kullanıcı rolü:");
                    JTextField rolField = new JTextField();

                    JButton ekleButton = new JButton("Kullanıcı Ekle");
                    JButton guncelleButton = new JButton("Kullanıcı Güncelle");
                    JButton silButton = new JButton("Kullanıcı Sil");
                    JButton goruntuleButton = new JButton("Kullanıcı Görüntüle");

                    // Kullanıcı İşlemleri Formu
                    adminKullaniciPanel.add(kullaniciAdiLabel);
                    adminKullaniciPanel.add(kullaniciAdiField);
                    adminKullaniciPanel.add(sifreLabel);
                    adminKullaniciPanel.add(sifreField);
                    adminKullaniciPanel.add(mailLabel);
                    adminKullaniciPanel.add(mailField);
                    adminKullaniciPanel.add(rolLabel);
                    adminKullaniciPanel.add(rolField);
                    adminKullaniciPanel.add(ekleButton);
                    adminKullaniciPanel.add(guncelleButton);
                    adminKullaniciPanel.add(silButton);
                    adminKullaniciPanel.add(goruntuleButton);
                    ////////////////////////////////////////////////////////////////////////////////////////////////////
                    //EKLE
                    // Controller nesnesi
                    ConcreteEkleAdminFactory factory = new ConcreteEkleAdminFactory();

                    ekleAdminController ekleadminController = new ekleAdminController(factory);

                    // Buton Olayları
                    ekleButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı ekleme işlemleri

                            String kullaniciAdi = kullaniciAdiField.getText();
                            String sifre = new String(sifreField.getPassword());
                            String mail = mailField.getText();
                            String rol = rolField.getText();

                            // Controller üzerinden kaydı ekle
                            ekleadminController.addekleAdmin(kullaniciAdi, sifre, mail, rol);
                            JOptionPane.showMessageDialog(frame, "Kayıt başarıyla eklendi.");
                            kullaniciAdiField.setText("");
                            sifreField.setText("");
                            mailField.setText("");
                            rolField.setText("");
                        }
                    });
                    ////////////////////////////////////////////////////////////////////////////////////////////////////

                    //SİL
                    // Controller nesnesi
                    silAdminController siladminController = new silAdminController();

                    // Buton Olayları
                    silButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı silme işlemleri

                            String kullaniciAdi = kullaniciAdiField.getText();
                            String sifre = new String(sifreField.getPassword());
                            String mail = mailField.getText();
                            String rol = rolField.getText();

                            // Controller üzerinden kaydı sil
                            siladminController.deletesilAdmin(kullaniciAdi, sifre, mail, rol);
                            JOptionPane.showMessageDialog(frame, "Kayıt başarıyla silindi.");
                            kullaniciAdiField.setText("");
                            sifreField.setText("");
                            mailField.setText("");
                            rolField.setText("");
                        }
                    });
                    ////////////////////////////////////////////////////////////////////////////////////////////////////

                    //GÜNCELLE

                    // Buton Olayları
                    guncelleButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı güncelleme işlemleri

                            String kullaniciAdi = kullaniciAdiField.getText();
                            String sifre = new String(sifreField.getPassword());
                            String mail = mailField.getText();
                            String rol = rolField.getText();

                            // Girilen kullanıcı adına göre güncelle
                            boolean success = siladminController.deletesilAdmin(kullaniciAdi, sifre, mail, rol);

                            if (success) {
                                JOptionPane.showMessageDialog(frame, "Kullanıcı güncelleme ekranı.");

                                // Yeni tab oluştur ve "Kullanıcı İşlemleri" tabını kaldır
                                tabbedPane.remove(adminKullaniciPanel);
                                JPanel guncellemePanel = new JPanel();
                                guncellemePanel.setLayout(new GridLayout(5, 2));

                                // Yeni tabdaki alanları oluştur
                                JLabel yenikullaniciAdiLabel = new JLabel("Kullanıcı Adı:");
                                JTextField yenikullaniciAdiField = new JTextField();

                                JLabel yenisifreLabel = new JLabel("Kullanıcı Şifre:");
                                JPasswordField yenisifreField = new JPasswordField();

                                JLabel yenimailLabel = new JLabel("Kullanıcı Mail:");
                                JTextField yenimailField = new JTextField();

                                JLabel yenirolLabel = new JLabel("Kullanıcı Rol:");
                                JTextField yenirolField = new JTextField();

                                JButton yeniGuncelleButton = new JButton("Güncelle");

                                // Yeni tabı oluştur
                                guncellemePanel.add(yenikullaniciAdiLabel);
                                guncellemePanel.add(yenikullaniciAdiField);
                                guncellemePanel.add(yenisifreLabel);
                                guncellemePanel.add(yenisifreField);
                                guncellemePanel.add(yenimailLabel);
                                guncellemePanel.add(yenimailField);
                                guncellemePanel.add(yenirolLabel);
                                guncellemePanel.add(yenirolField);
                                guncellemePanel.add(new JLabel()); // Boş alan
                                guncellemePanel.add(yeniGuncelleButton);

                                tabbedPane.addTab("Kullanıcı Güncelleme", guncellemePanel);
                                tabbedPane.setSelectedComponent(guncellemePanel); // Yeni tabı aktif yap

                                guncelleAdminController guncelleadminController = new guncelleAdminController();

                                // Yeni Güncelle Buton Olayı
                                yeniGuncelleButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Yeni tabdaki bilgileri al
                                        String yenikullaniciAdi = yenikullaniciAdiField.getText();
                                        String yenisifre = new String(yenisifreField.getPassword());
                                        String yenimail = yenimailField.getText();
                                        String yenirol = yenirolField.getText();

                                        // Güncellemeyi gerçekleştir
                                        boolean yeniBasari = guncelleadminController.updateguncelleAdmin(yenikullaniciAdi, yenisifre, yenimail, yenirol);

                                        if (yeniBasari) {
                                            JOptionPane.showMessageDialog(frame, "Kullanıcı bilgileri başarıyla güncellendi.");
                                            tabbedPane.remove(guncellemePanel); // guncelleme panel tabını siler
                                            tabbedPane.addTab("Kullanıcı İşlemleri", adminKullaniciPanel);
                                            tabbedPane.setSelectedComponent(adminKullaniciPanel);

                                            yenikullaniciAdiField.setText("");
                                            yenisifreField.setText("");
                                            yenimailField.setText("");
                                            yenirolField.setText("");

                                        }

                                        else {
                                            JOptionPane.showMessageDialog(frame, "Kullanıcı güncellenemedi.", "Hata", JOptionPane.ERROR_MESSAGE);
                                        }

                                    }
                                });


                            } else {
                                JOptionPane.showMessageDialog(frame, "Kullanıcı güncellenemedi. Lütfen bilgileri kontrol edin.", "Hata", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });
                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    //Kullanıcı Kayıtlarını Görüntüle
                    AbstractGoruntuleAdmin goruntuleAdmin = new DefaultGoruntuleAdmin();
                    goruntuleAdminController goruntuleadminController = new goruntuleAdminController(goruntuleAdmin);

                    // Buton Olayları
                    goruntuleButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı verilerini al
                            List<String[]> kullaniciListesi = goruntuleAdminController.getKullaniciListesi();

                            // "Kullanıcı Listesi" adındaki eski tabı kontrol et ve varsa kaldır
                            int tabCount = tabbedPane.getTabCount();
                            for (int i = 0; i < tabCount; i++) {
                                if (tabbedPane.getTitleAt(i).equals("Kullanıcı Listesi")) {
                                    tabbedPane.removeTabAt(i);
                                    break;
                                }

                            }

                            // Yeni bir tab oluştur
                            JPanel goruntulePanel = new JPanel(new BorderLayout());

                            // Tablo sütunları
                            String[] columnNames = {"Kullanıcı Adı", "Şifre", "Mail", "Rol"};

                            // Veriler
                            String[][] data = kullaniciListesi.toArray(new String[0][]);

                            // JTable oluştur
                            JTable table = new JTable(data, columnNames);
                            JScrollPane scrollPane = new JScrollPane(table);

                            // Tabloyu panele ekle
                            goruntulePanel.add(scrollPane, BorderLayout.CENTER);
                            goruntuleadminController.getKullaniciListesi();
                            // Yeni tab ekle
                            tabbedPane.addTab("Kullanıcı Listesi", goruntulePanel);
                            tabbedPane.setSelectedComponent(goruntulePanel);
                        }
                    });
                }
                else if (personelController.contPersonelGiris(kullaniciAdi, sifre)) {

                    // Yeni bir panel oluştur
                    JPanel yeniPanel = new JPanel();
                    yeniPanel.setLayout(new FlowLayout());
                    JPanel kutuphane = new JPanel();
                    JPanel odunckayip = new JPanel();
                    JPanel kayip = new JPanel();
                    JPanel kitapEkle = new JPanel();
                    kitapEkle.setLayout(new GridLayout(4, 2));
                    kutuphane.setLayout(new BorderLayout());
                    kayip.setLayout(new BorderLayout());


                    odunckayip.setLayout(new BorderLayout());
                    JLabel hosgeldinLabel = new JLabel("Hoş geldiniz, personelimiz " + kullaniciAdi + "!");
                    hosgeldinLabel.setFont(new Font("Arial", Font.BOLD, 35));
                    yeniPanel.add(hosgeldinLabel);
// ... (diğer kodlarınız)

// Kütüphane paneli oluşturma ve kitapları listeleme kısmı

                    JTextArea kitapListesi = new JTextArea(10, 20);
                    kitapListesi.setEditable(false);
                    JTextArea odunckayipListesi = new JTextArea(10, 20);
                    odunckayipListesi.setEditable(false);
                    JTextArea kayipListesi = new JTextArea(10, 20);
                    kayipListesi.setEditable(false);

                    JTextArea kullanicidaOlanlarListesi = new JTextArea(10, 20);
                    kullanicidaOlanlarListesi.setEditable(false);
                    OduncKayipController oduncKayipController = new OduncKayipController();
                    KullanicidaOlanlarController kullanicidaOlanlarController= new KullanicidaOlanlarController();

                    KitapController kitapController = new KitapController();
                    kullanicidaOlanlarController.listAllKitap(kullanicidaOlanlarListesi);
                    kitapController.listAllKitap(kitapListesi,null);
                    oduncKayipController.listAllKitap(odunckayipListesi,null);
                    kitapController.listAllKitap(kayipListesi,null);

                    JPanel searchPanel = new JPanel();
                    JLabel searchLabel = new JLabel("Arama Motoru: ");
                    JTextField searchField = new JTextField(15);
                    JButton searchButton = new JButton("Ara");

                    JPanel searchodunckayipPanel = new JPanel();
                    JLabel searchodunckayipLabel = new JLabel("Arama Motoru: ");
                    JTextField searchodunckayipField = new JTextField(15);
                    JButton searchodunckayipButton = new JButton("Ara");

                    JPanel searchkayipPanel = new JPanel();
                    JLabel searchkayipLabel = new JLabel("Arama Motoru: ");
                    JTextField searchkayipField = new JTextField(15);
                    JButton searchkayipButton = new JButton("Ara");


                    JPanel oduncSearchPanel = new JPanel();
                    JLabel oduncSearchLabel = new JLabel("Arama Motoru:");
                    JTextField oduncSearchField = new JTextField(15);
                    JButton oduncSearchButton = new JButton("Ara");
                    searchButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String searchQuery = searchField.getText();
                            kitapController.listAllKitap(kitapListesi, searchQuery);
                        }
                    });
                    searchodunckayipButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String searchQuery = searchodunckayipField.getText();
                            oduncKayipController.listAllKitap(odunckayipListesi, searchQuery);
                        }
                    });
                    searchkayipButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String searchQuery = searchkayipField.getText();
                            kitapController.listAllKitap(kayipListesi, searchQuery);
                        }
                    });

                    searchPanel.add(searchLabel);
                    searchPanel.add(searchField);
                    searchPanel.add(searchButton);

                    searchodunckayipPanel.add(searchodunckayipLabel);
                    searchodunckayipPanel.add(searchodunckayipField);
                    searchodunckayipPanel.add(searchodunckayipButton);

                    kutuphane.add(searchPanel, BorderLayout.NORTH);
                    kayip.add(searchkayipPanel, BorderLayout.NORTH);
                    odunckayip.add(searchodunckayipPanel, BorderLayout.NORTH);

                    searchkayipPanel.add(searchkayipLabel);
                    searchkayipPanel.add(searchkayipField);
                    searchkayipPanel.add(searchkayipButton);

                    frame.add(tabbedPane);
                    frame.pack();
                    frame.setVisible(true);

                    JScrollPane scrollPane = new JScrollPane(kitapListesi);

                    JScrollPane scrollkayipPane = new JScrollPane(kayipListesi);
                    JScrollPane scrollodunckayipPane = new JScrollPane(odunckayipListesi);

                    JScrollPane scrollOlanlar = new JScrollPane(kullanicidaOlanlarListesi);

/*
                    searchodunckayipPanel.add(oduncSearchLabel);
                    searchodunckayipPanel.add(oduncSearchField);
                    searchodunckayipPanel.add(oduncSearchButton);
                    searchodunckayipPanel.add(oduncSearchPanel, BorderLayout.NORTH);
*/
                    kayip.add(scrollkayipPane, BorderLayout.CENTER);
                    kutuphane.add(scrollPane, BorderLayout.CENTER);

                    odunckayip.add(scrollodunckayipPane, BorderLayout.CENTER);
                    // Eski paneli gizle ve yeni paneli göster
                    tabbedPane.removeAll();
                    tabbedPane.addTab("Giriş", yeniPanel);
                    tabbedPane.addTab("Kütüphane", kutuphane);
                    tabbedPane.addTab("Kayip", kayip);
                    tabbedPane.addTab("Ödünç Kitablar", odunckayip);
                    tabbedPane.addTab("Kitap Ekle", kitapEkle);

                    JLabel kitapAdiLabel = new JLabel("Kitap Adı:");
                    JTextField kitapAdiField = new JTextField();
                    JLabel kitapYazariLabel = new JLabel("Kitap Yazarı:");
                    JTextField kitapYazariField = new JTextField();
                    JLabel kitapKonusuLabel = new JLabel("Kitap Konusu:");
                    JTextField kitapKonusuField = new JTextField();
                    JButton kitapButton = new JButton("Kitap Ekle");

                    kitapEkle.add(kitapAdiLabel);
                    kitapEkle.add(kitapAdiField);
                    kitapEkle.add(kitapYazariLabel);
                    kitapEkle.add(kitapYazariField);
                    kitapEkle.add(kitapKonusuLabel);
                    kitapEkle.add(kitapKonusuField);
                    kitapEkle.add(kitapButton);

                    // Buton Olayları
                    kitapButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Kullanıcı silme işlemleri

                            String kitapAdi = kitapAdiField.getText();
                            String kitapYazari = kitapYazariField.getText();
                            String kitapKonusu = kitapKonusuField.getText();

                            KitapEkleController kitapEkleController=new KitapEkleController();
                            // Controller üzerinden kaydı sil
                            kitapEkleController.addKitap(kitapAdi, kitapYazari, kitapKonusu);
                            JOptionPane.showMessageDialog(frame, "Kayıt başarıyla eklendi.");
                            kitapAdiField.setText("");
                            kitapYazariField.setText("");
                            kitapKonusuField.setText("");
                            kitapController.listAllKitap(kayipListesi,null);
                            kitapController.listAllKitap(kitapListesi,null);
                            oduncKayipController.listAllKitap(odunckayipListesi,null);

                        }
                    });


                    tabbedPane.setSelectedIndex(0);
                    frame.add(tabbedPane);
                    frame.pack();
                    frame.setVisible(true);

                    KitapKayipModel kitapKayipModel=new KitapKayipModel();
                    kayipListesi.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {


                                try {
                                    // Metni alıyoruz ve bloklara ayırıyoruz
                                    String metin = kayipListesi.getText();
                                    String[] bloklar = metin.split("---------------------------------------------------");

                                    // Tıklanan satırı buluyoruz
                                    int offset = kayipListesi.viewToModel(e.getPoint());
                                    int satirNumarasi = kayipListesi.getLineOfOffset(offset);

                                    // Tıklanan satırın hangi bloğa ait olduğunu bul
                                    int satirSayaci = 0;
                                    for (String blok : bloklar) {
                                        if (blok.trim().isEmpty()) continue; // Boş blokları atla
                                        int satirSayisi = blok.split("\\n").length; // Bu bloktaki toplam satır sayısı

                                        // Tıklanan satır bu blokta mı?
                                        if (satirNumarasi < satirSayaci + satirSayisi) {
                                            // Bu bloğun içindeki ID'yi al
                                            Pattern pattern = Pattern.compile("ID:\\s*(\\d+),");
                                            Matcher matcher = pattern.matcher(blok);

                                            if (matcher.find()) {
                                                String id = matcher.group(1);

                                                System.out.println("Tıklanan bölümdeki ID: " + id);
                                                kitapKayipModel.guncelleKitapDurumu(id);
                                                kitapController.listAllKitap(kayipListesi,null);
                                                kitapController.listAllKitap(kitapListesi,null);
                                                oduncKayipController.listAllKitap(odunckayipListesi,null);


                                            } else {
                                                System.err.println("Bu blokta bir ID bulunamadı.");
                                            }
                                            return;
                                        }

                                        satirSayaci += satirSayisi; // Sonraki bloğa geç
                                    }

                                    System.err.println("Hiçbir blok bulunamadı.");
                                } catch (Exception ex) {
                                    System.err.println("Bir hata oluştu.");
                                    ex.printStackTrace();
                                }System.out.println("Mouse entered multiple times.");}

                    });
                    CevirmeModel cevirmeModel=new CevirmeModel();
                    odunckayipListesi.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {


                            try {
                                // Metni alıyoruz ve bloklara ayırıyoruz
                                String metin = odunckayipListesi.getText();
                                String[] bloklar = metin.split("---------------------------------------------------");

                                // Tıklanan satırı buluyoruz
                                int offset = odunckayipListesi.viewToModel(e.getPoint());
                                int satirNumarasi = odunckayipListesi.getLineOfOffset(offset);

                                // Tıklanan satırın hangi bloğa ait olduğunu bul
                                int satirSayaci = 0;
                                for (String blok : bloklar) {
                                    if (blok.trim().isEmpty()) continue; // Boş blokları atla
                                    int satirSayisi = blok.split("\\n").length; // Bu bloktaki toplam satır sayısı

                                    // Tıklanan satır bu blokta mı?
                                    if (satirNumarasi < satirSayaci + satirSayisi) {
                                        // Bu bloğun içindeki ID'yi al
                                        Pattern pattern = Pattern.compile("ID:\\s*(\\d+),");
                                        Matcher matcher = pattern.matcher(blok);

                                        if (matcher.find()) {
                                            String id = matcher.group(1);

                                            System.out.println("Tıklanan bölümdeki ID: " + id);
                                            CevirmeModel.guncelleKitapDurumu(id);
                                            oduncKayipController.listAllKitap(odunckayipListesi,null);
                                            kitapController.listAllKitap(kayipListesi,null);
                                            kitapController.listAllKitap(kitapListesi,null);


                                        } else {
                                            System.err.println("Bu blokta bir ID bulunamadı.");
                                        }
                                        return;
                                    }

                                    satirSayaci += satirSayisi; // Sonraki bloğa geç
                                }

                                System.err.println("Hiçbir blok bulunamadı.");
                            } catch (Exception ex) {
                                System.err.println("Bir hata oluştu.");
                                ex.printStackTrace();
                            }System.out.println("Mouse entered multiple times.");}

                    });
                    KitapSilModel kitapSilModel=new KitapSilModel();
                    kitapListesi.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {


                                try {
                                    // Metni alıyoruz ve bloklara ayırıyoruz
                                    String metin = kitapListesi.getText();
                                    String[] bloklar = metin.split("---------------------------------------------------");

                                    // Tıklanan satırı buluyoruz
                                    int offset = kitapListesi.viewToModel(e.getPoint());
                                    int satirNumarasi = kitapListesi.getLineOfOffset(offset);

                                    // Tıklanan satırın hangi bloğa ait olduğunu bul
                                    int satirSayaci = 0;
                                    for (String blok : bloklar) {
                                        if (blok.trim().isEmpty()) continue; // Boş blokları atla
                                        int satirSayisi = blok.split("\\n").length; // Bu bloktaki toplam satır sayısı

                                        // Tıklanan satır bu blokta mı?
                                        if (satirNumarasi < satirSayaci + satirSayisi) {
                                            // Bu bloğun içindeki ID'yi al
                                            Pattern pattern = Pattern.compile("ID:\\s*(\\d+),");
                                            Matcher matcher = pattern.matcher(blok);

                                            if (matcher.find()) {
                                                String id = matcher.group(1);
                                                System.out.println("Tıklanan bölümdeki ID: " + id);
                                                kitapSilModel.guncelleKitapDurumu(id);
                                                kitapController.listAllKitap(kitapListesi,null);
                                                kitapController.listAllKitap(kayipListesi,null);
                                                oduncKayipController.listAllKitap(odunckayipListesi,null);



                                            } else {
                                                System.err.println("Bu blokta bir ID bulunamadı.");
                                            }
                                            return;
                                        }

                                        satirSayaci += satirSayisi; // Sonraki bloğa geç
                                    }

                                    System.err.println("Hiçbir blok bulunamadı.");
                                } catch (Exception ex) {
                                    System.err.println("Bir hata oluştu.");
                                    ex.printStackTrace();
                                }System.out.println("Mouse entered multiple times.");}

                    });

                }
                else {
                    JOptionPane.showMessageDialog(frame, "Giriş Başarısız!");
                }
            }
        });
        personelgirisPanel.add(personelAdiLabel);
        personelgirisPanel.add(personelAdiField);
        personelgirisPanel.add(personelsifreLabel);
        personelgirisPanel.add(personelsifreField);
        personelgirisPanel.add(personelgirisButton);

        tabbedPane.addTab("Kayıt", kayitPanel);
        tabbedPane.addTab("Kullanıcı Giriş", girisPanel);
        tabbedPane.addTab("Personel Giriş", personelgirisPanel);

        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);
    }
}