package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;

import com.prenetics.pagefactory.circle.CircleCreateAccountPage;
import com.prenetics.pagefactory.circle.CircleUserDashboardPage;
import com.prenetics.pagefactory.circle.CircleUserLoginPage;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleUserLogin {

	WebDriver driver = DriverManager.getDriver();

	public CircleUserLoginPage login() {
		return new CircleUserLoginPage(driver);
	}

	public CircleUserDashboardPage userDashboard() {
		return new CircleUserDashboardPage(driver);
	}
	public CircleCreateAccountPage createAccount() {
		return new CircleCreateAccountPage(driver);
	}

	@Given("^page homepage is loaded$")
	public void loginPage() throws InterruptedException {
		driver.get("https://testing-app.circledna.com/signin");
	}

	@When("^User Login to Application$")
	public void user_Login_to_Application() throws Throwable {
		System.out.println("page launched");
	}
	@When("^enter email$")
	public void enter_email() throws Throwable {
		login().enterEmail("kapil+dnafit@prenetics.com");
	}
	
	@When("^enter email to download dnafit report$")
	public void enter_dnafit_email() throws Throwable {
		login().enterEmail("kapil+dnafit@prenetics.com");
	}
	
	@When("^enter email to download cancer report$")
	public void enter_cancer_email() throws Throwable {
		login().enterEmail("kapil+cancer@prenetiecs.com");
	}
	@When("^enter email to download aviva report$")
	public void enter_aviva_email() throws Throwable {
		login().enterEmail("test-automation+813030@prenetics.com");
	}
	
	@When("^enter email to download combo report$")
	public void enter_combo_email() throws Throwable {
		login().enterEmail("kapil+circle+combo@prenetics.com");
	}
	
	@When("^enter email to download cigna report$")
	public void enter_cigna_email() throws Throwable {
		login().enterEmail("test-autmation+8130301@prenetics.com");
	}
	@When("^enter Password$")
	public void enter_Password() throws Throwable {
		login().enterPassword();
	}

	@When("^click signin button$")
	public void click_signin_button() throws Throwable {
		login().clickLoginButton();
	}

	@Then("^user should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		createAccount().userDashboard();
	}
	
	@When("^user click on logout link$")
	public void user_click_on_logout_link() throws Throwable {
	  userDashboard().clickUserProfileIcon();
	  userDashboard().clickSignOutLink();
	}

	@Then("^I should be logout$")
	public void i_should_be_logout() throws Throwable {
	   login().validateIsLoginPage();
	   
	}

}