package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class H_Contactus {

	WebDriver driver;

	public H_Contactus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//=======================================================================
	
	
}
