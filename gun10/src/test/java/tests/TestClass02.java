package tests;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestClass02 extends TestBaseClass {

    HomePage homePage = new HomePage();
    AccountPage accountPage = new AccountPage();


    @Test
    public void testAddressBook() {
        homePage.gotoUrl();
        homePage.gotoLoginPage();
        homePage.fillandSubmitLoginForm("ZeydinToprak@hotmail.com", "123456");
    }

    @Test
    public void testFillAddressBook() {
       Map<String,String> addressInfo = new HashMap<>();
        addressInfo.put("first_name","Zeydin");
        addressInfo.put("last_name","Toprak");
        addressInfo.put("addres1","ABC");
        addressInfo.put("city","Aa");
        addressInfo.put("country","Turkey");
        addressInfo.put("region","Ankara");
        addressInfo.put("zipCode","1234");
        addressInfo.put("default","1");


        homePage.gotoMyAccount();
        accountPage.openAddressBookForm();
        // accountPage.fillAddressForm("Zeydin");
        //  accountPage.fillAddressForm("Toprak");
        // homePage.sleep(2000);
        accountPage.fillAddressForm(addressInfo);
    }
}
