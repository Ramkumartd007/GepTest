#Feature: List of scenarios.
Feature: login functionality of application
               
user login with valid data and land into home page og the application

#Scenario: Business rule through list of steps with arguments            
Scenario Outline: user login facebook applications

#Given: Some precondition step
Given user launch the application from chrome browsers

#When: Some key actions
When user enter the below detail

|username|password|
|Ramkumar@gmail.com|7894561230|
|Kumar@gmail.com|9234567980|
|Venkat@gmail.com|8527419630|
|Aravind@gmail.com|963456781|

#Then: To observe outcomes or validation
Then user clicked the login buttons


