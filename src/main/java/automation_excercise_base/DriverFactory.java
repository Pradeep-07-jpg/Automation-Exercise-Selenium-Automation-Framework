package automation_excercise_base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver =
	        new ThreadLocal<>();
	
    public static WebDriver createDriver() throws IOException {

    	WebDriver webDriver;
    	Properties prop = new Properties();
    	String path =System.getProperty("user.dir")+"\\src\\main\\java\\automation_excercise_utilities\\GlobalData.properties";
    	FileInputStream fis = new FileInputStream(path);
    	prop.load(fis);
    	String browser = prop.getProperty("browser");
 
  
        if (browser.equalsIgnoreCase("chrome")) {
        	webDriver = new ChromeDriver();
            
        } 
        else if (browser.equalsIgnoreCase("edge")) {
        	webDriver = new EdgeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
        	webDriver = new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        driver.set(webDriver);
        return driver.get();
    }
    
    
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
}
}