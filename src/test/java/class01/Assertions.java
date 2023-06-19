package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assertions {
    //test1
    // go to hrms
    // enter username Admin
    // enter no password
    //verify that massage is "Password cannot be empty"
    public static WebDriver driver;
    @BeforeMethod
    public void OpenBrowserAndLaunch(){
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

    @Test
    public void verifyErrorMessage(){
      WebElement usernameTextBox= driver.findElement(By.xpath("//input[@id='txtUsername']"));
      usernameTextBox.sendKeys("Admin");
      WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
      login.click();

      // get text
      WebElement errorMSG= driver.findElement(By.xpath("//span[@id='spanMessage']"));
      String actualErrorMSG=errorMSG.getText();
      String expectedErrorMSG="Password cannot be empty";
      Assert.assertEquals(actualErrorMSG,expectedErrorMSG);

    }





}
