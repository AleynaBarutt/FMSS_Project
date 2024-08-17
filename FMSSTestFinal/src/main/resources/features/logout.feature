Feature: Application Logout Process Verification

  @appium
  Background: User is logged in
    Given User is logged in to the application

  Scenario: User logs out successfully
    When User clicks on the "Logout" button
    Then User should see a "You have been logged out" message
    And User should be redirected to the "login" screen

  Scenario: User tries to log out when already logged out
    When User clicks on the "Logout" button
    Then User should see a "You are not logged in" error message

  Scenario: User cancels the logout confirmation
    When User clicks on the "Logout" button
    And User selects "Cancel" on the confirmation dialog
    Then User should remain on the current page

  Scenario: User logs out after session timeout
    When User waits for the session to timeout
    And User tries to access a "protected" page
    Then User should see a "Session expired, please log in again" message

