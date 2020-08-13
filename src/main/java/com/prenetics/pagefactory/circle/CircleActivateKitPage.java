package com.prenetics.pagefactory.circle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.prenetics.common.utility.CommonUtility;
import com.prenetics.setup.DriverManager;

public class CircleActivateKitPage {

	WebDriverWait wait;
	WebDriver driver = DriverManager.getDriver();
	private String emailID;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Activating a kit for kapil')]")
	WebElement activateKitHeaderText;

	@FindBy(how = How.XPATH, using = "//input[@id='barcode-input']")
	WebElement barcodeInputField;

	@FindBy(how = How.XPATH, using = "//div[@class='form-notice failure']")
	WebElement barcodeErrorValidation;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement continueBtnBarcode;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Please review and grant consent')]")
	WebElement customerConsent;

	@FindBy(how = How.XPATH, using = "//input[@id='consentCheckBox']")
	WebElement circleConsentChkbox;

	@FindBy(how = How.LINK_TEXT, using = "//input[@id='consentCheckBox']")
	WebElement customerDataConsentChkBox;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement consentSubmitBtn;

	@FindBy(how = How.XPATH, using = "//input[@value='male']")
	WebElement selectGenderMale;

	@FindBy(how = How.XPATH, using = "//input[@value='female']")
	WebElement selectGenderFemale;

	@FindBy(how = How.XPATH, using = "//select[@id='ethnicity-select']")
	WebElement selectEthnicity;

	@FindBy(how = How.XPATH, using = "//div[@class='modal create-account-success-modal is-active']//button[@class='modal-close is-large']")
	WebElement confirmationPopCrossButton;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-orange text-bold'][contains(text(),'Return Sample')]")
	WebElement returnSampleButton;

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Circle for Aviva')]")
	WebElement productNameForActivatedProduct;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement clickNextEthnicityPage;
	

	@FindBy(how = How.XPATH, using = "//div[@class='modal create-account-success-modal is-active']//div[@class='box']")
	WebElement activateKitconfirmationPopup;

	
	public CircleActivateKitPage(WebDriver driver) {

		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void barcodeScreenIsAppeared() {
		barcodeInputField.isDisplayed();
	}

	public void enterBarcode(String barcode) {
		barcodeInputField.clear();
		barcodeInputField.click();
		barcodeInputField.sendKeys(barcode);
	}

	public void clickContinueBtnAtBarcodePage() {
		continueBtnBarcode.isEnabled();
		continueBtnBarcode.click();
	}

	public void barcodeErrorMessage() {
		Assert.assertEquals(barcodeErrorValidation.getText(), "Barcode is invalid or has already been used");
	}

	public void customerCosnent() {
		if (!customerConsent.isSelected()) {
			customerConsent.clear();
		}
	}

	public void circleDateConsent() {
		if (!circleConsentChkbox.isSelected()) {
			circleConsentChkbox.click();
		}
	}

	public void clickActivateBtnFromConsentPage() {
		consentSubmitBtn.click();
	}
	
	public void selectMaleGender() {
		selectGenderMale.click();
	}
	
	public void selectFemaleGender() {
		selectGenderFemale.click();
	}
	
	public void selectEthnicity(String ethnicity) {
		new Select(selectEthnicity).selectByVisibleText(ethnicity);
	}
	
	public void clickNextFromEthnicityPage() {
		clickNextEthnicityPage.click();
	}
	
	public void confirmationPopup() {
		activateKitconfirmationPopup.click();
		confirmationPopCrossButton.click();
	}
	
	public void returnSampleButtonIsPresent() {
		returnSampleButton.isDisplayed();
	}
}
