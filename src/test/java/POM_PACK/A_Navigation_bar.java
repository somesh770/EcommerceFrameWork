package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_Navigation_bar {
	private WebDriver driver;

// Constructor	
	public A_Navigation_bar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//========================================================================
// Story element

//MyAccountCTA
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement MyAccountCTA;

	public void click_NavBara_MyAccountCTA() {
		MyAccountCTA.click();
	}

//----------------------------------------------------------------------
//Register< My account
	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement Register_MyAccount;

	public void click_NavBara_Register_MyAccount() {
		Register_MyAccount.click();
	}
//--------------------------------------------------------------------------
	
	@FindBy(xpath="//i[@class='fa fa-phone']")
	private WebElement Header_Conatctus;
	public void click_NavBara_contactust() {
		Header_Conatctus.click();
	}
//-------------------------------------------------------------------	
	
	@FindBy(xpath="//div[@id='top-links']//li[3]")
	private WebElement Header_withlist;
	public void click_Header_withlist() {
		Header_withlist.click();
	}
	
//-------------------------------------------------------	
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	private WebElement Header_shopppingcard;
	public void click_Header_shopppingcard() {
		Header_shopppingcard.click();
	}
	
//-----------------------------------------------------------------------
	@FindBy(xpath="//span[normalize-space()='Checkout']")
	private WebElement Header_checkout;
	public void click_Header_checkout() {
		Header_checkout.click();
	}
	
//--------------------------------------------------------------------
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement Header_searchbox;
	public void click_Header_searchbox() {
		Header_searchbox.click();
	}
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement Header_searchbutto;
	public void click_Header_searchbutto() {
		Header_searchbutto.click();
	}
	
//--------------------------------------------	

	@FindBy(xpath="//a[normalize-space()='Qafox.com']")
	private WebElement Header_QAfoxLogo;
	public void click_Header_QAfoxLogo() {
		Header_QAfoxLogo.click();
	}
	
//----------------------------------------------------------
// breadcrum	
	
	@FindBy(xpath="(//i[@class='fa fa-home'])[1]")
	private WebElement breadc_homeicon;
	public void click_breadc_homeicon() {
		breadc_homeicon.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Account']")
	private WebElement breadc_myaccount;
	public void click_breadc_myaccount() {
		breadc_myaccount.click();
	}
	
	@FindBy(xpath="//div[@id='account-register']//li[2]")
	private WebElement breadc_register;
	public void click_breadc_register() {
		breadc_register.click();
	}
	
	
//----------------------------------------------------------------	
	

	
}
