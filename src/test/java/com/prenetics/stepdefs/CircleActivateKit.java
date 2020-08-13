package com.prenetics.stepdefs;
import org.openqa.selenium.WebDriver;
import com.prenetics.pagefactory.circle.CircleActivateKitPage;
import com.prenetics.pagefactory.circle.CircleUserDashboardPage;
import com.prenetics.pagefactory.circle.CircleUserLoginPage;
import com.prenetics.properties.ObejectBaseClass;
import com.prenetics.setup.DriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CircleActivateKit extends ObejectBaseClass {

	WebDriver driver = DriverManager.getDriver();
	
	public CircleUserLoginPage loginPage() {
		return new CircleUserLoginPage(driver);
	}

	public CircleActivateKitPage activateKit() {
		return new CircleActivateKitPage(driver);
	}

	public CircleUserDashboardPage dashboard() {
		return new CircleUserDashboardPage(driver);
	}

	@When("^I click on activate kit button$")
	public void i_click_on_activate_kit_button() {
		dashboard().clickActivateKitButton();
	}

	@Then("^enter barcode screen should open$")
	public void enter_barcode_screen_should_open() {
		activateKit().barcodeScreenIsAppeared();
	}

	@When("^I enter invalid barcode$")
	public void i_enter_invalid_barcode() {
		activateKit().enterBarcode("12345678987612");
	}

	@Then("^error validation should appear$")
	public void error_validation_should_appear() {
		activateKit().clickContinueBtnAtBarcodePage();
		activateKit().barcodeErrorMessage();
	}

	@When("^I enter correct dnafit barcode$")
	public void i_enter_correct_DNAFit_barcode() {
		String dnafitKitcode =this.getBarcode("prenetics-hk-dnafit");		
		activateKit().enterBarcode(dnafitKitcode);
		getUtils().setValue("dnafitBarcode", dnafitKitcode);
	}

	@When("^I enter correct cancer barcode$")
	public void i_enter_Cancer_correct_barcode() {
		String cancerKitcode =this.getBarcode("prenetics-hk-cancer");		
		activateKit().enterBarcode(cancerKitcode);
		getUtils().setValue("cancerBarcode", cancerKitcode);
	}
	
	@When("^I enter correct aviva barcode$")
	public void i_enter_Cancer_Aviva_correct_barcode() {
		String avivaKitcode =this.getBarcode("aviva-hk");	
		activateKit().enterBarcode(avivaKitcode);
		getUtils().setValue("avivaBarcode", avivaKitcode);
	}
	
	@When("^I enter correct combo barcode$")
	public void i_enter_Cancer_combo_correct_barcode() {
		String comboKitcode =this.getBarcode("prenetics-hk-combo1");	
		activateKit().enterBarcode(comboKitcode);
		getUtils().setValue("comboBarcode", comboKitcode);
	}
	
	@When("^I enter correct cigna barcode$")
	public void i_enter_Cancer_Cigna_correct_barcode() {
		String cignaKitcode =this.getBarcode("cigna-hk");	
		activateKit().enterBarcode(cignaKitcode);
		getUtils().setValue("cignaBarcode", cignaKitcode);
	}
	
	@When("^click continue button from barcode$")
	public void click_continue_button_from_barcode() {
		activateKit().clickContinueBtnAtBarcodePage();
	}

	@When("^check consent checkboxes$")
	public void select_consent_checkboxes() {
		activateKit().clickActivateBtnFromConsentPage();
	}

	@When("^select gender and ehtnicity$")
	public void select_gender_and_ehtnicity() {
		activateKit().selectMaleGender();
		activateKit().selectEthnicity("Caucasian");
	}

	@When("^click Continue button from ethnicity$")
	public void click_Activate_kit_button() {
		activateKit().clickNextFromEthnicityPage();
	}

	@When("^check consent checkboxes and continue$")
	public void checkConsentCheckboxAndContinue() {
		activateKit().clickActivateBtnFromConsentPage();
	}

	@When("^I click kit Activation confirmation$")
	public void kit_Activation_confirmation_pop_appears() {
		activateKit().confirmationPopup();
	}
	
	@Then("^return sample button should appear$")
	public void return_sample_button_should_appear() {
		activateKit().returnSampleButtonIsPresent();
	}
}
