package com.prenetics.pagefactory.circle;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.prenetics.common.utility.CommonUtility;

public class CircleDownloadReportsPage{
	
	WebDriverWait wait;
	private WebDriver driver;
	private String emailID;
	
	@FindBy(how = How.XPATH, using = "//button[@class='button is-orange text-bold is-have-shadow is-small-wide download-report-button']")
	WebElement downloadReportBtn;
 
	@FindBy(how = How.XPATH, using = "//div[@class='select is-full-width is-have-shadow download-report-language-dropdown']//select")
	WebElement selectLanguageDropdown;
	
	@FindBy(how = How.XPATH, using = "//div[@class='column is-4']//app-sidebar-menu-panel")
	WebElement sideMenu;
	
	@FindBy(how = How.XPATH, using = "//input[@id='old-password-input']")
	WebElement oldPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='new-password-input']")
	WebElement newPassword;
	
	@FindBy(how = How.XPATH, using = "//div[@class='select is-pulled-right is-full-width download-report-language-dropdown']//select")
	WebElement selectReportLang;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-orange text-bold is-small-wide download-report-button']")
	WebElement downloadReportButton;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/user/test-result/circle-3/basic-report']//button[@class='button is-orange text-bold'][contains(text(),'View Report')]")
	WebElement downloadComboDnafitReportButton;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/user/test-result/circle-4/cancer-report']//button[@class='button is-orange text-bold'][contains(text(),'View Report')]")
	WebElement downloadComboCancerReportButton;
	
	
	public CircleDownloadReportsPage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	public void en_clickDownloadReportButton_() {
		new Select(selectLanguageDropdown).selectByIndex(0);
		downloadReportBtn.click();		
	}

	public void hk_clickDownloadReportButton_() {
		new Select(selectLanguageDropdown).selectByIndex(1);
		downloadReportBtn.click();		
	}	
	
	public void cn_clickDownloadReportButton_() {
		new Select(selectLanguageDropdown).selectByIndex(2);
		downloadReportBtn.click();		
	}	
	
	public void en_clickDownloadReportBtn() {
		new Select(selectReportLang).selectByIndex(0);
		downloadReportButton.click();		
	}

	public void hk_clickDownloadReportbtn() {
		new Select(selectReportLang).selectByIndex(2);
		downloadReportButton.click();		
	}	
	
	public void viewComboDnafitReportBtn() {
		downloadComboDnafitReportButton.click();		
	}	
	
	public void viewCombocancerReportBtn() {
		downloadComboCancerReportButton.click();		
	}	
	
	
	public void cn_clickDownloadReportBtn() {
		new Select(selectReportLang).selectByIndex(1);
		downloadReportButton.click();		
	}	
	  public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }
}
