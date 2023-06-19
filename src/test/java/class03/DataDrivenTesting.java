package class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataDrivenTesting {
    //    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"

    @DataProvider(name = "invalidCredentials")
    public Object[][] data() {
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;
    }

    public static WebDriver driver;

    @BeforeMethod
    public void openAndLaunchBrowser(){
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.close();
    }


    @Test(dataProvider ="invalidCredentials" )
    public void loginWithInvalidCredentials(String user,String pass,String expectedMSG){//
        // finding the username text box
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        // send username
        userName.sendKeys(user);
         // find pass
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        // send pass
        password.sendKeys(pass);
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
        //get the element message invalid credentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        // extract the error message
        String actualMsg = errorMsg.getText();
        // Assert
        Assert.assertEquals(actualMsg,expectedMSG);




    }

}
