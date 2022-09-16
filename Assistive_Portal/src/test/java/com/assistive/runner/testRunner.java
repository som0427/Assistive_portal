package com.assistive.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/assistive.feature", // feature file path
		glue = { "com/assistive/stepDefinitions" }, // path of the stepDefinition files
//	format={"pretty",""}
		monochrome = true, // display console o/p in readable format
		plugin = { "pretty", "html:target/htmlReports/assistive_report.html",
				"json:target/JSONReports/assistive_report.json", "junit:target/JUnitReports/assistive_report.xml" },
//		strict = true, 	//it will check if any step is not defined in step def file
		dryRun = false // to check the mapping is proper between feature and step def files
//			tags = {"~@Smoketest" , "~@RegressionTest"}
)

public class testRunner {

}
