package automation_excercise_runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/resources/Features",
	    glue = "StepDefinitions",
	    monochrome = true,
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	)
public class PaymentTestRunner extends AbstractTestNGCucumberTests{

}
