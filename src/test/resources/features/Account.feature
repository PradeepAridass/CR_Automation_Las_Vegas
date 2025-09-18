@Accounts
Feature: Validate the account each pages

  Background: Launch the browser and hit the login url
    Given Hit the Canyon Ranch staging URL
    When User hit the login url
    Then user refresh the page
    When user lands on login page
    Then user enter the registered mobile number "2111111119"
    And user clicks get verify code CTA in login page
    Then user enter the verification code "111119"
    And user lands on account landing page

  Scenario: Navigate to the service landing page by service option
    When user click services option on the menu panel
    Then user validate the landing service landing page

  Scenario: Navigate to the service landing page by clicking View more
    Then user click view more CTA on the service section
    Then user validate the landing service landing page


  Scenario: Navigate to the service details page by clicking arrow
    Then user click arrow on the service section
    Then user validate the landing service details page

  Scenario: Count the appointment and navigate to the service details page
    Then user click services option on the menu panel
    Then user validate the landing service landing page
    And count the number of booked appointment
    Then user click the view details of any of the booked appointment
    And user navigates to service details page