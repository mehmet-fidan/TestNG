package gun06.tests;

import org.testng.annotations.Test;

public class TestClass1 {


    @Test(groups = {"TestGroup1"})
    public void test1() {
        System.out.println("Test-1");
    }
    @Test(groups = {"TestGroup1","TestGroup2"})
    public void test2() {
        System.out.println("Test-2");
    }

    @Test(groups = {"TestGroup2","TestGroup3"})
    public void test3() {
        System.out.println("Test-3");
    }
}
