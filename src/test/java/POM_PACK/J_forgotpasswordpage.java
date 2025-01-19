package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class J_forgotpasswordpage 
{
	WebDriver driver;

	public J_forgotpasswordpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//=====================================================================
	

}
