Feature: Test Links

@Test1
  Scenario: Verify button ID change
    Given I am on the Challenging DOM page
    When I click the red button
    Then the red blue and green button IDs should change

@Test2
  Scenario: Verify 'Hello World!' is rendered
    Given I am on the Dynamic Loading page
    When I click Example 2 link
    Then "Hello World!" should be rendered