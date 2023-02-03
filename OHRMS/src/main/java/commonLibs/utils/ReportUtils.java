package commonLibs.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtils {

	ExtentHtmlReporter htmlReport;
	ExtentReports extentreports;
	ExtentTest extenttest;
	
	public ReportUtils(String htmlreportFilename) {
		
		htmlreportFilename = htmlreportFilename.trim();
		htmlReport= new ExtentHtmlReporter(htmlreportFilename);
		extentreports =new ExtentReports();
		extentreports.attachReporter(htmlReport);
	}
	
	public void createaTestcase(String testcasename) {
		extenttest=extentreports.createTest(testcasename);
	}
	
	public void addtestLog(Status status, String comment) {
		extenttest.log(status, comment);
	}
	
	public void attachscreenshottoreport(String filename) throws Exception {
		extenttest.addScreenCaptureFromPath(filename);
	}
	
	public void flushreport() {
		extentreports.flush();
	}
}
