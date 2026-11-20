package automation_excercise_pages;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automation_excercise_base.AbstractComponent;

public class OrderConfirmationPage extends AbstractComponent {
	
    private WebDriver driver;
    

    public OrderConfirmationPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css="h2[class='title text-center'] b")
    WebElement greenText;
    
    @FindBy(css=".btn.btn.btn-default.check_out")
    WebElement invoiceButton;
    
    @FindBy(css=".btn.btn-primary")
    WebElement continueButton;
    
    
    public String getOrderPlacedMessage() {
    	wait.until(ExpectedConditions.visibilityOf(greenText));
        return greenText.getText();
    }

    public void clickDownloadInvoice() {
        invoiceButton.click();
    }
    
    public boolean getFileDownloadStatus()
    {
    	 String downloadPath = System.getProperty("user.home") + "\\Downloads";
    	 File downloadFolder = new File(downloadPath);
    	    File[] files = downloadFolder.listFiles();

    	    if (files == null) {
    	        return false;
    	    }

    	    for (File file : files) {
    	        if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
    	            return true;
    	        }
    	    }

    	    return false;
    	}

    public void clickContinue() {
        continueButton.click();
    }

}
