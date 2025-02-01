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
import Utility_PACK.PropertyFileUtil;


public class D_Search extends base
{
	public WebDriver driver;
	static SoftAssert Softass = new SoftAssert();
	public static final Logger logger = LogManager.getLogger(C_LogOut.class);

	@BeforeMethod
	public void setup() {
		driver = setopenBrowserAndApplicationPageURL();

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
	public void TC_SF_001_Verify_searching_with_an_existing_Product_Name()
	{
		navbarmenu = new A_Navigation_bar(driver);
		navbarmenu.SendKeysIn_searchbox(PropertyFileUtil.getProperty("ExistingProductName"));
		navbarmenu.click_Header_searchbutto();
				
	    
	}
//========================================================================================
	@Test(priority = 2)
	public void TC_SF_002_Verify_searching_with_a_non_existing_Product_Name()
	{
	    
	}
//========================================================================================
	@Test(priority = 3)
	public void TC_SF_003_Verify_searching_without_providing_any_Product_Name()
	{
	    
	}
//========================================================================================
	@Test(priority = 4)
	public void TC_SF_004_Verify_searching_for_a_product_after_login_to_the_Application()
	{
	    
	}
//========================================================================================
	@Test(priority = 5)
	public void TC_SF_005_Verify_searching_by_providing_a_search_criteria_which_results_in_multiple_products()
	{
	    
	}
//========================================================================================
	@Test(priority = 6)
	public void TC_SF_006_Verify_all_fields_in_Search_functionality_and_Search_page_have_placeholders()
	{
	    
	}
//========================================================================================
	@Test(priority = 7)
	public void TC_SF_007_Verify_searching_using_Search_Criteria_field()
	{
	    
	}
//========================================================================================
	@Test(priority = 8)
	public void TC_SF_008_Verify_Search_using_text_from_product_description()
	{
	    
	}
//========================================================================================
	@Test(priority = 9)
	public void TC_SF_009_Verify_Search_by_selecting_category_of_product()
	{
	    
	}
//========================================================================================
	@Test(priority = 10)
	public void TC_SF_010_Verify_Search_by_selecting_to_search_in_subcategories()
	{
	    
	}
//========================================================================================
	@Test(priority = 11)
	public void TC_SF_011_Verify_List_and_Grid_views_when_only_one_Product_is_displayed_in_search_results()
	{
	    
	}
//========================================================================================
	@Test(priority = 12)
	public void TC_SF_012_Verify_List_and_Grid_views_when_multiple_Products_are_displayed_in_search_results()
	{
	    
	}
//========================================================================================
	@Test(priority = 13)
	public void TC_SF_013_Verify_navigating_to_Product_Compare_Page_from_Search_Results_page()
	{
	    
	}
//========================================================================================
	@Test(priority = 14)
	public void TC_SF_014_Verify_User_is_able_to_sort_Products_displayed_in_Search_Results()
	{
	    
	}
//========================================================================================
	@Test(priority = 15)
	public void TC_SF_015_Verify_User_can_select_how_many_products_can_be_displayed_in_Search_Results()
	{
	    
	}
//========================================================================================
	@Test(priority = 16)
	public void TC_SF_016_Verify_Search_textbox_and_button_with_search_icon_are_displayed_on_all_pages()
	{
	    
	}
//========================================================================================
	@Test(priority = 17)
	public void TC_SF_017_Verify_navigating_to_Search_page_from_Site_Map_page()
	{
	    
	}
//========================================================================================
	@Test(priority = 18)
	public void TC_SF_018_Verify_Breadcrumb_of_Search_page()
	{
	    
	}
//========================================================================================
	@Test(priority = 19)
	public void TC_SF_019_Verify_we_can_use_all_Search_options_using_Keyboard_keys()
	{
	    
	}
//========================================================================================
	@Test(priority = 20)
	public void TC_SF_020_Verify_Page_Heading_Page_URL_and_Page_Title_of_Search_page()
	{
	    
	}
//========================================================================================
	@Test(priority = 21)
	public void TC_SF_021_Verify_UI_of_Search_functionality_and_Search_page_options()
	{
	    
	}
//========================================================================================
	@Test(priority = 22)
	public void TC_SF_022_Verify_Search_functionality_in_all_supported_environments()
	{
	    
	}


}
