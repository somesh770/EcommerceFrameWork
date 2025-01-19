package Test_PACK;

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
import POM_PACK.B_Registration_page;
import POM_PACK.C_account_success_page;
import POM_PACK.D_MyAccount_page;
import POM_PACK.D_RHS_Menu_bar;
import POM_PACK.E_account_newsletter;
import POM_PACK.F_LoginPage;
import POM_PACK.G_Account_EditPage;
import POM_PACK.Rootpage;
import Utility_PACK.PropertyFileUtil;
import Utility_PACK.Reusable_details;

public class Login extends base {
	private WebDriver driver;
	static SoftAssert Softass = new SoftAssert();
	private static final Logger logger = LogManager.getLogger(Login.class);
	static A_Navigation_bar navbarmenu;
	static B_Registration_page RegistrationPG;
	static C_account_success_page AccountSuccessPage;
	static D_RHS_Menu_bar RHS_Menu_bar;
	static D_MyAccount_page myAcpage;
	static E_account_newsletter NewsLetterpage;
	static F_LoginPage loginpage;
	static G_Account_EditPage MyAC_Editpage;
	static Rootpage rootpage;
	static F_LoginPage loginPage;

	@BeforeMethod
	public void setup() {
		driver = setopenBrowserAndApplicationPageURL();
		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_nnavbarLoginbutton();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
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
		Softass.assertAll();

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
		Softass.assertAll();

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
		Softass.assertAll();
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
		Softass.assertAll();
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
		Softass.assertAll();

	}

//=========================================================================
	@Test(priority = 6)
	public void TC_LF_006_verifyForgottenPasswordOptionIsAvailable() {
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		Softass.assertEquals(loginPage.IsDisply_Forgotpassword(), true);
		loginPage.ClickOnForgotpassword();
		Softass.assertEquals(rootpage.GetPageTitle(), "Forgot Your Password?");
		Softass.assertAll();

	}

//========================================================================
	@Test(priority = 7)
	public void TC_LF_007_verifyLoggingIntoApplicationUsingKeyboardKeys() {

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
		Softass.assertAll();

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
		Softass.assertAll();

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
		Softass.assertAll();

	}

//===============================================================================
	@Test(priority = 12)
	public void TC_LF_12_verifyNumberOfUnsuccessfulLoginAttemps() {
		
		loginPage = new F_LoginPage(driver);
		
		loginPage.SendEmail_login(Reusable_details.reusableEmail());
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("mismatchingPassword"));
		loginPage.ClickOnLogin();

		Softass.assertEquals(loginPage.Login_GetAlert_InvalidEmail(),
				"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.");
		Softass.assertAll();
	}
//====================================================================================
	@Test(priority = 13)
	public void TC_LF_013VerifythetextintothePasswordfieldistoggledtohideitsvisibility() {
		loginPage = new F_LoginPage(driver);

		Softass.assertEquals(loginPage.GetDomAttribut_email(), "text");
		Softass.assertEquals(loginPage.GetDomAttribut_pasword(), "password");
		Softass.assertAll();
	}
//====================================================================================
	@Test(priority = 14)
	public void TC_LF_014_verifyCopyingOfTextEnteredIntoPasswordField() 
	{
		
	}
//========================================================================================	
}
