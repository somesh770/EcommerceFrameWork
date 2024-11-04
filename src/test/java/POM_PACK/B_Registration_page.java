package POM_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class B_Registration_page {
	private WebDriver driver;

	public static String reusableEmail() {
		return new Date().toString().replace(" ", "").replace(":", "") + "@gmail.com";
	}

	public static String reusableMobile() {
		return "9" + (100000000L + (long) (new Random().nextDouble() * 900000000L));
	}

	// Constructor
	public B_Registration_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	String email = reusableEmail();
	String mobile = reusableMobile();

	@FindBy(id = "input-email")
	private WebElement Email;

	public String Send_Email() {
		Email.sendKeys(email);
		return email;
	}

	public void printstatment() {
		System.out.println("Email - " + email);
		System.out.println("Mobile - " + mobile);
	}

//------------------------------------------------------------
	@FindBy(id = "input-telephone")
	private WebElement Mobile;

	public String Send_Mobile() {
		Mobile.sendKeys(mobile);
		return mobile;
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

}
