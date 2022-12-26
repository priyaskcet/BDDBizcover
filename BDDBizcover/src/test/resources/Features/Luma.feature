Feature: Feature to test the Login Functionality

  @Login
  Scenario Outline: Check for Login Success using Valid Credentials
    Given User opens the shopping site
    When User is on login page
    When User enters <username> and <password>
    Then User selects Top-> Jackets from the dropdown
    And User selects <Jacketname> from Jackets
    Then User Selects the <Size> , <Colour> and <Quantity>
    Then User clicks on Add to cart
    And User Selects pants from mens bottom
    Then User selects <Pantname> from Pants
    Then User select pant <PSize>, <Colour> and <PQuantity>
    Then User clicks on Add to cart
    And Go to cart verify <Jacketname> , <Pantname> and proceed to checkout
    Then Place Order
    And Go to My orders
    Then Verify for the order number
    Then Logout

    Examples: 
      | username               | password    | Jacketname                | Size | Colour | Quantity | Pantname         | PSize | PQuantity |
      | prepri010203@gmail.com | Password@123 | Proteus Fitness Jackshirt | M    | black  |        2 | Cronus Yoga Pant |    32 |       1 |
