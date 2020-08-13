package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;
import com.prenetics.common.utility.CommonUtility;
import com.prenetics.pagefactory.circle.CircleCreateAccountPage;
import com.prenetics.pagefactory.circle.CircleUserLoginPage;
import com.prenetics.properties.ObejectBaseClass;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleCreateAccount extends ObejectBaseClass {

	WebDriver driver = DriverManager.getDriver();
	private String emailID;

	CircleCreateAccountPage createAccount() {
		return new CircleCreateAccountPage(driver);
	}

	CircleUserLoginPage loginPage() {
		return new CircleUserLoginPage(driver);
	}

	@When("^I click on Create Account button$")
	public void click_on_Create_Account_button() {
		CommonUtility.waitForSeconds(3);
		loginPage().clickCreateAccountButton();
	}

	@Then("^Create account page should open$")
	public void create_account_page_should_open() {
		createAccount().headerIsPrensent();
	}

	@When("^I enter First Name and Last Name$")
	public void enter_First_Name_and_Last_Name() throws InterruptedException {
		createAccount().enterFirstName("test");
		createAccount().enterLastName("testing");
	}

	@When("^I enter Email and Confirm Email$")
	public void enter_Email_and_Confirm_Email() {
		emailID = this.getTestService().getAvailabeAccount();
		getUtils().setValue("email", emailID);
		createAccount().enterEmail(emailID);
		createAccount().enterConfirmEmail(emailID);
	}

	@When("^I enter Password and Confirm Password$")
	public void enter_Password_and_Confirm_Password() {
		createAccount().enterPassword("12345678");
		createAccount().enterConfirmPassword("12345678");
	}

	@When("^select DOB from the dropdwon$")
	public void select_DOB_from_the_dropdwon() {
		createAccount().selectDOB("10", "October", "1989");
	}

	@When("^Click submit on Create Account button$")
	public void click_submit_on_Create_Account_button() {
		createAccount().clickCreateAccount();
	}

	@Then("^click confirmation cancel popup$")
	public void confirmationShouldAppear() throws InterruptedException {
		createAccount().cancelPopup();
	}

	@And("^user dashboard should appear$")
	public void userDashboardShouldAppear() {
		createAccount().userName();
	}

	@Then("^delete user account$")
	public void delete_user_account() {
		this.deleteCustomer(emailID);
	}

	@Then("^emtpy fields error validation should appear$")
	public void emtpy_fields_error_validation_should_appear() {
		createAccount().emptyNameValidation();
		createAccount().emptyEmailValidation();
		createAccount().emptyPasswordValidation();
		createAccount().emptyDOBValidation();
	}

	@When("^I enter short first and last name$")
	public void i_enter_short_first_and_last_name() throws InterruptedException {
		createAccount().enterFirstName("t");
		createAccount().enterLastName("t");
	}

	@Then("^short first and last Name error message should appear$")
	public void short_first_and_last_Name_error_message_should_appear() {
		createAccount().shortNameValidation();
	}

	@When("^I enter invalid email$")
	public void i_enter_invalid_email() {
		createAccount().enterEmail("test-automation");
	}

	@Then("^invalid email error should appear$")
	public void invalid_email_error_should_appear() {
		createAccount().invalidEmailValidation();
	}

	@When("^I enter used email$")
	public void i_enter_used_email() {
		createAccount().enterEmail("kapil+circle@prenetics.com");
	}

	@Then("^already used error message should appear$")
	public void already_used_error_message_should_appear() {
		createAccount().duplicateEmailValidation();
	}

	@When("^I enter different email in confirm email field$")
	public void i_enter_different_email_in_confirm_email_field() {
		createAccount().enterEmail(this.getTestService().getAvailabeAccount());
		createAccount().enterConfirmEmail("test-automation@test.com");
	}

	@Then("^email doesn't match error should appear$")
	public void email_doesn_t_match_error_should_appear() {
		createAccount().emailDoesnotMatchValidation();
	}

	@When("^I enter short password$")
	public void i_enter_short_password() {
		createAccount().enterPassword("1234567");
	}

	@Then("^short password error message appear$")
	public void short_password_error_message_appear() {
		createAccount().emptyPasswordValidation();
	}

	@When("^I enter different confirm password$")
	public void i_enter_different_confirm_password() {
		createAccount().enterPassword("12345678");
		createAccount().enterConfirmPassword("1234567");
	}

	@Then("^password doesn't matach error should appear$")
	public void password_doesn_t_matach_error_should_appear() {
		createAccount().passwordDoesnotMatchValidation();
	}
}
