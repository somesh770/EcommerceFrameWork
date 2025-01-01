package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class G_Account_EditPage {
	WebDriver driver;

	public G_Account_EditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
//===============================================================
	@FindBy(id="input-firstname")
	private WebElement EditFirstName;
	
	@FindBy(id="input-lastname")
	private WebElement EditLastName;
	
	@FindBy(id="input-email")
	private WebElement EditEmail;
	
	@FindBy(id="input-telephone")
	private WebElement EditMobile;
	
//=================================================================
	
	public String getFirstName_Editpg()
	{
		return EditFirstName.getAttribute("value");
	}
	
	public String getLastName_Editpg()
	{
		return EditLastName.getAttribute("value");
	}
	
	public String getEmail_Editpg()
	{
		return EditEmail.getAttribute("value");
	}
	
	public String getMobile_Editpg()
	{
		return EditMobile.getAttribute("value");
	}
	
}
