Feature: Cancellation of booked appointment

  Background: Launch the browser and hit the login url
    Given Hit the Canyon Ranch staging URL
    When User hit the login url
    Then user refresh the page
    When user lands on login page
    Then user enter the registered mobile number "2111111114"
    And user clicks get verify code CTA in login page
    Then user enter the verification code "111114"
    And user lands on account landing page
    Then user click services option on the menu panel

  @can
  Scenario: Select the first cancellation button
    When user check and click the second cancel button on the menu icon
    And user clicks the keep appointment CTA
