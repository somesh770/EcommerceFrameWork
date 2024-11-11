package Test_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;
import java.util.Arrays;
import java.util.List;

public class TC_RF_010 extends Base_Class {

	@Test
	public void invalidEmail_1() {

		// Navigating to Register
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		// Instantiate the registration page
		B_Registration_page registrationPage = new B_Registration_page(driver);

		registrationPage.Send_FirstName();
		registrationPage.Send_LastName();

		WebElement emailField1 = driver.findElement(By.id("input-email"));
		emailField1.sendKeys("amotoori");
		// emailField.sendKeys(Keys.TAB); // Move focus away to trigger the validation

		registrationPage.Send_Mobile();
		registrationPage.Send_password();
		registrationPage.Send_ConfirmPassword();
		registrationPage.Select_disclaimer();
		registrationPage.clickON_Continue();

		String validationMessage = emailField1.getAttribute("validationMessage");
		System.out.println("Validation message for Email - amotoori---->" + validationMessage);

		
		
	}
//--------------------------------------------------------------------------------------------------------------
	
	@Test
	public void invalidEmail_2() {
	
		// Navigating to Register
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
		B_Registration_page registrationPage = new B_Registration_page(driver);

		registrationPage.Send_FirstName();
		registrationPage.Send_LastName();

		WebElement emailField2 = driver.findElement(By.id("input-email"));
		emailField2.sendKeys("amotoori@");
		// emailField.sendKeys(Keys.TAB); // Move focus away to trigger the validation

		registrationPage.Send_Mobile();
		registrationPage.Send_password();
		registrationPage.Send_ConfirmPassword();
		registrationPage.Select_disclaimer();
		registrationPage.clickON_Continue();

		String validationMessage2 = emailField2.getAttribute("validationMessage");
		System.out.println("Validation message for Email - amotoori@ ----> " + validationMessage2);

	}

//--------------------------------------------------------------------------------------------------------------------
	@Test
	public void invalidEmail_3() {

		// Navigating to Register
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		
		B_Registration_page registrationPage = new B_Registration_page(driver);


		registrationPage.Send_FirstName();
		registrationPage.Send_LastName();

		WebElement emailField3 = driver.findElement(By.id("input-email"));
		emailField3.sendKeys("amotoori@gmail");
		// emailField.sendKeys(Keys.TAB); // Move focus away to trigger the validation

		registrationPage.Send_Mobile();
		registrationPage.Send_password();
		registrationPage.Send_ConfirmPassword();
		registrationPage.Select_disclaimer();
		registrationPage.clickON_Continue();

		String ActulalMeesg = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		
		Assert.assertEquals(ActulalMeesg, "E-Mail Address does not appear to be valid!");

	}

//----------------------------------------------------------------------------------------------------------
	@Test
	public void invalidEmail_4() {
		// Navigating to Register
		
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		B_Registration_page registrationPage = new B_Registration_page(driver);

		registrationPage.Send_FirstName();
		registrationPage.Send_LastName();

		WebElement emailField4 = driver.findElement(By.id("input-email"));
		emailField4.sendKeys("amotoori@gmail.");
		// emailField.sendKeys(Keys.TAB); // Move focus away to trigger the validation

		registrationPage.Send_Mobile();
		registrationPage.Send_password();
		registrationPage.Send_ConfirmPassword();
		registrationPage.Select_disclaimer();
		registrationPage.clickON_Continue();

		String validationMessage4 = emailField4.getAttribute("validationMessage");
		System.out.println("Validation message for Email - amotoori@gmail. ----> " + validationMessage4);

	}

	
}
