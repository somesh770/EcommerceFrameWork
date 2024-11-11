package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_008 extends Base_Class
{
	@Test
	public void Verify_Registering_Account_by_entering_different_passwords_into_Password_and_Password_Confirm_fields()
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		// Entering user details
		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.Send_FirstName();
		RegistrationPG.Send_LastName();
		String email = RegistrationPG.Send_Email();
		String mobile = RegistrationPG.Send_Mobile();
		RegistrationPG.printstatment();		
		RegistrationPG.Send_password();
		RegistrationPG.Send_ConfirmPassword();   // send Test@123 password 
		
		driver.findElement(By.id("input-confirm")).sendKeys("1234"); // Send 1234 in confirm password
		
		RegistrationPG.select_SubscribeRadio_NO();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();
		
		String Expectedmessage= "Password confirmation does not match password!";
		
		String Actualmessgae = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		
		Assert.assertEquals(Actualmessgae, Expectedmessage);
		
	}

}
