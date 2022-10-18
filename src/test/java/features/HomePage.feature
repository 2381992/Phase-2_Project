Feature: Home Page feature scenario

  Background: 
    Given I have launched the application

  Scenario: This scenario is for adding product to cart
    When I enter the correct username and passowrd
    And I click on the Login Button
    And I should land on the home page
    And If Product name is "Sauce Labs Bike Light" add it to cart
    Then I check the corresponing Product numbers in the cart as been increased to 1

  @sanity
  Scenario Outline: This scenario is for adding products to cart
    When I enter the correct username and passowrd
    And I click on the Login Button
    And I should land on the home page
    And If Product name is "<ProductName>" add it to cart
    Then I check the corresponing Product numbers in the cart as been increased to 1

    Examples: 
      | ProductName                       |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  @sanity
  Scenario: This scenario is for adding products to cart
    When I enter the correct username and passowrd
    And I click on the Login Button
    And I should land on the home page
    And If Product name is "Sauce Labs Bike Light" add it to cart
    Then I check the corresponing Product numbers in the cart as been increased to 1
    And If Product name is "Sauce Labs Backpack" add it to cart
    Then I check the corresponing Product numbers in the cart as been increased to 2
    And If Product name is "Sauce Labs Onesie" add it to cart
    Then I check the corresponing Product numbers in the cart as been increased to 3
