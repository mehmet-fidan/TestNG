package gun08.dataprovider;


import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Driver;


public class DataProvider2  {

    /*
    "https://mockaroo.com/" güzel site
   "https://opencart.abstracta.us" adresinin login kismina
    10 farkli yetkisiz kullanici ve sifre ile giris yapmaya calisin.
    siteye girilemediğini assert edin.
     */

      DataProviderClass dataProviderClass = new DataProviderClass();


    @Test( dataProvider = "getData")
    public void testMultipleUser(String email, String password, int status ){
        dataProviderClass.goToUrl();
        dataProviderClass.dataProviderLogin(email,password,status);
    }

    @DataProvider
    public Object [][] getData(){
        Object[][] data = {
                {"russia@hotmail.com","dklcnba",0},
                {"ijonuzi2@blogger.com", "ueQsdRg", 0},
                {"rhackley3@phpbb.com", "BrQmT8OQy3d8", 0},
                {"sbaylis4@admin.ch", "2FrLKz", 0},
                {"bdunsford5@gnu.org", "0h0Ej32", 0},
                {"testngkurs@gmail.com", "testngkurs", 1},
                {"dmarven6@accuweather.com", "lLIXdOlqjrR", 0},
                {"eneal8@drupal.org", "bwwy0aBJIJ", 0},
                {"bdorkena@github.com", "8AjXlD6", 0},
                {"hbendb@imdb.com", "mCdonxCK2Ix", 0},
                {"m.fidan.2121@hotmail.com", "123456", 1},
        };
        return data;

    }
@AfterTest
    public void closeDriver(){
        DataProviderClass.driver.quit();

}
}
