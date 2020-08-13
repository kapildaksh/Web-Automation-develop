package com.prenetics.cucumber.hooks;

import static org.apache.commons.io.FileUtils.readFileToByteArray;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;

import com.prenetics.common.utility.AShotScreenCapture;
import com.prenetics.common.utility.ReadPropertiesFile;
import com.prenetics.common.utility.SystemProperty;
import com.prenetics.common.utility.browser.WebDriverLogs;
import com.prenetics.exception.InfraException;
import com.prenetics.setup.BrowserSetup;
import com.prenetics.setup.DriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class Hooks {

    private final static Logger logger = Logger.getLogger(Hooks.class);
    private BrowserSetup bs = new BrowserSetup();
    protected final ReadPropertiesFile config = new ReadPropertiesFile();
    @After
    public void after(Scenario scenario) {

        WebDriver driver = DriverManager.getDriver();

        try {
            takeScreenshot(scenario);
            if (scenario.getStatus().equalsIgnoreCase("failed")) {
                logger.info(
                        "\uD83D\uDE29\uD83D\uDE29\uD83D\uDE29 RESULT : FAILED \uD83D\uDE29\uD83D\uDE29\uD83D\uDE29");
                printConsoleLogs();
                // if (!SystemProperty.isRunningLocally()) printPerfLogs();
            } else if (scenario.getStatus().equalsIgnoreCase("passed")) {
                logger.info(
                        "\uD83D\uDE04\uD83D\uDE04\uD83D\uDE04 RESULT : PASSED \uD83D\uDE04\uD83D\uDE04\uD83D\uDE04");
            }
            logger.info("-------------------------------------------------");
            logger.info("COMPLETED SCENARIO");
            logger.info(scenario.getName());
            logger.info("-------------------------------------------------");

        } catch (Exception e) {
            logger.error("\uD83D\uDE04\uD83D Exception occurred in @After step");
            logger.error(e.getMessage());
            logger.error("==== BEGINNING STACK TRACE ====");
            e.printStackTrace();
        } finally {
            if (driver != null) {
                bs.quitDriver(driver);
            }
        }

    }

    @Before
    public void before(Scenario scenario) throws Exception {

        logger.info("-------------------------------------------------");
        logger.info("START SCENARIO");
        logger.info(scenario.getName());
        logger.info("-------------------------------------------------");
        RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = config.testBaseUrl();
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		        int attempt = 1, maxAttempt = 3;
        boolean success = false;

        while (!success && attempt <= maxAttempt) {
            try {
                logger.info("=== Browser init attempt #" + attempt++ + " ===");
                bs.initiateBrowser(SystemProperty.getBrowser(), SystemProperty.getExecution());

               

                success = true;
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }

        if (!success) {
            String errorMessage = "\uDE29\uD83D\uDE29 Browser init failed after " + maxAttempt + " attempts \uDE29\uD83D\uDE29";
            logger.error(errorMessage);
            throw new InfraException(errorMessage);
        }
    }

    private void printConsoleLogs() {

        WebDriverLogs webDriverLogs = new WebDriverLogs(DriverManager.getDriver(), LogType.BROWSER);
        webDriverLogs.printLogEntries();
    }

    @SuppressWarnings("unused")
	private void printPerfLogs() {

        WebDriverLogs webDriverLogs = new WebDriverLogs(DriverManager.getDriver(), LogType.PERFORMANCE);
        webDriverLogs.printLogEntries();
    }

    private void takeScreenshot(Scenario scenario) {

        WebDriver driver = DriverManager.getDriver();
        File scrFile = null;

        if (!scenario.isFailed() && scenario.getStatus().equalsIgnoreCase("passed")) {
            scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        } else if (scenario.isFailed() && scenario.getStatus().equalsIgnoreCase("failed")) {
            if (SystemProperty.isChromeBrowser()) {
                AShotScreenCapture as = new AShotScreenCapture();
                scrFile = as.captureFullScreenShot(driver);
            } else {
                scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            }
        }
        try {
            if (scrFile != null)
                scenario.embed(readFileToByteArray(scrFile), "image/png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
