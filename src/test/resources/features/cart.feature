@cartR
Feature: Cart related functions

      Background: Launch the browser and hit the CR site
            Given Hit the Canyon Ranch staging URL
            When User hit the service listing of las-vegas location
            And User lands on service listing page

      Scenario: Select the service and navigate to service details page
            When user select the one category from any pillar
            Then user select the service from selected category
            And User navigate to service details page
            And user clicks Add to cart CTA
            Then user select the addons and clicks Continue CTA
            Then user selects the male gender preference
            Then user clicks confirm preferences CTA
            When user navigate to cart page
            And user lands on cart page
            Then validate the count of the services in the cart
    
    @cart
      Scenario: Add the service to the guest from Similar service section
          When user select the one category from any pillar
          Then user select the service from selected category
          And User navigate to service details page
          And user clicks Add to cart CTA
          Then user select the addons and clicks Continue CTA
          Then user selects the male gender preference
          Then user clicks confirm preferences CTA
          When user navigate to cart page
          And user lands on cart page
          Then user clicks the Add new guest CTA
          Then validate the new guest cart
          And click Add service CTA on the new guest
          Then user redirects to service listing page
          When user select the pillar name to select the category for guest two
          And user select the service from another category for guest two
          Then User navigate to service details page
          And user clicks any one service from the similar services section for the guest two
          Then User navigate to service details page
          And user select the duration and clicks Add to Cart CTA
          And user select the addons and clicks Continue CTA
          And user selects the female gender preference
          And user clicks confirm preferences CTA
          When user navigate to cart page
          
          
          
      Scenario: Add a new guest with empty cart
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
      
      Scenario: Add a service to the new guest created
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
            And user select the service from another category for guest two
            Then User navigate to service details page
            Then user select the duration and clicks Add to Cart CTA
            And user select the addons and clicks Continue CTA
            And user selects the any gender preference
            Then user clicks confirm preferences CTA
            When user navigate to cart page
            Then validate the count of the services in the cart
            
      Scenario: Select the data and available group timeslots
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
            And user select the service from another category for guest two
            Then User navigate to service details page
            Then user select the duration and clicks Add to Cart CTA
            And user select the addons and clicks Continue CTA
            And user selects the any gender preference
            Then user clicks confirm preferences CTA
            When user navigate to cart page
            Then validate the count of the services in the cart
            And user selects the available date
            And check the group timeslots visible on the calendar section
            And user selects the available group time slots
            And user click the show arrow in the group timeslot
            And validate the timeslots details for each guest
    
   
     Scenario: Edit the guests service
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
            And user select the service from another category for guest two
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
            Then validate the signup checkout page
         
    Scenario: Delete the guests service
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
        Then user select the duration and clicks Add to Cart CTA
        When user navigate to cart page
        When user checks the cart count after update the service
        And user click remove guest CTA to delete the selected guest from cart
        And validate the guest deleted message
        When user checks the cart count after update the service
        And user selects the available date
        And check the group timeslots visible on the calendar section
        And user selects the available group time slots
        Then user clicks the Continue to checkout CTA
        Then user lands on signup checkout page
        Then validate the signup checkout page
    
    
    Scenario: Delete the service for selected guest and add it service
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
        And select the guest to add the service for guest two
        And user selects the any gender preference
        And user clicks confirm preferences CTA
        When user navigate to cart page
        When user checks the cart count after update the service
        And user selects the available date
        And check the group timeslots visible on the calendar section
        And user selects the available group time slots
        Then user validate the Continue to checkout CTA in the cart
    
    @cart1
    Scenario: Select the service from the similar service section to add for one of the guests
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
#        And user select the addons and clicks Continue CTA
        And user selects the any gender preference
        Then user clicks confirm preferences CTA
        When user navigate to cart page
        When user checks the cart count after update the service
        Then validate the new guest cart for adding Multi guest
        And click Add service CTA on the new guest
        Then user redirects to service listing page
        And user refresh the page
        When user select the pillar name to select the category for guest three
        And user select the service from another category for guest three
        Then User navigate to service details page
        And user clicks any one service from the similar services section for the guest three
        Then User navigate to service details page
        Then user clicks the guest dropdown of Add to cart CTA
        And select the guest to add the service for guest three
        And user selects the male gender preference
        And user clicks confirm preferences CTA
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
        And select the guest to add the service for guest two
        And user selects the any gender preference
        And user clicks confirm preferences CTA
        When user navigate to cart page
        When user checks the cart count after update the service
        And user selects the available date
        And check the group timeslots visible on the calendar section
        And user selects the available group time slots
        Then user validate the Continue to checkout CTA in the cart


    