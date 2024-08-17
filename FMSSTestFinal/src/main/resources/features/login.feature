Feature: User Login

  @appium
  Background:
    Given the application is opened

  Scenario: Successful login with valid username and password
    And User fills username as "testUser"
    And User fills password as "testPassword"
    Then User should be redirected to the "Home" page

  Scenario: Login with invalid username
    And User fills username as "invalidUser"
    And User fills password as "testPassword"
    Then User should see "Invalid username" error

  Scenario: Login with invalid password
    And User fills username as "testUser"
    And User fills password as "invalidPassword"
    Then User should see "Invalid password" error

  Scenario: Leaving the username field empty
    And User fills username as ""
    And User fills password as "testPassword"
    Then User should see "Username is required" error

  Scenario: Leaving the password field empty
    And User fills username as "testUser"
    And User fills password as ""
    Then User should see "Password is required" error

  Scenario: Leaving both username and password fields empty
    And User fills username as ""
    And User fills password as ""
    Then User should see "Username and password are required" error

  Scenario: Clicking on the "Forgot Password" link
    When User clicks on the "Forgot Password" link
    Then User should be redirected to the "Password Reset" page

  Scenario: Successful password reset request
    When User clicks on the "Forgot Password" link
    And User enters email as "user@example.com"
    And User clicks on the "Send Password Reset Request" button
    Then User should see "Your password reset request has been successfully sent" message


