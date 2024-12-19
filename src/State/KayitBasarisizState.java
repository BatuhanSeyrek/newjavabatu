package State;

public class KayitBasarisizState implements KayitState {
    @Override
    public void handle(String kul_adi, String kul_sifre, String kul_mail) {
        System.out.println("Kayıt sırasında bir hata oluştu. Lütfen bilgileri kontrol edin.");
    }
}
