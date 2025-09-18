@Regression
Feature: Regression flow on Online booking

  Background: Launch the browser and hit the CR site
    Given Hit the Canyon Ranch staging URL
    When User hit the service listing of las-vegas location
    And User lands on service listing page

  Scenario Outline: Book the Multi guest appointment with two guest
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the pillar name to select the category
    And user select the service to the cart page
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    And user select the addons and clicks Continue CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration from the page
    And user clicks Add to cart CTA
    And user selects the any gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date for two guests
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |


  Scenario Outline: Remove one of the guest from two guests and convert into Single guest flow booking
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the pillar name to select the category
    And user select the service to the cart page
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    And user select the addons and clicks Continue CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    And user selects the any gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date for two guests
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    Then user click Edit CTA on guest two
    And user click Remove guest CTA to delete guest two
    And user click the yes CTA on the popup to remove the guest two
    Then select the new date on the calendar in the checkout
    And user select the single time slots
    Then user click the update CTA to update the calendar
    And validate the selected date and time slots
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |


  Scenario Outline: Book the appointment with more than two Guest with update the service
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest two
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
#      And user select the addons and clicks Continue CTA
    And user selects the male gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    Then user click Edit option on any one of the guest
    And user clicks pencil icon of editing guest
    And user redirect to service details page with Save changes CTA
    And user clicks the Save changes CTA
#      And user click continue CTA to select select the gender
    Then user change only gender preference
    Then user clicks confirm preferences CTA
    Then user redirects to cart page with success updated message
    When user checks the cart count after update the service
    And user refresh the page
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno    | vcode  |
      | +2111111119 | 111119 |

  @fail
  Scenario Outline: Delete the service for selected guest and add it service in the cart page
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration from the page
    Then user clicks Add to cart CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest two
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration from the Guest Two
    Then user clicks Add to cart CTA
#      And user select the addons and clicks Continue CTA
    And user selects the male gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    Then validate the new guest cart for adding Multi guest
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest three
    And user select the service from another category for guest three
    Then User navigate to service details page
    Then user refresh the page
    Then user select the duration from the page
    Then user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
    Then user select the addons from the modal
    And user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user clicks delete icon on the editing guest to delete service
    And validate the guest deleted message
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    And user refresh the page
    When user select the pillar name to select the category for the selected guest service deleted
    And user select the service from another category for guest with deleted service
    Then User navigate to service details page
    Then user select the duration from the page
    And user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest two
    And user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user enter the Guest Three details and saved
    And user saved the Guest Three info
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |

  Scenario Outline: Delete one guest in the checkout and select the new date and time slots and booked
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest two
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    And user selects the male gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    Then validate the new guest cart for adding Multi guest
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest three
    And user select the service from another category for guest three
    Then User navigate to service details page
    Then user refresh the page
    Then user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
    And user select the addons from the modal
    And user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user enter the Guest Three details and saved
    And user saved the Guest Three info
    Then user click Edit CTA on guest two
    And user click Remove guest CTA to delete guest two
    And user click the yes CTA on the popup to remove the guest two
    Then select the new date on the calendar in the checkout
    Then select the group time slots on selected date in the checkout
    Then user click the update CTA to update the calendar
    And validate the selected date and time slots
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |

  @fails
  Scenario Outline: Refresh the checkout page and select the new date and time slots and booked
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest two
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
#    And user select the addons and clicks Continue CTA
    And user selects the male gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    Then validate the new guest cart for adding Multi guest
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest three
    And user select the service from another category for guest three
    Then User navigate to service details page
    Then user refresh the page
    Then user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
    And user select the addons from the modal
    And user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user enter the Guest Three details and saved
    And user saved the Guest Three info
    Then user refresh the page
    Then select the new date on the calendar in the checkout
    Then select the group time slots on selected date in the checkout
    Then user click the update CTA to update the calendar
    And validate the selected date and time slots
    And validate all the guest information is saved or not
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |


  Scenario Outline: Select the service from the similar service section to add for one of the guests
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest two
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    And user selects the any gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    Then validate the new guest cart for adding Multi guest
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest three
    And user select the service from another category for guest three
    Then User navigate to service details page
    And user refresh the page
    And user clicks any one service from the similar services section for the guest three
    Then User navigate to service details page
    Then user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
    And user select the addons from the modal
#		And user selects the male gender preference
    And user clicks confirm preferences CTA
    When user checks the cart count after update the service
    When user navigate to cart page
    And user clicks delete icon on the editing guest to delete service
    And validate the guest deleted message
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
#		And user refresh the page
    When user select the pillar name to select the category for the selected guest service deleted
    And user select the service from another category for guest with deleted service
    Then User navigate to service details page
    And user refresh the page
    Then user select the duration from the page
    And user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest two
    And user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user enter the Guest Three details and saved
    And user saved the Guest Three info
    Then user refresh the page
    Then select the new date on the calendar in the checkout
    Then select the group time slots on selected date in the checkout
    Then user click the update CTA to update the calendar
    And validate the selected date and time slots
    And validate all the guest information is saved or not
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |


  Scenario Outline: Select the service from the similar service section to add for all the guests carts
    When user select the service from any category for the guest one
    And user clicks the sign-in or register CTA
    Then user navigates to login page
    Then user enter the registered number "<mobileno>" from login page
    And user clicks get verification code CTA
    Then user enter the verification code "<vcode>"
    And user redirects to service listing page
    When user navigates to cart page
#    Then user delete the services added in the cart
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest two
    And user select the service from another category for guest two
    Then User navigate to service details page
    And user clicks any one service from the similar services section for the guest two
    Then User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    And user select the addons from the modal
    And user click continue CTA to select select the gender
    And user selects the female gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    Then validate the new guest cart for adding Multi guest
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for guest three
    And user select the service from another category for guest three
    Then User navigate to service details page
    And user refresh the page
    Then user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
    And user select the addons from the modal
    And user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user refresh the page
    When user checks the cart count after update the service
    And user clicks delete icon on the editing guest to delete service
    And validate the guest deleted message
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    When user select the pillar name to select the category for the selected guest service deleted
    And user select the service from another category for guest with deleted service
    Then User navigate to service details page
    Then user select the duration from the page
    And user refresh the page
    And user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest two
    And user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user validate the Continue to checkout CTA in the cart
    Then user clicks the Continue to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user enter the Guest Three details and saved
    And user saved the Guest Three info
    Then user refresh the page
    Then select the new date on the calendar in the checkout
    Then select the group time slots on selected date in the checkout
    Then user click the update CTA to update the calendar
    And validate the selected date and time slots
    And validate all the guest information is saved or not
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111111 | 111111 |


  Scenario Outline: Navigate to reschedule page by clicking first Reschedule option
    When User hit the login url
    When user lands on login page
    Then user enter the registered mobile number "<mobileno>"
    And user clicks get verify code CTA in login page
    Then user enter the verification code "<vcode>"
    And user lands on account landing page
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
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |


  Scenario Outline: Navigate to service history page from confirmation page
    When User hit the login url
    When user lands on login page
    Then user enter the registered mobile number "<mobileno>"
    And user clicks get verify code CTA in login page
    Then user enter the verification code "<vcode>"
    And user lands on account landing page
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
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |

  @M
  Scenario Outline: Book the Multi guest appointment with two guest and reschedule the same appointment
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the pillar name to select the category
    And user select the service to the cart page
    And User navigate to service details page
    Then user select the duration
    And user clicks Add to cart CTA
    And user select the addons and clicks Continue CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    And user select the service from another category for guest two
    Then User navigate to service details page
    Then user select the duration from the page
    And user clicks Add to cart CTA
    And user selects the any gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date for two guests
    And check the group timeslots visible on the calendar section
    And user selects the available group time slots
    Then user clicks the Continue to checkout CTA
    Then user lands on signup checkout page
    And user toggle to the login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verify code CTA
    And user enter the code "<vcode>"
    Then user clicks the Proceed to checkout CTA
    Then user lands on checkout page
    And user saved the Guest One info
    And user enter the Guest Two details and saved
    And user saved the Guest Two info
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    And user click the service option from the account panel
    Then user navigate to service history page
    Then user search the reservation number from the list of appointments
    And check the same reservation number is able to reschedule the date and time
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |