package gunQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class TestBaseClass {

     WebDriver driver;
     WebDriverWait wait;

     @BeforeSuite
     public void beforeSuite() {
     }

    @BeforeTest
    @Parameters("driverName")
    public void beforeTest(String browser) {

        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AfterTest
    public void afterTest () {
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }

  @AfterSuite
    public void afterSuite () {

  }
}
