package tests;

import org.testng.annotations.Test;

public class TestClass01 extends TestBaseClass {


    HomePage homePage = new HomePage();


    @Test
    public void testLogin(){
        homePage.gotoUrl();
        homePage.gotoLoginPage();
        homePage.fillandSubmitLoginForm("ZeydinToprak@hotmail.com","123456");
    }

}
