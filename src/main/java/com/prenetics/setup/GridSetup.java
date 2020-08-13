package com.prenetics.setup;

import com.prenetics.common.utility.Constants;
import com.prenetics.common.utility.ReadPropertiesFile;
import com.prenetics.common.utility.SystemProperty;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class GridSetup {

	private static Logger logger = Logger.getLogger(GridSetup.class);
	private WebDriver driver;

	public WebDriver runOnGrid(String browserName, String execution) {
		DesiredCapabilities desiredcapabilities;

		switch (browserName.toLowerCase()) {
		case Constants.Browser.FIREFOX:
			desiredcapabilities = BrowserCapabilities.Firefox();
			runOnGridMachine(desiredcapabilities, execution);
			break;
		case Constants.Browser.CHROME:
			desiredcapabilities = BrowserCapabilities.Chrome();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			desiredcapabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			// desiredcapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
			// true);
			runOnGridMachine(desiredcapabilities, execution);
			break;
		case Constants.Browser.EDGE:
			desiredcapabilities = BrowserCapabilities.Edge();
			runOnGridMachine(desiredcapabilities, execution);

		default:
			logger.error("Browser not found");
		}
		return driver;
	}

	private void runOnGridMachine(DesiredCapabilities desiredcapabilities, String execution) {
		ReadPropertiesFile prop = new ReadPropertiesFile();

		String gridURL;
		if (execution.equalsIgnoreCase(Constants.Execution.REMOTE_DEV))
			gridURL = prop.getPropertyValue(Constants.ConfigProperties.GRID_DEV_URL);
		else
			gridURL = prop.getPropertyValue(Constants.ConfigProperties.GRID_URL);
		try {
			logger.info("Initializing REMOTE WebDriver to: " + gridURL);
			logger.info("Using Capability: " + desiredcapabilities.toString());
			logger.info("######################################");
			driver = new RemoteWebDriver(new URL(gridURL), desiredcapabilities);
			resizeWindow(driver);
			logger.info("RemoteWebDriver initialized \uD83D\uDE01\uD83D\uDE01\uD83D\uDE01\uD83D\uDE01\uD83D\uDE01");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private void resizeWindow(WebDriver driver) {

		String headless = String.valueOf(SystemProperty.getIsHeadless());
		if (headless.equalsIgnoreCase("true")) {
			Dimension dimension = new Dimension(1920, 1080);
			driver.manage().window().setSize(dimension);
		}
	}
}
