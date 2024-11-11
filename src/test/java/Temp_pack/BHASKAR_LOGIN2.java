package Temp_pack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BHASKAR_LOGIN2 {

	@Test(invocationCount = 20)
	public void User02_email02_20hits() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.startupindia.gov.in/bhaskar");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Please enter your email address']"))
				.sendKeys("aaaza@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Please enter your password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//div[@class='styles_loginbtn__8y8bm']//button[contains(text(),'Login')]"))
				.click();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='IN-1124-9095JB']")));

		// Perform any action on the element (e.g., clicking)
		System.out.println("Element found: " + element.getText());

		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);

		Assert.assertEquals(currenturl, "https://www.startupindia.gov.in/bhaskar/profile");

		driver.quit();
	}

}
