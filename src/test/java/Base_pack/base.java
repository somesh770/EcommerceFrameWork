package Base_pack;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;
import POM_PACK.C_account_success_page;
import POM_PACK.D_MyAccount_page;
import POM_PACK.D_RHS_Menu_bar;
import POM_PACK.E_account_newsletter;
import POM_PACK.F_LoginPage;
import POM_PACK.G_Account_EditPage;
import POM_PACK.I_SearchPage;
import POM_PACK.K_Change_Password_Page;
import POM_PACK.L_AccountLogoutPage;
import POM_PACK.Rootpage;
import Utility_PACK.PropertyFileUtil;

public class base {

	public static WebDriver driver;
	public static String browserName;
	static SoftAssert Softass = new SoftAssert();
	public static final Logger logger = LogManager.getLogger(base.class);

	public A_Navigation_bar navbarmenu;
	public static B_Registration_page RegistrationPG;
	public C_account_success_page AccountSuccessPage;
	public D_RHS_Menu_bar RHS_Menu_bar;
	public D_MyAccount_page myAcpage;
	public E_account_newsletter NewsLetterpage;
	public F_LoginPage loginpage;
	public G_Account_EditPage MyAC_Editpage;
	public Rootpage rootpage;
	public F_LoginPage loginPage;
	public Actions act;
	public K_Change_Password_Page ChangePasswordPage;
	public L_AccountLogoutPage ACLogoutPage;
	public I_SearchPage  SearchPage;

	public WebDriver setopenBrowserAndApplicationPageURL() {

		browserName = PropertyFileUtil.getProperty("browser");

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(PropertyFileUtil.getProperty("baseUrl"));

		return driver;

	}

}
