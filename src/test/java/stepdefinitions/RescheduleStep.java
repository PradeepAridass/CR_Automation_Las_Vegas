package stepdefinitions;

import ConstantVariables.Variables;
import DriverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ReschedulePage;

public class RescheduleStep {

    ReschedulePage res = new ReschedulePage(DriverFactory.getDriver());

    @Then("user is able to click the single guest appointment")
    public void userIsAbleToClickTheSingleGuestAppointment() throws InterruptedException {
        res.validateAndClickRescheduleForLocation("Las vegas");
        Thread.sleep(2000);
    }

    @And("user navigate to Reschedule page")
    public void userNavigateToReschedulePage() throws InterruptedException {
        Assert.assertEquals("Reschedule Appointment", res.validateReschedulePage());
        Thread.sleep(2000);
        System.out.println("Landing page: " + Variables.BLUE + res.validateReschedulePage() + Variables.RESET);
        res.validateRescheduleUrlWithLocation();
    }

    @Then("user check the current schedule date and time")
    public void userCheckTheCurrentScheduleDateAndTime() {
        System.out.println(Variables.BLUE + "Current Schedule: " + Variables.RESET + Variables.GREEN + res.fetchCurrentSchedule() + Variables.RESET);
    }

    @Then("user select the new date and available time to reschedule")
    public void userSelectTheNewDateAndAvailableTimeToReschedule() throws InterruptedException {
        res.selectNewScheduleDate(2);
        res.timeSlot(2);
        Thread.sleep(1000);
    }

    @And("user click the update CTA to update the calendar in the reschedule page")
    public void userClickTheUpdateCTAToUpdateTheCalendarInTheReschedulePage() {
        res.clickUpdateButton();
    }

    @And("user click the Reschedule CTA")
    public void userClickTheRescheduleCTA() {
        res.clickRescheduleButton();
    }

    @Then("user navigates to confirmation page after reschedule")
    public void userNavigatesToConfirmationPageAfterReschedule() throws InterruptedException {
        Assert.assertTrue(res.validateConfirmationPage());
        Thread.sleep(2000);
    }

    @And("user check the new schedule date and time")
    public void userCheckTheNewScheduleDateAndTime() {
        res.newRescheduletiming();
    }

}
