package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;

import com.prenetics.pagefactory.circle.CirclePasswordChangePage;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleChangePassword {

	WebDriver driver = DriverManager.getDriver();

	public CirclePasswordChangePage changePassword() {
		return new CirclePasswordChangePage(driver);
	}

	@When("^user click on password tab$")
	public void user_click_on_password_tab() throws Throwable {
		changePassword().clickPasswordTab();
	}

	@When("^enters old and new passwords$")
	public void enters_old_and_new_passwords() throws Throwable {
		changePassword().enterOldPassword();
		changePassword().enterNewPassword();
	}

	@When("^click on save button$")
	public void click_on_save_button() throws Throwable {
		changePassword().clickPasswordSaveButton();
	}

	@Then("^password changed success message should appear$")
	public void password_changed_success_message_should_appear() throws Throwable {
		changePassword().validatePasswordSuccessMessage();
	}
}
