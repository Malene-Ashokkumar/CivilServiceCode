Feature: Search for a Job on Civil Service Jobs Website

 Background:
    Given I navigate to the Civil Service Jobs website
    When I search for "Analyst" jobs in "London" 
    
  Scenario: Select Department and Verify Job Listings
    When I select the department "Medicines and Healthcare products Regulatory Agency" from the filter options
    And I select the first available job listing
    Then I should see the number of jobs available on the job listing details page