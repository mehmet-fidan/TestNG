package gun05;


import org.testng.annotations.Test;
import pages.HomePage;
import utils.ParentClass;

public class TestEditAccount extends ParentClass {

    /*
    Senaryo 4
            1- Siteyi açınız.
            2- Edit Account a tıklatınız.
            3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
            5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.

     */

    HomePage homePage = new HomePage();

    @Test
    public void test_GoToSite(){
        homePage.goToSite();
    }
    @Test
    public void test_Login(){
        homePage.goToLogin();
        homePage.LoginAs("ZeydinToprak@hotmail.com","123456");
    }

    @Test
    public void test_UpdateMyAccount (){
        homePage.clickLinkText("Edit Account");
        homePage.updateAccount("Veli","Deli", "531");
        homePage.verifyNotification("successfull");
    }
    @Test
    public void test_UpdateMyAccount2(){
        homePage.clickLinkText("Edit Account");
        homePage.updateAccount("Zeydin","Toprak","123456");
        homePage.verifyNotification("successfull");
    }
}
