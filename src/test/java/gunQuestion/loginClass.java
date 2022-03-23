package gunQuestion;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginClass extends TestBaseClass {

    String url = "http://opencart.abstracta.us/";
    By lmyAccount = By.cssSelector("li a[title='My Account']");
    By lLogin = By.xpath("//li//a[text()='Login']");
    By lE_mail = By.cssSelector("#input-email");
    By lPassword = By.cssSelector("#input-password");
    By lLoginSubmit = By.cssSelector("input[value='Login']");

    By lContact = By.xpath("//li//a[text()='Contact Us']");
    By lMessage = By.cssSelector("#input-enquiry");
    By lSubmit = By.cssSelector("input[value='Submit']");


    @Test
    @Parameters({"userName", "password"})
    public void testLogin(String username, String pass) {
        driver.get(url);
        driver.manage().window().maximize();
        clickTo(lmyAccount);
        clickTo(lLogin);
        senKeysTo(lE_mail, username);
        senKeysTo(lPassword, pass);
        clickTo(lLoginSubmit);
    }

    @Test(dependsOnMethods = "testLogin")
    @Parameters("Message")
    public void testContact(String message) {
        clickTo(lContact);
        senKeysTo(lMessage, message);
        System.out.println(driver.findElement(lMessage).getAttribute("value"));
        clickTo(lSubmit);

    }

    public void clickTo(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void senKeysTo(By locator, String str) {
        driver.findElement(locator).sendKeys(str);
    }
}
