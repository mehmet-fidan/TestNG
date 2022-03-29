package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver (){

        return getDriver("chrome");
      /* if(driver==null) {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }
        return driver;
       */
    }

    public static WebDriver getDriver(String browser){

        if(driver==null){
            switch (browser.toLowerCase()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }
        }
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }
}
