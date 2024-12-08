package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_PACK.A_Navigation_bar;

public class TC_RF_020 extends Base_Class
{
	@Test
	public void Verify_whether_the_Privacy_Policy_checkbox_option_is_not_selected_by_default()
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
		boolean PrivacyPolicy_isselected = driver.findElement(By.xpath("//input[@name='agree']")).isSelected();
						
		Softass.assertEquals(PrivacyPolicy_isselected, false);
		
		
	}


}
