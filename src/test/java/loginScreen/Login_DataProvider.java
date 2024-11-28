package loginScreen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Login_DataProvider {

    //DataProvider ---> Pass the Test Data to the test cases
    @DataProvider(name = "LoginDataProvider")
    public Iterator<Map.Entry<String,String>> getData()
    {
        //Creating a HashMap to store the login data
        HashMap<String, String> loginData = new HashMap<String, String>();

        //Each key value pair is known as an entry
        loginData.put("admin", "admin");
        loginData.put("student", "Password123");
        loginData.put("userName", "Password123");
        loginData.put("student123", "admin");
        loginData.put("admin123", "Password123");

        //loginData.entrySet() --> Converted the data into the set of entries
        //loginData.entrySet().iterator() --> Converted the set of entries into the iterator so that it can fetch the data row by row
        return loginData.entrySet().iterator();
    }
}
