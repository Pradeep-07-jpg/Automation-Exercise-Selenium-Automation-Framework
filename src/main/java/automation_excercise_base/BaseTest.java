package automation_excercise_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) throws IOException {
    	
    	if (isApiTest(method)) {
            return;
        }
    	
        driver = DriverFactory.createDriver();

        driver.manage().window().maximize();
        
        driver.manage().timeouts()
        .pageLoadTimeout(Duration.ofSeconds(60));

        driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod
    public void tearDown(Method method) {
    	
    	if (isApiTest(method)) {
            return;
        }
    	DriverFactory.quitDriver();
    }
    
    private boolean isApiTest(Method method) {

        Test test = method.getAnnotation(Test.class);
        return test != null &&
                Arrays.asList(test.groups()).contains("api");
    }
}
