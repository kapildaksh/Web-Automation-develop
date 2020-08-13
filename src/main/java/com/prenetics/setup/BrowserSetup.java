package com.prenetics.setup;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.prenetics.common.utility.Constants;
import com.prenetics.common.utility.ReadPropertiesFile;
import com.prenetics.common.utility.SystemProperty;

public class BrowserSetup {

	public static String currentBrowserName = null;
	private static Logger logger = Logger.getLogger(BrowserSetup.class);
	private WebDriver driver;

	{
		PropertyConfigurator.configure("log4j.properties");
		SystemProperty.setReportNgEscapeOutput("false");
	}

	@BeforeMethod
	@Parameters({ "browser", "execution" })
	public void initiateBrowser(String browser, String execution) {
		currentBrowserName = browser;

		if (execution.equalsIgnoreCase(Constants.Execution.LOCAL)) {
			String driverLocation = "";
			ReadPropertiesFile config = new ReadPropertiesFile();
			boolean isChrome = browser.equalsIgnoreCase(Constants.Browser.CHROME),
					isFireFox = browser.equalsIgnoreCase(Constants.Browser.FIREFOX),
					isIE = browser.equalsIgnoreCase(Constants.Browser.INTERNET_EXPLORER),
					isEdge = browser.equalsIgnoreCase(Constants.Browser.EDGE),
					isWindows = SystemProperty.isWindowsSystem(), isMac = SystemProperty.isMacSystem(),
					isLinux = SystemProperty.isLinuxSystem();
			        

			if (isWindows && isChrome)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_WINDOWS_CHROME_DRIVER);
			else if (isWindows && isFireFox)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_WINDOWS_FIREFOX_DRIVER);
			else if (isWindows && isIE)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_WINDOWS_IE_DRIVER);
			else if (isWindows && isEdge)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_WINDOWS_EDGE_DRIVER);
			else if (isMac && isChrome)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_MACOS_CHROME_DRIVER);
			else if (isMac && isFireFox)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_MACOS_FIREFOX_DRIVER);
			else if (isLinux && isChrome)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_LINUX_CHROME_DRIVER);
			else if (isLinux && isFireFox)
				driverLocation = config.getPropertyValue(Constants.ConfigProperties.LOCAL_LINUX_FIREFOX_DRIVER);

			if (!driverLocation.isEmpty()) {
				if (isChrome) {
					SystemProperty.setChromeDriver(driverLocation);
					ChromeDriverService driverService = new ChromeDriverService.Builder()
							.usingDriverExecutable(new File(driverLocation)).usingAnyFreePort().build();
					ChromeOptions options = BrowserOptions.getChromeOptions();
					String downloadFilepath = System.getProperty("user.dir") + "//target//";
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", downloadFilepath);					
					options.setExperimentalOption("prefs", chromePrefs);	
					driver = new ChromeDriver(driverService, options);
					resizeWindow(driver);

				} else if (isFireFox) {

					FirefoxOptions options = BrowserOptions.getFirefoxOptions();
					options.merge(BrowserCapabilities.Firefox());
					GeckoDriverService service = new GeckoDriverService.Builder()
							.usingDriverExecutable(new File(driverLocation)).usingAnyFreePort().build();
					driver = new FirefoxDriver(service, options);
					resizeWindow(driver);

				} else if (isIE) {

					InternetExplorerOptions options = new InternetExplorerOptions();
					options.takeFullPageScreenshot();
					options.merge(BrowserCapabilities.IE());
					InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
							.usingDriverExecutable(new File(driverLocation)).usingAnyFreePort().build();
					driver = new InternetExplorerDriver(service, options);
					maximizeWindow(driver);
				} else if (isEdge) {

					EdgeDriverService service = new EdgeDriverService.Builder()
							.usingDriverExecutable(new File(driverLocation)).usingAnyFreePort().build();
					EdgeOptions options = BrowserOptions.getEdgeOptions();
					driver = new EdgeDriver(service, options);

				}
				DriverManager.setDriver(driver);

			} else {
				logger.error("Browser not found");
			}
			
		}else {
			GridSetup grid = new GridSetup();
			driver = grid.runOnGrid(browser, execution);
			DriverManager.setDriver(driver);
		}
	}

	@AfterMethod()
	public void quitDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
			logger.info("\uD83C\uDFAC\uD83C\uDFAC\uD83C\uDFAC BROWSER CLOSED");
		}
	}

	private void maximizeWindow(WebDriver driver) {
		// No need to maximize browser in Selenium grid
		if (SystemProperty.isRunningLocally()) {
			driver.manage().window().maximize();
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