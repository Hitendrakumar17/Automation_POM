package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC002_VerifyLoginWithValidCredentials extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithValidCredentials.class.getName());
	HomePage homePage;

	@BeforeTest
	public void SetUP() throws IOException {
		init();
	}

	@Test
	public void verifyLoginWithValidCredentials() {

		log.info("--------------- Staring verifyLoginWithValidCredentials -----------------");
		homePage = new HomePage(driver); // if you do not specify driver, NULL Pointer Exception will be raised.

		homePage.loginToApp("testng321@gmail.com", "testng");
		Assert.assertEquals(homePage.validLogingText(), "Sign out");
		log.info("--------------- Finished verifyLoginWithValidCredentials -----------------");
	}

	/*
	 * @AfterTest public void tearDown() { driver.close();
	 * 
	 * }
	 */

}
