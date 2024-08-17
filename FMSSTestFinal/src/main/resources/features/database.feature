Feature: User and Role Management

  Background:
    Given The database is set up correctly
    And The following roles exist in the User_Roles table:
      | role_id | role_name  |
      | 1       | User       |
      | 2       | Admin      |
      | 3       | Super Admin |

  Scenario: Creating a New User
    Given Necessary information to create a new user is available
    When A new user is registered with the email "testuser@example.com"
    Then A record with this email address should be found in the Users table
    And The user information in the Users table should be as follows:
      | email                | password_hash  | first_name | last_name | phone_number | identity_number | passport_number | date_of_birth |
      | testuser@example.com | hashed_password | Test       | User      | 1234567890   | 12345678901     | P1234567        | 1990-01-01    |

  Scenario: Assigning a Role to a User
    Given A user with the email "testuser@example.com" exists in the Users table
    When The role "Admin" is assigned to this user
    Then The User_Roles_Assignments table should have this user's assignment
    And The record in the User_Roles_Assignments table should be as follows:
      | user_id | role_id |
      | 1       | 2       |

  Scenario: Updating a User's Role
    Given There is an existing role assignment for the user with the email "testuser@example.com" in the User_Roles_Assignments table
    When The user's role is updated to "Super Admin"
    Then The User_Roles_Assignments table should have this user assigned to the "Super Admin" role
    And The record in the User_Roles_Assignments table should be as follows:
      | user_id | role_id |
      | 1       | 3       |

  Scenario: Deleting a User
    Given A user with the email "testuser@example.com" exists in the Users table
    When The user is deleted from the system
    Then The Users table should no longer contain the email "testuser@example.com"
    And The User_Roles_Assignments table should also not have any records for this user

  Scenario: Checking Role Assignment
    Given A user with the email "adminuser@example.com" exists in the Users table
    And The role "Admin" is assigned to this user
    When The system checks for the user's role
    Then The system should return the role "Admin" for the user with the email "adminuser@example.com"


  Scenario: Preventing Duplicate User Registration
    Given A user with the email "duplicate@example.com" already exists in the Users table
    When A new user attempts to register with the same email "duplicate@example.com"
    Then The system should return an error message "Email already exists"
    And The Users table should still contain only one record for "duplicate@example.com"

  Scenario: Viewing All Users
    Given Multiple users exist in the Users table
    When An admin requests to view all users
    Then The system should return a list of all users with their details

  Scenario: Searching for a User by Email
    Given A user with the email "searchuser@example.com" exists in the Users table
    When An admin searches for the user by email "searchuser@example.com"
    Then The system should return the user’s details from the Users table

  Scenario: Checking Data Types in Users Table
    Given A user with the email "testuser@example.com" exists in the Users table
    When The data types for the user fields are checked
    Then The email should be of type VARCHAR(100)
    And The password_hash should be of type VARCHAR(255)
    And The first_name should be of type VARCHAR(50)
    And The last_name should be of type VARCHAR(50)
    And The phone_number should be of type VARCHAR(15)
    And The identity_number should be of type VARCHAR(20)
    And The passport_number should be of type VARCHAR(20)
    And The date_of_birth should be of type DATE
    And The created_at should be of type TIMESTAMP
    And The updated_at should be of type TIMESTAMP
    And The status should be of type ENUM('active', 'inactive', 'suspended')
    And The is_updated should be of type BOOLEAN

  Scenario: Checking Foreign Key Constraints
    Given A user with the email "testuser@example.com" exists in the Users table
    And The role "Admin" is assigned to this user
    When The foreign key constraints are checked
    Then The user_id in the User_Roles_Assignments table should reference a valid user_id in the Users table
    And The role_id in the User_Roles_Assignments table should reference a valid role_id in the User_Roles table

  Scenario: Assigning Multiple Roles to a User
    Given A user with the email "multirole@example.com" exists in the Users table
    When The roles "User" and "Admin" are assigned to this user
    Then The User_Roles_Assignments table should have records for both roles
    And The records in the User_Roles_Assignments table should be as follows:
      | user_id | role_id |
      | 2       | 1       |
      | 2       | 2       |