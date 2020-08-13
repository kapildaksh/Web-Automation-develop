package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;

import com.prenetics.pagefactory.circle.CircleResetPasswordPage;
import com.prenetics.properties.ObejectBaseClass;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleResetPassword extends ObejectBaseClass {

	WebDriver driver = DriverManager.getDriver();

	private CircleResetPasswordPage resetPassword() {
		return new CircleResetPasswordPage(driver);
	}

	@When("^I click on forgot password link$")
	public void i_click_on_forgot_password_link() {
		resetPassword().clickForgetPassordLink();
	}

	@When("^click reset password button with invalid email$")
	public void click_on_reset_password_button() {
		resetPassword().enterEmail("test-automation");
		resetPassword().clickResetPasswordButton();
	}

	@Then("^error validation for invalid email should appear$")
	public void error_validation_for_invalid_email_should_appear() {
		resetPassword().validationMessageForInvalidEmail();
	}

	@When("^I enter click reset password button with emtpy email field$")
	public void i_enter_click_reset_password_button_with_emtpy_email_field() {
		resetPassword().enterEmail("");
		resetPassword().clickResetPasswordButton();
	}

	@Then("^error valid for empty email should appear$")
	public void error_valid_for_empty_email_should_appear() {
		resetPassword().validationMessageForEmptyEmail();
	}

	@When("^click on reset password button with valid email$")
	public void i_enter_valid_email() {
		resetPassword().enterEmail(this.getTestService().getAvailabeAccount());
		resetPassword().clickResetPasswordButton();
	}

	@Then("^confirmation popup should appear$")
	public void confirmation_popup_should_appear() {
		resetPassword().closeConfirmationPopup();
	}

	@When("^I click on signIn button$")
	public void i_click_on_signIn_button() {
		resetPassword().clickSignInButton();
	}

	@Then("^It should be redirected to signin page$")
	public void it_should_be_redirected_to_signin_page() {
		resetPassword().isLoginPage();
	}
}
