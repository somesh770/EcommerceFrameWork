package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 extends Base_Class
{
	@Test
	public void Verify__navigating_to_Register_Account_page_via_MY_Account_Registration()
	{
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        
       String RegisterAccount01 = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText();
       String RegisterAccount02 = driver.getCurrentUrl();
       
       Assert.assertEquals(RegisterAccount01, "Register Account");
       Assert.assertEquals(RegisterAccount02, "https://tutorialsninja.com/demo/index.php?route=account/register");
       		
	}
	
	@Test
	public void Verify__navigating_to_Register_Account_page_via_Login_page_NEW_Customer()
	{
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		String RegisterAccount01 = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText();
	    String RegisterAccount02 = driver.getCurrentUrl();
	       
	    Assert.assertEquals(RegisterAccount01, "Register Account");
	    Assert.assertEquals(RegisterAccount02, "https://tutorialsninja.com/demo/index.php?route=account/register");
	}
	
	@Test
	public void Verify__navigating_to_Register_Account_page_via_Login_page_Register_Right_Box()
	{
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Register']")).click();
		
		String RegisterAccount01 = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText();
	    String RegisterAccount02 = driver.getCurrentUrl();
	       
	    Assert.assertEquals(RegisterAccount01, "Register Account");
	    Assert.assertEquals(RegisterAccount02, "https://tutorialsninja.com/demo/index.php?route=account/register");
	}
	

}
