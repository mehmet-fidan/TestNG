package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.ParentClass;

public class Takvim extends ParentClass {

    By lSearchInput =By.cssSelector("input[name='search']");
    By lComputer = By.cssSelector("div.caption h4");
    By lDate = By.xpath("(//i[@class='fa fa-calendar'])[3]");
    By lMonthAndYear = By.xpath("(//th[@class='picker-switch'])[4]");
    By lNext = By.xpath("(//th[@class='picker-switch'])[4]/following-sibling::th[@class='next']");

    String year = "March 2022";

    @Test
    public void test1(){
        driver.get("http://opencart.abstracta.us/");
        sendKeysTo(lSearchInput,"cinema"+ Keys.ENTER);
        clickTo(lComputer);
        wait.until(ExpectedConditions.elementToBeClickable(lDate));
        clickTo(lDate);

      while (true){
            if (driver.findElement(lMonthAndYear).getText().equalsIgnoreCase(year))
            break;
            clickTo(lNext);
        }

        /*
        while (!driver.findElement(lMonthAndYear).getText().equalsIgnoreCase(year))
            clickTo(lNext);

         */
        }

    }

