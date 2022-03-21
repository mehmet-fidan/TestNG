package gun06.tests;

import org.testng.annotations.Test;

public class TestClass2 {

    @Test(groups = {"TestGroup1"})
    public void test4() {
        System.out.println("Test-4");
    }
    @Test(groups = {"TestGroup2"})
    public void test5() {
        System.out.println("Test-5");
    }

    @Test(groups = {"TestGroup1","TestGroup2","TestGroup3"})
    public void test6() {
        System.out.println("Test-6");
    }
}
