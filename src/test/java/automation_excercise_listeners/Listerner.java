package automation_excercise_listeners;

import org.testng.ITestListener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automation_excercise_base.DriverFactory;
import automation_excercise_utilities.*;


public class Listerner implements ITestListener {
	
	Extent_Report extentReport = new Extent_Report();

	ExtentReports extent = extentReport.getReport();

	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentTest test =
                extent.createTest(result.getMethod().getMethodName());

        extentTest.set(test);
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed Successfully");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = DriverFactory.getDriver();
		
		String filePath;
		try {
			filePath = getScreenShotUtils.getScreenShots(result.getMethod().getMethodName(), driver);
			extentTest.get().addScreenCaptureFromPath(filePath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(
		        Status.SKIP,
		        "Test Skipped: " + result.getThrowable()
		    );
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
