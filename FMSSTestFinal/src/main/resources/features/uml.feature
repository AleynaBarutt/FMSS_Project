Feature: User Account Management
  In order to use the application securely
  As a user
  I want to register, log in, enable 2FA, update account details, and delete my account

  Scenario: User registers a new account
    Given User is on the registration page
    When User enters valid registration details
    And User submits the registration form
    Then User should see a "Registration successful" message
    And User should be redirected to the login page

  Scenario: User logs in to the application
    Given User is on the login page
    When User enters valid login credentials
    And User clicks on the "Login" button
    Then User should be logged in successfully
    And User should be redirected to the home page

  Scenario: User enables Two-Factor Authentication (2FA)
    Given User is logged in
    When User navigates to the "Security Settings" page
    And User enables Two-Factor Authentication
    Then User should see a "Two-Factor Authentication enabled successfully" message

  Scenario: User logs in with Two-Factor Authentication enabled
    Given User has enabled Two-Factor Authentication
    When User logs out
    And User logs in with valid credentials
    Then User should be prompted to enter the verification code
    When User enters the correct verification code
    Then User should be logged in successfully


  Scenario: User updates account details
    Given User is logged in
    When User navigates to the "Account Settings" page
    And User updates their account details
    And User submits the updated details
    Then User should see a "Account details updated successfully" message

  Scenario: User deletes their account
    Given User is logged in
    When User navigates to the "Account Settings" page
    And User clicks on "Delete Account"
    And User confirms the account deletion
    Then User should see a "Your account has been deleted successfully" message
    And User should be redirected to the registration page



Feature: Registered user car rental process

  Background:
    Given User is on the login page
    And User has a valid account

  Scenario: User logs in and performs two-factor authentication
    When User enters their username and password
    And User clicks the "Login" button
    Then User is prompted for two-factor authentication
    When User enters the verification code sent to their phone
    Then User is logged in successfully

  Scenario: User updates account information
    Given User is logged in
    When User navigates to the account settings page
    And User updates their personal information (e.g., name, email, phone number)
    And User clicks the "Save" button
    Then User should see a confirmation message "Your account information has been updated successfully"
    And User's updated information should be displayed on the account settings page

  Scenario: User deletes their account
    Given User is logged in
    And User is on the account settings page
    When User clicks the "Delete Account" button
    And User confirms the deletion
    Then User should see a confirmation message "Your account has been deleted successfully"
    And User should be redirected to the homepage
    And User should no longer be able to log in with the deleted account

  Scenario: User searches for a car
    Given User is logged in
    When User navigates to the car search page
    And User enters search criteria (e.g., location, date, car type)
    And User clicks the "Search" button
    Then User should see a list of available cars

  Scenario: User lists cars
    Given User is on the car search results page
    When User filters the car list by criteria (e.g., price, brand)
    Then User should see an updated list of cars based on the filter

  Scenario: User revises a car
    Given User has selected a car from the list
    When User clicks on the "Revise" button
    And User changes the car options (e.g., add GPS, child seat)
    Then User should see the updated car details

  Scenario: User makes a payment
    Given User is on the checkout page with the selected car
    When User enters payment details (e.g., credit card info)
    And User clicks the "Pay" button
    Then User should see a payment confirmation message

  Scenario: User views reservation
    Given User is logged in
    When User navigates to the reservation page
    Then User should see a list of their current and past reservations
    And User clicks on a reservation to view the details
    Then User should see the reservation details


Feature: Admin Manages Car Rentals and Customer Information

  Scenario 1: Admin adds a new car to the system
    Given Admin is logged in to the system
    When Admin navigates to the "Add Car" page
    And Admin fills in all required car details
    And Admin clicks the "Save" button
    Then The new car should be added to the system
    And Admin should see a confirmation message "Car successfully added"

  Scenario 2: Admin edits an existing car's details
    Given Admin is logged in to the system
    And A car exists in the system
    When Admin navigates to the "Edit Car" page for that car
    And Admin updates the car details
    And Admin clicks the "Save" button
    Then The car's details should be updated in the system
    And Admin should see a confirmation message "Car details successfully updated"

  Scenario 3: Admin deletes a car from the system
    Given Admin is logged in to the system
    And A car exists in the system
    When Admin navigates to the "Delete Car" page for that car
    And Admin confirms the deletion
    Then The car should be removed from the system
    And Admin should see a confirmation message "Car successfully deleted"

  Scenario 4: Admin manages customer reservations
    Given Admin is logged in to the system
    And There are customer reservations in the system
    When Admin navigates to the "Manage Reservations" page
    And Admin selects a reservation to update or cancel
    Then Admin should be able to update or cancel the reservation
    And Admin should see a confirmation message "Reservation successfully updated/canceled"

  Scenario 5: Admin views customer information
    Given Admin is logged in to the system
    When Admin navigates to the "Customer Information" page
    Then Admin should see a list of customers with their details
    And Admin should be able to view detailed information for each customer

  Scenario 6: Admin generates reports
    Given Admin is logged in to the system
    When Admin navigates to the "Generate Reports" page
    And Admin selects the type of report and date range
    And Admin clicks the "Generate" button
    Then The system should generate the requested report
    And Admin should see a confirmation message "Report successfully generated"


