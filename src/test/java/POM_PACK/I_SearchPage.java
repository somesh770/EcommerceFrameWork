package POM_PACK;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class I_SearchPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public I_SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Initialize WebDriverWa
	}

//==============================================================================

	@FindBy(xpath = "//a[normalize-space()='Search']")
	private WebElement breadCrum_SearchPgElement;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noResultFoundtextElement;

	@FindBy(linkText = "HP LP3065")
	private WebElement existingProductOnElement;

	@FindBy(xpath = "//body/div[@id='product-search']/div[@class='row']/div[@id='content']/div[1]/div[1]")
	private WebElement ProductThumbnail;

	@FindBy(id = "input-search")
	private WebElement SearchCriteriBox;

	@FindBy(id = "button-search")
	private WebElement SearchCriteriButton;

	@FindBy(id = "description")
	private WebElement descriptionCheckBoxElement;

	@FindBy(xpath = "//select[@name='category_id']")
	private WebElement catagoryDropDown;

	@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'iMac')]")
	private WebElement iMacSearchResultElement;

	@FindBy(xpath = "//input[@name='sub_category']")
	private WebElement subcategoeryCheckBoxElement;

	@FindBy(xpath = "//i[@class='fa fa-th-list']")
	private WebElement list_view;

	@FindBy(xpath = "//i[@class='fa fa-th']")
	private WebElement grid_view;

	@FindBy(xpath = "//div[@class='product-layout product-list col-xs-12']")
	private List<WebElement> numberOfResult;

	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement Searchcard_AddToCardOption;

	@FindBy(xpath = "//button[@*='Add to Wish List']")
	private WebElement SearchCardAddToWishlist;

	@FindBy(xpath = "//button[@*='Compare this Product']")
	private WebElement SearchCard_CompareProduct;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessgae_searchpag;

	@FindBy(id = "compare-total")
	private WebElement compareHyperLink;
//=======================================================================
	public void Click_on_CompareproductHyperlink() {
		compareHyperLink.click();
	}	
	
	public void ClickOnAddToCard_SearchresultCards() {
		wait.until(ExpectedConditions.elementToBeClickable(Searchcard_AddToCardOption));
		Searchcard_AddToCardOption.click();
	}

	public void ClickOnWishlist_SearchresultCards() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchCardAddToWishlist));
		SearchCardAddToWishlist.click();
	}

	public void ClickOnProductCompare_SearchresultCards() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchCard_CompareProduct));
		SearchCard_CompareProduct.click();
	}

	public String SucessMessageOnSearchPage() {
		return successMessgae_searchpag.getText();
	}

	public int CheckNumberOfSearchResult() {
		return Rootpage.GetElementCount(numberOfResult);
	}

	public void ClickListView() {
		list_view.click();
	}

	public void ClickGridView() {
		grid_view.click();
	}

	public void Check_SearchIn_Subcatagory() {
		subcategoeryCheckBoxElement.click();
	}

	public boolean isDisply_MAC() {
		return iMacSearchResultElement.isDisplayed();
	}

	public void Click_iMAC() {
		iMacSearchResultElement.click();
	}

	public void SelectOptionFrmCatagory_MAC() {
		Select select = new Select(catagoryDropDown);
		select.selectByIndex(3);
	}

	public void SelectOptionFrmCatagory_PC() {
		Select select = new Select(catagoryDropDown);
		select.selectByIndex(2);

	}

	public void SelectParentCatagory_Desktop() {
		Select select = new Select(catagoryDropDown);
		select.selectByIndex(1);

	}

	public boolean Did_R_OnSearchPagw() {

		return breadCrum_SearchPgElement.isDisplayed();
	}

	public boolean NoProductFoundText() {
		return noResultFoundtextElement.isDisplayed();

	}

	public String Get_NoProductFoundText() {
		return noResultFoundtextElement.getText();

	}

	public boolean IsProductDisplyedInSearchResult() {
		return existingProductOnElement.isDisplayed();
	}

//	public void GetSearchResultCount() {
//		ProductThumbnail.clear();
//	}

	public String GetPlaceholder_searchCriteria() {
		return SearchCriteriBox.getDomProperty("placeholder");
	}

	public void SendKeywordIn_search_Crideria(String Searchkey) {
		SearchCriteriBox.sendKeys(Searchkey);

	}

	public void ClickOnSearchCriteriButton() {
		SearchCriteriButton.click();

	}

	public void Check_description() {
		descriptionCheckBoxElement.click();
	}

}
