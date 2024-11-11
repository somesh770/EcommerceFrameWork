package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_009 extends Base_Class {
	@Test
	public void Verify_Registering_Account_by_providing_the_existing_account_details() {
		// Navigating to Register
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		// Entering user details
		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.Send_FirstName();
		RegistrationPG.Send_LastName();

		driver.findElement(By.id("input-email")).sendKeys("MonNov11152227IST2024@gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys("9284181405");

		RegistrationPG.Send_password();
		RegistrationPG.Send_ConfirmPassword();
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		String ActualWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();

		Assert.assertEquals(ActualWarning, "Warning: E-Mail Address is already registered!");
	}
}
