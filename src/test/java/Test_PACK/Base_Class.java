package Test_PACK;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class Base_Class {
	static WebDriver driver;
	
	SoftAssert Softass = new SoftAssert();
	
	 @BeforeMethod
	    public void setUp() {
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://tutorialsninja.com/demo/");
	    }

	 
	 
	 @AfterMethod
	    public void tearDown() throws InterruptedException {
	        // Close the browser after the test
		 Thread.sleep(1000);
		// Softass.assertAll();
	        if (driver != null) {
	        	
	            driver.quit();
	            Softass.assertAll();
	        }
	    }

}
