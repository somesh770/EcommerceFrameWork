package Base_pack;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

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

public class base {

	public static WebDriver driver;
	String browserName;
	static SoftAssert Softass = new SoftAssert();
	public static final Logger logger = LogManager.getLogger(base.class);

	static A_Navigation_bar navbarmenu;
	static B_Registration_page RegistrationPG;
	static C_account_success_page AccountSuccessPage;
	static D_RHS_Menu_bar RHS_Menu_bar;
	static D_MyAccount_page myAcpage;
	static E_account_newsletter NewsLetterpage;
	static F_LoginPage loginpage;
	static G_Account_EditPage MyAC_Editpage;
	static Rootpage rootpage;


	public WebDriver setopenBrowserAndApplicationPageURL() {

		logger.info("Starting test execution");

		browserName = PropertyFileUtil.getProperty("browserName");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
		} else {
			System.out.println("Unknown browser:" + browserName);
		}

		logger.info("Driver initialized");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(PropertyFileUtil.getProperty("baseUrl"));
		
		return driver;

	}



}
