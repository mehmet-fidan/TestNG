package gun02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test04_opencart extends ParentClass {
    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By lsearchInput = By.cssSelector("div[id='search'] input[name='search']");
    By lsearchButton = By.cssSelector("span[class='input-group-btn']");

    @Test(priority = 1)
    public void menuList() {

        openSite(url);
        sendKeysTo(lsearchInput, "mac");
        clickTo(lsearchButton);

        List<WebElement> actualList = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));

        List<String> expectedList = new LinkedList<>();
        expectedList.add("Desktops");
        expectedList.add("Laptops & Notebooks");
        expectedList.add("Components");
        expectedList.add("Tablets");
        expectedList.add("Software");
        expectedList.add("Phones & PDAs");
        expectedList.add("Cameras");
        expectedList.add("MP3 Players");

        for (int i = 0; i < actualList.size(); i++) {
            Assert.assertEquals(actualList.get(i).getText(), expectedList.get(i), "Lists are not same");
        }
    }

    @Test(priority = 2)
    public void hoverTest() {
        openSite(url);
        List<WebElement> menulList = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));
        Actions builder = new Actions(driver);
        Action hoverAction;

        List<WebElement> elements = driver.findElements(By.cssSelector("li[class='dropdown'] a"));

        for (int i = 0; i < menulList.size(); i++) {
            hoverAction = builder.moveToElement(menulList.get(i)).build();
            sleep(2000);
            hoverAction.perform();

            //System.out.println(i+" elemnetin textleri "+ menulList.get(i).getText());
            //System.out.println(".......");

            /*

            for (int j = 0; j < elements.size(); j++) {

                try{
                    Assert.assertTrue(menulList.get(i).getText().contains(elements.get(j).getText()))

                } catch (Exception e) {
                    return false;

                }

               ,"baska element icermiyor");
                }
            }

             */

        }

    }

}