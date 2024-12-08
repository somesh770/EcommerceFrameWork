package Test_PACK;

import org.testng.annotations.Test;

import POM_PACK.A_Navigation_bar;
import POM_PACK.B_Registration_page;

public class TC_RF_023 extends Base_Class {
	@Test
	public void Verify_navigating_to_other_pages_using_options_or_links_provided_on_the_Register_Account_page() {

		A_Navigation_bar navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_NavBara_Register_MyAccount();

		navbarmenu.click_NavBara_contactust();
		String contactusurl = driver.getCurrentUrl();
		driver.navigate().back();

		navbarmenu.click_NavBara_MyAccountCTA();
		String Myacurl = driver.getCurrentUrl();
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

//		navbarmenu.click_breadc_homeicon();
//		String breadhome = driver.getCurrentUrl();
//		driver.navigate().back();

//		navbarmenu.click_breadc_myaccount();
//		String breadMyAC = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		navbarmenu.click_breadc_register();
//		String breadRegister = driver.getCurrentUrl();
//		driver.navigate().back();

		B_Registration_page RegistrationPG = new B_Registration_page(driver);

		RegistrationPG.click_Header_loginhyperlink();
		String loginhyperlink = driver.getCurrentUrl();
		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_login();
//		String login_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_register();
//		String register_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_forgotpass();
//		String forgotpass_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_myAC();
//		String myac_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_addressbook();
//		String addressbook_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_wishlist();
//		String wishlist_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_orderHistory();
//		String orderhistory_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_Download();
//		String download_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_RecurrinhPaymnet();
//		String recurringpayment_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_rewardPoint();
//		String rewardpoint_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_Return();
//		String return_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_Transaction();
//		String transaction_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();
//
//		RegistrationPG.click_register_rightbar_newsletter();
//		String newletter_rightbox = driver.getCurrentUrl();
//		driver.navigate().back();

		Softass.assertEquals(contactusurl, "https://tutorialsninja.com/demo/index.php?route=information/contact");
		Softass.assertEquals(Myacurl, "https://tutorialsninja.com/demo/index.php?route=account/login");
		Softass.assertEquals(cardurl, "https://tutorialsninja.com/demo/index.php?route=checkout/cart");
		Softass.assertEquals(checkouturl, "https://tutorialsninja.com/demo/index.php?route=checkout/cart");
		Softass.assertEquals(QAhomeurl, "https://tutorialsninja.com/demo/index.php?route=common/home");
	//	Softass.assertEquals(breadhome, "https://tutorialsninja.com/demo/index.php?route=common/home");
		// Softass.assertEquals(breadMyAC,
		// "https://tutorialsninja.com/demo/index.php?route=account/login");
		// Softass.assertEquals(breadRegister,
		// "https://tutorialsninja.com/demo/index.php?route=account/register");
		Softass.assertEquals(loginhyperlink, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(login_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(register_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/register");
//		Softass.assertEquals(forgotpass_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/forgotten");
//		Softass.assertEquals(myac_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(addressbook_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(wishlist_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(orderhistory_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(download_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(recurringpayment_rightbox,
//				"https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(rewardpoint_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(return_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(transaction_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");
//		Softass.assertEquals(newletter_rightbox, "https://tutorialsninja.com/demo/index.php?route=account/login");

	}
}
