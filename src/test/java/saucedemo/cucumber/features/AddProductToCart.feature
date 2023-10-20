Feature: Add Product to Cart

  Scenario: User can add product to their cart
    Given User already on Product Page
    When User click button Add to Cart
    And User click the cart icon button
    Then User will be redirected to Cart Page
    And The product will be displayed on cart