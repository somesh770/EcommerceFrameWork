package Test_PACK;

import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;

public class TC_RF_014 extends Base_Class
{
	@Test
	public static void Verify_all_mandatory_fields_in_Register_Account()
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
	}

}
