package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    // singelten static driver : Tum projede tek bir driver kullanmak icin olusturulan driver
    // icin kullanilir.

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser) {
        // Eger driver null(bos) ise driver tanimla degilse eskisini kullan.
        if (driver == null) {
            switch (browser.toLowerCase()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver =new EdgeDriver();
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }
        return driver;
        }

     public static void quitDriver() {
        if (driver!=null){
            driver.quit();
            driver = null;
        }
     }
}

