package gun07.TestLoginComment;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLoginClass extends TestBaseClass {


    SitePage sitePage;

    @Test
    @Parameters("driverName")
    public void test_goToUrl(){
        sitePage = new SitePage(driver);
        sitePage.goToUrl();
    }
    @Test (priority = 1)
    @Parameters ({"username","password"})
    public void test_Login(String username,String password) {
        sitePage.loginTo(username, password);
    }
    @Test (priority = 2)
    public void test_Assertion(){
        sitePage.login_Assertion();
    }
}
