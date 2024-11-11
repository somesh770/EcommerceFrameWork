package Temp_pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BHASKAR_LOGIN3 {
	
	@Test(invocationCount = 20)
	public void User03_email03_20hits() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.startupindia.gov.in/bhaskar");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Please enter your email address']"))
				.sendKeys("prodstartupfounder@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Please enter your password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//div[@class='styles_loginbtn__8y8bm']//button[contains(text(),'Login')]"))
				.click();
		Thread.sleep(2000);

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Complete Your Public Profile']")));

		// Perform any action on the element (e.g., clicking)
		System.out.println("Element found: " + element.getText());

		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);

		Assert.assertEquals(currenturl,
				"https://www.startupindia.gov.in/bhaskar/register/stepfour?role=StartupFounder&bhaskarid=IN-1024-9082CY");

		driver.quit();
	}


}
