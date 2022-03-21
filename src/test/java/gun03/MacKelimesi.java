package gun03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class MacKelimesi {

    String url = "http://opencart.abstracta.us/index.php?route=checkout/cart";
    public static WebDriver driver;

    By searchText =By.cssSelector("input[name='search']");
    By searchButton = By.cssSelector(".input-group-btn");

        String macText ="Mac";
    @Test
    public void macTest() {

        getDriver().get(url);
        goToElement(searchText).sendKeys("mac");
        goToElement(searchButton).click();
        List<WebElement> listOfMac = driver.findElements(By.cssSelector("div[class='row'] .caption a"));

        for (WebElement element : listOfMac) {

            System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains(macText),"Mac icermeyen var");
        }

        sleep(2000);
        quitDriver();
    }

    public static WebElement goToElement(By locator) {
       return driver.findElement(locator);
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
