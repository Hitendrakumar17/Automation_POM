package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase {

	public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());
	HomePage homePage;
	// String emailId = "testng321@gmail.com";
	// String psw = "testng";

	@DataProvider(name = "loginData")
	public String[][] getTestDate() {
		String[][] testRecords = getData("TestData.xlsx", "sheet1");
		return testRecords;
	}

	@BeforeTest
	public void SetUP() throws IOException {
		init();
	}

	@Test(dataProvider = "loginData")
	public void testLogin(String emailId, String psw, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User has marked this as no run...");
		}
		log.info("--------------- Staring verifyLoginWithValidCredentials -----------------");
		homePage = new HomePage(driver); // if you do not specify driver, NULL Pointer Exception will be raised.

		homePage.loginToApp(emailId, psw);
		boolean status = homePage.verifyLogoutDisplay();
		// System.out.println("Status is -- "+status);
		getScreenShot("testLogin_" + emailId);

		if (status) {
			homePage.clickOnLogout();
		}
		Assert.assertEquals(status, true);

		// Assert.assertEquals(homePage.validLogingText(), "Sign out");
		log.info("--------------- Finished verifyLoginWithValidCredentials -----------------");
	}

	/*
	 * @AfterTest public void tearDown() { driver.close();
	 * 
	 * }
	 */
}
