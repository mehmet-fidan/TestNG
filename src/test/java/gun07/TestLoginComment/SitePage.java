package gun07.TestLoginComment;

import com.google.auto.service.AutoService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SitePage {

    WebDriver driver;
    WebDriverWait wait;

    String url = "http://opencart.abstracta.us/";
    By lMyAccount = By.cssSelector("a[title='My Account']");
    By lLogin = By.xpath("//a[text()='Login']");
    By lEmail = By.cssSelector("#input-email");
    By lPassword = By.cssSelector("#input-password");
    By lLoginSubmit = By.cssSelector("input[value='Login']");

    By lLogOut = By.xpath("//li//a[text()='Logout']");
    By lContactUs = By.linkText("Contact Us");
    By lTextArea = By.cssSelector("#input-enquiry");
    By lTextSubmit = By.cssSelector("input[value='Submit']");



    public SitePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToUrl() {
        driver.get(url);
    }

    public void loginTo(String username, String password ) {
        driver.findElement(lMyAccount).click();
        driver.findElement(lLogin).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lEmail)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lPassword)).sendKeys(password);
        driver.findElement(lLoginSubmit).click();

    }
    public void login_Assertion(){
        driver.findElement(lMyAccount).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(lLogOut));
        System.out.println(driver.findElement(lLogOut).getText());
    }
    public void contactUs (String text){
        driver.findElement(lContactUs).click();
        driver.findElement(lTextArea).sendKeys(text);
        driver.findElement(lTextSubmit).click();
    }
}
