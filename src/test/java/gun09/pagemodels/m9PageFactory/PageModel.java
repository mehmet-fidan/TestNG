package gun09.pagemodels.m9PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageModel {

    WebDriver driver;
    WebDriverWait wait;

    /*
    calisilacak sayfanin selectorlerni @FindBy annotation ile elemente  ceviriyoruz.
     */

    @FindBy(css = "a[title='My Account']")
    public WebElement eMyAccount;

    @FindBy(xpath = "//li//a[text()='Login']")
    public WebElement eLogin;

    @FindBy(id = "input-email")
    public WebElement eEmail;

    @FindBy(id = "input-password")
    public WebElement ePassword;

    @FindBy(css = "input[value='Login']")
    public WebElement eLoginSubmit;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement eTextControl;

    public PageModel(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver,this);
    }

    @BeforeTest
    public void beforeTest() {
    }

    @Test
    public void test_Login() {
        driver.get("https://opencart.abstracta.us");

        eMyAccount.click();
        eLogin.click();
        eEmail.sendKeys("ZeydinToprak@hotmail.com");
        ePassword.sendKeys("123456");
        eLoginSubmit.click();
        wait.until(ExpectedConditions.titleIs("My Account"));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}