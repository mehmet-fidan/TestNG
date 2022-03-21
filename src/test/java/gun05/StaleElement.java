package gun05;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.ParentClass;

public class StaleElement extends ParentClass {

    String url = "http://opencart.abstracta.us";
    By menuDesktops = By.xpath("//ul//*[text()='Desktops']");

    @Test
    public void goToSite(){
        driver.get(url);
    }
    @Test
    public void clickToDesktops(){
        clickTo(menuDesktops);
    }

    @Test
    public void clickToDesktops1(){
    }
  /*
  Bir Selector refresh oncesi ya da ajax"in ilgili elementi guncellemesi ya da degistirmesi oncesi
  element halini almissa, refresh sonrasi ya da ajax islemi sonrasi o element ile islem yapilmak istenince
  StaleElement hatasi verir.
  Bu nedenle selectorlerin ne zaman element"e cevrilecekleri onemli.
   */
}
