package com.prenetics.pagefactory.circle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.prenetics.common.utility.CommonUtility;
import org.testng.Assert;

public class CircleResetPasswordPage {

	WebDriverWait wait;
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[@class='pull-right text-blue text-bold']")
	WebElement forgetPasswordLink;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Reset your Circle password')]")
	WebElement resetPasswordPageHeader;

	@FindBy(how = How.XPATH, using = "//input[@id='email-input']")
	WebElement emailAddressField;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement resetPasswordButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'This field cannot be blank')]")
	WebElement emptyEmailValidation;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),\"This email doesn't look right. Try again.\")]")
	WebElement invalidEmailValidation;

	@FindBy(how = How.XPATH, using = "//div[@class='form-notice success']")
	WebElement successMessage;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-orange text-bold is-outlined is-wide']")
	WebElement singInButton;

	@FindBy(how = How.XPATH, using = "//div[@class='box']")
	WebElement confirmationPopup;

	@FindBy(how = How.XPATH, using = "//h3[@class='subtitle']")
	WebElement resetLinkIsOnWayText;

	@FindBy(how = How.XPATH, using = "//button[@class='modal-close is-large']")
	WebElement closeConfirmationPopup;

	public CircleResetPasswordPage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void clickForgetPassordLink() {
		forgetPasswordLink.click();
	}

	public void isResetPasswordPageHeader() {
		return;
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
		emailAddressField.clear();
		emailAddressField.sendKeys(email);
	}

	public void validationMessageForEmptyEmail() {
		Assert.assertEquals(emptyEmailValidation.getText(), "This field cannot be blank");
	}

	public void validationMessageForInvalidEmail() {
		Assert.assertEquals(invalidEmailValidation.getText(), "This email doesn't look right. Try again.");
	}

	public void clickResetPasswordButton() {
		resetPasswordButton.click();
	}

	public void closeConfirmationPopup() {
		wait.until(ExpectedConditions.visibilityOf(confirmationPopup));
		confirmationPopup.click();
		Assert.assertEquals(resetLinkIsOnWayText.getText(), "Your reset link is on its way");
		closeConfirmationPopup.click();
	}

	public void clickSignInButton() {
		singInButton.click();
	}

	public void isLoginPage() {
		wait.until(ExpectedConditions.visibilityOf(forgetPasswordLink));
		forgetPasswordLink.isDisplayed();
	}
}
