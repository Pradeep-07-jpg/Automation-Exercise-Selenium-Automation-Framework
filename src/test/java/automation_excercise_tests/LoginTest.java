package automation_excercise_tests;


import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation_excercise_base.BaseTest;
import automation_excercise_listeners.Retry;
import automation_excercise_pages.LoginPage;
import automation_excercise_pages.ProductsPage;
import automation_excercise_pages.SignUpPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class LoginTest extends BaseTest {
	
	public LoginPage loginPage;
	public SignUpPage signUpPage;
	public ProductsPage productsPage;
	@Test //(retryAnalyzer = Retry.class)
	public void validLoginTest() throws InterruptedException {
		
		loginPage = new LoginPage(driver);
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV"); 
	}
	
	@Test(dataProvider="getData") //, retryAnalyzer = Retry.class
	public void InvalidLoginTest(HashMap<String, Object> data) {
		
		loginPage = new LoginPage(driver);
		String email = (String) data.get("email");
		String password = (String) data.get("password");
		loginPage.UserDetails(email, password);
		WebElement errorMessage=loginPage.getErrorMessage();
		Assert.assertEquals(errorMessage.getText().trim(), "Your email or password is incorrect!");
	}
	
	@Test //(retryAnalyzer = Retry.class)//No issue but taking so Much Time
	public void logoutAfterLoginTest()
	{
		loginPage = new LoginPage(driver);  
		loginPage.enterUserDetails("prdhip220798@gamil.com", "BfUt94uw@cwRJV");
		loginPage.LogoutButton();
	}
	 
	@Test //(retryAnalyzer = Retry.class)
	public void newUserRegistrationTest()
	{
		signUpPage = new SignUpPage(driver);
		signUpPage.enterSignUpDetails("Demo", "Demo4455@gmail.com");
		signUpPage.enterPassword("Yt@ahiOline");
		signUpPage.dayDOB();
		signUpPage.monthDOB();
		signUpPage.yearDOB();
		signUpPage.addressInformation_A("Demo", "A", "Google", "4/5, Rick 1st Street");
		signUpPage.addressInformation_B("Karnataka","Bangalore", "753656", "9789076543");
		System.out.println(signUpPage.creationMessage());
	}

	@Test(dependsOnMethods ="newUserRegistrationTest", groups="api") //, retryAnalyzer = Retry.class
	public void deleteAccountAPI()
	{
		String email = "Demo4455@gmail.com";
		String password ="Yt@ahiOline";
		
		Response response =given().baseUri("https://automationexercise.com").formParam("email", email)
				.formParam("password", password).when().delete("/api/deleteAccount").then().extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("email", "visual_user@gamil.com");
		map.put("password", "secret_sauce");
		
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("email", "standard_user@gamil.com");
		map1.put("password", "secret_sauce");
		return new Object[][] {{map},{map1}};
	}

}
