package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;

public class TC_RF_013 extends Base_Class
{
	@Test
	public static void Verify_all_fields_in_the_Register_Account_page_have_proper_placeholders()
	{
		// Navigating to Register
				A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
				navbarmenu.click_NavBara_MyAccountCTA();
				navbarmenu.click_NavBara_Register_MyAccount();
				
				String firstname = "First Name";
				String lastanme = "Last Name";
				String email = "E-Mail";
				String telephine = "Telephone";
				String password = "Password";
				String Confirmpassword = "Password Confir";
				
				Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), firstname);
				Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), lastanme);
				Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), email);
				Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), telephine);
				Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), password);
				Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), Confirmpassword);
				
				
		
	}

}
