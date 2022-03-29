package tests;


import org.testng.annotations.Test;

public class TestClass03 extends TestBaseClass {


    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    @Test
    public void loginToSearchIpod() {
        homePage.gotoUrl();
        homePage.gotoLoginPage();
        homePage.fillandSubmitLoginForm("ZeydinToprak@hotmail.com", "123456");
    }

    @Test
    public void searchAndSelectIpod (){
        homePage.gotoMyAccount();
        searchPage.IpodSearchAndSelect("ipod");
    }
}
