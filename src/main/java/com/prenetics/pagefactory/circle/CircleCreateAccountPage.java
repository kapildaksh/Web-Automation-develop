package com.prenetics.pagefactory.circle;
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

public class CircleCreateAccountPage {

	WebDriverWait wait;
	private WebDriver driver;
	private String emailID;

	@FindBy(how = How.ID, using = "first-name-input")
	WebElement firstName;

	@FindBy(how = How.ID, using = "last-name-input")
	WebElement lastName;

	@FindBy(how = How.ID, using = "email-input")
	WebElement email;

	@FindBy(how = How.ID, using = "confirm-email-input")
	WebElement confirmEmail;

	@FindBy(how = How.NAME, using = "password")
	WebElement password;

	@FindBy(how = How.NAME, using = "confirmPassword")
	WebElement confirmPassword;
	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-only-header-page/div/div/app-create-account-page/div/div/div[1]/div/h1")
	WebElement headerText;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-only-header-page/div/div/app-create-account-page/div/div/div[2]/app-create-account-form/form/div[1]/div[7]/app-birth-date-select/div/div[1]/div/div/div/select")
	WebElement selectDay;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-only-header-page/div/div/app-create-account-page/div/div/div[2]/app-create-account-form/form/div[1]/div[7]/app-birth-date-select/div/div[2]/div/div/div/select")
	WebElement selectMonth;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-only-header-page/div/div/app-create-account-page/div/div/div[2]/app-create-account-form/form/div[1]/div[7]/app-birth-date-select/div/div[3]/div/div/div/select")
	WebElement selectYear;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-only-header-page/div/div/app-create-account-page/div/div/div[2]/app-create-account-form/form/div[2]/button")
	WebElement createAccountButton;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-auth-page/div/div/app-dashboard-page/div[3]")
	WebElement createAccountSuccessPopup;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-auth-page/div/div/app-dashboard-page/div[1]/div/div/div[1]/h1")
	WebElement userDashbaord;

	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-auth-page/div/div/app-dashboard-page/div[3]/div[2]/div/button")
	WebElement popupCancelButton;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please enter your first name')]")
	WebElement emptyFirstNameError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Must have 2-20 characters')]")
	WebElement shortFirstNameError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Must have 2-20 characters')]")
	WebElement shortLastNameError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please enter your last name')]")
	WebElement emptyLastNameError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please enter your email')]")
	WebElement emptyEmailError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'This email is already in use')]")
	WebElement duplicateEmailError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Email does not match')]")
	WebElement emailNotMatched;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),\"This email doesn't look right. Try again.\")]")
	WebElement invalidEmailError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Email does not match')]")
	WebElement doesNotMatchEmailError;

	@FindBy(how = How.XPATH, using = "//div[@id='password-field']//p[@class='help is-danger'][contains(text(),'Must have at least 8 characters')]")
	WebElement shortPasswordError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Passwords do not match')]")
	WebElement doesNotMatchPasswordError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Must have at least 8 characters')]")
	WebElement emptyPasswordError;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please select your date of birth')]")
	WebElement emptyDateOfBirthError;

	public CircleCreateAccountPage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void enterFirstName(String firstNameVal) throws InterruptedException {
		firstName.isDisplayed();
		firstName.clear();
		firstName.sendKeys(firstNameVal);
	}

	public void enterLastName(String lastNameVal) throws InterruptedException {
		lastName.isDisplayed();
		lastName.clear();
		lastName.sendKeys(lastNameVal);
	}

	public void enterEmail(String emailID) {
		email.isDisplayed();
		email.clear();
		email.sendKeys(emailID);
	}

	public void enterConfirmEmail(String emailID) {
		confirmEmail.isDisplayed();
		confirmEmail.clear();
		confirmEmail.sendKeys(emailID);
	}

	public void enterPassword(String passwordVal) {
		password.isDisplayed();
		password.clear();
		password.sendKeys(passwordVal);
	}

	public void enterConfirmPassword(String passwordVal) {
		confirmPassword.isDisplayed();
		confirmPassword.clear();
		confirmPassword.sendKeys(passwordVal);
	}

	public void headerIsPrensent() {
		headerText.isDisplayed();
	}

	public void selectDOB(String date, String months, String years) {
		Select day = new Select(selectDay);
		day.selectByVisibleText(date);
		Select month = new Select(selectMonth);
		month.selectByVisibleText(months);
		Select year = new Select(selectYear);
		year.selectByVisibleText(years);
	}

	public void clickCreateAccount() {
		createAccountButton.click();
	}

	public void cancelPopup() throws InterruptedException {
		createAccountSuccessPopup.click();
		popupCancelButton.click();
	}

	public void userDashboard() {
		userDashbaord.isDisplayed();
		Assert.assertTrue(userDashbaord.getText().equalsIgnoreCase("Hi Kapil"));
	}

	public void userName() {
		driver.switchTo().defaultContent();
		userDashbaord.isDisplayed();
		Assert.assertTrue(userDashbaord.getText().equalsIgnoreCase("Hi test"));
	}

	public void emptyNameValidation() {
		Assert.assertEquals(emptyFirstNameError.getText(), "Please enter your first name");
		Assert.assertEquals(emptyLastNameError.getText(), "Please enter your last name");
	}

	public void shortNameValidation() {
		Assert.assertEquals(shortFirstNameError.getText(), "Must have 2-20 characters");
		Assert.assertEquals(shortLastNameError.getText(), "Must have 2-20 characters");
	}

	public void emptyEmailValidation() {
		Assert.assertEquals(emptyEmailError.getText(), "Please enter your email");
	}

	public void emptyDOBValidation() {
		Assert.assertEquals(emptyDateOfBirthError.getText(), "Please select your date of birth");
	}

	public void invalidEmailValidation() {
		Assert.assertEquals(invalidEmailError.getText(), "This email doesn't look right. Try again.");
	}

	public void duplicateEmailValidation() {
		confirmEmail.click();
		wait.until(ExpectedConditions.visibilityOf(duplicateEmailError));
		Assert.assertEquals(duplicateEmailError.getText(), "This email is already in use");
	}

	public void emailDoesnotMatchValidation() {
		Assert.assertEquals(doesNotMatchEmailError.getText(), "Email does not match");
	}

	public void emptyPasswordValidation() {
		Assert.assertEquals(emptyPasswordError.getText(), "Must have at least 8 characters");
	}

	public void passwordDoesnotMatchValidation() {
		Assert.assertEquals(doesNotMatchPasswordError.getText(), "Passwords do not match");
	}
}
