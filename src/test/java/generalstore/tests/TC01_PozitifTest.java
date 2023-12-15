package generalstore.tests;

import generalstore.pages.FormSayfasi;
import generalstore.pages.SepetSayfasi;
import generalstore.pages.SiparisTamamlamaSayfasi;
import generalstore.pages.UrunKatalogSayfasi;
import org.testng.annotations.Test;

import static generalstore.utils.Driver.uygulamayiKapat;

public class TC01_PozitifTest {
    @Test
    public void tc01PozitifTest() {
        FormSayfasi formSayfasi = new FormSayfasi();
        formSayfasi.ulkeSec("Belize");
        formSayfasi.isimGir("Safinaz");
        formSayfasi.cinsiyetSec("FEMALE");
        formSayfasi.letsShopButonunaTikla();

        UrunKatalogSayfasi urunKatalogSayfasi = new UrunKatalogSayfasi();
        urunKatalogSayfasi.sepeteUrunEkle("Converse All Star", 1);
        urunKatalogSayfasi.sepeteUrunEkle("LeBron Soldier 12 ", 1);
        urunKatalogSayfasi.sepeteGit();

        SepetSayfasi sepetSayfasi = new SepetSayfasi();
        sepetSayfasi.secilenUrunAdediniDogrula(2);
        sepetSayfasi.secilenUrunlerinToplamFiyatiniDogrula();
        sepetSayfasi.kontrolKutusunaTikla();
        sepetSayfasi.satinAlmaButonunaTikla();

        SiparisTamamlamaSayfasi siparisTamamlamaSayfasi = new SiparisTamamlamaSayfasi();
        siparisTamamlamaSayfasi.aramaMotorundaAra("Temel Reis");
        siparisTamamlamaSayfasi.uygulamayaGeriDon();

        formSayfasi.sayfaBasliginiDogrula();
        uygulamayiKapat();

    }
}
