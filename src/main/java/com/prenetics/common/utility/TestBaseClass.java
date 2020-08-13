package com.prenetics.common.utility;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

public abstract class TestBaseClass extends BaseClass {

	public interface ProductInfo {
		String getLoginRequestBody(String email, String password);

		String getLoginEndpoint();

		String getRegisterRequestBody(String barcode, String email, String password);

		String getRegisterRequestBody(String email, String password);

		String getRegisterEndpoint();

		String getBarcodeProvider();

		String getTrackKitEndPoint();

		String getProduct();
	}

	protected static final String PASSWORD = "12345678";

	protected abstract ProductInfo getInfo();

	/**
	 * Provides the {@link Utilities}.
	 * 
	 * @return
	 */
	protected abstract Utilities getUtils();

	/**
	 * Login and returns the access token given the email and password
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	protected abstract String login(String email, String password);

	/**
	 * Get a fresh barcode for the given provider
	 * 
	 * @param provider
	 * @return
	 */
	protected abstract String getBarcode(String provider);

	/**
	 * Get the customer's barcode
	 * 
	 * @param accessToken
	 * @return
	 */
	protected abstract String getCustomerBarcode(String accessToken);

	/**
	 * Activate/register a kit barcode with a given email and password.
	 * 
	 * @param barcode
	 * @param email
	 * @param password
	 */
	protected abstract void activate(String barcode, String email, String password);

	/**
	 * Test setup
	 * 
	 * @param method
	 */
	protected abstract void testSetup(Method method);

	protected String newEmailString() {
		return getUtils().getEmailString();
	}

	protected String login() {
		String accessToken = this.login(getUtils().getValue("email"), getUtils().getValue("password"));
		getUtils().setValue("token", accessToken);
		return accessToken;
	}
}
