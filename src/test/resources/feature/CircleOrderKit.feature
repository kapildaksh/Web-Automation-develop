Feature: Order circle product kit
         As a User I want to buy one or more circle product kits

@SmokeTest @RegressionTest @OrderKit
Scenario: order circle dnafit product kit
Given DNAFit checkout page is loaded
And dnafit product information and price should display
When I change the product quantity from the downdown 
Then dnafit information in cart also should be changed
When I apply promocode 
Then promocode should be applied on dnafit
When I remove promocode
Then promocode from dnafit should be removed
When I click on checkout button
And dnafit details in cart are still same
When I enter contact and shipping information 
And click on continue to payment button
And dnafit details in cart are still same
When I enter card details
And click on review order button
And dnafit details in cart are still same
When I click on purchase button
Then Order should be placed successfully


@SmokeTest @RegressionTest @OrderKit
Scenario: order circle cancer product kit
Given circle Cancer checkout page is loaded
And cancer product information and price should display
When I change the product quantity from the downdown 
Then cancer information in cart also should be changed
When I apply promocode 
Then promocode should be applied on cancer
When I remove promocode
Then promocode from cancer should be removed
When I click on checkout button
And cancer details in cart are still same
When I enter contact and shipping information 
And click on continue to payment button
And cancer details in cart are still same
When I enter card details
And click on review order button
And cancer details in cart are still same
When I click on purchase button
Then Order should be placed successfully


@SmokeTest @RegressionTest @OrderKit
Scenario: order circle combo product kit
Given circle combo checkout page is loaded
And combo product information and price should display
When I change the product quantity from the downdown 
Then combo information in cart also should be changed
When I apply promocode 
Then promocode should be applied on combo
When I remove promocode
Then promocode from combo should be removed
When I click on checkout button
And combo details in cart are still same
When I enter contact and shipping information 
And click on continue to payment button
And combo details in cart are still same
When I enter card details
And click on review order button
And combo details in cart are still same
When I click on purchase button
Then Order should be placed successfully