package com.prenetics.common.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prenetics.common.utility.browser.LocalStorage;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import com.prenetics.common.utility.ReadPropertiesFile;

public class CommonUtility {

	private static final Logger logger = Logger.getLogger(CommonUtility.class);

	private static final ReadPropertiesFile PROPS = new ReadPropertiesFile();

	public static void clearCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	public ReadPropertiesFile getProps() {
		return PROPS;
	}

	private final ThreadLocal<Map<String, String>> storage = ThreadLocal.withInitial(HashMap::new);

	public String getValue(String name) {
		return System.getProperty(name, storage.get().get(name));
	}

	public String setValue(String name, String value) {
		return storage.get().put(name, value);
	}

	public static void clearLocalStorage(WebDriver driver) {
		(new LocalStorage(driver)).clearLocalStorage();
	}

	public static String getDomainNameFromURL(String url) {

		String domainName = "";

		try {
			URL urlLink = new URL(url);
			domainName = urlLink.getHost();
			domainName = domainName.startsWith("www.") ? domainName.substring(4) : domainName;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return domainName;
	}

	public static By getElementLocator(String locatorInfo) {
		return LocatorProcessor.getElementLocator(locatorInfo);
	}

	public static String getInnerHTML(final WebDriver driver, WebElement ele) {
		String contents = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", ele);
		return contents;
	}

	public static int getRandomIntegerInclusive(int low, int high) {
		if (low > high) {
			int temp = low;
			low = high;
			high = temp;
		}
		return low + ((int) Math.floor(Math.random() * (high - low + 1)));
	}

	public static void highlight(WebDriver driver, WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", ele);
	}

	public static void scrollIntoView(final WebDriver driver, WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
	}

	public static void waitForElementToClickable(final WebDriver driver, WebElement ele, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitForElementToVisible(final WebDriver driver, WebElement ele, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForPageLoad(WebDriver driver) {
		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static void waitForSeconds(int seconds) {
		waitForSeconds(seconds * 1.0);
	}

	public static void waitForSeconds(double seconds) {
		try {
			Thread.sleep((long) Math.floor(1000 * seconds));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void waitTillURL(WebDriver driver, String url, int seconds) {
		try {
			logger.info(String.format("Wait for page to reach URL [ %s ]", url));
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.urlToBe(url));
		} catch (TimeoutException ex) {
			logger.warn(String.format(
					"Not reaching URL [ %s ] after [ %d ] seconds. Page lod time is longer than expected?", url,
					seconds));
		}
	}

	public static void waitTillURLContains(WebDriver driver, String urlFraction, int seconds) {
		try {
			logger.info(String.format("Wait for URL fraction [ %s ] to appear", urlFraction));
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.urlContains(urlFraction));
		} catch (TimeoutException ex) {
			logger.warn(String.format(
					"Not reaching URL fraction [ %s ] after [ %d ] seconds. Page lod time is longer than expected?",
					urlFraction, seconds));
		}
	}

	public static String getEmailString() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long time = timestamp.getTime();
		String email = "test-automation+"+time+ "@prenetics.com";
		return email;
	}

}