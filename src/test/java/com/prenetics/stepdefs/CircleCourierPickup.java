package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;

import com.prenetics.pagefactory.circle.CircleCourierPickDetailsPage;
import com.prenetics.properties.ObejectBaseClass;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleCourierPickup extends ObejectBaseClass {

	WebDriver driver = DriverManager.getDriver();

	CircleCourierPickDetailsPage courierPickup() {
		return new CircleCourierPickDetailsPage(driver);
	}

	@When("^I click on return sample button$")
	public void i_click_on_return_sample_button() {
		courierPickup().clickReturnSampleButton();
	}
	
	@When("^select pickup country$")
	public void select_pickup_country() {
		courierPickup().selectPickupCountry();
	}

	@When("^I enters the pickup details$")
	public void i_enters_the_pickup_details() throws InterruptedException {
		courierPickup().enterPickupDetails();
		courierPickup().selectDate(driver, 4);
	}

	@When("^click schedule courier pick button$")
	public void click_schedule_courier_pick_button() {
		courierPickup().clickSchedulePickButton();
	}

	@When("^I click on got it button$")
	public void i_click_on_got_it_button() {
		courierPickup().clickGotItButton();
	}

	@Then("^courier pickup is scheduled should appear$")
	public void courier_pickup_is_scheduled_should_appear() {
		courierPickup().pickupConfirmation();
	}

	@When("^I click on back to view my result button$")
	public void i_click_on_back_to_view_my_result_button() {
		courierPickup().clickGoBackToMyResulBtn();
	}

	@Then("^return sample button should be changed to view pickup details$")
	public void return_sample_button_should_be_changed_to_view_pickup_details() {
		courierPickup().IsViewPickupDetailsBtnPresent();
	}

	@When("^I click view pickup details button$")
	public void i_click_view_pickup_details_button() {
		courierPickup().clickPickupDetailsBtn();
	}

	@When("^cI click on modify button$")
	public void ci_click_on_modify_button() {
		courierPickup().clickOnModifyPickupBtn();
	}
}
