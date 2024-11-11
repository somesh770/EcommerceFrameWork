package Test_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;
import POM_PACK.C_account_success_page;
import POM_PACK.D_MyAccount_page;

public class TC_RF_005 extends Base_Class

{
	@Test
	public void Verify_Registering_an_Account_when_YES_option_is_selected_for_Newsletter_field() {
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
		RegistrationPG.Send_ConfirmPassword();
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		C_account_success_page accsuccessPG = new C_account_success_page(driver);

		accsuccessPG.click_ucc_ContinueCTA();

		D_MyAccount_page myAcpage = new D_MyAccount_page(driver);
		myAcpage.click_MyAC_subsscribe_Opn();

		boolean Newsletter_YES = driver.findElement(By.xpath("//input[@value='1']")).isSelected();

		Assert.assertEquals(Newsletter_YES, true);
	}

}
