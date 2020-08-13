Feature: Schedule Courier pickup 
         As a user I want to book return sample appointment and reschedule return sample appointment
         
@SmokeTest @RegressionTest @CourierPickup
Scenario: schedule and reshedule return sample
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
When I click on return sample button 
And select pickup country
And I enters the pickup details
And click schedule courier pick button
And I click on got it button
Then courier pickup is scheduled should appear
When I click on back to view my result button
Then return sample button should be changed to view pickup details
When I click view pickup details button
And cI click on modify button
And select pickup country
And I enters the pickup details
And click schedule courier pick button
And I click on got it button
Then courier pickup is scheduled should appear
And delete user account