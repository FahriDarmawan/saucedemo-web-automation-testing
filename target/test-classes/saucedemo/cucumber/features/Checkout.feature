Feature: Checkout Product

  Scenario: User can checkout the product
    Given User already login and add product to the cart
    And User access the Cart Page
    When User click Checkout Button
    Then User will be redirected to Your Information Page
    And User input the First Name
    And User input the Last Name
    And User input the ZipPostal Code
    When User click the Continue Button
    Then User will be redirected to Overview Page
    When User click the Finish Button
    Then User will be redirected to Complete Order Page