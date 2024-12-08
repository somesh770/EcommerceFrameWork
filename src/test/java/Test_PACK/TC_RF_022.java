package Test_PACK;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;

public class TC_RF_022 extends Base_Class {
	@Test
	public void Verify_the_Password_text_entered_into_the_Password_and_Password_Confirm_field_of_Register_Account_functionality_is_toggled_to_hide_its_visibility() {
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		Softass.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("type"), "password");
		Softass.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("type"), "password");

	}

}
