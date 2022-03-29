package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;


public class TestBaseClass  {

    @BeforeTest
    public void beforeTest(){
    }

    @AfterTest
    public void afterTest(){
       Driver.quitDriver();
    }

}
