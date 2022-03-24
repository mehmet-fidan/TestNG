package gun09.softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01HardAssert {


    @Test
    public void Test1(){
        Assert.assertTrue(true);
        System.out.println("test1");
    }

    @Test
    public void Test2(){
       Assert.assertTrue(false);
        System.out.println("test2");
    }


    /*
    Hard Assert hatayi gordugu anda testi keser.
     */

}
