package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D_RHS_Menu_bar {
	WebDriver driver;

	public D_RHS_Menu_bar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//-------------------------------------------------------------------------------	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LoginOut_RHSmenu;

	@FindBy(xpath = "//a[@class='list-group-item'][1]")
	private WebElement register_rightbar_login;

	@FindBy(xpath = "//a[@class='list-group-item'][2]")
	private WebElement register_rightbar_register;

	@FindBy(xpath = "//a[normalize-space()='Forgotten Password']")
	private WebElement register_rightbar_forgotpass;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
	private WebElement register_rightbar_myAC;

	@FindBy(xpath = "//a[@class='list-group-item'][5]")
	private WebElement register_rightbar_addressbook;

	@FindBy(xpath = "//a[@class='list-group-item'][6]")
	private WebElement register_rightbar_wishlist;

	@FindBy(xpath = "//a[@class='list-group-item'][7]")
	private WebElement register_rightbar_orderHistory;

	@FindBy(xpath = "//a[@class='list-group-item'][8]")
	private WebElement register_rightbar_Download;

	@FindBy(xpath = "//a[@class='list-group-item'][9]")
	private WebElement register_rightbar_RecurrinhPaymnet;

	@FindBy(xpath = "//a[@class='list-group-item'][10]")
	private WebElement register_rightbar_rewardPoint;

	@FindBy(xpath = "//a[@class='list-group-item'][11]")
	private WebElement register_rightbar_Return;

	@FindBy(xpath = "//a[@class='list-group-item'][12]")
	private WebElement register_rightbar_Transaction;

	@FindBy(xpath = "//a[@class='list-group-item'][13]")
	private WebElement register_rightbar_newsletter;

//==================================================================================================

	public void click_register_rightbar_login() {
		register_rightbar_login.click();
	}

	public void click_register_rightbar_register() {
		register_rightbar_register.click();
	}

	public void click_register_rightbar_forgotpass() {
		register_rightbar_forgotpass.click();
	}

	public void click_register_rightbar_myAC() {
		register_rightbar_myAC.click();
	}

	public void click_register_rightbar_addressbook() {
		register_rightbar_addressbook.click();
	}

	public void click_register_rightbar_wishlist() {
		register_rightbar_wishlist.click();
	}

	public void click_register_rightbar_orderHistory() {
		register_rightbar_orderHistory.click();
	}

	public void click_register_rightbar_Download() {
		register_rightbar_Download.click();
	}

	public void click_register_rightbar_RecurrinhPaymnet() {
		register_rightbar_RecurrinhPaymnet.click();
	}

	public void click_register_rightbar_rewardPoint() {
		register_rightbar_rewardPoint.click();
	}

	public void click_register_rightbar_Return() {
		register_rightbar_rewardPoint.click();
	}

	public void click_register_rightbar_Transaction() {
		register_rightbar_Transaction.click();
	}

	public void click_register_rightbar_newsletter() {
		register_rightbar_newsletter.click();
	}

	public boolean Logout_RHSmenu_isDisplayed() {
		return LoginOut_RHSmenu.isDisplayed();

	}
}
