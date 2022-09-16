Feature: Assistive portal web application functionality test

Scenario: validate login successful to Assistive dashboard with valid credentials

Given user opens browser
Then user is on login Page
When user enters username and password and clicks on Login button
Then user is navigated to Dahboard
Then user is on Dashboard Page