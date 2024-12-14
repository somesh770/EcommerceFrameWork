package POM_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_PACK.Reusable_details;

public class B_Registration_page {
	private WebDriver driver;
	private String email;
	private String mobile;
	

	// Constructor
	public B_Registration_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		this.email = Reusable_details.reusableEmail();
		this.mobile = Reusable_details.reusableMobile();
	}

//=================================================================
	// First Name
	@FindBy(id = "input-firstname")
	private WebElement firstname;

	public void Send_FirstName() {
		firstname.sendKeys("Test");
	}

//--------------------------------------------------------------------
	// Last Name
	@FindBy(id = "input-lastname")
	private WebElement LastName;

	public void Send_LastName() {
		LastName.sendKeys("Test");
	}

//------------------------------------------------------	
//	String email = reusableEmail();
//	String mobile = reusableMobile();

	@FindBy(id = "input-email")
	private WebElement Email;

	public String Send_Email() {
		Email.sendKeys(email);
		return email;
	}
	

//------------------------------------------------------------
	@FindBy(id = "input-telephone")
	private WebElement Mobile;

	public String Send_Mobile() {
		Mobile.sendKeys(mobile);
		return mobile;
	}

	public void printstatment() {
		System.out.println("Email - " + email);
		System.out.println("Mobile - " + mobile);
	}
	
	// ---------------------------------------------------------------------------
	@FindBy(id = "input-password")
	private WebElement password;

	public void Send_password() {
		password.sendKeys("Test@123");
	}

//----------------------------------------------------------------
	@FindBy(id = "input-confirm")
	private WebElement ConfirmPassword;

	public void Send_ConfirmPassword() {
		ConfirmPassword.sendKeys("Test@123");
	}

//-----------------------------------------------------------------
	@FindBy(xpath = "(//input[@value='1'])[2]")
	private WebElement SubscribeRadio_YES;

	public void select_SubscribeRadio_YES() {
		SubscribeRadio_YES.click();
	}
	
	@FindBy(xpath = "//input[@value='0']")
	private WebElement SubscribeRadio_NO;

	public void select_SubscribeRadio_NO() {
		SubscribeRadio_NO.click();
	}

//---------------------------------------------------------------
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement disclaimer;

	public void Select_disclaimer() {
		disclaimer.click();
	}

//----------------------------------------------------------
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement Continue;

	public void clickON_Continue() {
		Continue.click();
	}
//------------------------------------------------------------		

	public void setEmail(String invalidEmail) {
		this.email = email;
	    Email.clear();
	    Email.sendKeys(email);
		
	}
//-----------------------------------------------------------------
	@FindBy(xpath="//a[normalize-space()='login page']")
	private WebElement Header_loginhyperlink;
	public void click_Header_loginhyperlink() {
		Header_loginhyperlink.click();
	}
	
//----------------------------------------------------------------	
	// rightside menu bar
	
		@FindBy(xpath="//a[@class='list-group-item'][1]")
		private WebElement register_rightbar_login;
		public void click_register_rightbar_login() {
			register_rightbar_login.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][2]")
		private WebElement register_rightbar_register;
		public void click_register_rightbar_register() {
			register_rightbar_register.click();
		}
		
		@FindBy(xpath="//a[normalize-space()='Forgotten Password']")
		private WebElement register_rightbar_forgotpass;
		public void click_register_rightbar_forgotpass() {
			register_rightbar_forgotpass.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='My Account']")
		private WebElement register_rightbar_myAC;
		public void click_register_rightbar_myAC() {
			register_rightbar_myAC.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][5]")
		private WebElement register_rightbar_addressbook;
		public void click_register_rightbar_addressbook() {
			register_rightbar_addressbook.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][6]")
		private WebElement register_rightbar_wishlist;
		public void click_register_rightbar_wishlist() {
			register_rightbar_wishlist.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][7]")
		private WebElement register_rightbar_orderHistory;
		public void click_register_rightbar_orderHistory() {
			register_rightbar_orderHistory.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][8]")
		private WebElement register_rightbar_Download;
		public void click_register_rightbar_Download() {
			register_rightbar_Download.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][9]")
		private WebElement register_rightbar_RecurrinhPaymnet;
		public void click_register_rightbar_RecurrinhPaymnet() {
			register_rightbar_RecurrinhPaymnet.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][10]")
		private WebElement register_rightbar_rewardPoint;
		public void click_register_rightbar_rewardPoint() {
			register_rightbar_rewardPoint.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][11]")
		private WebElement register_rightbar_Return;
		public void click_register_rightbar_Return() {
			register_rightbar_rewardPoint.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][12]")
		private WebElement register_rightbar_Transaction;
		public void click_register_rightbar_Transaction() {
			register_rightbar_Transaction.click();
		}
		
		@FindBy(xpath="//a[@class='list-group-item'][13]")
		private WebElement register_rightbar_newsletter;
		public void click_register_rightbar_newsletter() {
			register_rightbar_newsletter.click();
		}
	

}
