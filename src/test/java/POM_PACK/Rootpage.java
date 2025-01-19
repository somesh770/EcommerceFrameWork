package POM_PACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Rootpage {
	WebDriver driver;

	public Rootpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String GetPageTitle() {
		return driver.getTitle();
	}

	public String GetCurrentURL() {

		return driver.getCurrentUrl();
	}
	
	public void  NagigateToBack() {

		 driver.navigate().back();
	}
	
	public void  RefreshPage() {

		 driver.navigate().refresh();
	}
	
	
	

}
