package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;
import com.prenetics.pagefactory.circle.CircleBookConsultationPage;
import com.prenetics.pagefactory.circle.CircleCourierPickDetailsPage;
import com.prenetics.pagefactory.circle.CircleUserLoginPage;
import com.prenetics.setup.DriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleBookConsultation {

	WebDriver driver = DriverManager.getDriver();

	public CircleUserLoginPage login() {
		return new CircleUserLoginPage(driver);
	}

	CircleCourierPickDetailsPage courierPickup() {
		return new CircleCourierPickDetailsPage(driver);
	}
	public CircleBookConsultationPage consultation() {
		return new CircleBookConsultationPage(driver);
	}

	@When("^user click on view report button$")
	public void user_click_on_view_report_button() {
		consultation().clickViewReportBtn();
	}

	@When("^click on schedule appointment button$")
	public void click_on_schedule_appointment_button() {
		consultation().clickScheduleAppointmentBtn();
	}

	@When("^click on update phone nubmer button$")
	public void click_on_update_phone_nubmer_button() {
		consultation().clickUpdatePhoneNumber();
		consultation().clickDoneUpdatePhoneButton();
		consultation().emptyPhoneErrorValidation();
	}

	@When("^Enter phone number to update$")
	public void enter_phone_number_to_update() {
		consultation().enterPhonenNumber();
	}

	@When("^Click done button$")
	public void click_done_button() {
		consultation().clickDoneUpdatePhoneButton();
	}

	@When("^I enter consultation details$")
	public void i_enter_consultation_details() throws InterruptedException {
		consultation().clickBookAppointmentBtn();
		consultation().errorValidation();
		consultation().selectCountry("Hong Kong");
		courierPickup().selectDate(driver, 5);
		consultation().clickOnAvailableTimeSlot();
	}

	@When("^click on book appointment$")
	public void click_on_book_appointment() {
		consultation().clickBookAppointmentBtn();
	}

	@Then("^booking appointment should be done$")
	public void booking_appointment_should_be_done() {
		consultation().appointmentSuccessMessage();
	}

	@When("^click on view appointment details button$")
	public void click_on_view_appointment_details_button() {
		consultation().clickViewAppointmentDetails();
	}

	@When("^click on reschedule button$")
	public void click_on_reschedule_button() {
    consultation().clickAppointmentRescheduleBtn();
	}

	@Then("^select timezone page should open$")
	public void select_timezone_page_should_open() {
     consultation().isAppointmentDetailsPage();
	}

	@When("^click on cancel button$")
	public void click_on_cancel_button() {
	    consultation().clickAppointmentCancelBtn();
	}

	@Then("^appointment should be cancel$")
	public void appointment_should_be_cancel() {
	    
	}
}
