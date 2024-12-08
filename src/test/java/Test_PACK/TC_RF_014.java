package Test_PACK;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;

public class TC_RF_014 extends Base_Class {
	@Test
	public static void Verify_all_mandatory_fields_in_Register_Account() {
		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		WebElement firstname = driver.findElement(By.cssSelector("label[for='input-firstname']"));

		JavascriptExecutor jsee = (JavascriptExecutor) driver;

		String ashstrictFN = (String) jsee.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content','color');", firstname);
		System.out.println("mandetory mark on first name field:" + ashstrictFN);
		
		String ashstrictcolorFN = (String) jsee.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstname);
		System.out.println("Color of the firstname label:" + ashstrictcolorFN);
		
		
		

		WebElement lastname = driver.findElement(By.cssSelector("label[for='input-lastname']"));

		WebElement email = driver.findElement(By.cssSelector("label[for='input-email']"));
	}

}
