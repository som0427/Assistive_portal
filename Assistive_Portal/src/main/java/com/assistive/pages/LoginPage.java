package com.assistive.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assistive.utility.testBaseClass;

public class LoginPage extends testBaseClass {

	// Page Factory locator
	@FindBy(xpath = "//img[contains(@src,'./assets/media/logos/assistive_logo.png')]")
	@CacheLookup
	WebElement loginImage;

	@FindBy(xpath = "//input[@id='mat-input-0']")
	@CacheLookup
	WebElement usrname;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	@CacheLookup
	WebElement passwd;

	@FindBy(id = "kt_login_signin_submit")
	@CacheLookup
	WebElement loginbutton;

	// Required fields
//	@FindBy(xpath = "//*[@id=\"mat-error-0\"]/strong")
//	WebElement requiredusername;
//	@FindBy(xpath = "//*[@id=\"mat-error-1\"]/strong")
//	WebElement requiredpasswd;

	// initialize the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// validate page title
	public String validateLoginPagetitle() {
		return driver.getTitle();
	}

	// validate login page image
	public boolean dispLoginImage() {
		boolean img = loginImage.isDisplayed();
		return img;
	}

	// validate login page required field for username
//	public void userNameRequired() {
//		requiredusername.getText();
//	}

	// validate login page required field for password
//	public void PasswordRequired() {
//		requiredpasswd.getText();
//	}

	// login method
	public Dashboard loginToDashboard(String uid, String pass) {

		usrname.clear();
		usrname.sendKeys(uid);
		passwd.clear();
		passwd.sendKeys(pass);
		loginbutton.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("arguments[0].click();", loginbutton);

		// return dashboard class object
		return new Dashboard();
	}

}
