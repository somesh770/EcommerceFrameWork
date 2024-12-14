package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_017 extends Base_Class {

	@Test(dataProvider = "passwordcomplixitycheck")
	public void Verify_whether_the_Password_fields_in_the_Register_Account_page_are_following_Password_Complexity_Standards(
			String password) {
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.Send_FirstName();
		RegistrationPG.Send_LastName();
		String email = RegistrationPG.Send_Email();
		String mobile = RegistrationPG.Send_Mobile();

		RegistrationPG.printstatment();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),
				"Password must be between 4 and 20 characters!");

	}

	@DataProvider(name = "passwordcomplixitycheck")

	public Object[][] supplypassword() {
		Object[][] passwords = { { "123" }, { "12345" }, { "abcdefghi" }, { "abcd1234" }, { "abcd123$" }, { "ABCD456#" } };
		return passwords;
	}

}
