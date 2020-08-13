package com.prenetics.setup;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.prenetics.common.utility.SystemProperty;

public class BrowserOptions {

	public static ChromeOptions getChromeOptions() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		String headless = String.valueOf(SystemProperty.getIsHeadless());
		if (headless.equalsIgnoreCase("true")) {
			options.addArguments("--headless");
		}
		return options;
	}

	public static FirefoxOptions getFirefoxOptions() {

		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--start-maximized");
		String headless = String.valueOf(SystemProperty.getIsHeadless());
		if (headless.equalsIgnoreCase("true")) {
			options.addArguments("--headless");
		}
		return options;
	}

	public static EdgeOptions getEdgeOptions() {

		EdgeOptions options = new EdgeOptions();
		options.merge(BrowserCapabilities.Edge());

		return options;
	}

}
