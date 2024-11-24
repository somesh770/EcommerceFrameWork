package Test_PACK;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility_PACK.Reusable_details;

public class TC_RF_012 extends Base_Class
{
	@Test
	public void Verify_Registering_Account_by_using_Keyboard_keys() throws InterruptedException
	{
		Actions act= new Actions(driver);
		
		act.sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(2)).
		sendKeys(Keys.ARROW_DOWN).
		sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).
		sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(1000);
		
		for(int i =1 ; i<=23; i++)
		{
			act.sendKeys(Keys.TAB).perform();
		}
		
		act.sendKeys("somesh").sendKeys(Keys.TAB).
		sendKeys("landge").sendKeys(Keys.TAB).
		sendKeys(Reusable_details.reusableEmail()).sendKeys(Keys.TAB).
		sendKeys(Reusable_details.reusableMobile()).sendKeys(Keys.TAB).
		sendKeys("Test@123").sendKeys(Keys.TAB).
		sendKeys("Test@123").sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		
		WebElement successMessage = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
		String actualSuccessText = successMessage.getText();
		String expectedSuccessText = "Your Account Has Been Created!";
		Assert.assertEquals(actualSuccessText, expectedSuccessText);

		// Verifying Logout option
		boolean isLogoutDisplayed = driver
				.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed();
		System.out.println("Is Logout Displayed: " + isLogoutDisplayed);
		Assert.assertTrue(isLogoutDisplayed);
		
		
		
		
	
		
	}

}
