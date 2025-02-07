 @SmokeTest
Feature: User Details Form and Quote Results Validation
 
  Background:
    Given User landson to the user details form page
    | retirement| income |
    | 45        | 35000  |
 
  Scenario: Verify customer details with valid inputs
    When user enter valid details in the user details form:
       | First Name | Last Name | Day | Month | Year | Email                  | Phone Number  | Postcode |
       | John       | Doe       | 15  | 08    | 1990 | john.doe@example.com   | 07384190135   | AB12CD   |
    And user check the terms and conditions checkbox
    And user click on the Continue button
    Then user navigates to next Page
   
    Scenario: Form Submission with Invalid Data
    When  user enter valid details in the user details form:
      | First Name    | Last Name    | Day | Month | Year    | Email        | Phone          | Postcode       |
      | John          |   doe        | 15  | 09    | 2006    | jhon.com     | 07384190135    | CF10 4DE       |
    And user click on the Continue button
    Then user should see error messages
