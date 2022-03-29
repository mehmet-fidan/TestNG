package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ParentClass;


public class HomePage extends ParentClass {


    String url ="http://opencart.abstracta.us/";

    @FindBy (css = "a[title='My Account']")
    public WebElement eMyAccount;

    @FindBy (xpath = "(//a[text()='My Account'])[1]")
    public WebElement eMyAccountInner;

    @FindBy(xpath ="//a[text()='Login']")
    public WebElement eLogin;

    @FindBy (id = "input-email")
    public WebElement eEmail;

    @FindBy(id = "input-password")
    public WebElement ePassword;

    @FindBy(css = "input[value='Login']")
    public WebElement eLoginButton;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public void gotoUrl () {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void gotoLoginPage(){
        clickTo(eMyAccount);
        clickTo(eLogin);
    }

    public void fillandSubmitLoginForm (String email,String password){
        sendkeys(eEmail,email);
        sendkeys(ePassword,password);
        clickTo(eLoginButton);
      // Assert.assertTrue( driver.getTitle().equals("My Account"));
       wait.until(ExpectedConditions.titleIs("My Account"));
    }

    public void gotoMyAccount(){
        clickTo(eMyAccount);
        clickTo(eMyAccountInner);
    }

}
