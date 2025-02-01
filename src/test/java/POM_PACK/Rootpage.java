package POM_PACK;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import Base_pack.base;

public class Rootpage extends base {
	WebDriver driver;

	public Rootpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		this.act = new Actions(driver);
	}

	public String GetPageTitle() {
		return driver.getTitle();
	}

	public String GetCurrentURL() {

		return driver.getCurrentUrl();
	}

	public void NagigateToBack() {

		driver.navigate().back();
	}

	public void RefreshPage() {

		driver.navigate().refresh();
	}

	public Actions ClickKeyoardKeyMultipleTimes(Keys NameKeys, int NoOfClick) {
		for (int i = 1; i <= NoOfClick; i++) {
			act.sendKeys(NameKeys).perform();
		}
		return act;
	}

	public Actions typeTextUsingActions(String text) {
		act.sendKeys(text).perform();
		return act;
	}

	public String GetPageSourceCode() {
		return driver.getPageSource();
	}

	public void CopyTextWithActionClass() {

		act.keyDown(Keys.CONTROL) // Press Ctrl
				.sendKeys("a") // Select all text (Ctrl+A)
				.sendKeys("c") // Copy text (Ctrl+C)
				.keyUp(Keys.CONTROL) // Release Ctrl
				.build().perform();

	}

	public void PastCopiedtext() {
		act.keyDown(Keys.CONTROL) // Press Ctrl
				.sendKeys("v") // Paste text (Ctrl+V)
				.keyUp(Keys.CONTROL) // Release Ctrl
				.build().perform();
	}

}
