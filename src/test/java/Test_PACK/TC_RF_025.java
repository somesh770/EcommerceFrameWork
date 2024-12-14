package Test_PACK;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;

public class TC_RF_025 extends Base_Class
{
	@Test
	public void Verify_Breadcrumb_PageHeading_PageURL_PageTitle_of_Register_AccountPage() 
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
		
		Softass.assertEquals(	driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Register']")).isDisplayed(), true);
		
		Softass.assertEquals(driver.getTitle(), "Register Account");
		
		Softass.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/register");
		
	}

}
