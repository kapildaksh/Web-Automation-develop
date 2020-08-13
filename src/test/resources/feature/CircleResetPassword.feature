Feature: Reset Password using email address
         As a user I want to reset my password using by my email address

@SmokeTest @RegressionTest @ResetPassword         
Scenario: reset password with valid and invalid email address
Given page homepage is loaded
When I click on forgot password link
When I enter click reset password button with emtpy email field
Then error valid for empty email should appear
And click reset password button with invalid email
Then error validation for invalid email should appear
When click on reset password button with valid email 
Then confirmation popup should appear
When I click on signIn button
Then It should be redirected to signin page

