package Test_PACK;

import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;

public class TC_RF_018 extends Base_Class
{
	@Test
	public void Verify_whether_fields_in_Register_Account_page_are_according_Client_requirements()
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
	}

}
