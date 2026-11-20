package automation_excercise_tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_excercise_base.BaseTest;
import automation_excercise_pages.LoginPage;
import automation_excercise_pages.ProductsPage;

public class ProductTest extends BaseTest{
	
	public LoginPage loginPage;
	public ProductsPage productsPage;
	
	@Test
    public void verifyProductsPageTest()
    {
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		productsPage.implicitWait();
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		productsPage.openProductSection();
		loginPage.closeAd();
		String pageTitle =driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals("Automation Exercise - All Products", pageTitle);
    }
	
	@Test
	public void verifyProductListTest()
	{
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		productsPage.implicitWait();
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		productsPage.openProductSection();
		loginPage.closeAd();
		int productsCount =productsPage.getSizeOfProducts();
		int visibleCount =productsPage.getVisibleCount();
		Assert.assertEquals(productsCount, visibleCount);
	}
	
	@Test
	public void verifyProductInformationTest()
	{
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		productsPage.implicitWait();
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		productsPage.openProductSection();
		loginPage.closeAd();
		productsPage.getProductDetails();
	}
	
	@Test
	public void verifyProductDetailsTest()
	{
		
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		productsPage.implicitWait();
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		productsPage.openProductSection();
		loginPage.closeAd();
		productsPage.openViewProduct();
		String pageTitle =driver.getTitle();
		Assert.assertEquals(pageTitle, "Automation Exercise - Product Details");
	}
	
	@Test
	public void verifyProductQuantityTest()
	{
		
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		productsPage.implicitWait();
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		productsPage.openProductSection();
		loginPage.closeAd();
		productsPage.openViewProduct();
		String actualQuantity =productsPage.elementToVisible();
		Assert.assertEquals(actualQuantity, "3");
	}
}
