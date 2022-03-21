package gun03;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

public class _02_OpenCartExample extends ParentClass {

    /*
    Senaryo
      1- Siteyi açınız.
      2- Login olun, Login oldugunuzu assert edin.
      3- Newsletter  Subscribe edin.
      4- Newsletter UnSubscribe Islemi yapin.
testngkurs@gmail.com
testngkurs
     */

    String url = "http://opencart.abstracta.us/index.php?route=checkout/cart";
    By myAccount = By.cssSelector("a[title='My Account']");
    By login1 = By.cssSelector("ul[class='dropdown-menu dropdown-menu-right'] a[href='https://opencart.abstracta.us:443/index.php?route=account/login']");
    By e_mail = By.cssSelector("#input-email");
    By password = By.cssSelector("#input-password");
    By giris = By.cssSelector("input[class='btn btn-primary']");
    By actual = By.xpath("(//a[text()='Edit Account'])[1]");
    String expected = "Edit Account";

    By newsletter = By.xpath("(//a[@href='https://opencart.abstracta.us:443/index.php?route=account/newsletter']) [3]");
    By yes = By.xpath("(//label[@class='radio-inline'])[1]");
    By continue1 = By.cssSelector("input[value='Continue']");
    By textActual = By.xpath("//div[contains(text(), 'Success')]");
    String textExpected = "successfully";


    By no = By.xpath("(//label[@class='radio-inline'])[2]");


    @Test //(priority = 1)
    public void loginOl() {
        driver.get(url);
        driver.manage().window().maximize();
        login(myAccount).click();
        login(login1).click();
        login(e_mail).sendKeys("m.fidan.2121@hotmail.com");
        login(password).sendKeys("123456");
        login(giris).click();
        login(actual).getText();


        Assert.assertEquals(login(actual).getText(), expected, "the message are not same");

    }

    @Test (dependsOnMethods = "loginOl") // (priority = 2)
    public void subscribe() {
        login(newsletter).click();
        login(yes).click();
        login(continue1).click();

        Assert.assertTrue(login(textActual).getText().contains(textExpected), "the texts are not same");

    }

    @Test (dependsOnMethods = "loginOl") // (priority = 3)
    public void unSubscribe(){
        login(newsletter).click();
        login(no).click();
        login(continue1).click();

        Assert.assertTrue(login(textActual).getText().contains(textExpected),"metinler ayni");
    }

    public WebElement login(By locator) {
        return driver.findElement(locator);
    }


}
