@service
Feature: Service Listing and Navigation of Service details page
	
	Background: Launch the browser and hit the CR site
		Given Hit the Canyon Ranch staging URL
		When User hit the service listing of las-vegas location
	
	Scenario: Landing on Service listing page
		When User lands on service listing page
		Then validate user can able to click all the pillar name
	
	Scenario: Select the service and navigate to service details page
		When User lands on service listing page
		When user select any service from any category
		And User navigate to service details page
	
	Scenario: Redirection to the service listing page from service details page
		When User lands on service listing page
		When user select any service from any category
		And User navigate to service details page
		When user clicks the category text and redirects to service listing page
		When user select the service from any category
		And User navigate to service details page
		Then user select the duration and clicks Add to Cart CTA
#    Then validate the mini cart popup modal is displayed with success message
	
	@s1
	Scenario: Select Add-ons and gender preferences and added to cart
		When User lands on service listing page
		Then user select the service from any category with Addons
		And User navigate to service details page
		And user clicks Add to cart CTA
		Then user select the addons and clicks Continue CTA
		Then user selects the any gender preference
		Then user clicks confirm preferences CTA
	
	
	Scenario: Select the services and add to cart
#		When User lands on service listing page
		And user select the service from fort-worth and add to cart