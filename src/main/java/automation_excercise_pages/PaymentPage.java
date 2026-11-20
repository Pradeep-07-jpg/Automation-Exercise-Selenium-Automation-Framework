package automation_excercise_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automation_excercise_base.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css="input[class='form-control']")
    WebElement cardName;
    
    @FindBy(css="input[name='card_number']")
    WebElement cardNumbers;
    
    @FindBy(css="input[name='cvc']")
    WebElement cardCVC;
    
    @FindBy(css="input[placeholder='MM']")
    WebElement cardMM;
    
    @FindBy(css="input[placeholder='YYYY']")
    WebElement cardYYYY;
    
    @FindBy(xpath="//button[@id='submit']")
    WebElement cardPay;
    
//    @FindBy(css="div[id='success_message'] div[class='alert-success alert']")
//    WebElement successMessage;
    
    public void enterCardDetails(String name, String cardNumber, String cvc, String month, String year)
    {
    	cardName.sendKeys(name);
    	cardNumbers.sendKeys(cardNumber);
    	cardCVC.sendKeys(cvc);
    	cardMM.sendKeys(month);
    	cardYYYY.sendKeys(year);
    }
    
    public void clickPayAndConfirmOrder()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(cardPay));
    	cardPay.click();
    }
    
}
