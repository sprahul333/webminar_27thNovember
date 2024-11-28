package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

    WebDriver driver;
    public Loginpage(WebDriver driver)
    {
        this.driver=driver;
    }

    private WebElement txt_UserName()
    {
        return driver.findElement(By.id("username"));
    }

    private WebElement txt_Password()
    {
        return driver.findElement(By.id("password"));
    }

    private WebElement btn_Submit()
    {
        return driver.findElement(By.id("submit"));
    }

    /***************************************************************************************************/

    public void enterUserName(String userName)
    {
        txt_UserName().sendKeys(userName);
    }

    public void enterPassword(String password)
    {
        txt_Password().sendKeys(password);
    }

    public void clickOnSubmit()
    {
        btn_Submit().click();
    }
}
