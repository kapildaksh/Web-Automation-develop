package com.prenetics.testscript;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = { "src/test/resources/" }, 
		glue = { "classpath:com/prenetics/stepdefs","com.prenetics.cucumber.hooks" }, 
		plugin = { "pretty", "json:target/cucumber.json",
				"html:target/site/cucumber-pretty" }, 
		tags = { "@SmokeTest", "@RegressionTest"}
		)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}