package gun08.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {

    @Test(dataProvider = "getData")
    public void test1(String name, String surname){
        System.out.println(name+", "+surname);
    }

    /*
    Data Provider
     */

    @DataProvider
    public Object[][] getData(){
        Object[][] data = {
                {"A","AA"},
                {"B","BB"},
                {"C","CC"},
                {"D","DD"}
        };
        return data;
    }
}
