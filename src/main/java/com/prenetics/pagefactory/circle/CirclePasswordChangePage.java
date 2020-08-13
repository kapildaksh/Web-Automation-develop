package com.prenetics.pagefactory.circle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prenetics.common.utility.CommonUtility;

public class CirclePasswordChangePage {
	WebDriverWait wait;
	private WebDriver driver;
	private String emailID;
	
	@FindBy(how = How.XPATH, using = "//a[@class='active' and text()=\"Password\"]")
	WebElement passwordTab;
 
	@FindBy(how = How.XPATH, using = "//div[@class='column is-4']")
	WebElement SideMenuPanel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='column is-4']//app-sidebar-menu-panel")
	WebElement sideMenu;
	
	@FindBy(how = How.XPATH, using = "//input[@id='old-password-input']")
	WebElement oldPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='new-password-input']")
	WebElement newPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='newRepeat-password-input']")
	WebElement confirmNewPassword;

	@FindBy(how = How.XPATH, using = "//div[@class='form-notice success']")
	WebElement successMessage;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement saveButton;

	public CirclePasswordChangePage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void clickPasswordTab() {
		SideMenuPanel.click();
		sideMenu.click();
		passwordTab.isDisplayed();
		passwordTab.isEnabled();
		passwordTab.click();
	}
	
	public void enterOldPassword() {
		oldPassword.clear();
		oldPassword.sendKeys("12345678");
	}
	
	public void enterNewPassword() {
		newPassword.clear();
		newPassword.sendKeys("12345678");
		confirmNewPassword.clear();
		confirmNewPassword.sendKeys("12345678");
	}
	
	public void clickPasswordSaveButton() {
		saveButton.isEnabled();
		saveButton.click();
	}
	
	public void validatePasswordSuccessMessage() {
		successMessage.isDisplayed();
	}
}

