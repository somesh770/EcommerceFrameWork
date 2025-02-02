package Test_PACK;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base_pack.base;
import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;
import POM_PACK.D_MyAccount_page;
import POM_PACK.D_RHS_Menu_bar;
import POM_PACK.F_LoginPage;
import POM_PACK.K_Change_Password_Page;
import POM_PACK.Rootpage;
import Utility_PACK.PropertyFileUtil;
import Utility_PACK.Reusable_details;
import Utility_PACK.TakeScreenshotClass;

public class B_Login extends base {
	public WebDriver driver;
	static SoftAssert Softass = new SoftAssert();
	private static final Logger logger = LogManager.getLogger(B_Login.class);

	@BeforeMethod
	public void setup() {
		driver = setopenBrowserAndApplicationPageURL();
		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_nnavbarLoginbutton();
		//SoftAssert Softass = new SoftAssert();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.error("Test failed: " + result.getName());
			// Add screenshot capture code here
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info("Test passed: " + result.getName());
		}
		Softass.assertAll();

		if (driver != null) {
			driver.quit();
			logger.info("Driver closed");
		}

	}
//===========================================================================

	@Test(priority = 1)
	public void TC_LF_001_verifyLoggingIntoApplicationUsingValidCredentails() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();

		Softass.assertEquals(rootpage.GetPageTitle(), "My Account");
		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
	//	Softass.assertAll();

	}
//=============================================================================

	@Test(priority = 2)
	public void TC_LF_002_verifyLoggingIntoApplicationUsingInvalidCredentials() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);

		loginPage.SendEmail_login(Reusable_details.reusableEmail());
		loginPage.Sendlogin_password(Reusable_details.reusableMobile());
		loginPage.ClickOnLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		Softass.assertEquals(loginPage.Login_GetAlert_InvalidEmail(),
				"Warning: No match for E-Mail Address and/or Password.");
		//Softass.assertAll();

	}

//===================================================================================
	@Test(priority = 3)
	public void TC_LF_003_verifyLoggingIntoApplicationUsingInvalidEmailAndValidPassword() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);

		loginPage.SendEmail_login(Reusable_details.reusableEmail());
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		Softass.assertEquals(loginPage.Login_GetAlert_InvalidEmail(),
				"Warning: No match for E-Mail Address and/or Password.");
		//Softass.assertAll();
	}

//================================================================================
	@Test(priority = 4)
	public void TC_LF_004_verifyLoggingIntoApplicationUsingValidEmailAndInvalidPassword() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);

		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("Invalidpassword"));
		loginPage.ClickOnLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		Softass.assertEquals(loginPage.Login_GetAlert_InvalidEmail(),
				"Warning: No match for E-Mail Address and/or Password.");
		//Softass.assertAll();
	}

//===================================================================================
	@Test(priority = 5)
	public void TC_LF_005_verifyLoggingIntoApplicationWithoutProvidingAnyCredentials() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		loginPage.ClickOnLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		Softass.assertEquals(loginPage.Login_GetAlert_InvalidEmail(),
				"Warning: No match for E-Mail Address and/or Password.");
		//Softass.assertAll();

	}

//=========================================================================
	@Test(priority = 6)
	public void TC_LF_006_verifyForgottenPasswordOptionIsAvailable() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		Softass.assertEquals(loginPage.IsDisply_Forgotpassword(), true);
		loginPage.ClickOnForgotpassword();
		Softass.assertEquals(rootpage.GetPageTitle(), "Forgot Your Password?");
	//Softass.assertAll();

	}

//========================================================================
	@Test(priority = 7)
	public void TC_LF_007_verifyLoggingIntoApplicationUsingKeyboardKeys() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

		rootpage.ClickKeyoardKeyMultipleTimes(Keys.TAB, 23);
		rootpage.typeTextUsingActions(PropertyFileUtil.getProperty("ExEmail"));
		rootpage.ClickKeyoardKeyMultipleTimes(Keys.TAB, 1);
		rootpage.typeTextUsingActions(PropertyFileUtil.getProperty("ValidPasword"));
		rootpage.ClickKeyoardKeyMultipleTimes(Keys.TAB, 2);
		rootpage.ClickKeyoardKeyMultipleTimes(Keys.ENTER, 1);

		Softass.assertEquals(rootpage.GetPageTitle(), "My Account");
		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
		//Softass.assertAll();

	}

//=======================================================================
	@Test(priority = 8)
	public void TC_LF_008_verifyPlaceHoldersOfFieldsInLoginPage() {
		loginPage = new F_LoginPage(driver);
		Softass.assertEquals(loginPage.GetplacholderEmail(), "E-Mail Address");
		Softass.assertEquals(loginPage.GetplacholderPassword(), "Password");
	}

//=====================================================================================	
	@Test(priority = 9)
	public void TC_LF_009_verifyBrowsingBackAfterLogin() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();

		rootpage.NagigateToBack();
		rootpage.RefreshPage();
		Softass.assertEquals(rootpage.GetPageTitle(), "My Account");
		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
	//	Softass.assertAll();

	}

//===================================================================	
	@Test(priority = 10)
	public void TC_LF_10verifyBrowsingBackAfterLogout() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();
		RHS_Menu_bar.ClickOnLogOut_RHSMenu();
		rootpage.NagigateToBack();
		rootpage.RefreshPage();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		//Softass.assertAll();

	}

//========================================================================
	@Test(priority = 11)
	public void TC_LF_11_verifyLoggingIntoApplicationUsingInactiveCredentials() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		loginPage.SendEmail_login(PropertyFileUtil.getProperty("InactiveEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("PasswordInactiveAC"));
		loginPage.ClickOnLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		Softass.assertEquals(loginPage.Login_GetAlert_InvalidEmail(),
				"Warning: No match for E-Mail Address and/or Password.");
	//	Softass.assertAll();

	}

//===============================================================================
	@Test(priority = 12)
	public void TC_LF_12_verify_Number_Of_Unsuccessful_Login_Attemps() {

		loginPage = new F_LoginPage(driver);

		loginPage.SendEmail_login(Reusable_details.reusableEmail());
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("mismatchingPassword"));
		loginPage.ClickOnLogin();

		Assert.assertEquals(loginPage.Login_GetAlert_InvalidEmail(),
				"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.");

	}

//====================================================================================
	@Test(priority = 13)
	public void TC_LF_013Verify_text_into_Password_field_is_toggled_to_hide_it_svisibility() {
		loginPage = new F_LoginPage(driver);

		Softass.assertEquals(loginPage.GetDomAttribut_email(), "text");
		Softass.assertEquals(loginPage.GetDomAttribut_pasword(), "password");
	//	Softass.assertAll();
	}

//====================================================================================
	@Test(priority = 14)
	public void TC_LF_014_verifyCopyingOfTextEnteredIntoPasswordField() throws InterruptedException {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnPasswordBox();
		Thread.sleep(1000);
		rootpage.CopyTextWithActionClass();
		Thread.sleep(1000);
		loginPage.ClickOnEmailBox();
		rootpage.PastCopiedtext();

	}
//========================================================================================	

	@Test(priority = 15)
	public void TC_LF_015_Verify_the_Password_is_not_visible_in_the_Page_Source() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);

		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();
		Assert.assertFalse(rootpage.GetPageSourceCode().contains(PropertyFileUtil.getProperty("ValidPasword")));
	}

//=======================================================================
	@Test(priority = 16)
	public void TC_LF_016_Verify_Logging_into_the_Application_after_changing_the_password() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		ChangePasswordPage = new K_Change_Password_Page(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		navbarmenu = new A_Navigation_bar(driver);
		myAcpage = new D_MyAccount_page(driver);

		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();
		myAcpage.click_MyAC_Change_your_password();
		ChangePasswordPage.EnterNewPassword(PropertyFileUtil.getProperty("ValidPasword"));
		ChangePasswordPage.EnterNewConfirmPassword(PropertyFileUtil.getProperty("ValidPasword"));
		ChangePasswordPage.ClickOnContinue();

		Softass.assertEquals(myAcpage.Get_myAC_alertMessageElement(),
				"Success: Your password has been successfully updated.");

		RHS_Menu_bar.ClickOnLogOut_RHSMenu();
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_nnavbarLoginbutton();
		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "My Account");
		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
		//Softass.assertAll();

	}

//================================================================================
	@Test(priority = 17)
	public void TC_LF_017_Verify_user_is_able_to_navigate_to_different_pages_from_Login_page()
			throws InterruptedException {
		loginPage = new F_LoginPage(driver);
		navbarmenu = new A_Navigation_bar(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		RegistrationPG = new B_Registration_page(driver);

		navbarmenu.click_NavBara_contactust();
		Softass.assertEquals(rootpage.GetPageTitle(), "Contact Us");
		rootpage.NagigateToBack();

		navbarmenu.click_Header_withlist();
		String wishlist = rootpage.GetCurrentURL();
		Softass.assertEquals(wishlist, PropertyFileUtil.getProperty("wishlistlink"));
		rootpage.NagigateToBack();

		navbarmenu.click_Header_shopppingcard();
		Softass.assertEquals(rootpage.GetPageTitle(), "Shopping Cart");
		rootpage.NagigateToBack();

		navbarmenu.click_Header_checkout();
		Softass.assertEquals(rootpage.GetPageTitle(), "Shopping Cart");
		rootpage.NagigateToBack();

		navbarmenu.click_Header_QAfoxLogo();
		Softass.assertEquals(rootpage.GetPageTitle(), "Your Store");
		rootpage.NagigateToBack();

		navbarmenu.click_Header_searchbutto();
		Thread.sleep(2000);
		Softass.assertEquals(rootpage.GetPageTitle(), "Search");
		rootpage.NagigateToBack();

		navbarmenu.Waitclick_breadc_homeicon();
		navbarmenu.click_breadc_homeicon();
		Softass.assertEquals(rootpage.GetPageTitle(), "Your Store");
		rootpage.NagigateToBack();

		navbarmenu.Waitclick_breadc_myaccount();
		navbarmenu.click_breadc_myaccount();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		rootpage.NagigateToBack();

		loginPage.CliCkBreadCrume_Login();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_login_withoutLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_register();
		Softass.assertEquals(rootpage.GetPageTitle(), "Register Account");
		rootpage.NagigateToBack();

		RHS_Menu_bar.click_register_rightbar_forgotpass();
		Softass.assertEquals(rootpage.GetPageTitle(), "Forgot Your Password?");
		rootpage.NagigateToBack();

		RHS_Menu_bar.click_register_rightbar_myAC();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_addressbook();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_wishlist();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_orderHistory();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_Download();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_RecurrinhPaymnet();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_rewardPoint();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_Return();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_Transaction();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_newsletter();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

	//	Softass.assertAll();

	}

//=====================================================================================	
	@Test(priority = 18)
	public void TC_LF_018_Verify_the_different_ways_of_navigating_to_the_Login_page() {
		loginPage = new F_LoginPage(driver);
		RegistrationPG = new B_Registration_page(driver);
		navbarmenu = new A_Navigation_bar(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		rootpage = new Rootpage(driver);

		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();
		RegistrationPG.click_Header_loginhyperlink();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		RHS_Menu_bar.click_register_rightbar_login_withoutLogin();
		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");

		//Softass.assertAll();

	}

//====================================================================================================
	@Test(priority = 19)
	public void TC_LF_019_Verify_the_Breakcrumb_Page_Heading_Page_Title_and_Page_URL_of_Login_page() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);

		Softass.assertEquals(rootpage.GetPageTitle(), "Account Login");
		Softass.assertEquals(rootpage.GetCurrentURL(), PropertyFileUtil.getProperty("loginrightbox"));

		Softass.assertEquals(loginPage.Get_headingNew_Customer(), "New Customer");
		Softass.assertEquals(loginPage.Get_headingReturninCustomer(), "Returning Customer");

	//	Softass.assertAll();
	}

//=========================================================================================
	@Test(priority = 20)
	public void TC_LF_20_Verify_the_UI_of_the_Login_page() throws IOException {
		TakeScreenshotClass.takeScreenshot("Login Page", driver);
	}

//==============================================================================================
	@Test(priority = 21)
	public void TC_LF_21_Verify_the_Login_page_functionality_in_all_the_supported_environments() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();

		Softass.assertEquals(rootpage.GetPageTitle(), "My Account");
		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
	//	Softass.assertAll();
	}
}
