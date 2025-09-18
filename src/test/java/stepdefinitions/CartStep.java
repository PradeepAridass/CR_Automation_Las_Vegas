package stepdefinitions;

import ConstantVariables.Variables;
import DriverFactory.DriverFactory;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.ServiceListingPage;


public class CartStep {
    CartPage cart = new CartPage(DriverFactory.getDriver());
    ServiceListingPage service = new ServiceListingPage(DriverFactory.getDriver());


    @When("user navigate to cart page")
    public void user_navigate_to_cart_page() throws InterruptedException {
        cart.clickViewCart();
    }

    @When("user close the popup window")
    public void user_close_the_popup_window() {
//        cart.validatepopUp();
    }

    @When("user lands on cart page")
    public void user_lands_on_cart_page() {
        cart.validateCart();
    }

    @Then("validate the count of the services in the cart")
    public void validate_the_count_of_the_services_in_the_cart() {
        System.out.println("Landing Cart page is success: " + Variables.GREEN + cart.validateCart() + Variables.RESET);
    }

    @When("user navigates to cart page")
    public void user_navigates_to_cart_page() {
        cart.clickCartIcon();
    }

    @When("user selects the available date")
    public void user_selects_the_available_date() {
//        cart.selectDate("July 2025", 3);
//        cart.clickNextMonth();
        cart.selectDate(3);
    }

    @Then("check the timeslots visible on the calendar section")
    public void check_the_timeslots_visible_on_the_calendar_section() {
        cart.validateTimeslot();
    }

    @Then("user selects the available time slots")
    public void user_selects_the_available_time_slots() {
        cart.clickTimeslot(1);
    }

    @When("user click the Continue Browsing CTA")
    public void user_click_the_continue_browsing_cta() {
        cart.clickBrowseCTA();
    }

    @Then("user clicks the Continue to checkout CTA")
    public void user_clicks_the_continue_to_checkout_cta() {
        cart.clickCheckout();
    }

    @Then("check the group timeslots visible on the calendar section")
    public void check_the_group_timeslots_visible_on_the_calendar_section() {
        cart.validateTimeslot();
    }

    @Then("user selects the available group time slots")
    public void user_selects_the_available_group_time_slots() {
        cart.clickGroupTimeslot(1);
    }

    @Then("user clicks Add more CTA")
    public void userClicksAddMoreCTA() {
        cart.clickAddMore();
    }

    @When("user clicks cart icon")
    public void userClicksCartIcon() {
        cart.clickCartIcon();
    }

    @Then("user selects the any gender preference")
    public void userSelectsTheAnyGenderPreference() {
        service.selectGender("Any");
    }

    @Then("user selects the confirm preference CTA")
    public void userSelectsTheConfirmPreferenceCTA() {
        service.clickConfirm();
    }

    @And("user selects any service provider from any genders")
    public void userSelectsAnyServiceProviderFromAnyGenders() throws InterruptedException {
        service.selectGender("Male");
        service.selectServiceProvider(1);

    }

    @Then("user can click Edit CTA")
    public void userCanClickEditCTA() {
        cart.clickEditCTA();
    }

    @And("user can click Edit icon for the gender selected service")
    public void userCanClickEditIconForTheGenderSelectedService() {
        cart.clickPencilIcon();
    }

    @Then("user redirects to cart page with success updated message")
    public void userRedirectsToCartPageWithSuccessUpdatedMessage() {
//        cart.validateUpdateMsg();
        System.out.println("Validate the updation: " + Variables.BLUE + cart.validateUpdateMsg() + Variables.RESET);

    }

    @When("user checks the cart count after update the service")
    public void userChecksTheCartCountAfterUpdateTheService() throws InterruptedException {
        cart.cartCount();
    }

    @And("user can delete one of the added service from cart")
    public void userCanDeleteOneOfTheAddedServiceFromCart() {
        cart.deleteService();

    }

    @Then("user checks the cart count after delete the service")
    public void userChecksTheCartCountAfterDeleteTheService() throws InterruptedException {
        cart.cartCount();
    }

    @And("validate the selected service is deleted")
    public void validateTheSelectedServiceIsDeleted() {
        cart.validateDeletedMsg();
    }

    @Then("user clicks the Add new guest CTA")
    public void userClicksTheAddNewGuestCTA() throws InterruptedException {
        cart.clickAddNewGuestCTA();
        Thread.sleep(2000);
    }

    @Then("validate the new guest cart")
    public void validateTheNewGuestCart() {
        System.out.println("Created guest empty cart: " + Variables.BRIGHT_GREEN + cart.validateGuestEmptyCart() + Variables.RESET);
    }

    @And("click Add service CTA on the new guest")
    public void clickAddServiceCTAOnTheNewGuest() {
        cart.clickAddService();
    }

    @And("user click the show arrow in the group timeslot")
    public void userClickTheShowArrowInTheGroupTimeslot() {
        cart.groupTimeSlotsExpansion();
    }

    @And("validate the timeslots details for each guest")
    public void validateTheTimeslotsDetailsForEachGuest() {
        cart.getTimeSlotDetails();
    }

    @Then("user click Edit option on any one of the guest")
    public void userClickEditOptionOnAnyOneOfTheGuest() {
        cart.clickEdit(2);
    }

    @And("user clicks pencil icon of editing guest")
    public void userClicksPencilIconOfEditingGuest() {
        cart.clickEditPencilIcon();
    }

    @And("user clicks delete icon on the editing guest to delete service")
    public void userClicksDeleteIconOnTheEditingGuestToDeleteService() throws InterruptedException {
        cart.clickEdit(2);
        cart.clickEditDeleteIcon();
    }

    @Then("validate the new guest cart for adding Multi guest")
    public void validateTheNewGuestCartForAddingMultiGuest() {
        cart.clickMoreNewGuest(2);
    }

    @And("validate the guest deleted message")
    public void validateTheGuestDeletedMessage() throws InterruptedException {
        cart.validateDeleteMessage();
        Thread.sleep(2000);
    }

    @And("user click remove guest CTA to delete the selected guest from cart")
    public void userClickRemoveGuestCTAToDeleteTheSelectedGuestFromCart() throws InterruptedException {
        cart.clickEdit(2);
        cart.clickRemoveGuestCTA();
    }

    @Then("user validate the Continue to checkout CTA in the cart")
    public void userValidateTheContinueToCheckoutCTAInTheCart() {
        cart.validateCheckoutCTA();
    }

    @And("user refresh the page")
    public void userRefreshThePage() throws InterruptedException {
        cart.refreshThePage();
        Thread.sleep(2000);
    }

    @And("user selects the available date for multi guest")
    public void userSelectsTheAvailableDateForMultiGuest() {
//        cart.clickNextMonth();
        cart.selectDate(2);
    }

    @Then("user delete the services added in the cart")
    public void userDeleteTheServicesAddedInTheCart() {
        cart.deleteCartServices();
    }

    @And("user selects the available date for two guests")
    public void userSelectsTheAvailableDateForTwoGuests() {
        cart.selectDate(2);
    }
}
