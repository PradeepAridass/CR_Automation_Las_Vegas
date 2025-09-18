@Reschedule
Feature: Reschedule flow validation

  Background: Launch the browser and hit the login url
    Given Hit the Canyon Ranch staging URL
    When User hit the login url
    Then user refresh the page
    When user lands on login page
    Then user enter the registered mobile number "2111111114"
    And user clicks get verify code CTA in login page
    Then user enter the verification code "111114"
    And user lands on account landing page


  Scenario: Navigate to reschedule page by clicking first Reschedule option
    Then user click services option on the menu panel
    Then user validate the landing service landing page
    And count the number of booked appointment
    Then user is able to click the single guest appointment
    And user navigate to Reschedule page
    Then user check the current schedule date and time
    Then user select the new date and available time to reschedule
    And user click the update CTA to update the calendar in the reschedule page
    And user click the Reschedule CTA
    Then user navigates to confirmation page after reschedule


  Scenario: Validate the new schedule date and time in both reschedule and confirmation page
    Then user click services option on the menu panel
    Then user validate the landing service landing page
    And count the number of booked appointment
    Then user is able to click the single guest appointment
    And user navigate to Reschedule page
    Then user check the current schedule date and time
    Then user select the new date and available time to reschedule
    And user click the update CTA to update the calendar in the reschedule page
    And user check the new reschedule date and time in the confirmation page
    And user check the new schedule date and time
    And user click the Reschedule CTA
    Then user navigates to confirmation page after reschedule
    And user check the new schedule date and time in the confirmation page

  Scenario: Navigate to service history page from confirmation page
    Then user click services option on the menu panel
    Then user validate the landing service landing page
    And count the number of booked appointment
    Then user is able to click the single guest appointment
    And user navigate to Reschedule page
    Then user check the current schedule date and time
    Then user select the new date and available time to reschedule
    And user click the update CTA to update the calendar in the reschedule page
    And user check the new reschedule date and time in the confirmation page
    And user check the new schedule date and time
    And user click the Reschedule CTA
    Then user navigates to confirmation page after reschedule
    And user check the new schedule date and time in the confirmation page
    And user click the service option from the account panel
    Then user navigate to service history page

  @Res
  Scenario: Navigate to service history page from confirmation page
    Then user click services option on the menu panel
    Then user validate the landing service landing page
    And count the number of booked appointment
    Then user is able to click the single guest appointment
    And user navigate to Reschedule page
    Then user check the current schedule date and time
    Then user select the new date and available time to reschedule
    And user click the update CTA to update the calendar in the reschedule page
    And user check the new reschedule date and time in the confirmation page
    And user check the new schedule date and time
    And user click the Reschedule CTA
    Then user navigates to confirmation page after reschedule
    And user fetch the confirmation or reservation number in the confirmation page
    And user check the new schedule date and time in the confirmation page
    And user click the service option from the account panel
    Then user navigate to service history page
    And user validate the new time slots for the booked appointment in the service history page