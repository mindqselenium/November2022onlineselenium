package com.ohrms.testcases;

import org.junit.runners.Parameterized.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;

import junit.framework.Assert;

public class LoginTest extends BaseTest {
   @org.testng.annotations.Parameters({"username","password"})
	@Test
	public void verifyuserwithcorrectcredentials(String username, String password) {
    	reportUtils.createaTestcase("verify user with correct credentials");
    	reportUtils.addtestLog(Status.INFO, "performing login");
		loginpage.logintoapplication(username, password);
		String expectedtitle="OrangeHRM";
		String actualtitle=cmnDriver.gettitleofthepage();
		reportUtils.addtestLog(Status.INFO, actualtitle);
		Assert.assertEquals(actualtitle, expectedtitle);
		
	}
}
