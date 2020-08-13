package com.prenetics.setup;

import java.util.logging.Level;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCapabilities {

	public static DesiredCapabilities Chrome() {

		DesiredCapabilities dc = DesiredCapabilities.chrome();
		ChromeOptions options = BrowserOptions.getChromeOptions();
		dc.setBrowserName("chrome");
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(ChromeOptions.CAPABILITY, BrowserOptions.getChromeOptions());
		dc.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc .setCapability(ChromeOptions.CAPABILITY, options);
		return dc;
	}

	public static DesiredCapabilities Firefox() {

		DesiredCapabilities dc = DesiredCapabilities.firefox();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		dc.setBrowserName("firefox");
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, BrowserOptions.getFirefoxOptions());
		return dc;
	}

	public static DesiredCapabilities IE() {

		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		dc.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		dc.setBrowserName("internet explorer");
		dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		dc.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		dc.setJavascriptEnabled(true);
		return dc;
	}

	public static DesiredCapabilities Edge() {

		DesiredCapabilities dc = DesiredCapabilities.edge();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		dc.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		dc.acceptInsecureCerts();
		dc.setJavascriptEnabled(true);
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
		dc.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
		dc.setCapability("EnableNativeEvents", false);
		dc.setCapability("ignoreZoomSetting", true);
		dc.setCapability("pageLoadStrategy", "eager");

		return dc;
	}

}
