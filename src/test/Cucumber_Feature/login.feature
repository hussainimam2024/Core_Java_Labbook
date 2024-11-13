@tag
Feature: Login to opencart Application


  Scenario: Login Successful
    Given Launch the Browser
    And Navigate to the URL
    When Enter the valid username and password
    And Click on login button
    Then Login should be successful


  Scenario: Login Unsuccessful
    Given Launch the Browser
    And Navigate to the URL
    When Enter the valid username and password
    And Click on login button
    Then Login should be unsuccessful
