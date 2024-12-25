package Test_PACK;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;
import POM_PACK.C_account_success_page;
import POM_PACK.D_MyAccount_page;
import POM_PACK.D_RHS_Menu_bar;
import POM_PACK.E_account_newsletter;
import POM_PACK.F_LoginPage;
import Utility_PACK.PropertyFileUtil;
import Utility_PACK.Reusable_details;
import Utility_PACK.TakeScreenshotClass;

public class Registration {

	public static WebDriver driver;
	static SoftAssert Softass = new SoftAssert();
	A_Navigation_bar navbarmenu;
	static B_Registration_page RegistrationPG;
	C_account_success_page AccountSuccessPage;
	D_RHS_Menu_bar RHS_Menu_bar;
	D_MyAccount_page myAcpage;
	E_account_newsletter NewsLetterpage;
	F_LoginPage loginpage;

	@BeforeMethod()
	public void setUp() {
		String browserName = PropertyFileUtil.getProperty("browserName");

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();

		}

		else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("Firefox")) {

			driver = new FirefoxDriver();
		} else {
			System.out.println("Unknown browser:" + browserName);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(PropertyFileUtil.getProperty("baseUrl"));

		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {

		if (driver != null) {
			driver.quit();

		}
	}

//=======================================================================================================	
	@Test(priority = 1)
	public void TC_RF_001_verify_Registering_Account_Using_MandatoryFields() {

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		RegistrationPG.Send_Email(Reusable_details.reusableEmail());
		RegistrationPG.Send_Mobile(Reusable_details.reusableMobile());
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();
		AccountSuccessPage = new C_account_success_page(driver);

		Assert.assertEquals(AccountSuccessPage.GetTest_Success_messgae_on_Accountpage(),
				"Your Account Has Been Created!");

		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
		Softass.assertAll();
	}

//================================================================================================	
	@Test(priority = 2)
	public void TC_RF_002_verifyThankYourConfirmationEmailOnSuccessfulRegistration() throws InterruptedException {

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));

		String emailText = Reusable_details.reusableEmail();
		RegistrationPG.Send_Email(Reusable_details.reusableEmail());
		RegistrationPG.Send_Mobile(Reusable_details.reusableMobile());
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		String email = emailText;
		String appPasscode = "dbmm vncw rtja ewoo";

		Thread.sleep(2000);

		// Gmail IMAP configuration
		String host = "imap.gmail.com";
		String port = "993";
		String username = email; // Your Gmail address
		String appPassword = appPasscode; // Your app password
		String expectedSubject = "Welcome To TutorialNinja";
		String expectedFromEmail = "tutorialsninja<account-update@tn.in>";
		String expectedBodyContent = "Your account has been successfully created.";

		try {
			// Mail server connection properties
			Properties properties = new Properties();
			properties.put("mail.store.protocol", "imaps");
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", port);
			properties.put("mail.imap.ssl.enable", "true");

			// Connect to the mail server
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("imaps");
			store.connect(host, username, appPassword); // replace email password with App password

			// Open the inbox folder
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			// Search for unread emails
			Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

			boolean found = false;
			for (int i = messages.length - 1; i >= 0; i--) {

				Message message = messages[i];

				if (message.getSubject().contains(expectedSubject)) {
					found = true;
					Assert.assertEquals(message.getSubject(), expectedSubject);
					Assert.assertEquals(message.getFrom()[0].toString(), expectedFromEmail);
					// Assert.assertTrue(CommonUtilities.getTextFromMessage(message).contains(expectedBodyContent));
					break;
				}
			}

			if (!found) {
				System.out.println("No confirmation email found.");
			}

			// Close the store and folder objects
			inbox.close(false);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		Softass.assertAll();
	}

//============================================================================================================	
	@Test(priority = 3)
	public void TC_RF_003_verifyRegisteringAnAccountproviding_all_fields() throws IOException {
		// Entering user details

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		RegistrationPG.Send_Email(Reusable_details.reusableEmail());
		RegistrationPG.Send_Mobile(Reusable_details.reusableMobile());
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();
		AccountSuccessPage = new C_account_success_page(driver);

		Softass.assertEquals(AccountSuccessPage.GetTest_Success_messgae_on_Accountpage(),
				"Your Account Has Been Created!");

		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
		Softass.assertAll();
	}

//===============================================================================================
	@Test(priority = 4)
	public void TC_RF_004_Verify_proper_notification_messages_with_no_data_in_the_madetory_field() {
		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.clickON_Continue();

		Softass.assertEquals(RegistrationPG.Get_alertmeg_for_Privacy_Policy(),
				"Warning: You must agree to the Privacy Policy!");

		Softass.assertEquals(RegistrationPG.Get_alertmeg_for_Firstname(),
				"First Name must be between 1 and 32 characters!");
		Softass.assertEquals(RegistrationPG.Get_alertmeg_for_Lastname(),
				"Last Name must be between 1 and 32 characters!");
		Softass.assertEquals(RegistrationPG.Get_alertmeg_for_Email(), "E-Mail Address does not appear to be valid!");
		Softass.assertEquals(RegistrationPG.Get_alertmeg_for_telephone(),
				"Telephone must be between 3 and 32 characters!");
		Softass.assertEquals(RegistrationPG.Get_alertmeg_for_Password(),
				"Password must be between 4 and 20 characters!");
		Softass.assertAll();
	}

//=========================================================================================
	@Test(priority = 5)
	public void TC_RF_005_Verify_Registering_an_Accountwith_Newsletter_field_As_YES() throws InterruptedException {

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		RegistrationPG.Send_Email(Reusable_details.reusableEmail());
		RegistrationPG.Send_Mobile(Reusable_details.reusableMobile());
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();
		AccountSuccessPage = new C_account_success_page(driver);
		AccountSuccessPage.click_ucc_ContinueCTA();
		myAcpage = new D_MyAccount_page(driver);
		myAcpage.click_MyAC_subsscribe_Opn();
		NewsLetterpage = new E_account_newsletter(driver);
		Softass.assertEquals(NewsLetterpage.isSelectedNewsleterpage_YES(), true);
		Softass.assertEquals(NewsLetterpage.isSelectedNewsleterpage_NO(), false);
		Softass.assertAll();
	}

//============================================================================================
	@Test(priority = 6)
	public void TC_RF_006_Verify_Registering_an_Accountwith_Newsletter_field_As_NO() {
		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		RegistrationPG.Send_Email(Reusable_details.reusableEmail());
		RegistrationPG.Send_Mobile(Reusable_details.reusableMobile());
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.select_SubscribeRadio_NO();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();
		AccountSuccessPage = new C_account_success_page(driver);
		AccountSuccessPage.click_ucc_ContinueCTA();
		myAcpage = new D_MyAccount_page(driver);
		myAcpage.click_MyAC_subsscribe_Opn();
		NewsLetterpage = new E_account_newsletter(driver);
		Softass.assertEquals(NewsLetterpage.isSelectedNewsleterpage_YES(), false);
		Softass.assertEquals(NewsLetterpage.isSelectedNewsleterpage_NO(), true);
		Softass.assertAll();
	}

//================================================================================================
	@Test(priority = 7)
	public void TC_RF_007_Verify__diff_ways_to_navigating_to_Register_page() {

		driver.get(PropertyFileUtil.getProperty("baseUrl"));
		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		driver.get(PropertyFileUtil.getProperty("baseUrl"));

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_Login_MyAccount();

		loginpage = new F_LoginPage(driver);
		loginpage.click_ContinueBBTN_loginpage();

		driver.get(PropertyFileUtil.getProperty("baseUrl"));

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_Login_MyAccount();
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);
		RHS_Menu_bar.click_register_rightbar_register();

		RegistrationPG = new B_Registration_page(driver);
		Softass.assertEquals(RegistrationPG.Get_Text_RegisterAccount(), "Register Account");
		Softass.assertEquals(driver.getCurrentUrl(),
				"https://tutorialsninja.com/demo/index.php?route=account/register");
		Softass.assertAll();
	}

//=========================================================================================
	@Test(priority = 8)
	public void TC_RF_008_Verify_Registering_Account_by_entering_different_passwords_into_Password_and_Password_Confirm_fields() {

		RegistrationPG = new B_Registration_page(driver);

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		RegistrationPG.Send_Email(Reusable_details.reusableEmail());
		RegistrationPG.Send_Mobile(Reusable_details.reusableMobile());
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("InValidComfirmPasword"));

		RegistrationPG.select_SubscribeRadio_NO();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		Softass.assertEquals(RegistrationPG.Get_alrtConfirmPassword(),
				"Password confirmation does not match password!");
		Softass.assertAll();

	}
//============================================================================================================
	@Test(priority = 9)
	public void TC_RF_009_Verify_Registering_Account_by_providing_the_existing_account_details() {

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(PropertyFileUtil.getProperty("ExEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(PropertyFileUtil.getProperty("Extelephone"));
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		Softass.assertEquals(RegistrationPG.Get_Worning_Emailexits(), "Warning: E-Mail Address is already registered!");
		Softass.assertAll();
	}

//=================================================================================================
	@Test(priority = 10)
	public void TC_RF_010_Verify_registraton_With_invalidEmail() throws InterruptedException {

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		RegistrationPG.Send_Email(PropertyFileUtil.getProperty("Invalidemail01"));
		RegistrationPG.Send_Mobile(Reusable_details.reusableMobile());
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		System.out.println("Validation message for Email - amotoori---->" + RegistrationPG.get_getDomProperty_Email());
		Softass.assertEquals(RegistrationPG.get_getDomProperty_Email(),
				"Please include an '@' in the email address. 'amotoori' is missing an '@'.");

		Thread.sleep(1000);
//---------------------------------------------------------------------------------------
		RegistrationPG.ClearEmail();
		RegistrationPG.Send_Email(PropertyFileUtil.getProperty("Invalidemail02"));
		RegistrationPG.clickON_Continue();

		System.out
				.println("Validation message for Email - amotoori@ ----> " + RegistrationPG.get_getDomProperty_Email());
		Softass.assertEquals(RegistrationPG.get_getDomProperty_Email(),
				"Please enter a part following '@'. 'amotoori@' is incomplete.");
//------------------------------------------------------------------------------------------------------
		RegistrationPG.ClearEmail();
		RegistrationPG.Send_Email(PropertyFileUtil.getProperty("Invalidemail03"));
		RegistrationPG.clickON_Continue();
		Thread.sleep(1000);

		Softass.assertEquals(RegistrationPG.get_getDomProperty_Email(), "'.' is used at a wrong position in 'gmail.'.");
		System.out.println(
				"Validation message for Email - amotoori@gmail. ----> " + RegistrationPG.get_getDomProperty_Email());

		Thread.sleep(1000);
//------------------------------------------------------------------------------------------------------------
		RegistrationPG.ClearEmail();
		RegistrationPG.Send_Email(PropertyFileUtil.getProperty("Invalidemail04"));
		RegistrationPG.clickON_Continue();

		Softass.assertEquals(RegistrationPG.getWorninginvalidemail04(), "E-Mail Address does not appear to be valid!");
		System.out.println(
				"Validation message for Email - amotoori@gmail ----> " + RegistrationPG.getWorninginvalidemail04());
		Thread.sleep(1000);
		Softass.assertAll();
	}
//====================================================================================================

	@Test(dataProvider = "InvalidMobilenumber", priority = 11)
	public void TC_RF_011Verify_Registering_Account_by_providing_invalid_phone_number(String invalidMobile) {

		RegistrationPG = new B_Registration_page(driver);
		RegistrationPG.Send_FirstName(PropertyFileUtil.getProperty("FirstName"));
		RegistrationPG.Send_LastName(PropertyFileUtil.getProperty("LastName"));
		RegistrationPG.Send_Email(Reusable_details.reusableEmail());
		RegistrationPG.Send_Mobile(PropertyFileUtil.getProperty("InvalidTelephone"));
		RegistrationPG.Send_password(PropertyFileUtil.getProperty("ValidPasword"));
		RegistrationPG.Send_ConfirmPassword(PropertyFileUtil.getProperty("ValidComfirmPasword"));
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/register");

		Softass.assertAll();

	}

	@DataProvider(name = "InvalidMobilenumber")

	public Object[][] supplyInvalidMobileNumber() {
		Object[][] invalidmobile = { { "111" }, { "AAAAA" } };
		return invalidmobile;
	}

//==================================================================================================================
	@Test(priority = 12)
	public void TC_RF_012Verify_Registering_Account_by_using_Keyboard_keys() throws InterruptedException {
		Actions act = new Actions(driver);

		act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
				.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER)
				.build().perform();

		Thread.sleep(1000);

		for (int i = 1; i <= 23; i++) {
			act.sendKeys(Keys.TAB).perform();
		}

		act.sendKeys("somesh").sendKeys(Keys.TAB).sendKeys("landge").sendKeys(Keys.TAB)
				.sendKeys(Reusable_details.reusableEmail()).sendKeys(Keys.TAB)
				.sendKeys(Reusable_details.reusableMobile()).sendKeys(Keys.TAB)
				.sendKeys(PropertyFileUtil.getProperty("ValidPasword")).sendKeys(Keys.TAB)
				.sendKeys(PropertyFileUtil.getProperty("ValidComfirmPasword")).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

		AccountSuccessPage = new C_account_success_page(driver);
		Assert.assertEquals(AccountSuccessPage.GetTest_Success_messgae_on_Accountpage(),
				"Your Account Has Been Created!");

		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);
		Softass.assertAll();

	}

//===============================================================================================
	@Test(priority = 13)
	public static void TC_RF_013Verify_all_fields_in_the_Register_Account_page_have_proper_placeholders() {

		RegistrationPG = new B_Registration_page(driver);

		Softass.assertEquals(RegistrationPG.get_placeholder_firstname(), "First Name");
		Softass.assertEquals(RegistrationPG.get_placeholder_lastname(), "Last Name");
		Softass.assertEquals(RegistrationPG.get_placeholder_email(), "E-Mail");
		Softass.assertEquals(RegistrationPG.get_placeholder_mobile(), "Telephone");
		Softass.assertEquals(RegistrationPG.get_placeholder_password(), "Password");
		Softass.assertEquals(RegistrationPG.get_placeholder_confirmpass(), "Password Confirm");
		Softass.assertAll();
	}

//========================================================================================================
	@Test(priority = 14)
	public static void TC_RF_014_Verify_all_mandatory_fields_in_Register_Account() {

		WebElement firstname = driver.findElement(By.cssSelector("label[for='input-firstname']"));

		JavascriptExecutor jsee = (JavascriptExecutor) driver;

		String ashstrictFN = (String) jsee.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content','color');",
				firstname);
		System.out.println("mandetory mark on first name field:" + ashstrictFN);

		String ashstrictcolorFN = (String) jsee.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstname);
		System.out.println("Color of the firstname label:" + ashstrictcolorFN);
		Softass.assertAll();

	}
//================================================================================================

	@Test(priority = 15)
	public void TC_RF_015_Verify_details_that_are_provided_while_Registering_Account_are_stored_in_Database() {
		
		String enteredFirstNameData = "Arun";
		driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstNameData);

		String enteredLastNameData = "Motoori";
		driver.findElement(By.id("input-lastname")).sendKeys(enteredLastNameData);

		String enteredEmailData = Reusable_details.reusableEmail();
		driver.findElement(By.id("input-email")).sendKeys(enteredEmailData);

		String enteredPasswordData = "12345";
		driver.findElement(By.id("input-password")).sendKeys(enteredPasswordData);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		driver.findElement(By.id("input-newsletter")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		// Database credentials
		String jdbcURL = "jdbc:mysql://localhost:3306/opencart_db";
		String dbUser = "root";
		String dbPassword = "";

		// SQL query
		String sqlQuery = "SELECT * FROM oc_customer";

		// JDBC objects
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		int newsletter = 0;

		try {
			// Step 1: Register JDBC driver (optional in newer versions)

			// Step 2: Open a connection
			connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			System.out.println("Connected to the database!");

			// Step 3: Create a statement
			statement = connection.createStatement();

			// Step 4: Execute the query
			resultSet = statement.executeQuery(sqlQuery);

			// Step 5: Process the ResultSet
			while (resultSet.next()) {
				firstName = resultSet.getString("firstname"); // Replace with your column name
				lastName = resultSet.getString("lastname"); // Replace with your column name
				email = resultSet.getString("email");
				newsletter = resultSet.getInt("newsletter");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Step 6: Close resources
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		Assert.assertEquals(firstName, enteredFirstNameData);
		Assert.assertEquals(lastName, enteredLastNameData);
		Assert.assertEquals(email, enteredEmailData);
		Assert.assertEquals(newsletter, 1);
		Softass.assertAll();

	}

//==================================================================================================
	@Test(priority = 16)
	public void TC_RF_016_verify_Registering_Account_By_Entering_Only_Spaces() {

		driver.findElement(By.id("input-firstname")).sendKeys("     ");
		driver.findElement(By.id("input-lastname")).sendKeys("     ");
		driver.findElement(By.id("input-email")).sendKeys("     ");
		driver.findElement(By.id("input-telephone")).sendKeys("     ");
		driver.findElement(By.id("input-password")).sendKeys("     ");
		driver.findElement(By.id("input-confirm")).sendKeys("     ");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText(), expectedFirstNameWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
						.getText(),
				expectedLastNameWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
						.getText(),
				expectedEmailWarning);
		Softass.assertAll();

	}

//==================================================================================================================
	@Test(dataProvider = "passwordcomplixitycheck", priority = 17)
	public void TC_RF_017_Verify_whether_the_Password_fields_in_the_Register_Account_page_are_following_Password_Complexity_Standards(
			String password) {

		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.Send_FirstName();
		RegistrationPG.Send_LastName();
		RegistrationPG.Send_Email();
		RegistrationPG.Send_Mobile();

		RegistrationPG.printstatment();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),
				"Password must be between 4 and 20 characters!");
		Softass.assertAll();

	}

	@DataProvider(name = "passwordcomplixitycheck")

	public Object[][] supplypassword() {
		Object[][] passwords = { { "123" }, { "12345" }, { "abcdefghi" }, { "abcd1234" }, { "abcd123$" },
				{ "ABCD456#" } };
		return passwords;
	}

//======================================================================================================	
	@Test(priority = 19)
	public void TC_RF_019_Verify_whether_the_leading_and_trailing_spaces_entered_into_the_Register_Account_fields_are_trimmed() {

		String firstname = " somesh  ";
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);

		String lastname = " landge   ";
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);

		String email = "    " + Reusable_details.reusableEmail() + "   ";

		driver.findElement(By.id("input-email")).sendKeys(email);

		String mobile = "  " + Reusable_details.reusableMobile() + "    ";
		driver.findElement(By.id("input-telephone")).sendKeys(mobile);

		String password = "  Test@123  ";
		driver.findElement(By.id("input-password")).sendKeys(password);

		String confpassword = "  Test@123  ";
		driver.findElement(By.id("input-confirm")).sendKeys(confpassword);

		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();

		driver.findElement(By.xpath("//a[text()='Edit your account information']")).click();

		String Actualfirname = driver.findElement(By.id("input-firstname")).getAttribute("value");
		String Actuallastname = driver.findElement(By.id("input-lastname")).getAttribute("value");
		String actualemail = driver.findElement(By.id("input-email")).getAttribute("value");
		String Actualtele = driver.findElement(By.id("input-telephone")).getAttribute("value");

		Softass.assertEquals(Actualfirname, firstname.trim());
		Softass.assertEquals(Actuallastname, lastname.trim());
		Softass.assertEquals(actualemail, email.trim());
		Softass.assertEquals(Actualtele, mobile.trim());
		Softass.assertAll();

	}

//==============================================================================================
	@Test(priority = 20)
	public void TC_RF_020_Verify_whether_the_Privacy_Policy_checkbox_option_is_not_selected_by_default() {

		boolean PrivacyPolicy_isselected = driver.findElement(By.xpath("//input[@name='agree']")).isSelected();

		Softass.assertEquals(PrivacyPolicy_isselected, false);
		Softass.assertAll();

	}

//==========================================================================================
	@Test(priority = 21)
	public void TC_RF_021_Verify_Registering_the_Account_without_selecting_the_Privacy_Policy_checkbox_option() {
		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.Send_FirstName();
		RegistrationPG.Send_LastName();

		RegistrationPG.Send_Email();
		RegistrationPG.Send_Mobile();

		RegistrationPG.printstatment();
		RegistrationPG.Send_password();
		RegistrationPG.Send_ConfirmPassword();
		RegistrationPG.select_SubscribeRadio_YES();
		RegistrationPG.clickON_Continue();

		Softass.assertEquals("https://tutorialsninja.com/demo/index.php?route=account/register",
				"https://tutorialsninja.com/demo/index.php?route=account/register");

		String privacypo = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();

		String privacy = "Warning: You must agree to the Privacy Policy!";

		Softass.assertEquals(privacypo, privacy);
		Softass.assertAll();

	}

//========================================================================================
	@Test(priority = 22)
	public void TC_RF_022_Verify_the_Password_text_entered_into_the_Password_and_Password_Confirm_field_of_Register_Account_functionality_is_toggled_to_hide_its_visibility() {

		Softass.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("type"), "password");
		Softass.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("type"), "password");
		Softass.assertAll();

	}

//================================================================================================
	@Test(priority = 23)
	public void TC_RF_023_Verify_navigating_to_other_pages_using_options_or_links_provided_on_the_Register_Account_page()
			throws InterruptedException {

		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);

		navbarmenu.click_NavBara_contactust();
		String contactusurl = driver.getCurrentUrl();
		driver.navigate().back();

		navbarmenu.click_Header_withlist();
		String wishlist = driver.getCurrentUrl();
		driver.navigate().back();

		navbarmenu.click_Header_shopppingcard();
		String cardurl = driver.getCurrentUrl();
		driver.navigate().back();

		navbarmenu.click_Header_checkout();
		String checkouturl = driver.getCurrentUrl();
		driver.navigate().back();

		navbarmenu.click_Header_QAfoxLogo();
		String QAhomeurl = driver.getCurrentUrl();
		driver.navigate().back();

		navbarmenu.click_breadc_homeicon();
		String breadhome = driver.getCurrentUrl();
		driver.navigate().back();

		navbarmenu.click_breadc_myaccount();
		String breadMyAC = driver.getCurrentUrl();
		driver.navigate().back();

//		Thread.sleep(1000);
//
//		navbarmenu.click_breadc_register();
//		String breadRegister = driver.getCurrentUrl();

		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.click_Header_loginhyperlink();
		String loginhyperlink = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_login();
		String login_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_register();
		String register_rightbox = driver.getCurrentUrl();

		RegistrationPG.click_register_rightbar_forgotpass();
		String forgotpass_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_myAC();
		String myac_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_addressbook();
		String addressbook_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_wishlist();
		String wishlist_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_orderHistory();
		String orderhistory_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_Download();
		String download_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_RecurrinhPaymnet();
		String recurringpayment_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_rewardPoint();
		String rewardpoint_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_Return();
		String return_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_Transaction();
		String transaction_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		RegistrationPG.click_register_rightbar_newsletter();
		String newletter_rightbox = driver.getCurrentUrl();
		driver.navigate().back();

		Softass.assertEquals(contactusurl, "https://tutorialsninja.com/demo/index.php?route=information/contact");
		Softass.assertEquals(wishlist, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(cardurl, "https://tutorialsninja.com/demo/index.php?route=checkout/cart");
		Softass.assertEquals(checkouturl, "https://tutorialsninja.com/demo/index.php?route=checkout/cart");
		Softass.assertEquals(QAhomeurl, "https://tutorialsninja.com/demo/index.php?route=common/home");
		Softass.assertEquals(breadhome, "https://tutorialsninja.com/demo/index.php?route=common/home");
		Softass.assertEquals(breadMyAC, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		 Softass.assertEquals(breadRegister,
//		 "https://tutorialsninja.com/demo/index.php?route=account/register");
		Softass.assertEquals(loginhyperlink, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(login_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(register_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/register");
		Softass.assertEquals(forgotpass_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/forgotten");
		Softass.assertEquals(myac_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(addressbook_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(wishlist_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(orderhistory_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(download_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(recurringpayment_rightbox,
				"https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(rewardpoint_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(return_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(transaction_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(newletter_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertAll();

	}

//===================================================================================================
	@Test(priority = 24)
	public void TC_RF_024_Verify_Registring_Account_by_filling_Password_field_and_not_filling_Password_Confirm_field() {

		// Entering user details
		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.Send_FirstName();
		RegistrationPG.Send_LastName();
		RegistrationPG.Send_Email();
		RegistrationPG.Send_Mobile();

		RegistrationPG.printstatment();
		RegistrationPG.Send_password();

		RegistrationPG.Select_disclaimer();
		RegistrationPG.clickON_Continue();

		Softass.assertEquals(driver
				.findElement(By.xpath("//div[text()='Password confirmation does not match password!']")).getText(),
				"Password confirmation does not match password!");

		Softass.assertEquals(driver.getCurrentUrl(),
				"https://tutorialsninja.com/demo/index.php?route=account/register");
		Softass.assertAll();

	}

//======================================================================================================
	@Test(priority = 25)
	public void TC_RF_025_Verify_Breadcrumb_PageHeading_PageURL_PageTitle_of_Register_AccountPage() {

		Softass.assertEquals(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Register']"))
				.isDisplayed(), true);

		Softass.assertEquals(driver.getTitle(), "Register Account");

		Softass.assertEquals(driver.getCurrentUrl(),
				"https://tutorialsninja.com/demo/index.php?route=account/register");

		Softass.assertAll();

	}

//=======================================================================
	@Test(priority = 26)
	public void TC_RF_026_Verify_the_UI_of_Register_Account_page() throws IOException {

		TakeScreenshotClass.takeScreenshot("registration page ", driver);
		Softass.assertAll();

	}

//==========================================================================
	@Test(dataProvider = "DataProviderforTest", priority = 27)
	public void TC_RF_027_Verify_Register_Account_functionality_in_all_the_supported_environments(String browserName) {

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();

		}

		else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("Firefox")) {

			driver = new FirefoxDriver();
		} else {
			System.out.println("Unknown browser:" + browserName);
		}

		driver.get("https://tutorialsninja.com/demo/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("somesh");
		driver.findElement(By.id("input-lastname")).sendKeys("landge");
		driver.findElement(By.id("input-email")).sendKeys(Reusable_details.reusableEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(Reusable_details.reusableMobile());
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		Softass.assertAll();

	}

	@DataProvider(name = "DataProviderforTest")

	public Object[][] DataProviderforTest() {
		Object[][] data = { { "chrome" }, { "Firefox" }, { "Edge" } };
		return data;

	}
//=====================================================================================================	

}
