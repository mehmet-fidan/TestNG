package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class _06Ornek {
  /*
    Soru

    https://opensource-demo.orangehrmlive.com/index.php/auth/login
    @BeforeClass"da
    driver tanimlayin
    @Test
    siteye gidin, title"i assert edin

    @Test
    login olun, login oldugunuzu assert edin

    @AfterClass
    driveri kapatin

   */

    WebDriver driver;

    String url = " https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    By username = By.id("txtUsername");
    By password = By.id("txtPassword");
    By login = By.id("btnLogin");
    By text = By.cssSelector("a[id='welcome']");

    @Test (priority = 2)
    void login() {

        driver.get(url);
        driver.findElement(username).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(login).click();
        System.out.println(driver.getTitle());
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "The titles are not same");
    }

    @Test(priority = 1,dependsOnMethods = "login")
    void loginAssert() {
        String actualMessage = driver.findElement(text).getText();
        System.out.println(actualMessage);
        String expectedmessage = "Welcome";
        Assert.assertTrue(actualMessage.contains(expectedmessage));

    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass

    public void afterClass() {
        driver.quit();
    }

}
