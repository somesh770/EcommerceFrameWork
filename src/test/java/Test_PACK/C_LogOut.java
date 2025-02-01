package Test_PACK;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base_pack.base;
import POM_PACK.A_Navigation_bar;
import POM_PACK.D_RHS_Menu_bar;
import POM_PACK.F_LoginPage;
import POM_PACK.L_AccountLogoutPage;
import POM_PACK.Rootpage;
import Utility_PACK.PropertyFileUtil;
import Utility_PACK.TakeScreenshotClass;

public class C_LogOut extends base {
	public WebDriver driver;
	static SoftAssert Softass = new SoftAssert();
	public static final Logger logger = LogManager.getLogger(C_LogOut.class);

	@BeforeMethod
	public void setup() {
		driver = setopenBrowserAndApplicationPageURL();
		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_nnavbarLoginbutton();
		loginPage = new F_LoginPage(driver);
		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();

	}

	@AfterMethod
	public void TearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.error("Test failed: " + result.getName());
			// Add screenshot capture code here
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info("Test passed: " + result.getName());
		}

		if (driver != null) {
			driver.quit();
			logger.info("Driver closed");
		}
	}

//=============================================================================================================	

	@Test(priority = 1)
	public void TC_LG_001_Verify_Logging_out_by_selecting_Logout_option_from_My_Account_dropmenu() {

		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.ClickLogoutMyAccount();
		ACLogoutPage = new L_AccountLogoutPage(driver);
		Softass.assertTrue(ACLogoutPage.Is_Disply_AccountLogoutText());
	}

//===========================================================================================
	@Test(priority = 2)
	public void TC_LG_002_Verify_Logging_out_by_selecting_Logout_option_from_Right_Column_options() {
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		RHS_Menu_bar.ClickOnLogOut_RHSMenu();
		ACLogoutPage = new L_AccountLogoutPage(driver);
		Softass.assertTrue(ACLogoutPage.Is_Disply_AccountLogoutText());
	}

//===========================================================================================
	@Test(priority = 3)
	public void TC_LG_003_Verify_the_Application_session_status_after_logging_and_closing_the_Browser_without_logging_out() {
		System.out.println("We cant automate this test case");
	}

//========================================================================================
	@Test(priority = 4)
	public void TC_LG_004_Verify_logging_out_and_browsing_back() {
		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.ClickLogoutMyAccount();
		rootpage = new Rootpage(driver);
		rootpage.NagigateToBack();
		rootpage.RefreshPage();

		navbarmenu.click_NavBara_MyAccountCTA();

		Softass.assertTrue(navbarmenu.NavBar_IsLogINOptionDisply());
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		Softass.assertAll();
	}

//=======================================================================================
	@Test(priority = 5)
	public void TC_LG_005_Verify_Logout_option_is_not_displayed_under_My_Account_menu_before_logging_in() {
		navbarmenu = new A_Navigation_bar(driver);
		ACLogoutPage = new L_AccountLogoutPage(driver);
		rootpage = new Rootpage(driver);

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.ClickLogoutMyAccount();
		ACLogoutPage.Click_On_ContinueBtn();
		navbarmenu.click_NavBara_MyAccountCTA();
		Softass.assertTrue(navbarmenu.NavBar_IsLogINOptionDisply());
		Softass.assertEquals(rootpage.GetPageTitle(), "Your Store");
		Softass.assertAll();
	}

//==========================================================================================
	@Test(priority = 6)
	public void TC_LG_006_Verify_Logout_option_is_not_displayed_under_Right_Column_options_before_logging_in() {
		navbarmenu = new A_Navigation_bar(driver);
		ACLogoutPage = new L_AccountLogoutPage(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.ClickLogoutMyAccount();

		Softass.assertTrue(RHS_Menu_bar.LogIN_RHSmenu_isDisplayed());
		Softass.assertAll();
	}

//=========================================================================
	@Test(priority = 7)
	public void TC_LG_007_Verify_logout_from_an_Account_from_a_single_place_after_logging_into_it_from_different_places() {
		System.out.println("We cant automate this test case");
	}

//============================================================================
	@Test(priority = 8)
	public void TC_LG_008_Verify_logging_out_and_logging_in_immediately_after_logout() {
		navbarmenu = new A_Navigation_bar(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.ClickLogoutMyAccount();

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_nnavbarLoginbutton();
		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();

		Softass.assertEquals(rootpage.GetPageTitle(), "My Account");
		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
		Softass.assertAll();

	}

//==============================================================================
	@Test(priority = 9)
	public void TC_LG_009_Verify_Account_Logout_page() {
		rootpage = new Rootpage(driver);
		navbarmenu = new A_Navigation_bar(driver);
		ACLogoutPage = new L_AccountLogoutPage(driver);

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.ClickLogoutMyAccount();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Logout");
		Softass.assertEquals(rootpage.GetCurrentURL(), PropertyFileUtil.getProperty("LogOutpageURL"));
		Softass.assertTrue(ACLogoutPage.IsLogOutDisplyOnBreadCrum());
		Softass.assertAll();
	}

//=================================================================================
	@Test(priority = 10)
	public void TC_LG_010_Verify_the_UI_of_the_Logout_option_and_the_Account_Logout_page() throws IOException {
		TakeScreenshotClass.takeScreenshot("Accouunt Logout page", driver);

	}
//============================================================================================
	@Test(priority = 11)
	public void TC_LG_011_Verify_the_Logout_functionality_in_all_the_supported_environments() {
		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.ClickLogoutMyAccount();
		ACLogoutPage = new L_AccountLogoutPage(driver);
		Softass.assertTrue(ACLogoutPage.Is_Disply_AccountLogoutText());

	}

}
