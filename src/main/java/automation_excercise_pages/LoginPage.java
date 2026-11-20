package automation_excercise_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation_excercise_base.AbstractComponent;

public class LoginPage extends AbstractComponent {

    private WebDriver driver;
    

    public LoginPage(WebDriver driver) {
        super(driver);
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
 // Locators
    
    @FindBy(css="a[href='/login']")
    WebElement SignorLogButton;
     
    @FindBy(xpath="(//input[@type='email'])[1]")
    WebElement userEmail;
    
    @FindBy(css="input[placeholder='Password']")
    WebElement userPassword;
    
    public @FindBy(xpath="(//a[normalize-space()='Signup / Login'])[1]")
    WebElement logButton;
    
    @FindBy(css="button[data-qa='login-button']")
    WebElement loginButton;
    
    @FindBy(xpath="(//p[normalize-space()='Your email or password is incorrect!'])[1]")
    WebElement errorMessage;
    
    @FindBy(xpath="(//a[normalize-space()='Logout'])[1]")
    WebElement logoutButton;
    
    @FindBy(css="a[href='/delete_account']")
    WebElement deleteButton;
    
    @FindBy(css="a[href='/delete_account']")
    WebElement accountDeleteButton;
    
    
  
    public void enterUserDetails(String email, String password) {
  
    	driver.findElement(
    	        By.xpath("(//a[normalize-space()='Signup / Login'])[1]")
    	    ).click();
    	userEmail.sendKeys(email);
    	userPassword.sendKeys(password);
    	loginButton.click();
    }
    public void UserDetails(String email, String password)
    {
    	SignorLogButton.click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
    	userEmail.sendKeys(email);
    	userPassword.sendKeys(password);
    	loginButton.click();
    }
    
    public WebElement getErrorMessage() {
    	
    	return errorMessage;
    }
    
    public void LogoutButton()
    {
    	logoutButton.click();
    }
    
    public void closeAd() {
        
    	closeAdvertisement();
    }
    
    public void accountDeletion() {

        accountDeleteButton.click();
    }
    
}