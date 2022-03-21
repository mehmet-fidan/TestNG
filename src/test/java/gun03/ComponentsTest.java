package gun03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.List;

public class ComponentsTest extends ParentClass {

    String url = "http://opencart.abstracta.us/index.php?route=checkout/cart";

    By components = By.xpath("//a[text()='Components']");
    By monitors = By.xpath("//a[contains(text(),'Monitors')]");
    By addToWish = By.cssSelector(".btn-group button[data-original-title='Add to Wish List']");
    By login = By.xpath("//a[text()='login']");
    By e_mail = By.cssSelector("#input-email");
    By password = By.cssSelector("#input-password");
    By loginOl = By.cssSelector("input[value='Login']");
    By wishList = By.id("wishlist-total");


    @Test
    public void componentTest() {
        driver.get(url);
        driver.manage().window().maximize();
        clickTo(components);
        clickTo(monitors);

        List<WebElement> monitorList = driver.findElements(By.cssSelector("div[class='row'] .caption a"));
        int random = (int) (Math.random() * monitorList.size());
        sleep(2000);
        monitorList.get(random).click();

        clickTo(addToWish);
        clickTo(login);
        sendKeysTo(e_mail, "m.fidan.2121@hotmail.com");
        sendKeysTo(password, "123456");
        clickTo(loginOl);
        sleep(2000);
        clickTo(wishList);
        sleep(2000);
        WebElement productSelection = driver.findElement(By.cssSelector("td[class='text-left'] a"));
        Assert.assertTrue(productSelection.isDisplayed());
        System.out.println(productSelection.getText());
    }


}
