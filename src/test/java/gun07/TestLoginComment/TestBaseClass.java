package gun07.TestLoginComment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Locale;

public class TestBaseClass {

   protected WebDriver driver;

  @BeforeSuite
  public void beforeSuite(){

  }

  @BeforeTest
  @Parameters("driverName")
  public void beforeTest(String browser){

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


  @AfterTest
    public void afterTest(){
      driver.quit();
  }

}
