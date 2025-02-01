package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class K_Change_Password_Page {
	public WebDriver driver;

	public K_Change_Password_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-password")
	private WebElement passChnage_PasswordElement;

	@FindBy(id = "input-confirm")
	private WebElement passChnage_PasswordConfirm;

	@FindBy(xpath = "//a[normalize-space()='Back']")
	private WebElement passChnage_BackBtnElement;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement passChnage_ContinueBtnElement;
//=====================================================================

	public void EnterNewPassword(String NewPassword) {
		passChnage_PasswordElement.sendKeys(NewPassword);

	}

	public void EnterNewConfirmPassword(String NewCNFPassword) {
		passChnage_PasswordConfirm.sendKeys(NewCNFPassword);
	}

	public void ClickOnBack() {
		passChnage_BackBtnElement.click();
	}

	public void ClickOnContinue() {
		passChnage_ContinueBtnElement.click();
	}
}
