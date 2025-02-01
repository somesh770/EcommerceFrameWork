package POM_PACK;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class L_AccountLogoutPage {
	protected WebDriver driver;
	WebDriverWait wait;

// Constructor	
	public L_AccountLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
//==============================================================

	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	private WebElement accountLogoutTextElement;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement AC_Logout_ContinueBtn;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement AC_Logout_BreadCrum;
	

//================================================================
	public String GetText_Account_Logout() {

		return accountLogoutTextElement.getText();
	}
	
	public boolean Is_Disply_AccountLogoutText() {

		return accountLogoutTextElement.isDisplayed();
	}

	public void Click_On_ContinueBtn() {

		AC_Logout_ContinueBtn.click();
	}
	
	public boolean IsLogOutDisplyOnBreadCrum() {
		return AC_Logout_BreadCrum.isDisplayed();
		
	}
	
	

}
