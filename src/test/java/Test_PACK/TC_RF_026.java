package Test_PACK;

import java.io.IOException;

import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import Utility_PACK.TakeScreenshotClass;

public class TC_RF_026 extends Base_Class
{
	@Test
	public void Verify_the_UI_of_Register_Account_page() throws IOException
	{
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
		TakeScreenshotClass.takeScreenshot("ss1", driver);
		
	}

}
