package POM_PACK;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A_Navigation_bar {
	protected WebDriver driver;
	private WebDriverWait wait;

// Constructor	
	public A_Navigation_bar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

//========================================================================

//MyAccountCTA
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement MyAccountCTA;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement Register_MyAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement Login_MyAccount;

	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	private WebElement LogoutMyAccount;

	@FindBy(xpath = "//i[@class='fa fa-phone']")
	private WebElement Header_Conatctus;

	@FindBy(xpath = "//div[@id='top-links']//li[3]")
	private WebElement Header_withlist;

	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	private WebElement Header_shopppingcard;

	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	private WebElement Header_checkout;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement Header_searchbox;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement Header_searchbutto;

	@FindBy(xpath = "//a[normalize-space()='Qafox.com']")
	private WebElement Header_QAfoxLogo;

// breadcrum	

	@FindBy(xpath = "(//i[@class='fa fa-home'])[1]")
	private WebElement breadc_homeicon;

	@FindBy(xpath = "//a[normalize-space()='Account']")
	private WebElement breadc_myaccount;

	@FindBy(xpath = "//div[@id='account-register']//li[2]")
	private WebElement breadc_register;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement navbarLoginbutton;

//=============================================================================
	public boolean NavBar_IsLogINOptionDisply() {
		return Login_MyAccount.isDisplayed();
	}
	
	
	public void ClickLogoutMyAccount() {
		LogoutMyAccount.click();
	}
	
	public void click_nnavbarLoginbutton() {
		navbarLoginbutton.click();
	}

	public void click_NavBara_MyAccountCTA() {
		MyAccountCTA.click();
	}

	public void click_NavBara_Register_MyAccount() {
		Register_MyAccount.click();

	}

	public void click_Login_MyAccount() {
		Login_MyAccount.click();

	}

	public void click_NavBara_contactust() {
		Header_Conatctus.click();
	}

	public void click_Header_withlist() {
		Header_withlist.click();
	}

	public void click_Header_shopppingcard() {
		Header_shopppingcard.click();
	}

	public void click_Header_checkout() {
		Header_checkout.click();
	}

	public void click_Header_searchbox() {
		Header_searchbox.click();
	}

	public void click_Header_searchbutto() {
		Header_searchbutto.click();
	}

	public void click_Header_QAfoxLogo() {
		Header_QAfoxLogo.click();
	}

	public void Waitclick_breadc_homeicon() {

		wait.until(ExpectedConditions.elementToBeClickable(breadc_homeicon));
	}

	public void click_breadc_homeicon() {

		breadc_homeicon.click();
	}

	public void Waitclick_breadc_myaccount() {

		wait.until(ExpectedConditions.elementToBeClickable(breadc_myaccount));

	}

	public void click_breadc_myaccount() {

		breadc_myaccount.click();
	}

	public void Waitclick_breadc_register() {
		wait.until(ExpectedConditions.elementToBeClickable(breadc_register));

	}

	public void click_breadc_register() {
		breadc_register.click();
	}

}
