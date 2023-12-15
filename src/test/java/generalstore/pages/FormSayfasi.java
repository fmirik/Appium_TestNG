package generalstore.pages;

import generalstore.utils.Driver;
import generalstore.utils.ReusableMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static generalstore.utils.Driver.driver;
import static generalstore.utils.ExtentReport.bilgiNotu;

public class FormSayfasi extends ReusableMethods {
    public FormSayfasi() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement ulkeMenusu;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement isimAlani;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement cinsiyetFemale;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement cinsiyetMale;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButonu;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement sayfaBasligi;
    @AndroidFindBy(xpath = "//android.widget.Toast")
    private WebElement hataMesaji;

    public void ulkeSec(String ulke){
        ulkeMenusu.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ulke+"\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+ulke+"\"]")).click();
        bilgiNotu("Ülke menüsünden " + ulke + " ülkesi seçildi.");
    }

    public void isimGir(String isim){
        isimAlani.sendKeys(isim);
        bilgiNotu("İsim kutusuna " + isim + " ismi girildi.");
    }

    public void cinsiyetSec(String cinsiyet){
        if (cinsiyet.equalsIgnoreCase("female")){
            cinsiyetFemale.click();
        }else {
            cinsiyetMale.click();
        }
        bilgiNotu("Cinsiyet seçeneklerinden " + cinsiyet + " seçildi.");
    }

    public void letsShopButonunaTikla(){
        letsShopButonu.click();
        bilgiNotu("Let's Shop butonuna tıklandı.");
    }

    public void sayfaBasliginiDogrula(){
        Assert.assertEquals(sayfaBasligi.getText(), "General Store");
        bilgiNotu("Sayfa başlığının General Store olduğu doğrulandı.");
    }

    public void hataMesajininGorundugunuDogrula(String mesaj){
        Assert.assertEquals(hataMesaji.getAttribute("name"), mesaj);
        bilgiNotu("Hata mesajının " + mesaj +  " olduğu doğrulandı.");
    }



}
