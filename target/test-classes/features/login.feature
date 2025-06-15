@login
Feature: Login Functionality
  As a user
  I want to login to the application
  So that I can access my account

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click on login button
    Then I should be redirected to the dashboard

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "invalid_user" and password "wrong_password"
    And I click on login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
