package POM_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_PACK.PropertyFileUtil;
import Utility_PACK.Reusable_details;

public class B_Registration_page {
	private WebDriver driver;
	private String email;
	private String mobile;

	// Constructor
	public B_Registration_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//=================================================================
	// First Name
	@FindBy(id = "input-firstname")
	private WebElement firstname_Fields;

	// Last Name
	@FindBy(id = "input-lastname")
	private WebElement LastnameField;

	@FindBy(id = "input-email")
	private WebElement Email;

	@FindBy(id = "input-telephone")
	private WebElement Mobile;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement ConfirmPassword;

	@FindBy(xpath = "(//input[@value='1'])[2]")
	private WebElement SubscribeRadio_YES;

	@FindBy(xpath = "//input[@value='0']")
	private WebElement SubscribeRadio_NO;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement disclaimer;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement Continue;

	@FindBy(xpath = "//a[normalize-space()='login page']")
	private WebElement Header_loginhyperlink;

// Worning message
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmeg_for_Privacy_Policy;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	WebElement alertmeg_for_Firstname;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	WebElement alertmeg_for_Lastname;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement alertmeg_for_Email;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	WebElement alertmeg_for_telephone;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	WebElement alertmeg_for_Password;

	@FindBy(xpath = "//h1[text()='Register Account']")
	WebElement Text_RegisterAccount;

	@FindBy(xpath = "//div[@class='text-danger']")
	WebElement alrtConfirmPassword;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement Worning_Emailexits;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement Worninginvalidemail04;
//===============================================================================================

	public String Get_Worning_Emailexits() {
		return Worning_Emailexits.getText();

	}

	public String Get_alrtConfirmPassword() {
		return alrtConfirmPassword.getText();

	}

	public String Get_Text_RegisterAccount() {
		return Text_RegisterAccount.getText();

	}

	public String Get_alertmeg_for_Password() {
		return alertmeg_for_Password.getText();

	}

	public String Get_alertmeg_for_telephone() {
		return alertmeg_for_telephone.getText();

	}

	public String Get_alertmeg_for_Email() {
		return alertmeg_for_Email.getText();

	}

	public String Get_alertmeg_for_Lastname() {
		return alertmeg_for_Lastname.getText();

	}

	public String Get_alertmeg_for_Firstname() {
		return alertmeg_for_Firstname.getText();

	}

	public String Get_alertmeg_for_Privacy_Policy() {
		return alertmeg_for_Privacy_Policy.getText();

	}

	public void Send_FirstName(String FirstName) {
		firstname_Fields.sendKeys(FirstName);
	}

	public String get_placeholder_firstname() {
		return firstname_Fields.getAttribute("placeholder");
	}

	public void Send_LastName(String LastName) {
		LastnameField.sendKeys(LastName);
	}

	public String get_placeholder_lastname() {
		return LastnameField.getAttribute("placeholder");
	}

	public String Send_Email(String EmailText) {
		Email.sendKeys(EmailText);
		return EmailText;
	}

	public String get_placeholder_email() {
		return Email.getAttribute("placeholder");
	}

	public String get_getDomProperty_Email() {
		return Email.getDomProperty("validationMessage");

	}

	public void ClearEmail() {
		Email.clear();

	}

	public String getWorninginvalidemail04() {
		return Worninginvalidemail04.getText();

	}

	public String Send_Mobile(String mobileText) {
		Mobile.sendKeys(mobileText);
		return mobileText;
	}

	public String get_placeholder_mobile() {
		return Mobile.getAttribute("placeholder");
	}

	public void Send_password(String ValidPasword) {
		password.sendKeys(ValidPasword);
	}

	public String get_placeholder_password() {
		return password.getAttribute("placeholder");
	}

	public void Send_ConfirmPassword(String confirmpasswordText) {
		ConfirmPassword.sendKeys(confirmpasswordText);
	}

	public String get_placeholder_confirmpass() {
		return ConfirmPassword.getAttribute("placeholder");
	}

	public void select_SubscribeRadio_YES() {
		SubscribeRadio_YES.click();
	}

	public void select_SubscribeRadio_NO() {
		SubscribeRadio_NO.click();
	}

	public void Select_disclaimer() {
		disclaimer.click();
	}

	public void clickON_Continue() {
		Continue.click();

	}

	public void click_Header_loginhyperlink() {
		Header_loginhyperlink.click();
	}

}
