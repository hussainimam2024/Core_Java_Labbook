Feature: Book API Management

  Scenario: Create a new book
    Given Enter the url
    And enter book details
    When post the book details
    Then validate the status code
    And validate the price
    And validate the Author

  Scenario: Get the book details
    Given Enter the url
    When get the book details
    Then validate the status code
    And validate the price
    And validate the Author

  Scenario: update the book details
    Given Enter the url
    When patch the book details
    Then validate the status code
    And validate the price
    And validate the Author

  Scenario: delete the book details
    Given Enter the url
    Then validate the status code
#  Scenario: update put the book details
#    Given Enter the url
#    When put the book details
#    Then validate the status code
#    And validate the price
#    And validate the Author
