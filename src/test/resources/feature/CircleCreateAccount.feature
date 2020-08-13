Feature: create new user account
         As a user I want to create new account 
         
                  
@SmokeTest @RegressionTest @CreateAccount
Scenario: create user with valid information
Given page homepage is loaded
When I click on Create Account button
Then Create account page should open
When I enter First Name and Last Name
And I enter Email and Confirm Email
And I enter Password and Confirm Password
And select DOB from the dropdwon
And Click submit on Create Account button 
Then click confirmation cancel popup
And user dashboard should appear
And delete user account


@RegressionTest @CreateAccount 
Scenario: create account input field validation
Given page homepage is loaded
When I click on Create Account button
Then Create account page should open
When Click submit on Create Account button
Then emtpy fields error validation should appear
When I enter short first and last name
Then short first and last Name error message should appear
When I enter invalid email 
Then invalid email error should appear
When I enter used email
Then already used error message should appear
When I enter different email in confirm email field
Then email doesn't match error should appear
When I enter short password
Then short password error message appear
When I enter different confirm password
Then password doesn't matach error should appear




