package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;

import com.prenetics.common.utility.CommonUtility;
import com.prenetics.pagefactory.circle.CircleUserDashboardPage;
import com.prenetics.pagefactory.circle.CircleUserLoginPage;
import com.prenetics.pagefactory.circle.CircleUserProfilePage;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleProfileUpdate {

	WebDriver driver = DriverManager.getDriver();

	private CircleUserDashboardPage userDashboard() {
		return new CircleUserDashboardPage(driver);
	}

	private CircleUserProfilePage userProfilePage() {
		return new CircleUserProfilePage(driver);
	}

	private CircleUserLoginPage loginPage() {
		return new CircleUserLoginPage(driver);
	}

	@When("^I Login to Application$")
	public void loginToApplication() throws Throwable {
		loginPage().enterEmail("kapil+circle@prenetics.com");
		loginPage().enterPassword();
		loginPage().clickLoginButton();
	}

	@And("^user click on account information$")
	public void user_click_on_account_information() throws Throwable {
		CommonUtility.waitForPageLoad(driver);
		userDashboard().clickUserProfileIcon();
		userDashboard().clickAccountDetailsLink();
	}

	@Then("^account information page should open$")
	public void account_information_page_should_open() throws Throwable {
		System.out.println("account infromation page is loaded");
	}

	@When("^user enter the phone number and save$")
	public void user_enter_the_phone_number_and_save() throws Throwable {
		userProfilePage().enterPhoneNumber();
		userProfilePage().clickSaveButton();
	}

	@Then("^sccess message should appear$")
	public void sccess_message_should_appear() throws Throwable {
		userProfilePage().successMessagePresent();

	}
}
