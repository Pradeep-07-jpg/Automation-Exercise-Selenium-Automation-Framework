package automation_excercise_stepdefinitions;

import automation_excercise_base.DriverFactory;
import automation_excercise_pages.CartPage;
import automation_excercise_pages.LoginPage;
import automation_excercise_pages.OrderConfirmationPage;
import automation_excercise_pages.PaymentPage;
import automation_excercise_pages.ProductsPage;
import automation_excercise_pages.SignUpPage;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;


public class PaymentStepDefinitions {
	

	@Before
	public void setUpScenario() throws IOException {
	    DriverFactory.createDriver();
	    WebDriver driver = DriverFactory.getDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	    driver.get("https://www.automationexercise.com/");
	    loginPage = new LoginPage(driver);
	    cartPage = new CartPage(driver);
	    productsPage = new ProductsPage(driver);
	    signUpPage = new SignUpPage(driver);
	    paymentPage = new PaymentPage(driver);
	    orderConfirmationPage = new OrderConfirmationPage(driver);
	}
	@After
	public void tearDownScenario() {
	    DriverFactory.quitDriver();
	}
	private Set<String> filesBeforeDownload;
	public LoginPage loginPage;
	public CartPage cartPage;
	public ProductsPage productsPage;
	public SignUpPage signUpPage;
	public PaymentPage paymentPage;
	public OrderConfirmationPage orderConfirmationPage;
	
	@Given("the user is on the payment page")
	public void theUserIsOnPaymentPage() {
	    navigateToPaymentPage();
	}
	
	@When("the user enters valid card details")
	public void enterUserValidCardDetails()
	{
		paymentPage.enterCardDetails("Pradeep A", "3321330001231314", "007", "18", "2018");
	}
	
	@And("the user confirms the order")
	public void userOrderConfirmation()
	{
		paymentPage.clickPayAndConfirmOrder();
	}

	@Then("the successful order confirmation message should be displayed")
	public void getTheOrderSuccessMessage()
	{
		String successMessage =orderConfirmationPage.getOrderPlacedMessage();
		Assert.assertEquals(successMessage, "ORDER PLACED!");
	}
	
	@Given("the user is on the order confirmation page")
	public void theUserIsOnOrderConfirmationPage() {
	    navigateToOrderConfirmationPage();
	}
	
	@When("the user downloads the invoice")
	public void userDownloadingTheInvoice()
	{
		orderConfirmationPage.clickDownloadInvoice();
	}
	
	@And("the invoice should be downloaded successfully")
	public void theInvoiceShouldBeDownloadedSuccessfully()
	{
		Assert.assertTrue(orderConfirmationPage.getFileDownloadStatus(),
	            "Invoice was not downloaded successfully");
	}
	
	@Then("the user clicks Continue")
	public void clickContinueToNextPage()
	{
		orderConfirmationPage.clickContinue();
	}

	public void navigateToPaymentPage() {
		loginPage.enterUserDetails("Verification@gamil.com", "vERIFICATION@1234");
		productsPage.openProductSection();
		loginPage.closeAd();
		productsPage.searchBox("Fancy Green Top");
		productsPage.openViewProduct();
		productsPage.elementToVisible();
		cartPage.go_To_CheckOut_Page();
	}

	public void navigateToOrderConfirmationPage()
	{
		loginPage.enterUserDetails("Verification@gamil.com", "vERIFICATION@1234");
		productsPage.openProductSection();
		loginPage.closeAd();
		productsPage.searchBox("Blue Top");
		productsPage.openViewProduct();
		productsPage.elementToVisible();
		cartPage.go_To_CheckOut_Page();
		paymentPage.enterCardDetails("Pradeep A", "3321330001231314", "007", "18", "2018");
		paymentPage.clickPayAndConfirmOrder();
	}
}
