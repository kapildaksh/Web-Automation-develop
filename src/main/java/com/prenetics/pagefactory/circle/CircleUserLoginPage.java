package com.prenetics.pagefactory.circle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.prenetics.common.utility.CommonUtility;
import com.prenetics.setup.DriverManager;

public class CircleUserLoginPage {

	WebDriver driver = DriverManager.getDriver();

	@FindBy(how = How.NAME, using = "email")
	WebElement email;

	@FindBy(how = How.NAME, using = "password")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//button[@type='button']")
	WebElement createAccountButton;

	@FindBy(how = How.XPATH, using = "//div[@class='signin-layout-contents']")
	WebElement validateSingInPage;
	
	public CircleUserLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String account) {
		email.clear();
		email.sendKeys(account);
	}

	public void enterPassword() {
		CommonUtility.waitForSeconds(1);
		password.clear();
		password.sendKeys("12345678");
	}

	public void clickLoginButton() {
		CommonUtility.waitForSeconds(1);
		loginButton.isEnabled();
		loginButton.click();
		CommonUtility.waitForSeconds(3);
	}

	public void clickCreateAccountButton() {
		createAccountButton.isEnabled();
		createAccountButton.click();
		CommonUtility.waitForSeconds(3);
	}

	public void validateIsLoginPage() {
		email.isDisplayed();
	}
}
