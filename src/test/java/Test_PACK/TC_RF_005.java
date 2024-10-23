package Test_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_005 extends Base_Class

{
	public static String reusableEmail() {
        return new Date().toString().replace(" ", "").replace(":", "") + "@gmail.com";
    }
    
    public static String reusableMobile() {
        return "9" + (100000000L + (long) (new Random().nextDouble() * 900000000L));
    }
    
	@Test
	public void  Verify_Registering_an_Account_when_YES_option_is_selected_for_Newsletter_field()
	{
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
        
        driver.findElement(By.linkText("Continue")).click();
        
        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
        
        boolean Newsletter_YES = driver.findElement(By.xpath("//input[@value='1']")).isSelected();
        
        Assert.assertEquals(Newsletter_YES, true);
	}
	

}
