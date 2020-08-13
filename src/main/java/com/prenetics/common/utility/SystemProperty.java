package com.prenetics.common.utility;

import org.apache.log4j.Logger;

public class SystemProperty {

	private final static Logger logger = Logger.getLogger(SystemProperty.class);
	private static boolean isMac, isLinux, isWindows, isChrome;
	private static String osName, browserName;

	static {
		osName = getSystemPropertyValue(Constants.SystemProperties.OS_NAME);
		browserName = getSystemPropertyValue(Constants.SystemProperties.BROWSER);
		isChrome = browserName != null && browserName.equalsIgnoreCase(Constants.Browser.CHROME);
		isMac = osName.toLowerCase().contains("mac");
		isLinux = osName.toLowerCase().contains("linux");
		isWindows = osName.toLowerCase().contains("windows");
	}

	public static String getBrowser() {
		return getSystemPropertyValue(Constants.SystemProperties.BROWSER).toUpperCase();
	}

	public static void setBrowser(String value) {
		setSystemPropertyValue(Constants.SystemProperties.BROWSER, value);
	}

	public static String getIsHeadless() {
		return getSystemPropertyValue(Constants.SystemProperties.isHEADLESS);
	}

	public static void setIsHeadless(String value) {
		setSystemPropertyValue(Constants.SystemProperties.isHEADLESS, value);
	}

	public static String getChromeDriver() {
		return getSystemPropertyValue(Constants.SystemProperties.CHROME_DRIVER);
	}

	public static void setChromeDriver(String value) {
		setSystemPropertyValue(Constants.SystemProperties.CHROME_DRIVER, value);
	}
	
	public static void setEdgeDriver(String value) {
		setSystemPropertyValue(Constants.SystemProperties.EDGE_DRIVER, value);
	}

	public static String getCountry() {
		return getSystemPropertyValue(Constants.SystemProperties.COUNTRY).toUpperCase();
	}

	public static void setCountry(String value) {
		setSystemPropertyValue(Constants.SystemProperties.COUNTRY, value);
	}

	public static String getEnvironment() {
		return getSystemPropertyValue(Constants.SystemProperties.ENVIRONMENT).toUpperCase();
	}

	public static void setEnvironment(String value) {
		setSystemPropertyValue(Constants.SystemProperties.ENVIRONMENT, value);
	}

	public static String getExecution() {
		return getSystemPropertyValue(Constants.SystemProperties.EXECUTION).toUpperCase();
	}

	public static void setExecution(String value) {
		setSystemPropertyValue(Constants.SystemProperties.EXECUTION, value);
	}

	public static String getGeckoDriver() {
		return getSystemPropertyValue(Constants.SystemProperties.GECKO_DRIVER);
	}

	public static void setGeckoDriver(String value) {
		setSystemPropertyValue(Constants.SystemProperties.GECKO_DRIVER, value);
	}

	public static String getHomeUrl() {
		return getSystemPropertyValue(Constants.SystemProperties.HOME_URL);
	}

	public static String getIEDriver() {
		return getSystemPropertyValue(Constants.SystemProperties.IE_DRIVER);
	}

	public static void setIEDriver(String value) {
		setSystemPropertyValue(Constants.SystemProperties.IE_DRIVER, value);
	}

	public static String getOSName() {
		if (osName == null) {
			osName = getSystemPropertyValue(Constants.SystemProperties.OS_NAME);
		}
		return osName;
	}

	public static String getSuiteXmlFile() {
		return getSystemPropertyValue(Constants.SystemProperties.SUITEXML);
	}

	private static String getSystemPropertyValue(String key) {
		String property = System.getProperty(key);
		String value = (property != null) ? property.trim() : null;
		logger.info(String.format("getSystemPropertyValue :: [ %s ]==>[ %s ]", key, value));
		return value;
	}

	public static String getUserHomePath() {
		return getSystemPropertyValue(Constants.SystemProperties.USER_HOME);
	}


	public static boolean isChromeBrowser() {
		return isChrome;
	}

	public static boolean isLinuxSystem() {
		return isLinux;
	}

	public static boolean isMacSystem() {
		return isMac;
	}

	public static boolean isRunningLocally() {
		return getExecution().equalsIgnoreCase(Constants.Execution.LOCAL);
	}

	public static boolean isRunningRemotely() {
		return getExecution().equalsIgnoreCase(Constants.Execution.REMOTE);
	}
	public static boolean isWindowsSystem() {
		return isWindows;
	}

	public static void setReportNgEscapeOutput(String value) {
		setSystemPropertyValue(Constants.SystemProperties.REPORTNG_ESCAPE_OUTPUT, value);
	}

	private static void setSystemPropertyValue(String key, String value) {
		logger.info(String.format("setSystemPropertyValue :: [ %s ]==>[ %s ]", key, value));
		System.setProperty(key, value);
	}

}
