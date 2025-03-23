package Test_PACK;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Base_pack.base;
import POM_PACK.A_Navigation_bar;
import POM_PACK.D_RHS_Menu_bar;
import POM_PACK.F_LoginPage;
import POM_PACK.I_SearchPage;

import POM_PACK.Rootpage;
import Utility_PACK.PropertyFileUtil;

public class D_Search extends base {
	public WebDriver driver;
	public static final Logger logger = LogManager.getLogger(C_LogOut.class);

	@BeforeMethod
	public void setup() {

		logger.info("Test Excecution Stated");
		driver = setopenBrowserAndApplicationPageURL();

		navbarmenu = new A_Navigation_bar(driver);
		SearchPage = new I_SearchPage(driver);
		loginPage = new F_LoginPage(driver);
		rootpage = new Rootpage(driver);
		RHS_Menu_bar = new D_RHS_Menu_bar(driver);

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

//==============================================================================
	@Test(priority = 1)
	public void TC_SF_001_Verify_searching_with_an_existing_Product_Name() {
		navbarmenu.SendKeysIn_searchbox(PropertyFileUtil.getProperty("ExistingProductNameOne"));
		navbarmenu.click_Header_searchbutto();
		SoftAssert Softass = new SoftAssert();
		Softass.assertTrue(SearchPage.Did_R_OnSearchPagw());
		Softass.assertTrue(SearchPage.IsProductDisplyedInSearchResult());
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 2)
	public void TC_SF_002_Verify_searching_with_a_non_existing_Product_Name() {
		navbarmenu.SendKeysIn_searchbox(PropertyFileUtil.getProperty("NonExistingProductName"));
		navbarmenu.click_Header_searchbutto();
		SoftAssert Softass = new SoftAssert();
		Softass.assertTrue(SearchPage.Did_R_OnSearchPagw());
		Softass.assertTrue(SearchPage.NoProductFoundText());
		Softass.assertEquals(SearchPage.Get_NoProductFoundText(),
				"There is no product that matches the search criteria.");
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 3)
	public void TC_SF_003_Verify_searching_without_providing_any_Product_Name() {
		navbarmenu.click_Header_searchbutto();
		SoftAssert Softass = new SoftAssert();
		Softass.assertTrue(SearchPage.Did_R_OnSearchPagw());
		Softass.assertTrue(SearchPage.NoProductFoundText());
		Softass.assertEquals(SearchPage.Get_NoProductFoundText(),
				"There is no product that matches the search criteria.");
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 4)
	public void TC_SF_004_Verify_searching_for_a_product_after_login_to_the_Application() {

		navbarmenu.click_NavBara_MyAccountCTA();
		navbarmenu.click_nnavbarLoginbutton();
		loginPage.SendEmail_login(PropertyFileUtil.getProperty("ExEmail"));
		loginPage.Sendlogin_password(PropertyFileUtil.getProperty("ValidPasword"));
		loginPage.ClickOnLogin();
		SoftAssert Softass = new SoftAssert();
		Softass.assertEquals(rootpage.GetPageTitle(), "My Account");
		Softass.assertEquals(RHS_Menu_bar.Logout_RHSmenu_isDisplayed(), true);

		navbarmenu.SendKeysIn_searchbox(PropertyFileUtil.getProperty("ExistingProductNameOne"));
		navbarmenu.click_Header_searchbutto();
		Softass.assertTrue(SearchPage.Did_R_OnSearchPagw());
		Softass.assertTrue(SearchPage.IsProductDisplyedInSearchResult());
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 5)
	public void TC_SF_005_Verify_searching_by_providing_a_search_criteria_which_results_in_multiple_products() {

		System.out.println("keeping this test on hold for now - looking for some diffeent solution");

	}

//========================================================================================
	@Test(priority = 6)
	public void TC_SF_006_Verify_all_fields_in_Search_functionality_and_Search_page_have_placeholders() {
		navbarmenu.click_Header_searchbutto();
		SoftAssert Softass = new SoftAssert();
		Softass.assertEquals(navbarmenu.GetPlaceholderForSearch(), "Search");
		Softass.assertEquals(SearchPage.GetPlaceholder_searchCriteria(), "Keywords");
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 7)
	public void TC_SF_007_Verify_searching_using_Search_Criteria_field() {
		navbarmenu.click_Header_searchbutto();
		SearchPage.SendKeywordIn_search_Crideria(PropertyFileUtil.getProperty("ExistingProductNameOne"));
		SearchPage.ClickOnSearchCriteriButton();
		SoftAssert Softass = new SoftAssert();
		Softass.assertTrue(SearchPage.IsProductDisplyedInSearchResult());
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 8)
	public void TC_SF_008_Verify_Search_using_text_from_product_description() {
		navbarmenu.click_Header_searchbutto();
		SearchPage.SendKeywordIn_search_Crideria(PropertyFileUtil.getProperty("textInProductDescription"));
		SearchPage.Check_description();
		SearchPage.ClickOnSearchCriteriButton();

		driver.findElement(By.xpath("//a[normalize-space()='iMac']")).click();
		String FirstProductDiscription = driver
				.findElement(By.xpath("//div[contains(text(),'Just when you thought iMac had everything, now the')]"))
				.getText();

		Assert.assertEquals(FirstProductDiscription.contains(PropertyFileUtil.getProperty("textInProductDescription")),
				true);
	}

//========================================================================================
	@Test(priority = 9)
	public void TC_SF_009_Verify_Search_by_selecting_category_of_product() {
		navbarmenu.click_Header_searchbutto();
		SearchPage.SendKeywordIn_search_Crideria(PropertyFileUtil.getProperty("ExistingProductNameTwo"));
		SearchPage.SelectOptionFrmCatagory_MAC();
		SearchPage.ClickOnSearchCriteriButton();

		SoftAssert Softass = new SoftAssert();
		Softass.assertTrue(SearchPage.isDisply_MAC());
		SearchPage.SelectOptionFrmCatagory_PC();
		SearchPage.ClickOnSearchCriteriButton();
		Softass.assertEquals(SearchPage.Get_NoProductFoundText(),
				"There is no product that matches the search criteria.");
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 10)
	public void TC_SF_010_Verify_Search_by_selecting_to_search_in_subcategories() {
		navbarmenu.click_Header_searchbutto();
		SearchPage.SendKeywordIn_search_Crideria(PropertyFileUtil.getProperty("ExistingProductNameTwo"));
		SearchPage.SelectParentCatagory_Desktop();
		SearchPage.ClickOnSearchCriteriButton();
		SoftAssert Softass = new SoftAssert();
		Softass.assertEquals(SearchPage.Get_NoProductFoundText(),
				"There is no product that matches the search criteria.");

		SearchPage.Check_SearchIn_Subcatagory();
		SearchPage.ClickOnSearchCriteriButton();
		Softass.assertTrue(SearchPage.isDisply_MAC());
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 11)
	public void TC_SF_011_Verify_List_and_Grid_views_when_only_one_Product_is_displayed_in_search_results()
			throws InterruptedException {
		SoftAssert Softass = new SoftAssert();
		navbarmenu.click_Header_searchbutto();
		SearchPage.SendKeywordIn_search_Crideria(PropertyFileUtil.getProperty("ExistingProductNameTwo"));
		SearchPage.ClickOnSearchCriteriButton();
		SearchPage.ClickListView();
		Softass.assertTrue(SearchPage.CheckNumberOfSearchResult() == 1);
		SearchPage.ClickOnAddToCard_SearchresultCards();
		Softass.assertEquals(SearchPage.SucessMessageOnSearchPage(), PropertyFileUtil.getProperty("NoLogin_AddTocard"));
		Thread.sleep(1000);
		SearchPage.ClickOnWishlist_SearchresultCards();
		Softass.assertEquals(SearchPage.SucessMessageOnSearchPage(), PropertyFileUtil.getProperty("NoLogin_Wishlist"));
		Thread.sleep(1000);
		SearchPage.ClickOnProductCompare_SearchresultCards();
		Softass.assertEquals(SearchPage.SucessMessageOnSearchPage(), PropertyFileUtil.getProperty("NoLogin_Compare"));
		Thread.sleep(1000);

		SearchPage.Click_iMAC();
		Softass.assertEquals(rootpage.GetCurrentURL(), PropertyFileUtil.getProperty("imacproductURL"));

//		rootpage.NagigateToBack();
//		SearchPage.ClickGridView();
//		Softass.assertTrue(SearchPage.CheckNumberOfSearchResult() == 1);
//		Softass.assertTrue(SearchPage.CheckNumberOfSearchResult() == 1);
//		SearchPage.ClickOnAddToCard_SearchresultCards();
//		Softass.assertEquals(SearchPage.SucessMessageOnSearchPage(), PropertyFileUtil.getProperty("NoLogin_AddTocard"));
//		SearchPage.ClickOnWishlist_SearchresultCards();
//		Softass.assertEquals(SearchPage.SucessMessageOnSearchPage(), PropertyFileUtil.getProperty("NoLogin_Wishlist"));
//		SearchPage.ClickOnProductCompare_SearchresultCards();
//		Softass.assertEquals(SearchPage.SucessMessageOnSearchPage(), PropertyFileUtil.getProperty("NoLogin_Compare"));
//		SearchPage.Click_iMAC();
//		Softass.assertEquals(rootpage.GetCurrentURL(), PropertyFileUtil.getProperty("imacproductURL"));
		Softass.assertAll();
	}

//========================================================================================
	@Test(priority = 12)
	public void TC_SF_012_Verify_List_and_Grid_views_when_multiple_Products_are_displayed_in_search_results() {

	}

//========================================================================================
	@Test(priority = 13)
	public void TC_SF_013_Verify_navigating_to_Product_Compare_Page_from_Search_Results_page() {

		navbarmenu.SendKeysIn_searchbox(PropertyFileUtil.getProperty("ExistingProductNameOne"));
		navbarmenu.click_Header_searchbutto();
		SearchPage.Click_on_CompareproductHyperlink();
		Assert.assertTrue(
				rootpage.GetCurrentURL().equals("https://tutorialsninja.com/demo/index.php?route=product/compare"));

	}

//========================================================================================
	@Test(priority = 14)
	public void TC_SF_014_Verify_User_is_able_to_sort_Products_displayed_in_Search_Results() {

	}

//========================================================================================
	@Test(priority = 15)
	public void TC_SF_015_Verify_User_can_select_how_many_products_can_be_displayed_in_Search_Results() {

	}

//========================================================================================
	@Test(priority = 16)
	public void TC_SF_016_Verify_Search_textbox_and_button_with_search_icon_are_displayed_on_all_pages() {

	}

//========================================================================================
	@Test(priority = 17)
	public void TC_SF_017_Verify_navigating_to_Search_page_from_Site_Map_page() {

	}

//========================================================================================
	@Test(priority = 18)
	public void TC_SF_018_Verify_Breadcrumb_of_Search_page() {

	}

//========================================================================================
	@Test(priority = 19)
	public void TC_SF_019_Verify_we_can_use_all_Search_options_using_Keyboard_keys() {

	}

//========================================================================================
	@Test(priority = 20)
	public void TC_SF_020_Verify_Page_Heading_Page_URL_and_Page_Title_of_Search_page() {

	}

//========================================================================================
	@Test(priority = 21)
	public void TC_SF_021_Verify_UI_of_Search_functionality_and_Search_page_options() {

	}

//========================================================================================
	@Test(priority = 22)
	public void TC_SF_022_Verify_Search_functionality_in_all_supported_environments() {

	}

}
