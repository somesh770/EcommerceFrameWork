package Test_PACK;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import Utility_PACK.Reusable_details;

public class TC_RF_019 extends Base_Class
{
	@Test
	public void Verify_whether_the_leading_and_trailing_spaces_entered_into_the_Register_Account_fields_are_trimmed()
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
		driver.findElement(By.id("input-firstname")).sendKeys(" somesh");
		driver.findElement(By.id("input-lastname")).sendKeys(" landge");
		driver.findElement(By.id("input-email")).sendKeys(" "+Reusable_details.reusableEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(" "+ Reusable_details.reusableMobile());
		driver.findElement(By.id("input-password")).sendKeys(" Test@123");
		driver.findElement(By.id("input-confirm")).sendKeys(" Test@123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		
	}

}
