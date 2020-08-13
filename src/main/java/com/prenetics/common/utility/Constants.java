package com.prenetics.common.utility;

public class Constants {

	public static final class Alfresco {

		public static final class Environment {
			public static final String INTEGRATION = "Integration";
			public static final String PREVIEW = "Preview";
			public static final String PROD = "Production";
			public static final String QA = "QA";
			public static final String STAGING = "Staging";
		}

		public static final class Login {
			public static final String PASSWORD = "bm93dGVzdGluZ2ZvcmNnZ2F1dG9tYXRpb24=";
			public static final String USERNAME = "cGlwcGluLmNoYW50aGFuYXNvbWJ1dA==";
		}

		public static final class SiteName {
			public static final String PRENETICS = "PreneticsWebAutomation";
		}

		public static final class Url {
		public static final String QA = "https://testing-app.circledna.com/signin";
		public static final String DNAFIT="https://testing-app.circledna.com/order?product=circle-3&lang=en&currency=hkd";
		public static final String CANCER="https://testing-app.circledna.com/order?product=circle-4&lang=en&currency=hkd";
		public static final String CIRCLECOMBO="https://testing-app.circledna.com/order?product=circle-5&lang=en&currency=hkd";
			public static final String PROD = "https://testing-app.circledna.com/signin";
		}
	}

	public static final class Browser {
		public static final String CHROME = "ch";
		public static final String FIREFOX = "ff";
		public static final String INTERNET_EXPLORER = "ie";
		public static final String EDGE = "edge";
	}

	public static final class ConfigProperties {
		public static final String CONFIG_FILE_NAME = "config.properties";
		public static final String GRID_URL = "gridURL";
		public static final String GRID_DEV_URL = "gridDevURL";
		public static final String LOCAL_LINUX_CHROME_DRIVER = "localLinuxChromeDriver";
		public static final String LOCAL_LINUX_FIREFOX_DRIVER = "localLinuxFirefoxDriver";
		public static final String LOCAL_MACOS_CHROME_DRIVER = "localMacOSChromeDriver";
		public static final String LOCAL_MACOS_FIREFOX_DRIVER = "localMacOSFirefoxDriver";
		public static final String LOCAL_WINDOWS_CHROME_DRIVER = "localWindowsChromeDriver";
		public static final String LOCAL_WINDOWS_FIREFOX_DRIVER = "localWindowsFirefoxDriver";
		public static final String LOCAL_WINDOWS_IE_DRIVER = "localWindowsIEDriver";
		public static final String LOCAL_WINDOWS_EDGE_DRIVER = "localWindowsEdgeDriver";
		public static final String CONFIG_ENDPOINT_NAME = System.getProperty("user.dir")+"/config.properties";;
	}

	public static final class Environment {
		public static final String INTEGRATION = "int";
		public static final String PROD = "prod";
		public static final String QA = "qa";
		public static final String STAGING = "stg";
	}

	public static final class Execution {
		public static final String LOCAL = "local";
		public static final String REMOTE = "remote";
		public static final String REMOTE_DEV = "remotedev";
	}

	public static final class Lead {
		public static final String PRENETICS_AUTOQA_EMAIL = "kapil+circle@prenetics.com";
		public static final String PRENETICS_AUTOQA_FIRSTNAME = "Automated";
		public static final String PRENETICS_AUTOQA_LASTNAME = "QA";
	}

	public static final class SystemProperties {
		public static final String BROWSER = "browser";
		public static final String CHROME_DRIVER = "webdriver.chrome.driver";
		public static final String COUNTRY = "country";
		public static final String ENVIRONMENT = "environment";
		public static final String EXECUTION = "execution";
		public static final String GECKO_DRIVER = "webdriver.gecko.driver";
		public static final String HOME_URL = "homeUrl";
		public static final String IE_DRIVER = "webdriver.ie.driver";
		public static final String EDGE_DRIVER = "webdriver.edge.driver";
		public static final String OS_NAME = "os.name";
		public static final String REPORTNG_ESCAPE_OUTPUT = "org.uncommons.reportng.escape-output";
		public static final String SUITEXML = "suiteXmlFile";
		public static final String USER_HOME = "user.home";
		public static final String isHEADLESS = "isHeadless";
	}

	public static final class Timeout {
		public static final int HTTP_REQUEST = 3000;
	}
}