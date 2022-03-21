package gun01;


import org.testng.annotations.Test;

// @Test annotation"i olan classlar TestNG classlaridir.
// @Test annotation"i olan method ve class calistirilacaktir.
// bir test calistirildiginda o class"dan bir nesne olusturarak calistirir.
// @Test annotation"i olan bir method ayri ayri calistitilmalidir.

public class _01Giris {

    public static void main(String[] args) {
        System.out.println("main");

        _01Giris giris = new _01Giris();
      //  giris.test1();
        giris.test2();

    }

    int number=10;
   // Instance initializer. Nesne olustugunda constructordan once calisir.
   {
       System.out.println("instance initilazier");
   }

    public _01Giris() {
        System.out.println("constructor");
        System.out.println(number);
    }

    @Test
    void test1(){
        System.out.println("testNG-1");
    }

    @Test
    void test2(){
        System.out.println("testNG-2");
    }

    /* functional testlerin yapilmasi icin bir tool
       Assertion
       Testleri organize

       TestNG -JUnit
       Annotations
       @Test
       @BeforeClass
       @AfterClass

       .........
     */
}
