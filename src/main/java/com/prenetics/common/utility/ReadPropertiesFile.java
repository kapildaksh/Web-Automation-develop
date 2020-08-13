
package com.prenetics.common.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	private interface Props {
		String getProperty(String name);
	}

	private static final String PROPERTY_FILE_PATH = Constants.ConfigProperties.CONFIG_ENDPOINT_NAME;
	private final Props properties;

	public ReadPropertiesFile() {
		this.properties = getProps();
	}

	Props getProps() {
		Properties properties = new Properties();

		try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {
			properties.load(reader);
		} catch (IOException e) {
			throw new RuntimeException("Cannot load property", e);
		}

		return new Props() {
			@Override
			public String getProperty(String name) {
				return System.getProperty(name, properties.getProperty(name));
			}
		};
	}

	public String testBaseUrl() {
		return properties.getProperty("testBaseUrl");
	}

	public String getPropertyValue(String propperty) {
		return properties.getProperty(propperty);
	}

	public String testLabDataBaseURL() {
		return properties.getProperty("databaseURLTestLab");
	}

	public String testIdentityServerURL() {
		return properties.getProperty("databaseURLTestIdentityServer");
	}
	
	
}
