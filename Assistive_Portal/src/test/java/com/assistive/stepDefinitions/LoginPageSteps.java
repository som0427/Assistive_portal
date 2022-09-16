package com.assistive.stepDefinitions;

import org.junit.Assert;

import com.assistive.pages.Dashboard;
import com.assistive.pages.LoginPage;
import com.assistive.utility.testBaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends testBaseClass {

	LoginPage login;
	Dashboard dash;

	@Given("^user opens browser$")
	public void user_opens_browser() {
		testBaseClass.initialization();
		System.out.println("Browser successfully initialized");
	}

	@Then("^user is on login Page$")
	public void user_is_on_login_page() throws InterruptedException {
		login = new LoginPage();

		// validate Login page title
		String loginPage_title = login.validateLoginPagetitle();
		Assert.assertEquals("Assistive", loginPage_title);
		System.out.println("Login Page Title: " + loginPage_title);
		if (driver.getTitle().equals("Assistive")) {
			System.out.println("Login Page title matched");
		} else {
			System.out.println("Login page Title not Matched");
		}

		// validate login image present
		Boolean loginimage = login.dispLoginImage();
		String loginimg = loginimage.toString();
		System.out.println("Login image present: " + loginimg);

		System.out.println("User is sucessfully navigated to Login page");
	}

	@When("^user enters username and password and clicks on Login button$")
	public void user_enters_username_and_password() {
		login = new LoginPage();

		// takes username and password from properties file and click login button
		dash = login.loginToDashboard(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("User sucessfully entered username and password and clicked login button");
	}

	@Then("^user is navigated to Dahboard$")
	public void user_is_navigated_to_dahboard() throws InterruptedException {
		dash = new Dashboard();
		Thread.sleep(3000);

		// call dashboard page title_url and print if
		dash.validateDashboardPage_title_url();
	}

	@Then("^user is on Dashboard Page$")
	public void user_is_on_Dashboard_Page() {
		dash = new Dashboard();
		String D_A_report = dash.dash_dailyAtivityReport();
		System.out.println("User is on dashboard " + D_A_report);
	}

}
