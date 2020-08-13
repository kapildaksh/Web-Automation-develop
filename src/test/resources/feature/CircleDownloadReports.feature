Feature: Download reports for all the three languangues 
         As a user I want to download reports in SC, TC and EN languages 


@SmokeTest @RegressionTest @DownloadReports
Scenario: download dnafit reports 
Given page homepage is loaded
When User Login to Application
And enter email to download dnafit report
And enter Password 
And click signin button 
Then user should be logged in 
When user click on view report button
And click on download report with en
Then en dnafit report should be downloaded
And click on download report with hk
Then hk dnafit report should be downloaded
And click on download report with cn
Then cn dnafit report should be downloaded

@SmokeTest @RegressionTest @DownloadReports
Scenario: download aviva reports 
Given page homepage is loaded
When User Login to Application
And enter email to download aviva report
And enter Password 
And click signin button 
When user click on view report button
And click on download report with en
Then en aviva report should be downloaded
And click on download report with hk
Then hk aviva report should be downloaded
And click on download report with cn
Then cn aviva report should be downloaded

@SmokeTest @RegressionTest @DownloadReports
Scenario: download cigna reports 
Given page homepage is loaded
When User Login to Application
And enter email to download cigna report
And enter Password 
And click signin button 
When user click on view report button
And click on download report with en
Then en cigna report should be downloaded
And click on download report with hk
Then hk cigna report should be downloaded
And click on download report with cn
Then cn cigna report should be downloaded

@SmokeTest @RegressionTest @DownloadReports
Scenario: download cancer negative reports 
Given page homepage is loaded
When User Login to Application
And enter email to download cancer report
And enter Password 
And click signin button 
When user click on view report button
And click on download cancer report with en
Then en cancer report should be downloaded
And click on download cancer report with hk
Then hk cancer report should be downloaded
And click on download cancer report with cn
Then cn cancer report should be downloaded


@SmokeTest @RegressionTest @DownloadReports
Scenario: download combo product reports 
Given page homepage is loaded
When User Login to Application
And enter email to download combo report
And enter Password 
And click signin button 
When user click on view report button for dnafit
And click on download report with en
Then en dnafit report should be downloaded
And click on download report with hk
Then hk dnafit report should be downloaded
And click on download report with cn
Then cn dnafit report should be downloaded
And click on circle logo
When user click on view report button for cancer
And click on download cancer report with en
Then en cancer report should be downloaded
And click on download cancer report with hk
Then hk cancer report should be downloaded
And click on download cancer report with cn
Then cn cancer report should be downloaded