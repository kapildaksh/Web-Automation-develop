package com.prenetics.reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;

public class GenerateCucumberReport {

	private static Logger logger = Logger.getLogger(GenerateCucumberReport.class);

	public void generateCucumberReport(String fileName) {

		CucumberDetailedResults results = new CucumberDetailedResults();
		results.setOutputDirectory("report/");
		results.setOutputName(fileName);
		results.setScreenShotLocation("screenshot/image");
		File pathToFiles = new File("cucumberreport/json");
		File[] files = pathToFiles.listFiles();
		List<String> jsonReportFileList = new ArrayList<String>();
		if (files.length == 0) {
			logger.error("The directory is empty");
		} else {
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().substring(files[i].getName().lastIndexOf(".") + 1).equals("json")) {
					jsonReportFileList.add(files[i].getPath());
				}
			}
		}
		results.setSourceFiles(jsonReportFileList.toArray(new String[jsonReportFileList.size()]));
		try {
			results.execute();
		} catch (Exception e) {
			logger.error("Exception occurred while generating Cucumber report.");
		}

	}

}