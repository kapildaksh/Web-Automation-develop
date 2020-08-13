package com.prenetics.pagefactory.circle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prenetics.common.utility.CommonUtility;

public class CircleUserDashboardPage {
	WebDriverWait wait;
	private WebDriver driver;
	private String emailID;

	@FindBy(how = How.XPATH, using = "//a[@class='navbar-link']")
	WebElement userProfileIcon;

	@FindBy(how = How.LINK_TEXT, using = "Account details")
	WebElement accountDeatils;

	@FindBy(how = How.XPATH, using = "//div[@class='navbar-dropdown is-boxed is-right']//a[@class='navbar-item'][contains(text(),'Sign out')]")
	WebElement signOutLink;

	@FindBy(how = How.XPATH, using = "//button[@type='button']")
	WebElement activiateKitButton;
	
	@FindBy(how = How.XPATH, using = "//BUTTON[@_ngcontent-c13=''][text()='Return Samle']")
	WebElement returnSampleButton;

	public CircleUserDashboardPage(WebDriver driver) {

		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void clickUserProfileIcon() {
		userProfileIcon.isDisplayed();
		userProfileIcon.click();
	}

	public void clickAccountDetailsLink() {
		accountDeatils.isDisplayed();
		accountDeatils.click();
	}
	
	public void clickSignOutLink() {
		signOutLink.isDisplayed();
		signOutLink.click();
		driver.navigate().refresh();
	    CommonUtility.waitForSeconds(3);
	}
	
	public void clickActivateKitButton() {
		activiateKitButton.isDisplayed();
		activiateKitButton.click();
	}
	
	public void clickReturnSampleButton() {
		returnSampleButton.isEnabled();
		returnSampleButton.click();
	}
}
