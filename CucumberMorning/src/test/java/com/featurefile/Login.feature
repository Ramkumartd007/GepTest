#Feature: List of scenarios.
Feature: login functionality of application
               
         user login with valid data and land into home page og the application

#Scenario: Business rule through list of steps with arguments.             
Scenario: user login facebook application

#Given: Some precondition step
Given user launch the application

#When: Some key actions
When user enter the "ramkumartd2012@gmail.com" in email field

#And,But: To enumerate more Given,When,Then steps
And user enter the "Ramkumar" in the password field

#Then: To observe outcomes or validation
Then user click the login button






