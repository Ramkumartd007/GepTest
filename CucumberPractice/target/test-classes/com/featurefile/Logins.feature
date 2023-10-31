#Feature: List of scenarios
@all
Feature: login functionality of application
               
user login with valid data and land into home page og the application

@sr1
Scenario Outline: First user login facebook application 

#Given: Some precondition step
Given user launch the application from chrome browser

#When: Some key actions
When user enter the below details

|username|password|
|Ramkumar@gmail.com|7894561230|
|Kumar@gmail.com|9234567980|
|Venkat@gmail.com|8527419630|
|Aravind@gmail.com|963456781|

#Then: To observe outcomes or validation
Then user clicked the login button

@sr2

Scenario Outline: Second user login facebook application

#Given: Some precondition step
Given user launch the application from chrome browser

#When: Some key actions
When user enter the below details

|username|password|
|Ramkumar@gmail.com|7894561230|
|Kumar@gmail.com|9234567980|
|Venkat@gmail.com|8527419630|
|Aravind@gmail.com|963456781|

#Then: To observe outcomes or validation
Then user clicked the login button

@sr3
      
Scenario Outline: Third user login facebook application

#Given: Some precondition step
Given user launch the application from chrome browser

#When: Some key actions
When user enter the below details

|username|password|
|Ramkumar@gmail.com|7894561230|
|Kumar@gmail.com|9234567980|
|Venkat@gmail.com|8527419630|
|Aravind@gmail.com|963456781|

#Then: To observe outcomes or validation
Then user clicked the login button

