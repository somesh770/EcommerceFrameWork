package Test_PACK;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_RF_012 extends Base_Class
{
	@Test
	public void Verify_Registering_Account_by_using_Keyboard_keys() throws InterruptedException
	{
		Actions act= new Actions(driver);
		
		act.sendKeys(Keys.TAB);
		act.sendKeys(Keys.TAB);
		act.sendKeys(Keys.TAB);
		
		
		act.sendKeys(Keys.ENTER);
		
		act.sendKeys(Keys.TAB);
		
		act.sendKeys(Keys.ENTER);
		
	Thread.sleep(4000);
		
	}

}
