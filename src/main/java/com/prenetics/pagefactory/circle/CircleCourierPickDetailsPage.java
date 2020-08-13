package com.prenetics.pagefactory.circle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.monte.media.tiff.DateValueFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.prenetics.common.utility.CommonUtility;
import com.prenetics.setup.DriverManager;

public class CircleCourierPickDetailsPage {
	WebDriverWait wait;
	private WebDriver driver = DriverManager.getDriver();

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Return Sample')]")
	WebElement returnSampleButton;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Schedule Courier Pickup')]")
	WebElement courierPickupHeaderPage;

	@FindBy(how = How.XPATH, using = "//select[@id='country-select']")
	WebElement selectCountryDropdown;

	@FindBy(how = How.XPATH, using = "//select[@class='ng-untouched ng-pristine ng-invalid']")
	WebElement selectDistrictDropdown;

	@FindBy(how = How.XPATH, using = "//span[@class='mydpicon icon-mydpcalendar']")
	WebElement selectPickupScheduleDate;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Room, Floor, Block']")
	WebElement selectAddreesLineOne;

	@FindBy(how = How.XPATH, using = "//input[@id='street-input']")
	WebElement selectAddreesLineTwo;

	@FindBy(how = How.XPATH, using = "//input[@name='fullName']")
	WebElement enterFullName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='e.g. +852 1234-1234']")
	WebElement enterPhoneNumber;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement clickSchedulePickupButton;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement clickNextBtn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'text-bold is-height is-full-width')]")
	WebElement clickBackButton;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Before the courier arrives, make sure you have:')]")
	WebElement reminderPageHeaderText;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'button is-orange text-bold is-full-width is-height')]")
	WebElement clickGotItButton;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Your courier pickup is scheduled!')]")
	WebElement pickupConfirmationText;

	@FindBy(how = How.XPATH, using = "//input[@class='selection inputnoteditable ng-untouched ng-pristine ng-valid']")
	WebElement dateField;

	@FindBy(how = How.XPATH, using = "//div[@class='selector selectorarrow selectorarrowleft']/table[@class='caltable']/tbody/tr/td[contains(@class,'tablesingleday')]/div/span")
	List<WebElement> availableDays;

	@FindBy(how = How.XPATH, using = "//a[@class='button back-button is-orange text-bold is-height is-full-width']")
	WebElement backToMyResultsBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-orange text-bold'][contains(text(),'View Pickup Details')]")
	WebElement viewPickupDetails;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Modify')]")
	WebElement modifyPickupBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='box']")
	WebElement reschedulePickupConfirmationPopup;

	@FindBy(how = How.XPATH, using = "//button[@type='button']")
	WebElement yesToReschedulingConfirmationPopup;

	@FindBy(how = How.XPATH, using = "/h1[contains(text(),'Schedule Courier Pickup')]")
	WebElement isSchedulePickuppage;
	
	@FindBy(how = How.XPATH, using = "//h2[@class='subtitle' and text()='Mail Back']")
	WebElement returnTipsForSingapore;
	
	@FindBy(how = How.XPATH, using = "//a[@class='button back-button text-bold is-height is-full-width']")
	WebElement backBtnSingpaoreReturnTips;
	
	@FindBy(how = How.XPATH, using = "//tr//td[1]//div[1]//div[3]//button[1]")
	WebElement nextMonthButton;
	
	

	public CircleCourierPickDetailsPage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void clickGoBackToMyResulBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(backToMyResultsBtn));
		backToMyResultsBtn.click();
	}

	public void IsViewPickupDetailsBtnPresent() {
		wait.until(ExpectedConditions.elementToBeClickable(viewPickupDetails));
		viewPickupDetails.isDisplayed();
	}

	public void clickPickupDetailsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(viewPickupDetails));
		viewPickupDetails.isDisplayed();
		viewPickupDetails.click();
	}

	public void clickOnModifyPickupBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(modifyPickupBtn));
		modifyPickupBtn.click();
		reschedulePickupConfirmationPopup.click();
		yesToReschedulingConfirmationPopup.click();
	}
	
	public void selectPickupCountry(){
		wait.until(ExpectedConditions.visibilityOf(selectCountryDropdown));
		new Select(selectCountryDropdown).selectByVisibleText("Singapore");
		clickNextBtn.click();
		returnTipsForSingapore.isDisplayed();
		backBtnSingpaoreReturnTips.click();
		wait.until(ExpectedConditions.visibilityOf(selectCountryDropdown));
		new Select(selectCountryDropdown).selectByVisibleText("Hong Kong");
		clickNextBtn.click();
	}

	public void enterPickupDetails() throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(selectDistrictDropdown));
		new Select(selectDistrictDropdown).selectByIndex(2);
		selectAddreesLineOne.sendKeys("108 Austin road");
		selectAddreesLineTwo.sendKeys("Kowloon");
		enterFullName.sendKeys("test Automation");
		enterPhoneNumber.sendKeys("85255398621");

	}

	public void clickSchedulePickButton() {
		clickSchedulePickupButton.isEnabled();
		clickSchedulePickupButton.click();
	}

	public void clickBackButton() {
		clickBackButton.isEnabled();
		clickBackButton.click();
	}

	public void isReminderHeaderText() {
		reminderPageHeaderText.isDisplayed();
	}

	public void clickGotItButton() {
		wait.until(ExpectedConditions.elementToBeClickable(clickGotItButton));
		clickGotItButton.click();
	}

	public void isPickupSchedulePage() {
		wait.until(ExpectedConditions.visibilityOf(isSchedulePickuppage));
		isSchedulePickuppage.isDisplayed();
		Assert.assertEquals(isSchedulePickuppage.getText(), "Schedule Courier Pickup");
	}

	public void clickReturnSampleButton() {
		driver.switchTo().defaultContent();
		returnSampleButton.isDisplayed();
		returnSampleButton.click();
	}

	public void pickupConfirmation() {
		pickupConfirmationText.isDisplayed();
		Assert.assertEquals(pickupConfirmationText.getText(), "Your courier pickup is scheduled!");
	}

	public void selectDate(WebDriver driver, int days) throws InterruptedException {
		selectPickupScheduleDate.click();
		SimpleDateFormat df = new SimpleDateFormat("d");
		Date dt = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);
		cl.add(Calendar.DAY_OF_YEAR, days);
		while (cl.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cl.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cl.add(Calendar.DATE, 1);
		}
		dt = cl.getTime();
		String dateVal = df.format(dt);	
		if(availableDays.size()==0)
			nextMonthButton.click();
		for (WebElement d : availableDays) {
			if (d.getText().equals(dateVal)) {
				d.click();
				return;
			}
		}
	}
}
