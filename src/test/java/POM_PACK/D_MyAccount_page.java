package POM_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_PACK.Reusable_details;

public class D_MyAccount_page {
	WebDriver driver;
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
	private WebElement MyAC_subsscribe_Opn;
	
	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	private WebElement MyAC_editAccouintInfo;
	
	@FindBy(xpath = "//a[text()='Change your password']")
	private WebElement MyAC_Change_your_password;
	
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement myAC_alertMessageElement;
//=====================================================================
	public void click_MyAC_subsscribe_Opn()
	{
		MyAC_subsscribe_Opn.click();
	}
	public void click_MyAC_editAccouintInfo()
	{
		MyAC_editAccouintInfo.click();
	}
	
	public void click_MyAC_Change_your_password()
	{
		MyAC_Change_your_password.click();
	}
	
	public String Get_myAC_alertMessageElement() {
		return myAC_alertMessageElement.getText();
	}
	
			
}
