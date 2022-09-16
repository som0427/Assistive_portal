package com.assistive.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assistive.utility.testBaseClass;

public class Dashboard extends testBaseClass {

	// Page Factory locator
	@FindBy(xpath = "//img[contains(@src,'./assets/media/logos/assistive_logo.png')]")
	WebElement dashboard_assistive_logo;

	@FindBy(xpath = "//*[@class='text-dark font-weight-bold my-2 mr-5 ng-star-inserted']")
	WebElement dash_dailyAtivityReport;

	// initialize the page object
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}

	public void validateDashboardPage_title_url() {
		System.out.println("Dashboard Page Title: " + driver.getTitle());
		System.out.println("Dashboard page url: " + driver.getCurrentUrl());
	}

	public String dash_dailyAtivityReport() {
		return dash_dailyAtivityReport.getText();
	}

}
