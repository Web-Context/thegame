Feature: Login
	As a Custommer
	I want to be able to login
	So that I can access to restrictived features

	Scenario: unauthenticated User
		Given I am on the login page
		When I login
		Then I should be logged in

	Scenario: User who has not loggin for ages
		Given I have not logged in for 7 years
		And I am on the login page
		When I login
		Then I should see the welcome back message

	Scenario: User who login with an unknown username
		Given I am on the login page
		When I login with aN unknown username
		Then I should see the unknwon username message
		And I am proposed to register with the register link 

	Scenario: User input the wrong password
		Given I am on the login page
		When I login with wrong password
		Then I should see the error password message
		And I am proposed to reset my password with the reset link
		