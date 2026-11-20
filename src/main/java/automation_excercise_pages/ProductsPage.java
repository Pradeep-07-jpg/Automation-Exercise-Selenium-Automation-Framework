package automation_excercise_pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import automation_excercise_base.AbstractComponent;
import automation_excercise_base.BaseTest;
import automation_excercise_utilities.CartData;
import automation_excercise_utilities.JsonReader;
import automation_excercise_utilities.ProductData;

import org.testng.Assert;
public class ProductsPage extends AbstractComponent {
	
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	
	public ProductsPage(WebDriver driver) {
		super(driver);
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(css="div[class='productinfo text-center'] a[class='btn btn-default add-to-cart']")
	WebElement addtocartButton;
	
	@FindBy(xpath="//p[@class='text-center']//a")
	WebElement viewCartButton;
	
	@FindBy(css="input[type='number']")
	WebElement productQuantity;
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement productButton;
	
	@FindBy(xpath="//h2[normalize-space()='All Products']")
	WebElement text;
	
	@FindBy(css="div[class='single-products']")
	List<WebElement> totalProducts;
	
	@FindBy(xpath="//div[@class='single-products']/div/p")
	List<WebElement> productsName;
	
	@FindBy(xpath="//div[@class='single-products']/div/h2")
	List<WebElement> productsPrice;
	
	@FindBy(xpath="//a[normalize-space()='View Product']")
	WebElement viewProduct;
	
	@FindBy(id="search_product")
	WebElement searchBar;
	
	@FindBy(css="#submit_search")
	WebElement searchButton;
	
	
	public String grabText() {
		return text.getText();
	}
	
	public void implicitWait() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
	}
	
	public int getSizeOfProducts() {
	int	TotalProducts =totalProducts.size();
	return TotalProducts;
	}
	
	public int getVisibleCount() {
		int visibleCount = 0;

		for (WebElement product : totalProducts) {
		    if (product.isDisplayed()) {
		        visibleCount++;
		    }
		}
		return visibleCount;
	}
	
	public ArrayList<String> getProductText() {
		ArrayList<String> list = new ArrayList<String>();
		for(WebElement products : productsName)
		{
			String name=products.getText();
			list.add(name);
		}
		return list; 
	}
	
	public void getProductDetails() {
		
		for(int i=0; i<productsName.size(); i++)
		{
			String productName= productsName.get(i).getText();
			String productPrice =productsPrice.get(i).getText();
			Assert.assertFalse(productName.isEmpty(), "Product name is empty");
			Assert.assertFalse(productPrice.isEmpty(), "Product price is empty");
//			System.out.println(productName + " " +productPrice);
		}
	}
	
	public void openViewProduct() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		viewProduct.click();
		
	}
	
//	public void addProductQuantity()
//	{
//		productQuantity.sendKeys("3");
//	}
	
	public void searchBox(String productName) {
		
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.sendKeys(productName);
		searchButton.click();
	}
	
	public String searchBoxText() {
		return searchBar.getAttribute("value");
	}
	
	public List<String> getProductNameList()
	{
		return productsName.stream()
	            .map(WebElement::getText)
	            .map(String::trim)
	            .toList();
	}

	public void addProductFromJson() throws IOException 
	{
		JsonReader jsonReader = new JsonReader();

		CartData cartData = jsonReader.jsonToMap();
		
		List<ProductData> products =cartData.getProducts();
		for(int i=0; i<products.size(); i++)
		{
			searchBar.clear();
			String productName =products.get(i).getProductName();
			searchBar.sendKeys(productName);
			searchButton.click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scroll(0,500)");
			
			addtocartButton.click();
//			wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
//			continueShoppingButton.click();
//			wait.until(ExpectedConditions.invisibilityOf(continueShoppingButton));
		}
		wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
		viewCartButton.click();
	}
	
}
