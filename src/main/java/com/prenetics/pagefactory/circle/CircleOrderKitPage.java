package com.prenetics.pagefactory.circle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.prenetics.common.utility.CommonUtility;

public class CircleOrderKitPage {
	WebDriverWait wait;
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//div[@class='name']")
	WebElement productNameInCart;

	@FindBy(how = How.XPATH, using = "//div[@class='quantity']")
	WebElement quantityInCart;

	@FindBy(how = How.XPATH, using = "//div[@class='cost-item subtotal']//div[@class='cost']")
	WebElement subtotalPrice;

	@FindBy(how = How.XPATH, using = "//div[@class='estimated-total']//div[@class='cost']")
	WebElement orderTotal;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Free')]")
	WebElement shippingFees;

	@FindBy(how = How.XPATH, using = "//div[@class='price']")
	WebElement basePrice;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement couponApplybtn;

	@FindBy(how = How.XPATH, using = "//input[@id='promo-code-input']")
	WebElement promocodeTexbox;

	@FindBy(how = How.XPATH, using = "//button[@title='Remove promo code']")
	WebElement removePromocodeBtn;

	@FindBy(how = How.XPATH, using = "//em[@class='promo-code']")
	WebElement promocodeText;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),\"You've got 20% off!\")]")
	WebElement promocodeSuccessMessage;

	@FindBy(how = How.XPATH, using = "//select[@name='orderQuantity']")
	WebElement quantityDropdown;

	@FindBy(how = How.XPATH, using = "//button[@class='checkout-button button is-blue is-wide']")
	WebElement checkoutButton;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-orange is-wide']")
	WebElement buyBundledButton;

	@FindBy(how = How.XPATH, using = "//input[@id='email-input']")
	WebElement emailTextBoxes;

	@FindBy(how = How.XPATH, using = "//select[@id='country-code-select']")
	WebElement couuntryCodeDropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='phone-number-input']")
	WebElement phoneNumberTextBox;

	@FindBy(how = How.XPATH, using = "//select[@id='country-select']")
	WebElement countrySelectDropdown;

	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	WebElement firstNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	WebElement lastNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Room, Floor, Block']")
	WebElement addressLineOneTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='street-input']")
	WebElement addressLineTwoTextbox;

	@FindBy(how = How.XPATH, using = "//select[@id='district-select']")
	WebElement selectDistrictDropdown;

	@FindBy(how = How.XPATH, using = "//select[@id='country-code-select']")
	WebElement areaCodeDropdown;

	@FindBy(how = How.XPATH, using = "//input[@name=\"cardnumber\"]")
	WebElement cardNumber;

	@FindBy(how = How.XPATH, using = "//input[@name=\"exp-date\"]")
	WebElement cardExpiryDate;

	@FindBy(how = How.XPATH, using = "//input[@name=\"cvc\"]")
	WebElement cardCVVNumber;

	@FindBy(how = How.XPATH, using = "//input[@name=\"postal\"]")
	WebElement cardPostalNumber;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue to Payment')]")
	WebElement continueToPaymentBtn;

	@FindBy(how = How.XPATH, using = "//button[@class='button is-orange is-wide']")
	WebElement reviewOrderButton;

	@FindBy(how = How.XPATH, using = "//button[@class='checkout-button button is-orange is-wide']")
	WebElement purchaseButton;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order Successfully Placed')]")
	WebElement orderPlacedSuccessfullyMessage;

	@FindBy(how = How.XPATH, using = "//span[@class='email']")
	WebElement confirmationEmail;

	@FindBy(how = How.XPATH, using = "//input[@name='zipCode']")
	WebElement zipcodeTextbox;
	
	@FindBy(how = How.XPATH, using = "//p[@class='promo-code-form-error']")
	WebElement promocodeError;

	public CircleOrderKitPage(WebDriver driver) {
		CommonUtility.waitForPageLoad(driver);
		CommonUtility.waitForSeconds(3);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public void validateProductName(String productName) {
		Assert.assertEquals(productNameInCart.getText(), productName);
	}

	public void validateProductQuantity(String quantity) {
		Assert.assertEquals(quantityInCart.getText(), quantity);
	}

	public void ValidateProductBasePrice(String price) {
		Assert.assertEquals(basePrice.getText(), price);
	}

	public void ValidateProductShippingFees() {
		Assert.assertEquals(shippingFees.getText(), "Free");
	}

	public boolean ValidateProductSubTotalPrice() {
		if (basePrice.getText().equalsIgnoreCase(subtotalPrice.getText())) {
			return true;
		}
		return false;
	}

	public void ValidateProductOrderTotalPrice(String price) {
		Assert.assertEquals(orderTotal.getText(), price);
	}

	public void changeProductQuantity(String quantity) {
		new Select(quantityDropdown).selectByValue(quantity);
	}

	public void enterOrderContactInformation(String email, String areaCode, String phoneNumber) {
		emailTextBoxes.clear();
		emailTextBoxes.sendKeys(email);
		new Select(couuntryCodeDropdown).selectByVisibleText(areaCode);
		phoneNumberTextBox.clear();
		phoneNumberTextBox.sendKeys(phoneNumber);
	}

	public void enterOrderShippingInformation(String country) {
		new Select(countrySelectDropdown).selectByVisibleText(country);
		firstNameTextbox.clear();
		firstNameTextbox.sendKeys("test");
		lastNameTextbox.clear();
		lastNameTextbox.sendKeys("Automation");
		addressLineOneTextbox.clear();
		addressLineOneTextbox.sendKeys("7F Millinium Plaza");
		addressLineTwoTextbox.clear();
		addressLineTwoTextbox.sendKeys("Quarry Bay");
		if (country.equalsIgnoreCase("Hong Kong")) {
			new Select(selectDistrictDropdown).selectByVisibleText("Central");
		} else {
			zipcodeTextbox.clear();
			zipcodeTextbox.sendKeys("251201");
		}
	}

	public void clickContinueToPaymentBtn() {
		continueToPaymentBtn.click();
	}

	public void enterCardDetails() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.name("__privateStripeFrame4")));
		cardNumber.clear();
		cardNumber.sendKeys("4242 4242 4242 4242");
		cardCVVNumber.sendKeys("242");
		cardPostalNumber.sendKeys("424242");
		cardExpiryDate.sendKeys("0424");
		driver.switchTo().defaultContent();
	}

	public void clickReviewYourOrderbtn() {
		reviewOrderButton.click();
	}

	public void clickPurchaseBtn() {
		purchaseButton.click();
	}

	public void validateOrderPlacedSuccessMessage(String successMessage) {
		Assert.assertEquals(orderPlacedSuccessfullyMessage.getText(), successMessage);
		Assert.assertEquals(confirmationEmail.getText(), "kapil+circle@prenetics.com");
	}

	public void clickCheckoutBtn() {
		checkoutButton.click();
	}

	public void applyPromocode(String promocode) {
		promocodeTexbox.clear();
		promocodeTexbox.sendKeys(promocode);
		couponApplybtn.click();
	}

	public void clickRemovePromocode() {
		removePromocodeBtn.click();
	}

	public void validatePromocodeText(String promocode) {
		Assert.assertEquals(promocodeText.getText(), promocode);
	}

	public void validatePromoAppliedMessage(String message) {
		Assert.assertEquals(promocodeSuccessMessage.getText(), message);
	}
	
	public void validatePromoError() {
		Assert.assertEquals(promocodeError.getText(), "You have entered an invalid promo code");
	}
}
