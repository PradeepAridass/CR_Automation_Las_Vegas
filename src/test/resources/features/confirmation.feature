Feature: Validating the data in the confirmation page
	
	Background: Launch the browser and hit the CR site
		Given Hit the Canyon Ranch staging URL
		When User hit the service listing of las-vegas location
	
	@Test
	Scenario Outline: Validate the guest details
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
		Then validate the guest details in the checkout page
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
		Then validate the guest details in the confirmation page
		Examples:
			| mobileno   | vcode  |
			| 2111111119 | 111119 |
	