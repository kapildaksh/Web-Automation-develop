Feature: Activate kit with valid and invalid kit code
         As a User I want to activate a product kit

@SmokeTest @RegressionTest @ActivateKit
Scenario: activate dnafit kit with valid invalid barcode
Given page homepage is loaded
And I click on Create Account button
Then Create account page should open
When I enter First Name and Last Name
And I enter Email and Confirm Email
And I enter Password and Confirm Password
And select DOB from the dropdwon
And Click submit on Create Account button 
Then click confirmation cancel popup
And user dashboard should appear
When I click on activate kit button
Then enter barcode screen should open
When I enter invalid barcode
Then error validation should appear
When I enter correct dnafit barcode
And click continue button from barcode
And select gender and ehtnicity
And click Continue button from ethnicity
And check consent checkboxes and continue
And I click kit Activation confirmation
Then return sample button should appear
And delete user account

@SmokeTest @RegressionTest @ActivateKit
Scenario: activate cancer kit with valid invalid barcode
Given page homepage is loaded
And I click on Create Account button
Then Create account page should open
When I enter First Name and Last Name
And I enter Email and Confirm Email
And I enter Password and Confirm Password
And select DOB from the dropdwon
And Click submit on Create Account button 
Then click confirmation cancel popup
And user dashboard should appear
When I click on activate kit button
Then enter barcode screen should open
When I enter invalid barcode
Then error validation should appear
When I enter correct cancer barcode
And click continue button from barcode
And select gender and ehtnicity
And click Continue button from ethnicity
And check consent checkboxes and continue
And I click kit Activation confirmation
Then return sample button should appear
And delete user account

@SmokeTest @RegressionTest @ActivateKit
Scenario: activate aviva kit with valid invalid barcode
Given page homepage is loaded
And I click on Create Account button
Then Create account page should open
When I enter First Name and Last Name
And I enter Email and Confirm Email
And I enter Password and Confirm Password
And select DOB from the dropdwon
And Click submit on Create Account button 
Then click confirmation cancel popup
And user dashboard should appear
When I click on activate kit button
Then enter barcode screen should open
When I enter invalid barcode
Then error validation should appear
When I enter correct cigna barcode
And click continue button from barcode
And select gender and ehtnicity
And click Continue button from ethnicity
And I click kit Activation confirmation
Then return sample button should appear
And delete user account

@SmokeTest @RegressionTest @ActivateKit
Scenario: activate cigna kit with valid invalid barcode
Given page homepage is loaded
And I click on Create Account button
Then Create account page should open
When I enter First Name and Last Name
And I enter Email and Confirm Email
And I enter Password and Confirm Password
And select DOB from the dropdwon
And Click submit on Create Account button 
Then click confirmation cancel popup
And user dashboard should appear
When I click on activate kit button
Then enter barcode screen should open
When I enter invalid barcode
Then error validation should appear
When I enter correct aviva barcode
And click continue button from barcode
And select gender and ehtnicity
And click Continue button from ethnicity
And I click kit Activation confirmation
Then return sample button should appear
And delete user account

@SmokeTest @RegressionTest @ActivateKit
Scenario: activate combo kit with valid invalid barcode
Given page homepage is loaded
And I click on Create Account button
Then Create account page should open
When I enter First Name and Last Name
And I enter Email and Confirm Email
And I enter Password and Confirm Password
And select DOB from the dropdwon
And Click submit on Create Account button 
Then click confirmation cancel popup
And user dashboard should appear
When I click on activate kit button
Then enter barcode screen should open
When I enter invalid barcode
Then error validation should appear
When I enter correct combo barcode
And click continue button from barcode
And select gender and ehtnicity
And check consent checkboxes and continue
And click Continue button from ethnicity
And I click kit Activation confirmation
Then return sample button should appear
And delete user account