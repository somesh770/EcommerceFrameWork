package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_LoginPage {
	WebDriver driver;

	public F_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//========================================================
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement ContinueBBTN_loginpage;

	@FindBy(id = "input-email")
	private WebElement login_EmailElement;

	@FindBy(id = "input-password")
	private WebElement login_password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginCTAElement;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement Alrt_InvalidEmail;
	
	@FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	private WebElement forgotpassElement;
//===============================================================
	public  String GetplacholderEmail() 
	{		
		return login_EmailElement.getDomAttribute("placeholder");
	}
	
	public  String GetplacholderPassword() 
	{		
		return login_password.getDomAttribute("placeholder");
	}
	
	
	public boolean IsDisply_Forgotpassword()
	{
		return  forgotpassElement.isDisplayed();
	}
	public void  ClickOnForgotpassword()
	{
		 forgotpassElement.click();
	}
	
	public String Login_GetAlert_InvalidEmail()
	{
	     return	Alrt_InvalidEmail.getText();
	}
	
	public void ClickOnLogin()
	{
		loginCTAElement.click();
	}
	public void SendEmail_login(String EmailText) {
		login_EmailElement.sendKeys(EmailText);
	}

	public void Sendlogin_password(String password) {
		login_password.sendKeys(password);
	}

	public String GetDomAttribut_pasword() {
		return login_password.getDomAttribute("type");
	}

	public String GetDomAttribut_email() {
		return login_EmailElement.getDomAttribute("type");
	}

	public void click_ContinueBBTN_loginpage() {
		ContinueBBTN_loginpage.click();
	}
}
