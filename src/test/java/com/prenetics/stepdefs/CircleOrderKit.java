package com.prenetics.stepdefs;

import org.openqa.selenium.WebDriver;

import com.prenetics.common.utility.Constants;
import com.prenetics.pagefactory.circle.CircleOrderKitPage;
import com.prenetics.properties.ObejectBaseClass;
import com.prenetics.setup.DriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleOrderKit extends ObejectBaseClass {

	WebDriver driver = DriverManager.getDriver();

	public CircleOrderKitPage orderKit() {
		return new CircleOrderKitPage(driver);
	}

	@Given("^DNAFit checkout page is loaded$")
	public void dnafit_checkout_page_is_loaded() {
		driver.get(Constants.Alfresco.Url.DNAFIT);
	}

	@Given("^circle Cancer checkout page is loaded$")
	public void cancer_checkout_page_is_loaded() {
		driver.get(Constants.Alfresco.Url.CANCER);
	}

	@Given("^circle combo checkout page is loaded$")
	public void combo_checkout_page_is_loaded() {
		driver.get(Constants.Alfresco.Url.CIRCLECOMBO);
	}

	@Given("^dnafit product information and price should display$")
	public void product_name_in_cart_should_be_dnafit() {
		orderKit().validateProductName("Diet Fitness Pro 360");
		orderKit().validateProductQuantity("x1");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$1,499");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$1,499");
	}

	@Given("^cancer product information and price should display$")
	public void cancer_product_name_in_cart_should_be_dnafit() {
		orderKit().validateProductName("Cancer DNA Test");
		orderKit().validateProductQuantity("x1");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$2,499");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$2,499");
	}

	@Given("^combo product information and price should display$")
	public void combo_product_name_in_cart_should_be_dnafit() {
		orderKit().validateProductName("Comprehensive Bundle");
		orderKit().validateProductQuantity("x1");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$3,198");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$3,198");
	}

	@When("^I change the product quantity from the downdown$")
	public void i_change_the_product_quantity_from_the_downdown() {
		orderKit().changeProductQuantity("2");
	}

	@Then("^dnafit information in cart also should be changed$")
	public void information_in_cart_also_should_be_changed() throws InterruptedException {
		orderKit().validateProductQuantity("x2");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$2,998");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$2,998");
	}

	@Then("^cancer information in cart also should be changed$")
	public void cancer_information_in_cart_also_should_be_changed() throws InterruptedException {
		orderKit().validateProductQuantity("x2");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$4,998");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$4,998");
	}

	@Then("^combo information in cart also should be changed$")
	public void combo_information_in_cart_also_should_be_changed() throws InterruptedException {
		orderKit().validateProductQuantity("x2");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$6,396");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$6,396");
	}

	@When("^I apply promocode$")
	public void i_apply_dnafit_promocode() {
		orderKit().applyPromocode("1234567890");
		orderKit().validatePromoError();
		orderKit().applyPromocode("APPLYALLTHREE");
	}

	@Then("^promocode should be applied on dnafit$")
	public void promocode_should_be_applied_on_dnafit() {
		orderKit().validatePromocodeText("APPLYALLTHREE");
		orderKit().validatePromoAppliedMessage("You've got 20% off!");
		orderKit().ValidateProductBasePrice("$2,998");
		orderKit().ValidateProductOrderTotalPrice("$2,399");
	}

	@Then("^promocode should be applied on cancer$")
	public void promocode_should_be_applied_on_cancer() {
		orderKit().validatePromocodeText("APPLYALLTHREE");
		orderKit().validatePromoAppliedMessage("You've got 20% off!");
		orderKit().ValidateProductBasePrice("$4,998");
		orderKit().ValidateProductOrderTotalPrice("$3,999");
	}

	@Then("^promocode should be applied on combo$")
	public void promocode_should_be_applied_on_combo() {
		orderKit().validatePromocodeText("APPLYALLTHREE");
		orderKit().validatePromoAppliedMessage("You've got 20% off!");
		orderKit().ValidateProductBasePrice("$6,396");
		orderKit().ValidateProductOrderTotalPrice("$5,117");
	}

	@When("^I remove promocode$")
	public void i_remove_promocode() {
		orderKit().clickRemovePromocode();
	}

	@Then("^promocode from dnafit should be removed$")
	public void promocode_from_dnafit_should_be_removed() {
		orderKit().ValidateProductOrderTotalPrice("$2,998");
		orderKit().ValidateProductBasePrice("$2,998");
	}

	@Then("^promocode from cancer should be removed$")
	public void promocode_from_cancer_should_be_removed() {
		orderKit().ValidateProductOrderTotalPrice("$4,998");
		orderKit().ValidateProductBasePrice("$4,998");
	}

	@Then("^promocode from combo should be removed$")
	public void promocode_from_combo_should_be_removed() {
		orderKit().ValidateProductOrderTotalPrice("$6,396");
		orderKit().ValidateProductBasePrice("$6,396");
	}

	@When("^I click on checkout button$")
	public void i_click_on_checkout_button() {
		orderKit().clickCheckoutBtn();
	}

	@Then("^dnafit details in cart are still same$")
	public void dnafit_details_in_cart_are_still_same() throws InterruptedException {
		orderKit().validateProductQuantity("x2");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$2,998");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$2,998");
	}

	@Then("^cancer details in cart are still same$")
	public void cancer_details_in_cart_are_still_same() throws InterruptedException {
		orderKit().validateProductQuantity("x2");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$4,998");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$4,998");
	}

	@Then("^combo details in cart are still same$")
	public void combo_details_in_cart_are_still_same() throws InterruptedException {
		orderKit().validateProductQuantity("x2");
		orderKit().ValidateProductShippingFees();
		orderKit().ValidateProductBasePrice("$6,396");
		orderKit().ValidateProductSubTotalPrice();
		orderKit().ValidateProductOrderTotalPrice("$6,396");
	}

	@When("^I enter contact and shipping information$")
	public void i_enter_contact_and_shipping_information() {
		orderKit().enterOrderContactInformation("kapil+circle@prenetics.com", "+852", "55398628");
		orderKit().enterOrderShippingInformation("Hong Kong");
	}

	@When("^click on continue to payment button$")
	public void click_on_continue_to_payment_button() {
		orderKit().clickContinueToPaymentBtn();
	}

	@When("^I enter card details$")
	public void i_enter_card_details() throws InterruptedException {
		orderKit().enterCardDetails();
	}

	@When("^click on review order button$")
	public void click_on_review_order_button() {
		orderKit().clickReviewYourOrderbtn();
	}

	@When("^I click on purchase button$")
	public void i_click_on_purchase_button() {
		orderKit().clickPurchaseBtn();
	}

	@Then("^Order should be placed successfully$")
	public void order_should_be_placed_successfully() {
		orderKit().validateOrderPlacedSuccessMessage("Order Successfully Placed");
	}

}
