Feature: Login Feature Scenario

  Background: 
    Given I have launched the application

  Scenario: This scenario is for sucessful login by hardcoding
    When I enter the Username as "standard_user" and Password as "secret_sauce"
    And I click on the Login Button
    Then I should land on the home page

  @sanity
  Scenario: This scenario is for sucessful login
    When I enter the correct username and passowrd
    And I click on the Login Button
    Then I should land on the home page

  @sanity
  Scenario: This sceanrio is for failed login
    When I enter the incorrect username and passowrd
    And I click on the Login Button
    Then I should get the error message "Epic sadface: Username and password do not match any user in this service"
