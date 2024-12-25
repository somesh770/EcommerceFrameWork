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
	WebElement ContinueBBTN_loginpage;

//===============================================================
	public void click_ContinueBBTN_loginpage() {
		ContinueBBTN_loginpage.click();
	}
}
