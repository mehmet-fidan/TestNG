package gun07.TestLoginComment;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestContactUsClass extends TestBaseClass{

    SitePage sitePage;

    @Test
    @Parameters("Message")
    public void test_ContactUs (String message){
        sitePage.contactUs(message);
    }

}
