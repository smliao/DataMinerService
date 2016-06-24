Feature: CRUD User profile
  As a user
  I want to create user profiles
  So that I can manage different profiles

  Scenario: Create a user profile
    Given I create a user profile with the follow details
      | username | bill                       |
      | age      | 10                         |
      | interest | jogging, running, sleeping |
    Then I see user profile with details
      | username | bill                       |
      | age      | 10                         |
      | interest | jogging, running, sleeping |
