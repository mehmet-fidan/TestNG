package gun09.pagemodels.m2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageModel {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test_Login() {
        driver.get("https://opencart.abstracta.us");

        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='My Account']")));
        myAccount.click();

        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[text()='Login']")));
        login.click();

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        email.sendKeys("ZeydinToprak@hotmail.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password")));
        password.sendKeys("123456");

        WebElement loginSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']")));
        loginSubmit.click();

        WebElement textControl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Logout']")));
        textControl.isDisplayed();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
