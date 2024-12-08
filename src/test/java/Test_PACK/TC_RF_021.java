package Test_PACK;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_021 extends Base_Class
{
	@Test
	public void Verify_Registering_the_Account_without_selecting_the_Privacy_Policy_checkbox_option()
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.Send_FirstName();
		RegistrationPG.Send_LastName();
		
		String email = RegistrationPG.Send_Email();
		String mobile = RegistrationPG.Send_Mobile();
		
		RegistrationPG.printstatment();
		RegistrationPG.Send_password();
		RegistrationPG.Send_ConfirmPassword();
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.clickON_Continue();
		
		
		Softass.assertEquals("https://tutorialsninja.com/demo/index.php?route=account/registe","https://tutorialsninja.com/demo/index.php?route=account/register" );
		
		String privacypo = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		
		String privacy = "Warning: You must agree to the Privacy Policy!";
		
		Softass.assertEquals(privacypo , privacy);
		
	}


}
