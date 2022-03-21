package gun01;

import org.testng.annotations.*;

public class _03Annotations {


    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test  // methodun bir test methodunu oldugunu belirtir.
    void test2() {
        System.out.println("test2");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("BeforeTest");
    }

    @AfterTest  // test, TestNG xml"de belirtilen tanimlamasi
    void afterTest() {
        System.out.println("AfterTest");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("AfterMethod");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }
    @AfterClass
    protected void afterClass() {
        System.out.println("AfterClass");
    }

    @BeforeSuite
    void beforeSuit(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    void afterSuite(){
        System.out.println("AfterSuite");
    }

    @BeforeGroups
    void beforeGroups (){
        System.out.println("BeforeGroups");
    }
    @AfterGroups
    void afterGroups() {
        System.out.println("AfterGroups");
    }
}
