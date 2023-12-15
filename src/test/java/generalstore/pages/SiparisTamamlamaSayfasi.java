package generalstore.pages;

import generalstore.utils.Driver;
import generalstore.utils.ReusableMethods;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static generalstore.utils.Driver.driver;
import static generalstore.utils.ExtentReport.bilgiNotu;

public class SiparisTamamlamaSayfasi extends ReusableMethods {
    public SiparisTamamlamaSayfasi() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @FindBy(name = "q")
    private WebElement aramaMotoru;

    public void aramaMotorundaAra(String metin){
        aramaMotoru.sendKeys(metin, Keys.ENTER);
        bilgiNotu("Arama motorunda " +metin+ " metni arandı.");
    }

    public void uygulamayaGeriDon(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        bilgiNotu("Uygulama Ana Sayfasına geri dönüldü.");
    }
}
