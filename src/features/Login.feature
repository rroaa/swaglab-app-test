 @UserLoginFeature
 Feature: User Login
 Description: to test the user-login functionality on Swag Lab App
 
 @PositiveScenario
 Scenario Outline: Verify user is able to login with valid credentials
 	Given User has been registered in the website and user on the login page
 	When User enters "<username>" and "<password>"
 	And User clicks on login button 
 	Then User is navigated to products page
 	
 	Examples: 
 	|username     | password    |
 	|standard_user|	secret_sauce|
 	
 @NegativeScenario
  Scenario Outline: Verify user is not able to login with invalid credentials
 	Given User has been registered in the website and user on the login page
 	When User enters "<username>" and "<password>" 
 	And User clicks on login button 
 	Then Error message appears to the user
 	
 	Examples: 
 	|username     | password  |
 	|standard_user|	p@ssw0rd  |
 	
 
 