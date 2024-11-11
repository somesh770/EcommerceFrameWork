package Test_PACK;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class email_verification 
{
	@Test
	public void test()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("qasomesh001@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Test@123");
		driver.findElement(By.id("signInSubmit")).click();
		
	}

}
