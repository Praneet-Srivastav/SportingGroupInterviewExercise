Feature: Test User Management

@Test3
  Scenario: Create a new user
    Given I have access to the User Creation API
    When I send a POST request to create a new user
    |id|name|Salary|age|
    |001 |praneet|10000|25|
  Then I should receive a response indicating that a user was created

    @Test4
  Scenario Outline: Delete the given user
    Given I have access to the User Deletion API
    When I send a DELETE request to delete the <userId>
    Then I should receive a response indicating that the user was deleted

      Examples:
        | userId |
        |001     |
