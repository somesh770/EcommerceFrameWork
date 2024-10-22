package Test_PACK;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_003 extends Base_Class
{
       
    public static String reusableEmail() {
        return new Date().toString().replace(" ", "").replace(":", "") + "@gmail.com";
    }
    
    public static String reusableMobile() {
        return "9" + (100000000L + (long) (new Random().nextDouble() * 900000000L));
    }
    
    @Test
    public void verifyRegisteringAnAccount() {
        // Navigating to Register
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        
        // Entering user details
        driver.findElement(By.id("input-firstname")).sendKeys("qa");
        driver.findElement(By.id("input-lastname")).sendKeys("qa");
        
        String email = reusableEmail();
        String mobile = reusableMobile();
        
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(mobile);
        
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
        
        driver.findElement(By.id("input-password")).sendKeys("Test@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Test@123");
        
        // Submitting form
        driver.findElement(By.xpath("(//input[@value='1'])[2]")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        // Verifying success message
        WebElement successMessage = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        String actualSuccessText = successMessage.getText();
        String expectedSuccessText = "Your Account Has Been Created!";
        Assert.assertEquals(actualSuccessText, expectedSuccessText);
        
        // Verifying Logout option
        boolean isLogoutDisplayed = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed();
        System.out.println("Is Logout Displayed: " + isLogoutDisplayed);
        Assert.assertTrue(isLogoutDisplayed);
    }
    
    
}

	

	
	

