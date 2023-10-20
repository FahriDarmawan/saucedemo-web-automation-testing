Feature: Logout functionality

  Scenario: User can logout from the website
    Given User already login with the registered account
    When User click hamburger icon menu
    And Sidebar menu will be displayed
    And User click the logout button
    Then User will be redirected to login page
