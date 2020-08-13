package com.prenetics.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.prenetics.common.utility.SystemProperty;
import com.prenetics.common.utility.ZipFiles;
import com.prenetics.reporting.GenerateCucumberReport;

public class CucumberReporter {

	private static Logger logger = Logger.getLogger(CucumberReporter.class);
	static GenerateCucumberReport report = new GenerateCucumberReport();

	public static void main(String[] args) {

		String htmlReportPath = "report/", reportZipPath = "reportzip/", cucumberReport = "cucumberreport",
				runnerFolder = "runner",tempFolder="temp", reportArchivePath = getReportArchivePath(), logPath = "log",
				reportFileName = getReportFileName(), reportFilePath = reportZipPath + reportFileName;

		// (1) Generate the report folder
		logger.info("Generate Cucumber Report to : " + reportFileName);
		report.generateCucumberReport(reportFileName);

		try {
			// (2) Zip it
			ZipFiles zip = new ZipFiles();
			FileUtils.cleanDirectory(new File(reportZipPath));
			logger.info("Adding report file to zip directory : " + reportZipPath);
			FileUtils.copyDirectoryToDirectory(new File(logPath), new File(htmlReportPath));
			zip.zipDirectory(new File(htmlReportPath), reportFilePath);

			// (3) Copy to user's local archive
			if (SystemProperty.isRunningLocally()) {
				logger.info("Saving test report ZIP file to : " + reportArchivePath);
				FileUtils.copyFileToDirectory(new File(reportFilePath), new File(reportArchivePath));
			}

		} catch (Exception e) {
			logger.warn("Failed to create report folder");
		}

		// (4) Clean all directories
		try {
			FileUtils.deleteDirectory(new File(htmlReportPath));
		} catch (Exception e) {
			logger.warn("Failed to delete report folder");
		}

		try {
			FileUtils.deleteDirectory(new File(runnerFolder));
		} catch (Exception e) {
			logger.warn("Failed to delete runner folder");
		}

		try {
			FileUtils.deleteDirectory(new File(cucumberReport));
		} catch (Exception e) {
			logger.warn("Failed to delete cucumberreport folder");
		}
		
		try {
			FileUtils.deleteDirectory(new File(tempFolder));
		} catch (Exception e) {
			logger.warn("Failed to delete temp folder");
		}

		try {
			LogManager.shutdown();
			FileUtils.deleteDirectory(new File(logPath));
		} catch (Exception e) {
			logger.warn("Failed to delete log folder");
		}
		

	}

	private static String getCurrentTimestamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime());
	}

	private static String getReportArchivePath() {
		String archivePath = "";

		if (SystemProperty.isWindowsSystem()) {
			archivePath = "Desktop/TestReport";
		} else if (SystemProperty.isMacSystem() || SystemProperty.isLinuxSystem()) {
			archivePath = SystemProperty.getUserHomePath().concat("/Desktop/TestReport");
		}

		return archivePath;
	}

	private static String getReportFileName() {
		String format = "TestReport_%s_%s_%s_%s_%s.zip",
				country = SystemProperty.getCountry().toUpperCase().trim(),
				environment = SystemProperty.getEnvironment().toUpperCase().trim(),
				browser = SystemProperty.getBrowser().trim(), timestamp = getCurrentTimestamp();

		return String.format(format, country, environment, browser, timestamp);
	}
}