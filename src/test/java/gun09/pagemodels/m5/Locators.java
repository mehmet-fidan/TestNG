package gun09.pagemodels.m5;

import org.openqa.selenium.By;

public class Locators {

    public static final By lmyAccount = By.cssSelector("a[title='My Account']");
    public static final By lLogin = By.xpath("//li//a[text()='Login']");
    public static final By lEmail = By.id("input-email");
    public static final By lPassword = By.id("input-password");
    public static final By lLoginSubmit = By.cssSelector("input[value='Login']");
    public static final By lTextControl = By.xpath("(//a[text()='Logout'])[1]");
}
