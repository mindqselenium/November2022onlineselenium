package com.ohrms.testcases;

import java.net.URI;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.ohrms.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;

public class BaseTest {
	CommonDriver cmnDriver;
	String url;
	
	WebDriver driver;
	LoginPage loginpage;
	String configFilename;
	String currentworkingdirectory;
	Properties configproperty;
	
	String reportfilename;
	ReportUtils reportUtils;
	ScreenshotUtils screenshot;
	
	@BeforeSuite
	public void presetup() throws Exception {
		currentworkingdirectory=System.getProperty("user.dir");
		configFilename=currentworkingdirectory+"/config/config.properties";
		reportfilename=currentworkingdirectory+"/reports/ohrmstestreport.html";
		configproperty=ConfigUtils.readproperties(configFilename);
		reportUtils=new ReportUtils(reportfilename);
	}

	@BeforeClass
	public void setup() throws Exception {
		url=configproperty.getProperty("url");
		String browsertype=configproperty.getProperty("browsertype");
		cmnDriver=new CommonDriver(browsertype);
		driver=cmnDriver.getDriver();
		loginpage=new LoginPage(driver);
		screenshot =new ScreenshotUtils(driver);
		cmnDriver.navigateURL(url);
	}
	
	
	@AfterMethod
	public void posttestaction(ITestResult result) throws Exception {
		String testcasename=result.getName();
long executiontime=System.currentTimeMillis();
String screenshotfilename=currentworkingdirectory+"/screenshots/"+testcasename+executiontime+".jpeg";
		if(result.getStatus()==ITestResult.FAILURE) {
			reportUtils.addtestLog(Status.FAIL, "one or more steps failed");
			screenshot.captureandsavescreenshot(screenshotfilename);
			reportUtils.attachscreenshottoreport(screenshotfilename);
		}
		
	}
	
	@AfterClass
	public void teardown() {
		//cmnDriver.closeallbrowser();
	}
	
	@AfterSuite
	public void postteardown() {
		reportUtils.flushreport();
	}
}
