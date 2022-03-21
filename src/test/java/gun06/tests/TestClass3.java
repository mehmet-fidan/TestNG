package gun06.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass3 {

    @Test
    @Parameters("derName")  //buradaki isim ile xml"deki isim ayni olmali.
    public void isimYaz(String name){
        System.out.println(name);
    }
}
