Feature: Manage Books
  As a user of the Book Hive system,
  I want to manage books through the REST API
  So that I can view, add, update, and delete books.

  Background:
    Given the API endpoint is "http://192.168.5.75:8888/api/books"

  Scenario: Get all books
    When I send a GET request to "/"
    Then the response status should be 200
    And the response should contain a list of books

  Scenario: Get a book by ID
    Given a book with ID 1 exists in the database
    When I send a GET request to "/11"
    Then the response status should be 200
    And the response should contain the book details

#  Scenario: Add a new book
#    Given I have a book with the title "The White Tiger", author "Aravind Adiga", and price 250.0
#    When I send a POST request to "/"
#    Then the response status should be 200
#    And the response should contain the added book's details
#
#  Scenario: Update a book
#    Given a book with ID 1 exists in the database
#    And I have updated details for the book with title "The White Tiger", author "Aravind Adiga", and price 300.0
#    When I send a PUT request to "/1"
#    Then the response status should be 200
#    And the response should contain the updated book's details
#
#  Scenario: Delete a book
#    Given a book with ID 1 exists in the database
#    When I send a DELETE request to "/1"
#    Then the response status should be 204
#    And the book with ID 1 should no longer exist

#  Scenario: Place an order
#    Given the base URL is set
#    When I send the order details to the "orders" endpoint using POST
#    Then the response status code should be 201
#    And the response should contain "orderStatus" with value "Placed"
#    Then create the ExtentReports for order placement
#
#  Scenario: Release the order
#    Given the base URL is set
#    When I send the release order details to the "orders/{id}/release" endpoint
#    Then the response should contain "releaseStatus" with value "Released"
#    Then create the ExtentReports for order release
#
#  Scenario: Delete the order
#    Given the base URL is set
#    When I send the delete order details to the "orders/{id}" endpoint
#    Then the response status code should be 204
#    Then create the ExtentReports for order deletion
