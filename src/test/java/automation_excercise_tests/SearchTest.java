package automation_excercise_tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation_excercise_base.BaseTest;
import automation_excercise_pages.LoginPage;
import automation_excercise_pages.ProductsPage;
import automation_excercise_pages.SignUpPage;
import automation_excercise_utilities.ExcelReader;

public class SearchTest extends BaseTest {

	public LoginPage loginPage;
	public ProductsPage productsPage;
	public SignUpPage signUpPage;
	
	@Test
	public void verifySearchFunctionalityTest()
	{
		getSearchMethod();
		productsPage.searchBox("Premium Polo");
		String Text =productsPage.searchBoxText();
		Assert.assertEquals(Text, "Premium Polo");
	}
	
	@Test
	public void verifySearchResultsTest()
	{
		getSearchMethod();
		productsPage.searchBox("Blue");
		List<String> productNames =productsPage.getProductNameList();
		Assert.assertTrue(
			    productNames.stream().anyMatch(name -> name.contains("GRAPHIC DESIGN MEN T SHIRT"))
			);
	}
	
	@Test
	public void verifyNoSearchResultsTest() 
	{
		getSearchMethod();
		productsPage.searchBox("BlueBerry");
		List<String> productNames =productsPage.getProductNameList();
		Assert.assertTrue(productNames.isEmpty());
	}
	
	@Test
	public void verifySearchResultsRelevanceTest()
	{
		getSearchMethod();
		productsPage.searchBox("Blue");
		List<String> productNames =productsPage.getProductNameList();
		Assert.assertTrue(productNames.stream().allMatch(name -> name.toLowerCase().contains("blue")));
	}
	
	@Test(dataProvider="getData")
	public void verifySearchWithMultipleTermsTest(String searchProduct, String expectedProduct)
	{
		getSearchMethod();
		productsPage.searchBox(searchProduct);
		List<String> productNames =productsPage.getProductNameList();
		Assert.assertTrue(
			    productNames.stream().anyMatch(name -> name.contains(expectedProduct))
			);
	}
	
	@Test(dataProvider = "getExcelData")
	public void verifySearchWithExcelDataTest(
	        String searchTerm, String expectedProduct)
	{
		getSearchMethod();
		productsPage.searchBox(searchTerm);
		List<String> productNames =productsPage.getProductNameList();
		Assert.assertTrue(
			    productNames.stream().anyMatch(name -> name.contains(expectedProduct)),"Expected product not found: " + expectedProduct);
	}
	
	
	@DataProvider
	public Object[][] getExcelData() throws IOException {
	    ExcelReader reader = new ExcelReader();
	    return reader.excelDataReader();
	}
	
	@DataProvider
	public Object[][] getData()
	{
	   return  new Object[][] {{"Blue","Blue Top"},{"Women","Lace Top For Women"},{"Winter Top","Winter Top"}};
	}
	
	public void getSearchMethod()
	{
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		productsPage.openProductSection();
		loginPage.closeAd();
	}
}
