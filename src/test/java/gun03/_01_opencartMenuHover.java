package gun03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.List;

public class _01_opencartMenuHover extends ParentClass {

    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By mainMenuItems = By.cssSelector("ul[class='nav navbar-nav']>li");

    @Test
    public void Test_HoverAndJustifyMenu(){
        openSite(url);
        List<WebElement> elementOfMenuItems = driver.findElements(mainMenuItems);


        for (WebElement menuItem : elementOfMenuItems) {
            hoverList(menuItem,1000);

            if(menuItem.findElements(By.cssSelector("div[class='dropdown-inner']")).size()>0){
                System.out.println("Alt menu var "+menuItem.findElements(By.cssSelector("div[class='dropdown-inner'] li")).size());
                Assert.assertTrue(menuItem.findElement(By.cssSelector("div[class='dropdown-inner']")).isDisplayed());
            } else {
                System.out.println("Alt menu yok");
            }
        }

    }

}
