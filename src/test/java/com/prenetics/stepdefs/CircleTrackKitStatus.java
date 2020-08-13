package com.prenetics.stepdefs;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.prenetics.pagefactory.circle.CircleTrackKitStatusPage;
import com.prenetics.properties.ObejectBaseClass;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleTrackKitStatus extends ObejectBaseClass {

	WebDriver driver = DriverManager.getDriver();

	public CircleTrackKitStatusPage trackKit() {
		return new CircleTrackKitStatusPage(driver);
	}

	@When("^I register dnafit sample into lab$")
	public void i_register_dnafit_sample_into_lab() {
		String barcodeDnafit = getUtils().getValue("dnafitBarcode");
		registerSampleIntoLab(barcodeDnafit);
		driver.navigate().refresh();
	}

	@When("^I register cancer sample into lab$")
	public void i_register_cancer_sample_into_lab() {
		String barcodeCancer = getUtils().getValue("cancerBarcode");
		registerSampleIntoLab(barcodeCancer);
		driver.navigate().refresh();
	}

	@When("^I register aviva sample into lab$")
	public void i_register_aviva_sample_into_lab() {
		String barcodeAviva = getUtils().getValue("avivaBarcode");
		registerSampleIntoLab(barcodeAviva);
		driver.navigate().refresh();
	}

	@When("^I register cigna sample into lab$")
	public void i_register_cigna_sample_into_lab() {
		String barcodeCigna = getUtils().getValue("cignaBarcode");
		registerSampleIntoLab(barcodeCigna);
		driver.navigate().refresh();
	}
	
	@When("^I register combo sample into lab$")
	public void i_register_combo_sample_into_lab() {
		String barcodeCombo = getUtils().getValue("comboBarcode");
		registerSampleIntoLab(barcodeCombo);
		driver.navigate().refresh();
	}

	@Then("^user click on track sample button$")
	public void user_click_on_track_sample_button() {
		trackKit().clickTrackSampleBtn();
	}

	@Then("^register sample status should be checked$")
	public void register_sample_status_should_be_checked() {
		trackKit().isSampleArrivedTickGreen();
	}

	@When("^I process extraction dnafit sample$")
	public void i_process_extraction_dnafit_sample() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String query = extractionPrepQuery("29", customerID);
		trackKit().extractSampleQueryToInsert(query, UTILS.getProps().testLabDataBaseURL(), "29");
	}

	@When("^I process extraction cancer sample$")
	public void i_process_extraction_cancer_sample() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String query = extractionPrepQuery("30", customerID);
		trackKit().extractSampleQueryToInsert(query, UTILS.getProps().testLabDataBaseURL(), "30");
	}

	@When("^I process extraction aviva sample$")
	public void i_process_extraction_aviva_sample() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String query = extractionPrepQuery("21", customerID);
		trackKit().extractSampleQueryToInsert(query, UTILS.getProps().testLabDataBaseURL(), "21");
	}

	@When("^I process extraction cigna sample$")
	public void i_process_extraction_cigna_sample() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String query = extractionPrepQuery("24", customerID);
		trackKit().extractSampleQueryToInsert(query, UTILS.getProps().testLabDataBaseURL(), "24");
	}

	@When("^I process extraction dnafit from combo sample$")
	public void i_process_extraction_dnafit_combo_sample() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String query = extractionPrepQuery("31", customerID);
		trackKit().extractSampleQueryToInsert(query, UTILS.getProps().testLabDataBaseURL(), "31");
	}
	

	@When("^I process extraction cancer from combo sample$")
	public void i_process_extraction_cancer_combo_sample() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String query = extractionPrepQuery("32", customerID);
		trackKit().extractSampleQueryToInsert(query, UTILS.getProps().testLabDataBaseURL(), "32");
	}
	
	
	@Then("^processing sample tick should be checked$")
	public void tacking_sample_should_should_checked() {
		trackKit().isSampleInProcesssTickGreen();
	}

	@When("^I upload dnafit results$")
	public void i_upload_dnafit_results() throws ClassNotFoundException, SQLException, InterruptedException {
		String customerID = getCustomerID();
		String reportCompleteQuery = reportCompleteQuery("29", customerID);
		trackKit().reportCompleteQueryToInsert(reportCompleteQuery, UTILS.getProps().testLabDataBaseURL(), "29");
		String reportGenerateQuery = reportCompleteQuery("29", customerID);
		trackKit().reportGenerateQueryToInsert(reportGenerateQuery, UTILS.getProps().testLabDataBaseURL(), "29");
	}
	@When("^I upload combo results for dnafit$")
	public void i_upload_combo_results_dnafit() throws ClassNotFoundException, SQLException, InterruptedException {
		String customerID = getCustomerID();
		String reportCompleteQuery = reportCompleteQuery("31", customerID);
		trackKit().reportCompleteQueryToInsert(reportCompleteQuery, UTILS.getProps().testLabDataBaseURL(), "31");
		String reportGenerateQuery = reportCompleteQuery("31", customerID);
		trackKit().reportGenerateQueryToInsert(reportGenerateQuery, UTILS.getProps().testLabDataBaseURL(), "31");
		trackKit().clickCircleLogo();
	}
	
	@When("^I upload combo results for cancer$")
	public void i_upload_combo_results_cancer() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String reportCompleteQuery = reportCompleteQuery("32", customerID);
		trackKit().reportCompleteQueryToInsert(reportCompleteQuery, UTILS.getProps().testLabDataBaseURL(), "32");
		String reportGenerateQuery = reportCompleteQuery("32", customerID);
		trackKit().reportGenerateQueryToInsert(reportGenerateQuery, UTILS.getProps().testLabDataBaseURL(), "32");
		driver.navigate().refresh();
	}
	
	@When("^I upload cancer results$")
	public void i_upload_cancer_results() throws ClassNotFoundException, SQLException {
		String customerID = getCustomerID();
		String reportCompleteQuery = reportCompleteQuery("30", customerID);
		trackKit().reportCompleteQueryToInsert(reportCompleteQuery, UTILS.getProps().testLabDataBaseURL(), "30");
		String reportGenerateQuery = reportCompleteQuery("30", customerID);
		trackKit().reportGenerateQueryToInsert(reportGenerateQuery, UTILS.getProps().testLabDataBaseURL(), "30");
		trackKit().clickCircleLogo();
	}

	@When("^I upload aviva results$")
	public void i_upload_aviva_results() throws ClassNotFoundException, SQLException, InterruptedException {
		String customerID = getCustomerID();
		String reportCompleteQuery = reportCompleteQuery("21", customerID);
		trackKit().reportCompleteQueryToInsert(reportCompleteQuery, UTILS.getProps().testLabDataBaseURL(), "21");
		String reportGenerateQuery = reportCompleteQuery("21", customerID);
		trackKit().reportGenerateQueryToInsert(reportGenerateQuery, UTILS.getProps().testLabDataBaseURL(), "21");
		trackKit().clickCircleLogo();
	}

	@When("^I upload cigna results$")
	public void i_upload_cigna_results() throws ClassNotFoundException, SQLException, InterruptedException {
		String customerID = getCustomerID();
		String reportCompleteQuery = reportCompleteQuery("24", customerID);
		trackKit().reportCompleteQueryToInsert(reportCompleteQuery, UTILS.getProps().testLabDataBaseURL(), "24");
		String reportGenerateQuery = reportCompleteQuery("24", customerID);
		trackKit().reportGenerateQueryToInsert(reportGenerateQuery, UTILS.getProps().testLabDataBaseURL(), "24");
		trackKit().clickCircleLogo();
	}

	@Then("^view report button should be ready$")
	public void view_report_button_should_be_ready() throws InterruptedException {
		trackKit().clickCircleLogo();
		trackKit().isViewReportBtnPresent();
	}
	
	@Then("^In progress button should for cancer$")
	public void inProgress_button_should_be_cancer() {
		trackKit().cancerFromComboIsInProgess();
	}
	@Then("^view report button for cancer should be ready$")
	public void view_report_button_cancer_should_be_ready() {
		trackKit().cancerViewReportBtnPresent();
	}
}
