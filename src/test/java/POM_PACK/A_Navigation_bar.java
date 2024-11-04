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
//

}
