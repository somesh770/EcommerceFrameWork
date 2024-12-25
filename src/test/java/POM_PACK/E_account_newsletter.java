package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_account_newsletter {
	WebDriver driver;

	public E_account_newsletter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//====================================================================
	@FindBy(xpath = "//input[@value='1']")
	WebElement Newsleterpage_YES;
	
	@FindBy(xpath = "//input[@value='0']")
	WebElement Newsleterpage_NO;
//======================================================================
	public boolean isSelectedNewsleterpage_YES() {
		return Newsleterpage_YES.isSelected();
		
	}
	
	public boolean isSelectedNewsleterpage_NO() {
		return Newsleterpage_NO.isSelected();
		
	}
	
	
}
