package Test_PACK;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility_PACK.Reusable_details;

public class TC_RF_027 {

	WebDriver driver = null;

	@Test(dataProvider = "DataProviderforTest")
	public void Verify_Register_Account_functionality_in_all_the_supported_environments(String browserName) {

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();

		}

		else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("Firefox")) {

			driver = new FirefoxDriver();
		} else {
			System.out.println("Unknown browser:" + browserName);
		}

		driver.get("https://tutorialsninja.com/demo/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("somesh");
		driver.findElement(By.id("input-lastname")).sendKeys("landge");
		driver.findElement(By.id("input-email")).sendKeys(Reusable_details.reusableEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(Reusable_details.reusableMobile());
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

	}

	@AfterMethod
	public void tearDowon() {
		driver.quit();

	}

	@DataProvider(name = "DataProviderforTest")

	public Object[][] DataProviderforTest() {
		Object[][] data = { { "chrome" }, { "Edge" }, { "Firefox" } };
		return data;

	}

}
