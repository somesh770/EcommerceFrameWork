package Test_PACK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_004 extends Base_Class
{
	@Test
	public void Verify_proper_notification_messages_with_no_data_in_the_madetory_field()
	{
		 // Navigating to Register
				A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
				navbarmenu.click_NavBara_MyAccountCTA();
				navbarmenu.click_NavBara_Register_MyAccount();
        
				B_Registration_page RegistrationPG = new B_Registration_page(driver);
				RegistrationPG.clickON_Continue();
        
        String alertmeg_for_Privacy_Policy = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        String EX_alertmeg_for_Privacy_Policy = "Warning: You must agree to the Privacy Policy!";
        System.out.println(alertmeg_for_Privacy_Policy);
                
        String alertmeg_for_Firstname = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
        String EX_alertmeg_for_Firstname = "First Name must be between 1 and 32 characters!";
        System.out.println(alertmeg_for_Firstname);
        
        String alertmeg_for_Lastname = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
        String EX_alertmeg_for_Lastname = "Last Name must be between 1 and 32 characters!";
        System.out.println(alertmeg_for_Lastname);
        
        String  alertmeg_for_Email= driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
        String EX_alertmeg_for_email = "E-Mail Address does not appear to be valid!";
        System.out.println(alertmeg_for_Email);
        
        String alertmeg_for_telephone = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
        String EX_alertmeg_for_telephone  = "Telephone must be between 3 and 32 characters!";
        System.out.println(alertmeg_for_telephone);
        
        String alertmeg_for_Password = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
        String EX_alertmeg_for_Password = "Password must be between 4 and 20 characters!";
        System.out.println(alertmeg_for_Password);
        
        Assert.assertEquals(EX_alertmeg_for_Privacy_Policy, alertmeg_for_Privacy_Policy);
        Assert.assertEquals(EX_alertmeg_for_Firstname, alertmeg_for_Firstname);
        Assert.assertEquals(EX_alertmeg_for_Lastname, alertmeg_for_Lastname);
        Assert.assertEquals(EX_alertmeg_for_email,alertmeg_for_Email );
        Assert.assertEquals(EX_alertmeg_for_telephone, alertmeg_for_telephone);
        Assert.assertEquals(EX_alertmeg_for_Password, alertmeg_for_Password );


	}
	
	
	
}
