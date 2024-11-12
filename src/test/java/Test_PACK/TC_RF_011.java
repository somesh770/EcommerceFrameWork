package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_011 extends Base_Class
{
	@Test
	public void Verify_Registering_Account_by_providing_invalid_phone_number_111()
	{
		// Navigating to Register
				A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
				navbarmenu.click_NavBara_MyAccountCTA();
				navbarmenu.click_NavBara_Register_MyAccount();

				// Entering user details
				B_Registration_page RegistrationPG = new B_Registration_page(driver);

				RegistrationPG.Send_FirstName();
				RegistrationPG.Send_LastName();
				
				String email = RegistrationPG.Send_Email();
				
				driver.findElement(By.id("input-telephone")).sendKeys("111");
				
				RegistrationPG.printstatment();
				RegistrationPG.Send_password();
				RegistrationPG.Send_ConfirmPassword();
				RegistrationPG.select_SubscribeRadio_YES();
				RegistrationPG.Select_disclaimer();
				RegistrationPG.clickON_Continue();
				
				
				String actualurl = driver.getCurrentUrl();
				String  expectedurl = "https://tutorialsninja.com/demo/index.php?route=account/register";
				
				Assert.assertEquals(actualurl, expectedurl);
		
	}
	
	
	
	@Test
	public void Verify_Registering_Account_by_providing_invalid_phone_number_abcde()
	{
		// Navigating to Register
				A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
				navbarmenu.click_NavBara_MyAccountCTA();
				navbarmenu.click_NavBara_Register_MyAccount();

				// Entering user details
				B_Registration_page RegistrationPG = new B_Registration_page(driver);

				RegistrationPG.Send_FirstName();
				RegistrationPG.Send_LastName();
				
				String email = RegistrationPG.Send_Email();
				
				driver.findElement(By.id("input-telephone")).sendKeys("abcde");
				
				
				RegistrationPG.printstatment();
				RegistrationPG.Send_password();
				RegistrationPG.Send_ConfirmPassword();
				RegistrationPG.select_SubscribeRadio_YES();
				RegistrationPG.Select_disclaimer();
				RegistrationPG.clickON_Continue();
				
				String actualurl = driver.getCurrentUrl();
				String  expectedurl = "https://tutorialsninja.com/demo/index.php?route=account/register";
				
				Assert.assertEquals(actualurl, expectedurl);
		
	}

}
