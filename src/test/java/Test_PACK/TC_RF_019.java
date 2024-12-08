package Test_PACK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import Utility_PACK.Reusable_details;

public class TC_RF_019 extends Base_Class {
	@Test
	public void Verify_whether_the_leading_and_trailing_spaces_entered_into_the_Register_Account_fields_are_trimmed() {
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		String firstname = " somesh  ";
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);

		String lastname = " landge   ";
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);

		String email = "    " + Reusable_details.reusableEmail() + "   ";

		driver.findElement(By.id("input-email")).sendKeys(email);

		String mobile = "  " + Reusable_details.reusableMobile() + "    ";
		driver.findElement(By.id("input-telephone")).sendKeys(mobile);

		String password = "  Test@123  ";
		driver.findElement(By.id("input-password")).sendKeys(password);

		String confpassword = "  Test@123  ";
		driver.findElement(By.id("input-confirm")).sendKeys(confpassword);

		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();

		driver.findElement(By.xpath("//a[text()='Edit your account information']")).click();

		String Actualfirname = driver.findElement(By.id("input-firstname")).getAttribute("value");
		String Actuallastname = driver.findElement(By.id("input-lastname")).getAttribute("value");
		String actualemail = driver.findElement(By.id("input-email")).getAttribute("value");
		String Actualtele = driver.findElement(By.id("input-telephone")).getAttribute("value");

		Softass.assertEquals(Actualfirname, firstname.trim());
		Softass.assertEquals(Actuallastname, lastname.trim());
		Softass.assertEquals(actualemail, email.trim());
		Softass.assertEquals(Actualtele, mobile.trim());

	}

}
