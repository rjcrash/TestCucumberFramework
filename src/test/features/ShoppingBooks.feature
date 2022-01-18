Feature: Shopping books end to end test

  Scenario: In section books search for Harry Potter and the Cursed Child
    Given I navigate to Home Page
    And I verify that Home Page title is Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more
    And I select search section Books and type Harry Potter and the Cursed Child
    And I verify that the first item contains title Harry Potter and the Cursed Child - Parts One and Two
    And I verify item if it has any badge
    And I verify the selected type is Paperback
    And I verify the price is 4.00 in pounds
    And I navigate to the first book details
    And I verify product title Harry Potter and the Cursed Child - Parts One and Two: The Official Playscript of the Original West End Production
    And I verify product item if it has any badge
    And I verify the product price is 4.00 in pounds
    And I verify the selected product type is Paperback
    And I add the product into basket
    And I verify that the notification is shown
    And I verify the title Added to Basket
    And verify there is 1 item in the basket
    And I click on the basket
    And I verify that the book in basket is shown on the list
    And I verify that the book in basket has title Harry Potter and the Cursed Child - Parts One and Two: The Official Playscript of the Original West End Production
    And I verify that the book type is Paperback
    And I verify that the book price is 4.00 in pounds
    When I verify that the quantity is 1
    Then I verify that the total price is 4.00 in pounds