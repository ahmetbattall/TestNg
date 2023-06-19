package class02;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HardAssertions  extends CommonMethods {

    // go to hrms
    //enter username
    //click on login
    //verify that error message Invalid credentials is displayed
    //also confirm that error message is diplayed

    @BeforeMethod
    public void openBrowserAndNavigate(){
        openBrowserAndNavigateToURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login","chrome");
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
    @Test(groups = "smoke")
    public void verifyErrorMessage(){
        // send username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");

        // send password

        WebElement password=  driver.findElement(By.xpath("//input[@id='txtPassword']"));
         password.sendKeys("abracadabra");

         // click login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

        // get the error message
        WebElement errorMSG= driver.findElement(By.id("spanMessage"));
        String actualErrorMSG= errorMSG.getText();
        String expectedErrorMSG="Invalid credentials";


       //comparing two strings, which assertion to use
        Assert.assertEquals(actualErrorMSG,expectedErrorMSG);

        // check if it is displayed
        boolean errorMsgDisplayed= errorMSG.isDisplayed();
        Assert.assertTrue(errorMsgDisplayed);

    }




}
