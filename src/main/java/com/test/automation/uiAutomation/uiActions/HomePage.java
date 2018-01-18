package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase{

	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;

	@FindBy(xpath = ("//a[@class='login']"))
	WebElement signIn;

	@FindBy(id = "email")
	WebElement loginEmail;

	@FindBy(id = ("passwd"))
	WebElement loginPassword;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement sbtButton;

	@FindBy(xpath = ("//*[@id='center_column']/div[1]/ol/li"))
	WebElement authenticationFailed;

	@FindBy(xpath = ("//*[@title='Log me out']"))
	WebElement authenticationPassed;

	/*@FindBy(xpath = ("//a[@class='logout']"))
	WebElement logOut;*/ // same as above

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApp(String emailId, String psw) {
		signIn.click();
		log.info("Clicked on SignIn Buton and the boject is - " + signIn.toString());
		loginEmail.sendKeys(emailId);
		log.info("Entered the email id and the boject is - " + loginEmail.toString());
		loginPassword.sendKeys(psw);
		log.info("Entered the password and the boject is - " + loginPassword.toString());
		sbtButton.click();
		log.info("Clicked on LogIn Buton and the boject is - " + sbtButton.toString());

	}
	
	public boolean verifyLogoutDisplay() {
		try {
			//waitForElement(300, authenticationPassed);
			authenticationPassed.isDisplayed();
			log.info("logout is displayed and object is - " +authenticationPassed.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnLogout() {
		authenticationPassed.click();
		log.info("clicked on log out button ");
	}

	public String invalidLogingText() {
		log.info("Error message is - " + authenticationFailed.getText());
		return authenticationFailed.getText();
	}

	public String validLogingText() {
		log.info("Sign out" + authenticationPassed.getText());
		return authenticationPassed.getText();
	}
	
	public void clickOnNavagationMeunu() {
		////a[contains(text(),'Women') and @title='Women']
		////*[@id="block_top_menu"]/ul/li[3]/a
		
		
		
	}
}
