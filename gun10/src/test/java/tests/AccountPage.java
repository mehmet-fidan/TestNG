package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.Map;

public class AccountPage extends ParentClass {

    @FindBy(xpath = "//div[@id='content']//a[contains(text(),'Address')]")
    public WebElement eLinkAddressBook;

    @FindBy(linkText = "New Address")
    public WebElement eAddressBookNewAddressButton;

    @FindBy(id = "input-firstname")
    public WebElement eAddressFormFirstName;

    @FindBy(id = "input-lastname")
    public WebElement eAddressFormLastName;

    @FindBy(id = "input-address-1")
    public WebElement eAddressFormAddres1;

    @FindBy(id = "input-city")
    public WebElement eAddressFormCity;

    @FindBy(id = "input-postcode")
    public WebElement eAddressFormZipCode;

    @FindBy(id = "input-country")
    public WebElement eAddressFormCountry;

    @FindBy(id = "input-zone")
    public WebElement eAddressFormRegion;

    @FindBy(css = "input[type='radio'][value='1']")
    public WebElement eAddressFormDefaultAddress;

    @FindBy(css = "input[value='Continue']")
    public WebElement eAddressFormContinueButton;

    @FindBy(css = ".alert")
    public WebElement eAlert;


    public AccountPage() {

        PageFactory.initElements(driver, this);
    }

    public void openAddressBookForm() {
        clickTo(eLinkAddressBook);
    }


    public void fillAddressForm(Map<String, String> addressBook) {
    // public void fillAddressForm(String addressBook) {
        clickTo(eAddressBookNewAddressButton);
       // sendkeys(eAddressFormFirstName,addressBook);
       // sendkeys(eAddressFormLastName,addressBook);
        sendkeys(eAddressFormFirstName, addressBook.get("first_name"));
        sendkeys(eAddressFormLastName, addressBook.get("last_name"));
        sendkeys(eAddressFormAddres1, addressBook.get("addres1"));
        sendkeys(eAddressFormCity, addressBook.get("city"));
        sendkeys(eAddressFormZipCode, addressBook.get("zipCode"));

        Select country = new Select(eAddressFormCountry);
        country.selectByVisibleText(addressBook.get("country"));
        waitForText(addressBook.get("region"));
        Select city = new Select(eAddressFormRegion);
        city.selectByVisibleText(addressBook.get("region"));

        if (addressBook.get("default").equals("1")) {
            clickTo(eAddressFormDefaultAddress);
        }
        // clickTo(eAddressFormDefaultAddress);
        clickTo(eAddressFormContinueButton);

        Assert.assertTrue(eAlert.getText().toLowerCase().contains("successfully"), "basarisiz");
    }

    public void waitForText(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
    }


}
