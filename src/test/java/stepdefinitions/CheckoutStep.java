package stepdefinitions;

import ConstantVariables.Variables;
import DriverFactory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ServiceListingPage;


public class CheckoutStep {
    WebDriver driver;
    CartPage cart = new CartPage(DriverFactory.getDriver());
    CheckoutPage check = new CheckoutPage(DriverFactory.getDriver());
    ServiceListingPage service = new ServiceListingPage(DriverFactory.getDriver());

    @Then("user lands on signup checkout page")
    public void user_lands_on_signup_checkout_page() throws InterruptedException {
        Thread.sleep(2000);
        check.landingSignup();
    }

    @Then("validate the signup checkout page")
    public void validateTheSignupCheckoutPage() {
        System.out.println("Signup page(Checkout): " + check.validateCheckoutSignUp());
    }

    @When("user toggle to the login page")
    public void user_toggle_to_the_login_page() {
        check.clickLogin();
    }

    @Then("user enter the registered number {string}")
    public void user_enter_the_registered_number(String mobileno) throws InterruptedException {
        check.enterMobile(mobileno);
        Thread.sleep(2000);
    }

    @Then("user enter the code {string}")
    public void user_enter_the_code(String vcode) throws InterruptedException {
        check.enterCode(vcode);
        Thread.sleep(1000);
    }

    @When("user clicks get verify code CTA")
    public void user_clicks_get_verify_code_cta() throws InterruptedException {
        check.clickGetCode();
        System.out.println("Navigate to Verification code: " + Variables.BLUE + check.validatePopup() + Variables.RESET);
    }

    @Then("user clicks the Proceed to checkout CTA")
    public void user_clicks_the_proceed_to_checkout_cta() throws InterruptedException {
        Thread.sleep(2000);
        check.clickContinue();
        Thread.sleep(2000);
    }

    @Then("user lands on checkout page")
    public void user_lands_on_checkout_page() throws InterruptedException {
        System.out.println("Landing on checkout:" + Variables.BRIGHT_PURPLE + check.validateCheckout() + Variables.RESET);
        System.out.println(Variables.BLUE + check.getCheckout() + Variables.RESET);
        Thread.sleep(2000);
    }

    @Then("user hits the checkout url and redirect back to cart page")
    public void user_hits_the_checkout_url_and_redirect_back_to_cart_page() {
        driver.get("https://staging.canyonranch.com/fort-worth/checkout");
    }

    @Then("user checks the payment card added")
    public void user_checks_the_payment_card_added() throws InterruptedException {
        check.validatePaymentCard();
        System.out.println("Selected Payment method: " + Variables.CYAN + check.validatePaymentCard() + Variables.RESET);
    }

    @Then("user clicks book CTA")
    public void user_clicks_book_cta() {
        check.clickBook();
    }

    @Then("user navigates to confirmation page")
    public void user_navigates_to_confirmation_page() {
//        System.out.println("Landing on Confirmation page: "+Variables.BRIGHT_PURPLE+check.validateConfirmPage()+Variables.RESET);
        check.validateConfirmPage();
    }

    @Then("user validate the confirmation number generated")
    public void user_validate_the_confirmation_number_generated() throws InterruptedException {
        System.out.println("Confirmation number: " + Variables.BRIGHT_GREEN + check.getConfirmNumber() + Variables.RESET);
        Thread.sleep(2000);
        System.out.println("Confirmation url: " + driver.getCurrentUrl());
    }

    @And("validate the booking failure")
    public void validateTheBookingFailure() {
        check.validateFailureMsg();
    }

    @And("user can edit the date and time slot")
    public void userCanEditTheDateAndTimeSlot() {

    }

    @And("user saved the Guest One info")
    public void userSavedTheGuestOneInfo() throws InterruptedException {
        check.SaveGuestInfo(1);
        Thread.sleep(2000);
    }

    @And("user enter the Guest Two details and saved")
    public void userEnterTheGuestTwoDetailsAndSaved() throws InterruptedException {
        check.GuestDetailsFillingForGuestTwo();
        Thread.sleep(2000);
    }

    @And("user saved the Guest Two info")
    public void userSavedTheGuestTwoInfo() throws InterruptedException {
        check.clickSaveGuestTwoInfo();
        Thread.sleep(2000);
    }


    @And("user validate the reservartion number generated")
    public void userValidateTheReservartionNumberGenerated() {
        check.getReservationNumber();
    }

    @And("user validate the multi guest appointment details")
    public void userValidateTheMultiGuestAppointmentDetails() {
        check.validateAppointmentDetails();
    }

    @And("user enter the Guest Three details and saved")
    public void userEnterTheGuestThreeDetailsAndSaved() throws InterruptedException {
        check.GuestDetailsFillingForGuestThree();
        Thread.sleep(2000);
    }

    @And("user saved the Guest details")
    public void userSavedTheGuestDetails() throws InterruptedException {
        check.SaveGuestInfo(1);
        Thread.sleep(1500);
    }

    @And("user saved the Guest Three info")
    public void userSavedTheGuestThreeInfo() throws InterruptedException {
        check.clickSaveGuestThreeInfo();
        Thread.sleep(2000);
    }

    @Then("user click Edit CTA on guest two")
    public void userClickEditCTAOnGuestTwo() throws InterruptedException {
        Thread.sleep(2000);
        check.clickEditCTA(2);
    }

    @And("user click Remove guest CTA to delete guest two")
    public void userClickRemoveGuestCTAToDeleteGuestTwo() throws InterruptedException {
        Thread.sleep(1500);
        check.clickRemoveGuestCTA();
        Thread.sleep(2000);
    }

    @Then("select the new date on the calendar")
    public void selectTheNewDateOnTheCalendar() {
        cart.selectDate(5);
    }

    @Then("select the group time slots on selected date")
    public void selectTheGroupTimeSlotsOnSelectedDate() {
        cart.clickGroupTimeslot(2);
    }

    @Then("select the new date on the calendar in the checkout")
    public void selectTheNewDateOnTheCalendarInTheCheckout() {
        check.selectDate(9);
    }

    @Then("select the group time slots on selected date in the checkout")
    public void selectTheGroupTimeSlotsOnSelectedDateInTheCheckout() {
        check.clickTimeslot(1);
    }

    @Then("user click the update CTA to update the calendar")
    public void userClickTheUpdateCTAToUpdateTheCalendar() {
        check.clickUpdateCTA();
    }

    @And("validate the selected date and time slots")
    public void validateTheSelectedDateAndTimeSlots() {
        check.validateDateAndTimeslot();
    }

    @And("validate all the guest information is saved or not")
    public void validateAllTheGuestInformationIsSavedOrNot() {
        check.validateSavedGuestInfo();
    }

    @And("user select the single time slots")
    public void userSelectTheSingleTimeSlots() {
        check.selectSingleTimeSlot(2);
    }

    @And("user click the yes CTA on the popup to remove the guest two")
    public void userClickTheYesCTAOnThePopupToRemoveTheGuestTwo() throws InterruptedException {
        Thread.sleep(2000);
        check.clickYesCTA();
        Thread.sleep(1500);
    }

    @Then("validate the guest details in the checkout page")
    public void validateTheGuestDetailsInTheCheckoutPage() {
        check.GuestName();
    }

    @And("user check the new reschedule date and time in the confirmation page")
    public void userCheckTheNewRescheduleDateAndTimeInTheConfirmationPage() {
        
    }
}
