package automation_excercise_base;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractComponent {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
//	public void loginButton()
//	{
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
//
//    	wait.until(ExpectedConditions.elementToBeClickable(
//    	    By.cssSelector("button[data-qa='login-button']")
//    	)).click();
//	}
	
	public void openProductSection()
	{
    	

    	wait.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("//a[@href='/products']"))).click();
	}
	
	public void closeAdvertisement() {
    
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.tagName("iframe")));

    int frameCount = driver.findElements(By.tagName("iframe")).size();

    for (int i = 0; i < frameCount; i++) {

        driver.switchTo().defaultContent();

        List<WebElement> frames =
                driver.findElements(By.tagName("iframe"));

        try {
            driver.switchTo().frame(frames.get(i));

            List<WebElement> closeButton =
                    driver.findElements(By.id("dismiss-button"));

            if (!closeButton.isEmpty()) {

                wait.until(ExpectedConditions.elementToBeClickable(
                        closeButton.get(0))).click();

                driver.switchTo().defaultContent();
                return;
            }

        } catch (Exception e) {
        	System.out.println("Iframe " + i + " does not contain the advertisement close button.");
        }
    }

    driver.switchTo().defaultContent();
}
	

	public String elementToVisible() {
		
		WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));
		
        WebElement enterValue  = driver.findElement(By.xpath("//input[@id='quantity']"));
        enterValue.clear();
        enterValue.sendKeys("3");
		
        wait.until(ExpectedConditions.textToBePresentInElementValue(enterValue, "3"));
         return enterValue.getAttribute("value");
        
	}
	

}