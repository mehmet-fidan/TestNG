package gun09.softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _02SoftAssert {

    /*
    Soft assert, tum assertleri verdikten sonra hatayı verir.
    ve testi kesmez.
     */

    SoftAssert sa = new SoftAssert();

    @Test
    public void test1() {
        sa.assertTrue(false);
        System.out.println("test1");
        sa.assertTrue(true); //asserti degerlendirir ama isleme sokmaz.
        System.out.println("test2");
        sa.assertAll(); // bu satirla ustteki tum assertler isletilir.
    }
    @Test
    public void test2(){
       Assert.assertTrue(false);
        System.out.println("test1");
        Assert.assertTrue(true);
        System.out.println("test2");
    }
}

