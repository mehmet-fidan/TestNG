package gun09.pagemodels.m6;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class PageModel extends ParentPM{
    @Test
    public void test_Login() {
        driver.get("https://opencart.abstracta.us");


        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(lmyAccount));
        myAccount.click();

        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(lLogin));
        login.click();

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(lEmail));
        email.sendKeys("ZeydinToprak@hotmail.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(lPassword));
        password.sendKeys("123456");

        WebElement loginSubmit = wait.until(ExpectedConditions.elementToBeClickable(lLoginSubmit));
        loginSubmit.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(lTextControl));
    }
}