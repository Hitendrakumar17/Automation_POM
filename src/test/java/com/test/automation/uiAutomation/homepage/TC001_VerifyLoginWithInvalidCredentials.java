package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	HomePage homePage;

	@BeforeTest
	public void SetUP() throws IOException {
		init();
	}

	@Test
	public void verifyLoginWithInvalidCredentials() {

		log.info("--------------- Staring verifyLoginWithInvalidCredentials -----------------");
		homePage = new HomePage(driver); // if you do not specify driver, NULL Pointer Exception will be raised.

		homePage.loginToApp("test123@gmail.com", "test123");
		Assert.assertEquals(homePage.invalidLogingText(), "TestAuthentication failed.");
		System.out.println("user.dir : " + System.getProperty("user.dir"));
		log.info("--------------- Finished verifyLoginWithInvalidCredentials -----------------");
	}

	/*
	 * @AfterTest public void tearDown() { driver.close();
	 * 
	 * }
	 */
}
