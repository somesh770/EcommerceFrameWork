package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class M_ProductPage_imac {
	WebDriver driver;

	public M_ProductPage_imac(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//=====================================================================
	

}
