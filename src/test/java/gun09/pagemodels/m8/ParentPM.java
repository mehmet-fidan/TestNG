package gun09.pagemodels.m8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ParentClass;

import java.time.Duration;

public class ParentPM extends ParentClass {

    By lmyAccount = By.cssSelector("a[title='My Account']");
    By lLogin = By.xpath("//li//a[text()='Login']");
    By lEmail = By.id("input-email");
    By lPassword = By.id("input-password");
    By lLoginSubmit = By.cssSelector("input[value='Login']");
    By lTextControl = By.xpath("(//a[text()='Logout'])[1]");

    //WebDriver driver;
    // WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        //WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        // driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void senKeys(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
}