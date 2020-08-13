Feature: Track kit different status
         As a user I want to see different status during my sample tracking


@SmokeTest @RegressionTest @TrackKit
Scenario: track dnafit kit and tracking status
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
When I register dnafit sample into lab
And  user click on track sample button
Then register sample status should be checked
When I process extraction dnafit sample
Then processing sample tick should be checked
When I upload dnafit results 
Then view report button should be ready
And delete user account


@SmokeTest @RegressionTest @TrackKit
Scenario: track cancer kit and tracking status
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
When I register cancer sample into lab
And  user click on track sample button
Then register sample status should be checked
When I process extraction cancer sample
Then processing sample tick should be checked
When I upload cancer results 
Then view report button should be ready
And delete user account

@SmokeTest @RegressionTest @TrackKit
Scenario: track aviva kit and tracking status
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
When I register aviva sample into lab
And  user click on track sample button
Then register sample status should be checked
When I process extraction aviva sample
Then processing sample tick should be checked
When I upload aviva results 
Then view report button should be ready
And delete user account

@SmokeTest @RegressionTest @TrackKit
Scenario: track cigna kit and tracking status
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
When I register cigna sample into lab
And  user click on track sample button
Then register sample status should be checked
When I process extraction cigna sample
Then processing sample tick should be checked
When I upload cigna results 
Then view report button should be ready
And delete user account



@SmokeTest @RegressionTest @TrackKit
Scenario: track combo kit and tracking status
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
And click Continue button from ethnicity
And check consent checkboxes and continue
And I click kit Activation confirmation
Then return sample button should appear
When I register combo sample into lab
And  user click on track sample button
Then register sample status should be checked
When I process extraction dnafit from combo sample
Then processing sample tick should be checked
When I upload combo results for dnafit
Then view report button should be ready
And In progress button should for cancer
When I process extraction cancer from combo sample
When I upload combo results for cancer
Then view report button for cancer should be ready
And delete user account
