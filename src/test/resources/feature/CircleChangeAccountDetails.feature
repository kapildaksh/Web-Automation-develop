Feature: change user account information 
         As a user want to see and change accounnt information

@RegressionTest @ChangePhoneNumber    
Scenario: change user account phone number
Given page homepage is loaded
When I Login to Application
And user click on account information
Then account information page should open
When user enter the phone number and save
Then sccess message should appear

@RegressionTest @ChangePassword
Scenario: change user account password
Given page homepage is loaded
When I Login to Application
And user click on account information
Then account information page should open
When user click on password tab
And enters old and new passwords
And click on save button
Then password changed success message should appear


