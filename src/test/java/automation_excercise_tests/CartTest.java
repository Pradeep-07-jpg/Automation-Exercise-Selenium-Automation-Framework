package automation_excercise_tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_excercise_base.BaseTest;
import automation_excercise_pages.CartPage;
import automation_excercise_pages.LoginPage;
import automation_excercise_pages.ProductsPage;
import automation_excercise_utilities.CartData;
import automation_excercise_utilities.CartItemData;
import automation_excercise_utilities.JsonReader;
import automation_excercise_utilities.ProductData;

public class CartTest extends BaseTest {
	
	
	public LoginPage loginPage;
	public ProductsPage productsPage;
	public CartPage cartPage;

	@Test
	public void verifyAddProductToCartTest()
	{
		loginandSearchProduct();
		productsPage.searchBox("Premium Polo T-Shirts");
		String Text =productsPage.searchBoxText();
		String cartProductName =cartPage.addToCartAndGetSuccessText();
		Assert.assertEquals(Text, cartProductName);
	}

	@Test
	public void verifyProductDetailsInCartTest()
	{  
		loginandSearchProduct();
		productsPage.searchBox("Premium Polo T-Shirts");
		String Text =productsPage.searchBoxText();
		String cartProductName =cartPage.addToCartAndGetSuccessText();
		String actualPrice =cartPage.getProductPrice();
		String actualQuantity =cartPage.getProductQuantity();
		String actualTotal =cartPage.getProductTotal();
		Assert.assertEquals(Text, cartProductName);
		Assert.assertEquals(actualPrice, "Rs. 1500");
		Assert.assertEquals(actualQuantity, "2");
		Assert.assertEquals(actualTotal, "Rs. 3000");
		cartPage.deleteProductButton();
	}
	
	@Test
	public void verifyAddMultipleProductsToCartUsingJsonTest() throws Exception
	{
		loginandSearchProductForVerification();
		productsPage.addProductFromJson();
		String Message =cartPage.cartProductDelete();
		Assert.assertEquals(Message, "Cart is empty!");
	}
	
	@Test
	public void verifyCartDetailsAndTotalUsingJsonTest() throws IOException
	{
		loginandSearchProductForVerification();
		productsPage.addProductFromJson();
		cartPage.goToCheckOutPage();
	    JsonReader jsonReader = new JsonReader();
	    CartData cartData = jsonReader.jsonToMap();
	    List<ProductData> expectedProducts = cartData.getProducts();
	    List<CartItemData> actualProducts = cartPage.getCartProductDetails();
	    int actualCartTotal = cartPage.getActualCartTotal();
	    int expectedCartTotal = cartData.getExpectedCartTotal();
	    Assert.assertEquals(actualCartTotal, expectedCartTotal);
	    driver.navigate().back();
		String Message =cartPage.cartProductDelete();
		Assert.assertEquals(Message, "Cart is empty!");
	}
	
	@Test
	public void verifyUpdateProductQuantityInCartTest()
	{
		loginandSearchProductForVerification();
		productsPage.searchBox("Fancy Green Top");
		productsPage.openViewProduct();
		productsPage.elementToVisible();
		cartPage.addtocartButton.click();
		cartPage.getMultipleProductTotal();
		driver.navigate().back();
		String Message =cartPage.cartProductDelete();
		Assert.assertEquals(Message, "Cart is empty!");
	}
	
	public void loginandSearchProduct()
	{
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		productsPage.openProductSection();
		loginPage.closeAd();
	}
	
	public void loginandSearchProductForVerification()
	{
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		loginPage.enterUserDetails("Verification@gamil.com", "vERIFICATION@1234");
		productsPage.openProductSection();
		loginPage.closeAd();
	}
}
