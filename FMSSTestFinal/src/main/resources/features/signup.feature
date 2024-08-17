Feature: Application Signup Process Verification

  @appium
  Background: User Opens the application
    Given User opens the application

  Scenario: User registers successfully with valid details
    When User enters a valid first name
    And User enters a valid last name
    And User enters a valid email address
    And User enters a strong password
    And User clicks on the "Register" button
    Then User should see a "Registration successful" message

  Scenario: User tries to register without entering a first name
    When User leaves the first name field empty
    And User enters a valid last name
    And User enters a valid email address
    And User enters a strong password
    And User clicks on the "Register" button
    Then User should see a "First name is required" error message

  Scenario: User tries to register without entering a last name
    When User enters a valid first name
    And User leaves the last name field empty
    And User enters a valid email address
    And User enters a strong password
    And User clicks on the "Register" button
    Then User should see a "Last name is required" error message

  Scenario: User tries to register with an invalid email format
    When User enters a valid first name
    And User enters a valid last name
    And User enters an invalid email address
    And User enters a strong password
    And User clicks on the "Register" button
    Then User should see a "Invalid email format" error message

  Scenario: User tries to register with a weak password
    When User enters a valid first name
    And User enters a valid last name
    And User enters a valid email address
    And User enters a weak password
    And User clicks on the "Register" button
    Then User should see a "Password must be at least 6 characters" error message

  Scenario: User tries to register with an already registered email
    When User enters a valid first name
    And User enters a valid last name
    And User enters an already registered email address
    And User enters a strong password
    And User clicks on the "Register" button
    Then User should see a "This email address is already registered" error message

  Scenario: User tries to register without filling in any fields
    When User leaves all fields empty
    And User clicks on the "Register" button
    Then User should see a "All fields are required" error message
