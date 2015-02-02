Feature: Login
	As a Custommer
	I want to be able to login
	So that I can access to restrictived features

	Scenario: unauthenticated User
		Given I am on the login page
		When I login
		Then I should be logged in
