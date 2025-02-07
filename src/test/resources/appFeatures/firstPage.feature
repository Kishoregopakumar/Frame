Feature: Income Protection Form
  As a user
  I want to fill out the income protection form
  So that I can proceed by clicking the "Continue" button


  Scenario: Verify navigation to the next page when clicking Continue
  Given user filled all required fields
  When user enters retirement age "45"
  And user enters income "35000"
  And user clicks on continue button
  Then user navigates to next Page
  
    
    
