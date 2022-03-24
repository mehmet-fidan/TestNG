package gun09.pagemodels.m10PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class PageModel {

    WebDriver driver;
    WebDriverWait wait;

    public PageModel(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeTest
    public void beforeTest() {
    }

    @Test
    public void test_Login() {
        LoginPO loginPO = new LoginPO(driver);

        driver.get("https://opencart.abstracta.us");

        loginPO.eMyAccount.click();
        loginPO.eLogin.click();
        loginPO.eEmail.sendKeys("ZeydinToprak@hotmail.com");
        loginPO.ePassword.sendKeys("123456");
        loginPO.eLoginSubmit.click();
       // wait.until(ExpectedConditions.presenceOfElementLocated(eTextControl));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}