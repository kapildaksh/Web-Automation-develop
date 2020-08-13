package com.prenetics.pagefactory.circle;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.prenetics.common.utility.CommonUtility;
import com.prenetics.common.utility.DataBaseConnector;

public class CircleTrackKitStatusPage {

	WebDriverWait wait;
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//div[@class='track-kit-progress-box']//app-track-kit-verticle-progress[1]//article[1]//div[2]//figure[1]//i[1]")
	WebElement kitActivated;

	@FindBy(how = How.XPATH, using = "//div[@class='track-kit-progress-box']//app-track-kit-verticle-progress[2]//article[1]//div[2]//figure[1]//i[1]")
	WebElement sampleArrivedToLab;
	
	@FindBy(how = How.XPATH, using = "//div[@class='track-kit-progress-box']//app-track-kit-verticle-progress[3]//article[1]//div[2]//figure[1]//i[1]")
	WebElement kitIsInProcessing;

	@FindBy(how = How.XPATH, using = "//article[@class='media success last-element']//i[@class='fa fa-check-circle fa-4x']")
	WebElement resultReady;

	@FindBy(how = How.XPATH, using = "//img[@alt='circle dna']")
	WebElement circleDnaLogo;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Track Sample')]")
	WebElement trackSampleButton;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'View Report')]")
	WebElement viewReportButton;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/user/test-result/circle-4/cancer-report']//button[@class='button is-orange text-bold'][contains(text(),'View Report')]")
	WebElement cancerViewReportButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='tag text-bold is-light']")
	WebElement inProgressBtn;

	public CircleTrackKitStatusPage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	
	public void extractSampleQueryToInsert(String query, String connectionURL, String productCode) {
		try {
			DataBaseConnector.executeSQLQueryToInsert(query, connectionURL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reportCompleteQueryToInsert(String query, String connectionURL, String productCode) {

		try {
			DataBaseConnector.executeSQLQueryToInsert(query, connectionURL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reportGenerateQueryToInsert(String query, String connectionURL, String productCode) {
		try {
			DataBaseConnector.executeSQLQueryToInsert(query, connectionURL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void isKitActivationTickGreen() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(kitActivated));
		kitActivated.isDisplayed();
	}

	public void isSampleArrivedTickGreen() {
		wait.until(ExpectedConditions.visibilityOf(kitActivated));
		kitActivated.isDisplayed();
		sampleArrivedToLab.isDisplayed();
	}

	public void isSampleInProcesssTickGreen()  {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(kitActivated));
		kitActivated.isDisplayed();
		sampleArrivedToLab.isDisplayed();
		kitIsInProcessing.isDisplayed();
	}

	public void isReportReadyTickGreen() throws InterruptedException {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(kitActivated));
		kitActivated.isDisplayed();	
		sampleArrivedToLab.isDisplayed();		
		kitIsInProcessing.isDisplayed();	
		resultReady.isDisplayed();
		
			
	}

	public void clickCircleLogo() {
		circleDnaLogo.click();
		driver.navigate().refresh();
	}

	public void clickTrackSampleBtn() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(trackSampleButton));
		trackSampleButton.click();
		wait.until(ExpectedConditions.visibilityOf(kitActivated));
	}

	public void isViewReportBtnPresent() {
		wait.until(ExpectedConditions.visibilityOf(viewReportButton));
		viewReportButton.isDisplayed();
	}
	
	public void cancerFromComboIsInProgess() {
		wait.until(ExpectedConditions.visibilityOf(inProgressBtn));
		inProgressBtn.isDisplayed();
	}

	public void cancerViewReportBtnPresent() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(cancerViewReportButton));
		cancerViewReportButton.isDisplayed();
		
	}
}
