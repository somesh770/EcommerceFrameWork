package POM_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_PACK.Reusable_details;

public class D_MyAccount_page {
	private WebDriver driver;
	private String email;
	private String mobile;

	

	// Constructor
	public D_MyAccount_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		this.email = Reusable_details.reusableEmail();
		this.mobile = Reusable_details.reusableMobile();
	}
//-----------------------------------------------------------------------------
	@FindBy(linkText= ("Subscribe / unsubscribe to newsletter"))
	WebElement MyAC_subsscribe_Opn;
	
	public void click_MyAC_subsscribe_Opn()
	{
		MyAC_subsscribe_Opn.click();
	}
			
}
