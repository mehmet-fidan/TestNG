package gun09.pagemodels.m8;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class PageModel extends ParentPM {

    @Test
    public void test_Login() {
        driver.get("https://opencart.abstracta.us");

        clickTo(lmyAccount);
        click(lLogin);
        senKeys(lEmail,"ZeydinToprak@hotmail.com");
        senKeys(lPassword,"123456");
        click(lLoginSubmit);
        wait.until(ExpectedConditions.presenceOfElementLocated(lTextControl));
    }
}