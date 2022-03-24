package gun09.pagemodels.m4;

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

    By lmyAccount= By.cssSelector("a[title='My Account']");
    By lLogin =By.xpath("//li//a[text()='Login']");
    By lEmail= By.id("input-email");
    By lPassword = By.id("input-password");
    By lLoginSubmit = By.cssSelector("input[value='Login']");
    By lTextControl = By.xpath("//a[text()='Logout']");

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void test_Login(){
        driver.get("https://opencart.abstracta.us");


        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(lmyAccount));
        myAccount.click();

        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(lLogin));
        login.click();

        WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(lEmail));
        email.sendKeys("ZeydinToprak@hotmail.com");

        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(lPassword));
        password.sendKeys("123456");

        WebElement loginSubmit= wait.until(ExpectedConditions.elementToBeClickable(lLoginSubmit));
        loginSubmit.click();

         wait.until(ExpectedConditions.presenceOfElementLocated(lTextControl));

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}