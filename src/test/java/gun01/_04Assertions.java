package gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _04Assertions {

    @Test
    public void test01(){

        int a = 2;
        int b = 3;

        /*
        if (a!=b){
            throw new RuntimeException("Sayilar esit degil");
        }

         */

        Assert.assertEquals(a,b,"the numbers are not equals");

        // Herbir method"da bir assertion kullanilmasinda fayda var.
    }

    @Test
    public void test02(){
        int a = 2;
        int b = 3;

        Assert.assertTrue(a==b,"the numbers are not equals");

    }
    @Test
    public void test03(){
        int a = 2;
        int b = 2;

        Assert.assertEquals(a,b, "the numbers are not equals");
    }

    @Test
    public void Toplam(){
        int actual = topla(1,2,3,4,5,6);
        int expected = 21;
        Assert.assertEquals(actual,expected,"Toplam sonuc hatalidir");
    }

    public int topla(int...sayilar) {
        int toplam =0;
        for (int sayi : sayilar) {
            toplam +=sayi;

        }
        return toplam;
    }
    @Test
    public void test04() {
        String str = null;
        Assert.assertNull(str);
        Assert.assertNotNull(str);
    }
}
