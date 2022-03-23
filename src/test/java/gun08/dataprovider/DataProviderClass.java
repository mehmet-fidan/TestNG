package gun08.dataprovider;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

public class DataProviderClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    String url = "https://opencart.abstracta.us";
    String url2 = "https://opencart.abstracta.us/index.php?route=account/login";

   // By lmyAccount = By.cssSelector("li a[title='My Account']");
    //By lLogin = By.xpath("//li//a[text()='Login']");
   // By lLogin2 = By.xpath("(//div//a[text()='Login'])[2]");
    By lE_mail = By.cssSelector("#input-email");
    By lPassword = By.cssSelector("#input-password");
    By lLoginSubmit = By.cssSelector("input[value='Login']");
    By lLogOutText = By.xpath("(//a[text()='Logout'])[2]");
    By lWarning = By.cssSelector("div.alert.alert-danger.alert-dismissible");


    public void goToUrl() {
        driver = Driver.getDriver();
        driver.get(url2);
    }

    public void dataProviderLogin(String email, String password, int status) {
        // driver.findElement(lmyAccount).click();
        // driver.findElement(lLogin).click();
        driver.findElement(lE_mail).sendKeys(email);
        driver.findElement(lPassword).sendKeys(password);
        driver.findElement(lLoginSubmit).click();
        if (status == 0) {
            Assert.assertTrue(driver.findElement(lWarning).getText().contains("Warning"));
            clearTest();
        } else {
            Assert.assertTrue(driver.findElement(lLogOutText).getText().contains("Logout"));
            driver.findElement(lLogOutText).click();
        }
    }

    public void clearTest() {
        driver.findElement(lE_mail).clear();
        driver.findElement(lPassword).clear();
    }

}
