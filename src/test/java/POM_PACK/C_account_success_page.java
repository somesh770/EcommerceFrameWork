package POM_PACK;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_PACK.Reusable_details;

public class C_account_success_page {
	private WebDriver driver;
	private String email;
	private String mobile;

	// Constructor
	public C_account_success_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.email = Reusable_details.reusableEmail();
		this.mobile = Reusable_details.reusableMobile();
	}
//=========================================================================

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement succ_ContinueCTA;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement successMesssageOnAccountPage;
	
//============================================================================================

	public void click_ucc_ContinueCTA() {
		succ_ContinueCTA.click();
	}

	public String GetTest_Success_messgae_on_Accountpage() {
		return successMesssageOnAccountPage.getText();
	}

}
