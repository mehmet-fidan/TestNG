package pages;

import org.openqa.selenium.By;
import utils.ParentClass;
import utils.WaitConditions;

public class HomePage extends ParentClass {
    String url = "http://opencart.abstracta.us/index.php?route=common/home";
    By mainMenuAccount = By.cssSelector("a[title='My Account']");
    By getMainMenuAccountLogin = By.linkText("Login");
    By lNotification = By.cssSelector("div.alert.alert-success");
    By lLoginEmail = By.id("input-email");
    By lLoginPassword = By.id("input-password");
    By lLoginSubmitButton = By.xpath("//input[@value='Login']");
    By lLogOut = By.xpath("//div[@id='top-links']//a[text()='Logout']");

    By lEditAccountFirstname = By.id("input-firstname");
    By lEditAccountLastName = By.id("input-lastname");
    By lEditAccountTelephone = By.id("input-telephone");
    By lEditAccountContinueButton = By.xpath("//input[@value='Continue']");

    public void goToSite () {
        openSite(url);
    }
    public void goToLogin(){
        clickTo(mainMenuAccount);
        clickTo(getMainMenuAccountLogin);
    }

    public void LoginAs (String username,String password){
        sendKeysTo(lLoginEmail,username);
        sendKeysTo(lLoginPassword, password);
        clickTo(lLoginSubmitButton);
        waitFor(lLogOut, WaitConditions.exist);
    }
    public void verifyNotification (String str) {
        verifyTextIn(lNotification,str);
    }

    public void clickLinkText(String str){
        clickTo(By.partialLinkText(str));
    }
    public void updateAccount (String firstname,String lastname,String telephone){
        sendKeysTo(lEditAccountFirstname,firstname,true);
        sendKeysTo(lEditAccountLastName,lastname,true);
        sendKeysTo(lEditAccountTelephone,telephone, true);
        clickTo(lEditAccountContinueButton);
    }
    /*
     priority siralama verir.
        önceki test basarisiz olsa da pesinen gelen test calistirilir.


        dependsOnMethods  ise bagimlilik ifade eder.
        Bagimli oldugu test basarili olursa o test calisir,
        basarisiz olursa o test skip edilir.
     */


}
