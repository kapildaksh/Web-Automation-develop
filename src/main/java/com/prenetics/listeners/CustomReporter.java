package com.prenetics.listeners;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.HTMLReporter;

import com.prenetics.reporting.SendEmail;

public class CustomReporter extends HTMLReporter {

	private final static Logger logger = Logger.getLogger(CustomReporter.class);

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectoryName) {
		super.generateReport(xmlSuites, suites, outputDirectoryName);

		try {
			logger.info("Generating report");
			SendEmail.execute();
			logger.info("Report generated");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}