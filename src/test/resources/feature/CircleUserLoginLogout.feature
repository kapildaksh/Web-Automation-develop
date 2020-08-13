Feature: complete User Email Login journey


@SmokeTest @RegressionTest @Login
Scenario: Valid Email User Login and verify logout
Given page homepage is loaded
When User Login to Application
And enter email 
And enter Password 
And click signin button 
Then user should be logged in 
When user click on logout link
Then I should be logout

