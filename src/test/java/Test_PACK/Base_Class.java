package Test_PACK;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Base_Class {
	
	WebDriver driver;
	
	
	@AfterClass
	public void Afterclassmethod()
	{
		if (driver != null){
		driver.quit();
		}
	}
	
	

}
