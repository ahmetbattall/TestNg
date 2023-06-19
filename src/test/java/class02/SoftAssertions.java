package class02;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftAssertions extends CommonMethods {
    //precondition

    // login into the syntax HRMS app
    // verify that welcome message is displayed
    // verify that the message is  "Welcome Admin"

    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndNavigate(){
        openBrowserAndNavigateToURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login","chrome");

    }
    // post conditions
    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){

        driver.quit();
    }

    @Test(groups = "regression")
    public void verifyTheWelcomeMessage(){
        // send username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");

        // send password
        WebElement password=  driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

        //        click login
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

        // get the message
        WebElement welcomeMSG=driver.findElement(By.id("welcome"));


        // verify is displayed
        boolean isDisplay= welcomeMSG.isDisplayed();;
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(isDisplay);

        // verify the message is welcome admin
        String actualWelcomeText=welcomeMSG.getText();
        String expectedWelcomeText="Welcome Admin";
        soft.assertEquals(actualWelcomeText,expectedWelcomeText);

        // assert all the assertions
        soft.assertAll();
    }









}
