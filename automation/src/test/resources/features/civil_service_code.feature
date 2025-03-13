Feature: Verify the "Civil Service Code" link on the Civil Service Jobs Website

  Scenario: Locate and verify "Civil Service Code"
    Given I navigate to the Civil Service Jobs website
    When I select on "careers available at civil service"
    When I locate on "Working for the Civil Service"
    And I click on "Civil Service Code"
    Then I should be redirected to the "Code" section of the Civil Service Commission website