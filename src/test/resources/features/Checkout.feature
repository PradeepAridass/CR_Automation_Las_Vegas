Feature: Validate the checkout page

  Background: Launch the browser and hit the CR site
    Given Hit the Canyon Ranch staging URL
    When User hit the service listing of las-vegas location
    And User lands on service listing page


  Scenario Outline: Book the Multi guest appointment
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration and clicks Add to Cart CTA
    Then user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
    Then user clicks the Add new guest CTA
    Then validate the new guest cart
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    And user select the service from another category
    Then User navigate to service details page
    Then user select the duration and clicks Add to Cart CTA
    And user select the addons and clicks Continue CTA
    And user selects the any gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    Then user click Edit option on any one of the guest
    And user clicks pencil icon of editing guest
    And user redirect to service details page with Save changes CTA
    And user clicks the Save changes CTA
    Then user change only gender preference
    Then user clicks confirm preferences CTA
    Then user redirects to cart page with success updated message
    When user checks the cart count after update the service
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
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno   | vcode  |
      | 2111111119 | 111119 |


  Scenario Outline: Delete the service for selected guest and add it service
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration and clicks Add to Cart CTA
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
    Then user select the duration and clicks Add to Cart CTA
    And user select the addons and clicks Continue CTA
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
    Then user select the duration and clicks Add to Cart CTA
    When user navigate to cart page
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
    And user refresh the page
    Then user redirects to service listing page
    When user select the pillar name to select the category for the selected guest service deleted
    And user select the service from another category for guest with deleted service
    Then User navigate to service details page
    Then user select the duration from the page
    And user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
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
    And user enter the Guest Three details and saved
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
    Then user select the duration and clicks Add to Cart CTA
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
    Then user select the duration and clicks Add to Cart CTA
    And user select the addons and clicks Continue CTA
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
    Then user select the duration and clicks Add to Cart CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    And user selects the available date for multi guest
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
    And user enter the Guest Three details and saved
    And user saved the Guest Three info
    And user checks the payment card added
    Then user clicks book CTA
    Then user navigates to confirmation page
    And user validate the reservartion number generated
    Examples:
      | mobileno    | vcode  |
      | +2111111119 | 111119 |


  Scenario Outline: Delete one guest and select the new date and time slots and booked
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration and clicks Add to Cart CTA
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
    Then user select the duration and clicks Add to Cart CTA
#    And user select the addons and clicks Continue CTA
    And user selects the male gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    Then validate the new guest cart for adding Multi guest
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    Then user refresh the page
    When user select the pillar name to select the category for guest three
    And user select the service from another category for guest three
    Then User navigate to service details page
    Then user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
    And user selects the any gender preference
    And user clicks confirm preferences CTA
    When user navigate to cart page
#    Then user select the duration and clicks Add to Cart CTA
##    And user select the addons and clicks Continue CTA
#    And user selects the female gender preference
#    And user clicks confirm preferences CTA
#    When user navigate to cart page
#    And user refresh the page
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
    And user enter the Guest Three details and saved
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

  @check
  Scenario Outline: Refresh the checkout page and select the new date and time slots and booked
    When user navigates to cart page
    And user click the Continue Browsing CTA
    When user select the service from Body Treatment category
    And User navigate to service details page
    Then user select the duration and clicks Add to Cart CTA
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
    Then user select the duration and clicks Add to Cart CTA
#    And user select the addons and clicks Continue CTA
    And user selects the male gender preference
    Then user clicks confirm preferences CTA
    When user navigate to cart page
    When user checks the cart count after update the service
    Then validate the new guest cart for adding Multi guest
    And click Add service CTA on the new guest
    Then user redirects to service listing page
    Then user refresh the page
    When user select the pillar name to select the category for guest three
    And user select the service from another category for guest three
    Then User navigate to service details page
    Then user clicks the guest dropdown of Add to cart CTA
    And select the guest to add the service for guest three
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
    And user enter the Guest Three details and saved
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
