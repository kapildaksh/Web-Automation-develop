package com.prenetics.common.utility.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import com.prenetics.common.utility.SystemProperty;

import java.util.Date;


public class WebDriverLogs {

    private final static Logger logger = Logger.getLogger(WebDriverLogs.class);
    private final WebDriver driver;
    private final String logType;

    public WebDriverLogs(WebDriver driver, String logType) {
        this.driver = driver;
        this.logType = logType;
    }

    public void printLogEntries() {
        LogEntries logEntries = getLogEntries();
        if (logEntries != null) {
            System.out.println("================================");
            System.out.println(logType + " LOG");
            System.out.println("================================");
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("================================");
        }
    }

    private LogEntries getLogEntries() {
        LogEntries logEntries = null;
        if (SystemProperty.isChromeBrowser()) {
            logEntries = driver.manage().logs().get(logType);
        } else {
            logger.info("Browser log is not implemented for browser : " + SystemProperty.getBrowser());
        }
        return logEntries;
    }
}