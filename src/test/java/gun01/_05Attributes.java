package gun01;

import org.testng.annotations.Test;

public class _05Attributes {

    /*
    priority : test oncelik tanir.
    -5000, +5000 kucuk degerli olan onceliklidir.
    Testlere herhangi bir priority yazilmaz ise default her test"in priority"si 0"dir.
    Priority"si esit olanlari testNG method ismine gore sirali calistirir.

     */

    @Test (testName = "5 Nolu Test", priority = 2)
    public void test5() {
        System.out.println("Test5");
    }
    @Test(testName = "1 Nolu Test", priority = 0)
    public void test1(){
        System.out.println("Test1");
    }

    // enable attribute"u methodun calistirilip calistirilamayacagini belirler
    @Test(testName = "3 Nolu Test", priority = 1,enabled = false)
    public void test3(){
        System.out.println("Test3");
    }
    //timeOut testin ne kadar surecegini sinirlar
    @Test(testName = "4 Nolu Test", timeOut = 2000)
    public void test4(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test4");
    }

    // invocationCount, bu methodun kac defa tekrarlanacagini belirtir.
    @Test(testName = "6 Nolu Test", priority = 1, invocationCount = 5)
    public void test6(){
        System.out.println("Test6");
    }


}
