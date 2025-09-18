package stepdefinitions;

import ConstantVariables.Variables;
import DriverFactory.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AccountPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.ReschedulePage;

public class ConfirmationStep {

    ConfirmationPage confirm = new ConfirmationPage(DriverFactory.getDriver());
    CheckoutPage check = new CheckoutPage(DriverFactory.getDriver());
    ReschedulePage res = new ReschedulePage(DriverFactory.getDriver());
    AccountPage ac = new AccountPage(DriverFactory.getDriver());

    @Then("validate the guest details in the confirmation page")
    public void validateTheGuestDetailsInTheConfirmationPage() {
        Assert.assertEquals(confirm.guestDetails(), check.GuestName());
    }

    @And("user check the new schedule date and time in the confirmation page")
    public void userCheckTheNewScheduleDateAndTimeInTheConfirmationPage() throws InterruptedException {
        Assert.assertEquals(res.newRescheduletiming(), confirm.newConfirmationDateTime());
        System.out.println(Variables.BLUE + "New Schedule Date & Time in the Rescheule page: " + Variables.RESET + Variables.BRIGHT_CYAN + res.newRescheduletiming() + Variables.RESET);
        System.out.println(Variables.BLUE + "New Schedule Date & Time in the Confirmation page: " + Variables.RESET + Variables.BRIGHT_CYAN + confirm.newConfirmationDateTime() + Variables.RESET);
        Thread.sleep(1000);
    }

    @And("user click the service option from the account panel")
    public void userClickTheServiceOptionFromTheAccountPanel() throws InterruptedException {
        confirm.clickServiceOption();
    }

    @Then("user navigate to service history page")
    public void user_navigate_to_service_history_page() throws InterruptedException {
        ac.validateServicePage();
        Thread.sleep(2000);
    }

    @And("user fetch the confirmation or reservation number in the confirmation page")
    public void userFetchTheConfirmationOrReservationNumberInTheConfirmationPage() {
//        System.out.println(confirm.fetchAppointmentNumber());
        System.out.println(confirm.fetchAppointmentNumber());
    }

}
