Feature: Login functionality

  Scenario: User login with valid credential
    Given User access the SauceDemo login page
    When User input the registered username
    And User input the registered password
    And User click the Login Button
    Then User will be redirected to Products Page

  Scenario: User login with invalid credential
    Given User access the SauceDemo login page
    When User input the unregistered username
    And User input the unregistered password
    And User click the Login Button
    Then Error message will be displayed