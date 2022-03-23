package gun06.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.Driver;

import java.util.Locale;

public class TestClass4 {

    WebDriver driver;
    String url ="http://opencart.abstracta.us/index.php?route=common/home";
   @BeforeTest
   @Parameters("browserName")
   public void beforeTest(String browser){
       driver = Driver.getDriver(browser);

       /*
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
        */
   }

   @Test
   public void goToUrl(){
       driver.get(url);
   }

   @Test(dependsOnMethods = "goToUrl")
    @Parameters({"searchText", "browserName"})
    public void search (String text, String str){
       driver.findElement(By.cssSelector("#search input")).sendKeys(text+ Keys.ENTER);
       System.out.println("search Text: "+str);
   }
   @AfterTest
   @Parameters("browserName")
    public void afterTest(String bName){
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("Method: "+bName);
       Driver.quitDriver();
   }

}
