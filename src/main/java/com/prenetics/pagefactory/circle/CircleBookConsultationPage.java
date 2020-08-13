package com.prenetics.pagefactory.circle;
import java.util.List;
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

public class CircleBookConsultationPage {

	WebDriverWait wait;
	private WebDriver driver = DriverManager.getDriver();

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'View Report')]")
	WebElement viewReportButton;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-link text-bold']")
	WebElement scheduleAppointmnetButton;

	@FindBy(how = How.XPATH, using = "//select[@formcontrolname=\"timeZone\"]")
	WebElement selectCountryDropDown;

	@FindBy(how = How.XPATH, using = "//span[@class='mydpicon icon-mydpcalendar']")
	WebElement schedulAppointmentDatePickup;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'date-list-selecting-container')]")
	List<WebElement> availableTimeslots;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Update Mobile Number')]")
	WebElement updatePhoneNumberBtn;

	@FindBy(how = How.XPATH, using = "//button[contains(@type,'submit')]")
	WebElement doneUpadtePhoneButton;

	@FindBy(how = How.XPATH, using = "//p[contains(@class,'help is-danger')]")
	WebElement emtpyPhoneNumberValidation;

	@FindBy(how = How.XPATH, using = "//input[@name=\"phoneNumber\"]")
	WebElement phoneNumberTextbox;

	@FindBy(how = How.XPATH, using = "//button[contains(@type,'submit')]")
	WebElement bookAppointmentBtn;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),\"Kapil, we've scheduled your consultation\")]")
	WebElement appointmentConfirmationMsg;

	@FindBy(how = How.XPATH, using = "//button[contains(@type,'submit')]")
	WebElement goBackToCircle;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-link text-bold']")
	WebElement viewAppointmentDetails;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Reschedule')]")
	WebElement appointmentRescheduleBtn;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel Appointment')]")
	WebElement appointmentCancelBtn;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'modal reschedule-confirmation-modal is-active')]//button[contains(@type,'button')][contains(text(),'Yes')]")
	WebElement appointmentResheduleConfirmation;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'modal cancellation-confirmation-modal is-active')]//button[contains(@type,'button')][contains(text(),'Yes')]")
	WebElement appointmentCancelConfirmation;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please select your country')]")
	WebElement countryErrorValidation;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please select a date that works for you')]")
	WebElement dateErrorValidation;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please select a time that works for you')]")
	WebElement TimeErrorValidation;

	@FindBy(how = How.XPATH, using = "//tbody//tr//td[@class='daycell currmonth tablesingleday']/div[@class='datevalue currmonth']/span")
	List<WebElement> availableDays;

	@FindBy(how = How.XPATH, using = "//div[@class='column is-3 is-12-mobile timeslot-item'][1]")
	WebElement selectTimeslote;
	
	@FindBy(how = How.XPATH, using = "//div[@class='modal cancellation-confirmation-modal is-active']//div[@class='box']")
	WebElement clickOnCacelConfirmationPopup;
	
	@FindBy(how = How.XPATH, using = "//div[@class='modal reschedule-confirmation-modal is-active']//div[@class='box']")
	WebElement clickOnRescheduleConfirmationPopup;
	
	
	@FindBy(how = How.XPATH, using = "//nav[@class='breadcrumb has-succeeds-separator']//ul")
	WebElement appointDetailsBreadcrumb;
	

	public CircleBookConsultationPage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void clickViewReportBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(viewReportButton));
		viewReportButton.click();
	}

	public void clickScheduleAppointmentBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(scheduleAppointmnetButton));
		scheduleAppointmnetButton.click();
	}

	public void clickUpdatePhoneNumber() {
		wait.until(ExpectedConditions.elementToBeClickable(updatePhoneNumberBtn));
		updatePhoneNumberBtn.click(); 
	}

	public void clickDoneUpdatePhoneButton() {
		wait.until(ExpectedConditions.elementToBeClickable(doneUpadtePhoneButton));
		doneUpadtePhoneButton.click();
	}

	public void emptyPhoneErrorValidation() {
		Assert.assertEquals(emtpyPhoneNumberValidation.getText(), "Please enter a valid area code and mobile number");
	}

	public void enterPhonenNumber() {
		phoneNumberTextbox.clear();
		phoneNumberTextbox.sendKeys("85255398628");
	}

	public void selectCountry(String country) {
		//.until(ExpectedConditions.elementToBeSelected(selectCountryDropDown));
		//selectCountryDropDown.click();
		new Select(selectCountryDropDown).selectByVisibleText(country);
	}

	public void errorValidation() {
		Assert.assertEquals(countryErrorValidation.getText(), "Please select your country");
		Assert.assertEquals(dateErrorValidation.getText(), "Please select a date that works for you");
		Assert.assertEquals(TimeErrorValidation.getText(), "Please select a time that works for you");
	}

	public void clickOnAvailableTimeSlot() {
		wait.until(ExpectedConditions.elementToBeClickable(selectTimeslote));
		selectTimeslote.click();
	}

	public void clickBookAppointmentBtn() {
		bookAppointmentBtn.click();
	}

	public void appointmentSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOf(appointmentConfirmationMsg));
		Assert.assertEquals(appointmentConfirmationMsg.getText(), "Kapil, we've scheduled your consultation");
	}

	public void clickGoBackToCircleButton() {
		goBackToCircle.click();
	}
	
	public void clickViewAppointmentDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(viewAppointmentDetails));
		viewAppointmentDetails.click();
	}
	
	public void clickAppointmentRescheduleBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(appointmentRescheduleBtn));
		appointmentRescheduleBtn.click();
		wait.until(ExpectedConditions.visibilityOf(clickOnRescheduleConfirmationPopup));
		clickOnRescheduleConfirmationPopup.click();
		appointmentResheduleConfirmation.click();
	}
	
	public void clickAppointmentCancelBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(appointmentCancelBtn));
		appointmentCancelBtn.click();
		wait.until(ExpectedConditions.visibilityOf(clickOnCacelConfirmationPopup));
		clickOnCacelConfirmationPopup.click();
		appointmentCancelConfirmation.click();
	}
	
	public void isAppointmentDetailsPage() {
		appointDetailsBreadcrumb.isDisplayed();
	}
	
	public void isUserDashboardPage() {
		wait.until(ExpectedConditions.visibilityOf(viewReportButton));
		viewReportButton.isDisplayed();
	}
}
