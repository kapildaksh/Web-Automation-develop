Feature: Book cancel and reschedule phone consultation


@SmokeTest @RegressionTest @PhoneConsultation
Scenario: Book phone consultation 
Given page homepage is loaded
When User Login to Application
And enter email 
And enter Password 
And click signin button 
Then user should be logged in 
When user click on view report button
And click on schedule appointment button
And click on update phone nubmer button
And Enter phone number to update
And Click done button
When I enter consultation details
And click on book appointment
Then booking appointment should be done


@SmokeTest @RegressionTest @PhoneConsultation
Scenario: Reschedule booked phone consultation
Given page homepage is loaded
When User Login to Application
And enter email 
And enter Password 
And click signin button 
Then user should be logged in 
When user click on view report button
And click on view appointment details button
And click on reschedule button
Then select timezone page should open
When I enter consultation details
And click on book appointment
Then booking appointment should be done


@SmokeTest @RegressionTest @PhoneConsultation
Scenario: Cancel booked phone consultation
Given page homepage is loaded
When User Login to Application
And enter email 
And enter Password 
And click signin button 
Then user should be logged in 
When user click on view report button
And click on view appointment details button
And click on cancel button
Then appointment should be cancel 


  