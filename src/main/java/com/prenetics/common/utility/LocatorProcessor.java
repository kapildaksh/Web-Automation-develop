package com.prenetics.common.utility;

import org.openqa.selenium.By;

import java.util.Arrays;

public class LocatorProcessor {

	private String by;
	private String using;

	private LocatorProcessor(String locatorInfoString) {
		String[] split = locatorInfoString.split(":", 2);
		assert split.length == 2;

		setInfo(split[0], split[1]);
	}

	private LocatorProcessor(String by, String using) {
		setInfo(by, using);
	}

	private LocatorProcessor(By locator) {
		this(locator.toString().replace("By.", "").trim());
	}

	public static By getCombinedXPathLocators(By... locators) {
		if (locators.length <= 1) {
			return locators[0];
		} else if (locators.length == 2) {
			return getCombinedXPathLocators(locators[0], locators[1]);
		} else {
			return getCombinedXPathLocators(locators[0],
					getCombinedXPathLocators(Arrays.copyOfRange(locators, 1, locators.length)));
		}
	}

	public static By getElementLocator(String locatorInfoString) {
		return (new LocatorProcessor(locatorInfoString)).getElementLocator();
	}

	private static By getCombinedXPathLocators(By first, By second) {
		LocatorProcessor firstLocator = new LocatorProcessor(first),
				secondLocator = new LocatorProcessor(second);
		assert firstLocator.by.equals(secondLocator.by) && secondLocator.by.equals("xpath");
		return (new LocatorProcessor("xpath", firstLocator.using + secondLocator.using)).getElementLocator();
	}

	private By getElementLocator() {
		By locator = null;
		switch (by) {
			case "id":
				locator = By.id(using);
				break;
			case "classname":
				locator = By.className(using);
				break;
			case "name":
				locator = By.name(using);
				break;
			case "cssselector":
				locator = By.cssSelector(using);
				break;
			case "linktext":
				locator = By.linkText(using);
				break;
			case "partiallinktext":
				locator = By.partialLinkText(using);
				break;
			case "tagname":
				locator = By.tagName(using);
				break;
			case "xpath":
				locator = By.xpath(using);
				break;
		}
		return locator;
	}

	private void setInfo(String by, String using) {
		this.by = by.toLowerCase().trim();
		this.using = using.trim();
	}
}
