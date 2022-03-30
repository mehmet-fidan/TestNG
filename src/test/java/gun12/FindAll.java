package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

public class FindAll extends ParentClass {

    FindAllPO po;
    String searchText= "mac";
    @Test
    public void test1(){
        po = new FindAllPO(driver);
        driver.get("http://opencart.abstracta.us/");
        po.getSearchText().sendKeys(searchText);
        po.getSearchButton().click();
        Assert.assertTrue(po.getSiteMap().getText().toLowerCase().contains("search"));
    }

    @Test
    public void test2(){
        for (WebElement productName : po.getProducts()) {
            System.out.println(productName.getText());
            Assert.assertTrue(productName.getText().toLowerCase().contains(searchText));
        }
    }

    @Test
    public void test3(){
        for (WebElement element : po.getIsimVeFiyat()) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void test4(){
        driver.findElements(By.cssSelector("xxx")); //hata vermez, null list ret
        System.out.println("after findElements");

       // driver.findElement(By.cssSelector("xxx")); //hata verir
      //  System.out.println("after element");

        if (driver.findElements(By.cssSelector("xxx")).size()>0) {
            System.out.println("Bu element mevcut değil");
        } else {
            System.out.println("Bu element mevcut");
            System.out.println(po.getFindBys().getText());
            WebElement e= driver
                    .findElement(By.xpath("(//div[@class='product-thumb'])[2]"))
                    .findElement(By.cssSelector("h4"));
            System.out.println(e.getText());
        }
    }
}
