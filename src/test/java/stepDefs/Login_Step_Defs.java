package stepDefs;

import com.google.common.io.Files;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Loginpage;

import java.io.File;
import java.io.IOException;

public class Login_Step_Defs
{
    static WebDriver driver;
    Loginpage login;

    @BeforeAll //Equivalent to @BeforeClass in TestNG
    public static void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Open the Application")
    public void openTheApplication() {
        login=new Loginpage(driver);
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }


    @And("Enter the UserName {string}")
    public void enterTheUserName(String userName) 
    {
//        WebElement txt_UserName=driver.findElement(By.id("username"));
//        txt_UserName.sendKeys(userName); //.sendKeys() is used to enter the text in the text box

        login.enterUserName(userName);
    }

    @And("Enter the Password {string}")
    public void enterThePassword(String password) {

//        WebElement txt_Password=driver.findElement(By.id("password"));
//        txt_Password.sendKeys(password);

        login.enterPassword(password);
    }

    @Then("Click on Login Button")
    public void clickOnLoginButton() throws IOException
    {
//        WebElement btn_Submit=driver.findElement(By.id("submit"));
//        btn_Submit.click(); //.click() is used to click on the button

        login.clickOnSubmit();

        //Capturing the screenshot after logging into the application:
        //(TakesScreenshot) is the function used to capture the screenshot
        //((TakesScreenshot)driver) is the function used to capture the screenshot of the browser

        //.findElements ---> Capturing multiple webelements at a time
        if(driver.findElements(By.xpath("//div[text()='Your password is invalid!']")).size()!=0)
        {
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)"); //Scrolling Down the page by 300 px

            //Screenshots captured will be stored in the temp folder
            //Always the screenshots will be stored in the form of .png file
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //System.getProperty("user.dir") --> Represent the current working directory
            File dest = new File(System.getProperty("user.dir") + "//Screenshot_" + System.currentTimeMillis() + ".png");

            Files.copy(src,dest);
        }

        else {

            //Screenshots captured will be stored in the temp folder
            //Always the screenshots will be stored in the form of .png file
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //System.getProperty("user.dir") --> Represent the current working directory
            File dest = new File(System.getProperty("user.dir") + "//Screenshot_" + System.currentTimeMillis() + ".png");

            Files.copy(src,dest);
        }


    }
}
