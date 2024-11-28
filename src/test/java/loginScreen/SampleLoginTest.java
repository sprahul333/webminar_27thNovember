package loginScreen;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SampleLoginTest {

    String browser;
    WebDriver driver;
    public SampleLoginTest(String browser)
    {
        this.browser=browser;
    }

    @BeforeClass //BeforeClass --> This method will be executed before the execution of the test cases in the given class
    public void setDrivers()
    {
        if(browser.equalsIgnoreCase("Chrome") || browser.isEmpty() || browser.isBlank())
            driver=new ChromeDriver(); //Creating an instance of the chrome browser
        else if(browser.equalsIgnoreCase("Firefox"))
            driver=new FirefoxDriver(); //Creating an instance of the firefox browser
        else if(browser.equalsIgnoreCase("Edge"))
            driver=new EdgeDriver(); //Creating an instance of the edge browser

        driver.manage().window().maximize(); //Maximizing the browser window
    }


    //dataProviderClass --> Mention the class name where the data provider is present
    @Test(description = "Testing Login Scenarios",dataProvider = "LoginDataProvider",
        dataProviderClass = Login_DataProvider.class)
    public void doLogin(Map.Entry<String,String> data) throws IOException
    {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //driver.findElement ---> Finding for that particular webelement in the current web page

        //Syntax of finding an element on the basis of id:
//        driver.findElement(By.id("value"))

        WebElement txt_UserName=driver.findElement(By.id("username"));
        txt_UserName.sendKeys(data.getKey()); //.sendKeys() is used to enter the text in the text box

        WebElement txt_Password=driver.findElement(By.id("password"));
        txt_Password.sendKeys(data.getValue());

        WebElement btn_Submit=driver.findElement(By.id("submit"));
        btn_Submit.click(); //.click() is used to click on the button

        //Capturing the screenshot after logging into the application:
        //(TakesScreenshot) is the function used to capture the screenshot
        //((TakesScreenshot)driver) is the function used to capture the screenshot of the browser

        //Screenshots captured will be stored in the temp folder
        //Always the screenshots will be stored in the form of .png file
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //System.getProperty("user.dir") --> Represent the current working directory
        File dest=new File(System.getProperty("user.dir")+"//Screenshot_"+System.currentTimeMillis()+".png");

        Files.copy(src,dest);

    }
}
