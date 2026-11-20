package automation_excercise_utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report {
	ExtentReports extent;
	
	public ExtentReports getReport()
	{
		String path = System.getProperty("user.dir") + "/Reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Excercise");
		reporter.config().setDocumentTitle("COM Design Results");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Tester", "Pradeep");
		return extentReport;
	}
}
