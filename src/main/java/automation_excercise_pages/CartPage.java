package automation_excercise_pages;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation_excercise_base.AbstractComponent;
import automation_excercise_utilities.CartData;
import automation_excercise_utilities.CartItemData;
import automation_excercise_utilities.JsonReader;
import automation_excercise_utilities.ProductData;

public class CartPage extends AbstractComponent{
	
	public WebDriver driver;
	public ProductsPage productsPage;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		this.productsPage = new ProductsPage(driver);
	}

	@FindBy(xpath="//button[contains(@type,'button')]")
	public WebElement addtocartButton;
	
	@FindBy(xpath="//p[@class='text-center']//a")
	public WebElement viewCartButton;
	
	@FindBy(xpath="//ul//li[3]")
	WebElement UIcartButton;
	
	@FindBy(xpath="//div//tr//td//h4")
	WebElement cartProductName;
	
	@FindBy(xpath="//td[@class='cart_price']")
	WebElement totalPrice;
	
	@FindBy(xpath="//td[@class='cart_quantity']/button")
	WebElement productQuantity;
	
	@FindBy(xpath="//p[@class='cart_total_price']")
	WebElement productCartPrice;
	
	@FindBy(css=".cart_quantity_delete")
	WebElement productDeleteButton;
	
	@FindBy(css=".btn.btn-success.close-modal.btn-block")
	WebElement continueShoppingButton;
	
	@FindBy(css="a[class='cart_quantity_delete']")
	List<WebElement> deleteButton;
	
	@FindBy(xpath="//span[@id='empty_cart']//b")
	WebElement cartEmptyMessage;
	
	@FindBy(css=".cart_total")
	List<WebElement> productPrice;
	
	@FindBy(css=".cart_total")
	WebElement productPriceCart;
	
	@FindBy(css=".cart_quantity")
	List<WebElement> cartQuantity;
	
	@FindBy(xpath="//tbody/tr/td[2]/h4/a")
	List<WebElement> cartProductsName;
	
	@FindBy(xpath="//tr//td[4]/p")
	WebElement cartTotalPrice;
	
	@FindBy(css=".btn.btn-default.check_out")
	WebElement checkoutButton;
	
	@FindBy(css=".btn.btn-default.check_out")
	public WebElement placeOrder;
	
	public String addToCartAndGetSuccessText()
	{
		addtocartButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
		viewCartButton.click();
		wait.until(ExpectedConditions.visibilityOf(cartProductName));
		return cartProductName.getText();
	}
		
	public String getProductPrice()
	{
		return totalPrice.getText();
	}
	
	public String getProductQuantity()
	{
		return productQuantity.getText();
	}
	
	public String getProductTotal()
	{
		return productCartPrice.getText();
	}
	
	public void deleteProductButton()
	{
		productDeleteButton.click();
	}

	public String cartProductDelete()
	{
		
	for(int i=0; i<deleteButton.size();i++)
	{
		deleteButton.get(i).click();
	}
	wait.until(ExpectedConditions.visibilityOf(cartEmptyMessage));
	String Text =cartEmptyMessage.getText();
	return Text;
	}
	
	public  List<CartItemData> getCartProductDetails()
	{
		List<CartItemData> actualCartDetails = new ArrayList<>();
		
	    for (int i = 0; i < cartProductsName.size(); i++)
	    {
	    	CartItemData cartItem = new CartItemData();
	    	
	    	String name = cartProductsName.get(i).getText();
	    	
	    	int price = Integer.parseInt(
	    			productPrice.get(i).getText().replaceAll("[^0-9]", ""));
	    	
	    	int quantity = Integer.parseInt(
	    		    cartQuantity.get(i).getText()
	    		);
	    	
	    	int cartTotal = Integer.parseInt(
	    		    cartTotalPrice.getText().replaceAll("[^0-9]", ""));
	    	
	    	cartItem.setProductName(name);
	    	cartItem.setProductPrice(price);
	    	cartItem.setProductQuantity(quantity);
	    	cartItem.setProductTotal(cartTotal);
	    	
	    	actualCartDetails.add(cartItem);
	    }
	    
	    return actualCartDetails;
	}
	
	public int getActualCartTotal()
	{
	    return Integer.parseInt(
	        cartTotalPrice.getText().replaceAll("[^0-9]", "")
	    );
	}

	public void goToCheckOutPage()
	{
		UIcartButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		checkoutButton.click();
	}
	
	public void getMultipleProductTotal()
	{
		viewCartButton.click();
		int actualTotal = Integer.parseInt(productPriceCart.getText().replaceAll("[^0-9]", ""));
		int price = Integer.parseInt(getProductPrice().replaceAll("[^0-9]", ""));
		int quantity = Integer.parseInt(getProductQuantity().replaceAll("[^0-9]", ""));
		int expectedTotal = price*quantity;
	
		Assert.assertEquals(expectedTotal, actualTotal);
		System.out.println(expectedTotal);
		checkoutButton.click();
		int cartTotal =Integer.parseInt(cartTotalPrice.getText().replaceAll("[^0-9]", ""));
		Assert.assertEquals(expectedTotal, cartTotal);
	}
	
	public void go_To_CheckOut_Page()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addtocartButton));
		addtocartButton.click();
		goToCheckOutPage();
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		placeOrder.click();
	}
	
}
