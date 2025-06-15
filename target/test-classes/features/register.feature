@register
Feature: Register Functionality
  As a new user
  I want to create a new account
  So that I can access the application
      
  Scenario: Successful register with valid information
    Given I am on the register page
    And I enter first name "John"
    And I enter last name "Doe"
    And I enter non-existing email
    And I enter password "P@ssw0rd123"
    And I confirm password "P@ssw0rd123"
    And I click on Create an Account button
    Then I should see a success message 'Thank you for registering with Main Website Store.'
    And I should be redirected to the login page
  
  @test
  Scenario: Failed register with existing email
    Given I am on the register page
    When I enter first name "Thu"
    And I enter last name "Bui"
    And I enter email "test_thu_3@example.com"
    And I enter password "P@ssw0rd123"
    And I confirm password "P@ssw0rd123"
    And I click on Create an Account button
    Then I should see an error message 'There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.'
