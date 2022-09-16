package com.assistive.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public testBaseClass() {

		try {
			prop = new Properties();
			File src = new File(
					"C:\\Users\\Soumya Chatterjee\\eclipse-workspace-2022_06\\Assistive_Portal\\src\\main\\java\\com\\assistive\\config\\config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	// @BeforeClass
	public static void initialization() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		}

		else if (browsername.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		}

		else if (browsername.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
		}

		else {
			System.out.println("We do not support this browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(testUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(testUtil.PAGE_LOAD_TIMEOUT));
		driver.get(prop.getProperty("url"));

//		return driver;

	}

	// @AfterClass
	public static void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
