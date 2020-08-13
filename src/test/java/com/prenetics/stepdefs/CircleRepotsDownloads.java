package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;

import com.prenetics.pagefactory.circle.CircleDownloadReportsPage;
import com.prenetics.pagefactory.circle.CircleTrackKitStatusPage;
import com.prenetics.setup.DriverManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleRepotsDownloads {

	WebDriver driver = DriverManager.getDriver();

	public CircleDownloadReportsPage downloadReport() {
		return new CircleDownloadReportsPage(driver);
	}

	public CircleTrackKitStatusPage trackKit() {
		return new CircleTrackKitStatusPage(driver);
	}

	@Then("^click on circle logo$")
	public void clickCircleLogo() {
		trackKit().clickCircleLogo();
	}

	@When("^user click on view report button for dnafit$")
	public void user_click_on_view_report_button_dnafit() {
		downloadReport().viewComboDnafitReportBtn();
	}

	@When("^user click on view report button for cancer$")
	public void user_click_on_view_report_button_cancer() {
		downloadReport().viewCombocancerReportBtn();
	}

	@When("^click on download report with en$")
	public void click_on_download_report_with_en() throws InterruptedException {
		downloadReport().en_clickDownloadReportButton_();
		Thread.sleep(10000);
	}

	@When("^click on download cancer report with en$")
	public void click_on_download_cancer_report_with_en() throws InterruptedException {
		downloadReport().en_clickDownloadReportBtn();
		Thread.sleep(10000);
	}

	@Then("^en dnafit report should be downloaded$")
	public void en_dnafit_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-3_report_en_US.pdf");

	}

	@Then("^en cancer report should be downloaded$")
	public void en_cancer_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-4_report_en_US.pdf");

	}

	@Then("^en aviva report should be downloaded$")
	public void en_aviva_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-1_report_en_US.pdf");

	}

	@Then("^en cigna report should be downloaded$")
	public void en_cigna_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-2_report_en_US.pdf");

	}

	@Then("^click on download report with hk$")
	public void click_on_download_report_with_zh() throws InterruptedException {
		downloadReport().hk_clickDownloadReportButton_();
		Thread.sleep(10000);
	}

	@Then("^click on download cancer report with hk$")
	public void click_on_download_report_with_hk() throws InterruptedException {
		downloadReport().hk_clickDownloadReportbtn();
		Thread.sleep(10000);
	}

	@Then("^hk dnafit report should be downloaded$")
	public void hk_dnafit_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-3_report_zh_HK.pdf");
	}

	@Then("^hk cancer report should be downloaded$")
	public void hk_cancer_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-4_report_zh_HK.pdf");
	}

	@Then("^hk aviva report should be downloaded$")
	public void hk_aviva_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-1_report_zh_HK.pdf");
	}

	@Then("^hk cigna report should be downloaded$")
	public void hk_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-2_report_zh_HK.pdf");
	}

	@Then("^click on download report with cn$")
	public void click_on_download_report_with_cn() throws InterruptedException {
		downloadReport().cn_clickDownloadReportButton_();
		Thread.sleep(10000);
	}

	@Then("^click on download cancer report with cn$")
	public void click_on_download_cancer_report_with_cn() throws InterruptedException {
		downloadReport().cn_clickDownloadReportBtn();
		Thread.sleep(10000);
	}

	@Then("^cn dnafit report should be downloaded$")
	public void cn_dnafit_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-3_report_zh_CN.pdf");
	}

	@Then("^cn cancer report should be downloaded$")
	public void cn_cancer_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-4_report_zh_CN.pdf");
	}

	@Then("^cn aviva report should be downloaded$")
	public void cn_aviva_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-1_report_zh_CN.pdf");
	}

	@Then("^cn cigna report should be downloaded$")
	public void cn_report_should_be_downloaded() {
		downloadReport().isFileDownloaded(System.getProperty("user.dir") + "//target//", "circle-2_report_zh_CN.pdf");
	}

}
