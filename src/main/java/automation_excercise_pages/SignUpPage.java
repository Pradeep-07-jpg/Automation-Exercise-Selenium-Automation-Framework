package automation_excercise_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import automation_excercise_base.AbstractComponent;

public class SignUpPage extends AbstractComponent {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(css="input[type=\"text\"]")									
    WebElement enterName;
    
    @FindBy(xpath="//input[@data-qa='signup-email']")
    WebElement enterEmail;
    
    @FindBy(xpath="(//button[@type='submit'])[2]")
    WebElement signUpButton;
    
    @FindBy(id="password")
    WebElement enterPassword;
    
    @FindBy(id="days")
    WebElement day;
    
    @FindBy(id="months")
    WebElement month;

    @FindBy(id="years") 
    WebElement year;

    @FindBy(xpath="(//input[@type=\"text\"])[3]")
    WebElement firstName;
    
    @FindBy(xpath="(//input[@type=\"text\"])[4]")
    WebElement lastName;
    
    @FindBy(xpath="(//input[@type=\"text\"])[5]")
    WebElement company;
    
    @FindBy(xpath="(//input[@type=\"text\"])[6]")
    WebElement address;
    
    @FindBy(xpath="(//input[@type=\"text\"])[8]")
    WebElement stateName;
    
    @FindBy(xpath="(//input[@type=\"text\"])[9]")
    WebElement cityName;
    
    @FindBy(xpath="(//input[@type=\"text\"])[10]")
    WebElement zipcode;
    
    @FindBy(xpath="(//input[@type=\"text\"])[11]")
    WebElement mobileNumber;
    
    @FindBy(css="button[data-qa=\"create-account\"]")
    WebElement createButton;
    
    @FindBy(xpath="//b[normalize-space()='Account Created!']")
    WebElement successMessage;
    
    @FindBy(xpath="//b[normalize-space()='Account Deleted!']")
    WebElement deletedMessage;
    
    public void enterSignUpDetails(String name, String email)
    {
    	LoginPage log = new LoginPage(driver);
    	log.logButton.click();                         //logButton locator Reused from LoginPage
    	enterName.sendKeys(name);
    	enterEmail.sendKeys(email);
    	signUpButton.click();
    	
    }
    
    public void enterPassword(String Password)
    {
    	enterPassword.sendKeys(Password);
    }
    
    public void dayDOB()
    {
    	WebElement StaticDropdown = day;
    	Select dropdown = new Select(StaticDropdown);
    	dropdown.selectByIndex(21);
    }
    
    public void monthDOB()
    {
    	WebElement StaticDropdown = month;
    	Select dropdown = new Select(StaticDropdown);
    	dropdown.selectByIndex(7);
    }
    
    public void yearDOB()
    {
    	WebElement StaticDropdown = year;
    	Select dropdown = new Select(StaticDropdown);
    	dropdown.selectByValue("1953");
    }
    
    public void addressInformation_A(String FirstName, String LastName, String Company, String Address)
    {
    	firstName.sendKeys(FirstName);
    	lastName.sendKeys(LastName);
    	company.sendKeys(Company);
    	address.sendKeys(Address);
    }
    public void addressInformation_B(String StateName, String CityName, String Zipcode, String MobileNumber)
    {
    	stateName.sendKeys(StateName);
    	cityName.sendKeys(CityName);
    	zipcode.sendKeys(Zipcode);
    	mobileNumber.sendKeys(MobileNumber);
    	createButton.click();
    }
    
    public String creationMessage() {
    String Created =successMessage.getText();
    return Created;
    }
    
    public String deletionMessage() {
    	
    	wait.until(ExpectedConditions.visibilityOf(deletedMessage));
    	String Deleted = deletedMessage.getText();
    	return Deleted;
    }
}
