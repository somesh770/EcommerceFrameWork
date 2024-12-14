package Test_PACK;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_024 extends Base_Class {
	@Test
	public void Verify_Registring_Account_by_filling_Password_field_and_not_filling_Password_Confirm_field() {
		// Navigating to Register
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

		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		Softass.assertEquals(driver.findElement(By.xpath("//div[text()='Password confirmation does not match password!']")).getText(),
				"Password confirmation does not match password!");

		Softass.assertEquals(driver.getCurrentUrl(),
				"https://tutorialsninja.com/demo/index.php?route=account/register");

	}

}
