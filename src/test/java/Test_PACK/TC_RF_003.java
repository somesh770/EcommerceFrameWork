package Test_PACK;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_003 extends Base_Class {
	@Test
	public void verifyRegisteringAnAccount() {
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

		// Verifying success message
		WebElement successMessage = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
		String actualSuccessText = successMessage.getText();
		String expectedSuccessText = "Your Account Has Been Created!";
		Assert.assertEquals(actualSuccessText, expectedSuccessText);

		// Verifying Logout option
		boolean isLogoutDisplayed = driver
				.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed();
		System.out.println("Is Logout Displayed: " + isLogoutDisplayed);
		Assert.assertTrue(isLogoutDisplayed);
	}

}
