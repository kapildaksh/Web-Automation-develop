package com.prenetics.pagefactory.circle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prenetics.common.utility.CommonUtility;

public class CircleUserProfilePage {
	WebDriverWait wait;
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Profile')]")
	WebElement profileLink;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Your Account')]")
	WebElement profileHeaderText;

	@FindBy(how = How.NAME, using = "phoneNumber")
	WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(how =How.XPATH, using ="//div[@class='form-notice success']")
	WebElement successMessage;

	public CircleUserProfilePage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void isProfilePage() {
		profileLink.isDisplayed();
		profileLink.isEnabled();
		profileHeaderText.isDisplayed();
	}

	public void enterPhoneNumber() {
		phoneNumber.clear();
		phoneNumber.sendKeys("85255398628");
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void successMessagePresent() {
		successMessage.isDisplayed();
	}
}
