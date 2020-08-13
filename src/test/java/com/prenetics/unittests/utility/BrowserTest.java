package com.prenetics.unittests.utility;

import com.prenetics.common.utility.Constants;
import com.prenetics.common.utility.SystemProperty;
import com.prenetics.setup.BrowserSetup;
import com.prenetics.setup.DriverManager;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class BrowserTest {

	protected WebDriver driver;
	private BrowserSetup browser;

	@Before
	public void setup() throws Exception {
		String sysBrowser = Constants.Browser.CHROME;
		String sysExecution = Constants.Execution.LOCAL;

		SystemProperty.setBrowser(sysBrowser);
		SystemProperty.setExecution(sysExecution);

		browser = new BrowserSetup();
		browser.initiateBrowser(sysBrowser, sysExecution);
		driver = DriverManager.getDriver();
	}

	@After
	public void teardown() {
		browser.quitDriver(driver);
	}
}
