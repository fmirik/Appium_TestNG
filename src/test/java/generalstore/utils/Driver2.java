package generalstore.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;

import static generalstore.utils.ConfigReader.getProperty;

public class Driver2 {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    @BeforeClass
    public static void setUp() {
        serverBaslat("127.0.0.1", 4723); // Appium server'ı başlat
        driver = getDriver(); // AndroidDriver'ı başlat
    }

    @AfterClass
    public static void tearDown() {
        uygulamayiKapat(); // Uygulamayı kapat
        serverKapat(); // Appium server'ı kapat
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            if (service == null) {
                service = new AppiumServiceBuilder().build();
                service.start();
            }

            String appUrl = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "test"
                    + File.separator + "resources"
                    + File.separator + getProperty("apkName");

            UiAutomator2Options options = new UiAutomator2Options()
                    .setApp(appUrl);

            driver = new AndroidDriver(service.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void serverBaslat(String ipAdres, int port) {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAdres)
                .usingPort(port);

        service = builder.build();
        service.start();
    }

    public static void uygulamayiKapat() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void serverKapat() {
        if (service != null) {
            service.stop();
            service = null;
        }
    }
}
