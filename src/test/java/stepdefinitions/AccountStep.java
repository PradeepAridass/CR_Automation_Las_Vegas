package stepdefinitions;

import ConstantVariables.Variables;
import DriverFactory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.AccountPage;
import pages.ConfirmationPage;

import java.awt.*;

public class AccountStep {

    AccountPage ac = new AccountPage(DriverFactory.getDriver());
    ConfirmationPage confirm = new ConfirmationPage(DriverFactory.getDriver());

    @When("user click services option on the menu panel")
    public void userClickServicesOptionOnTheMenuPanel() throws InterruptedException {
        ac.clickServiceOption();
        Thread.sleep(2000);
    }

    @And("user lands on the service details page")
    public void userLandsOnTheServiceDetailsPage() {

    }

    @Then("user validate the landing service landing page")
    public void userValidateTheLandingServiceLandingPage() {
        System.out.println("Landing page: " + Variables.GREEN + ac.validateServicePage() + Variables.RESET);
    }

    @Then("user click view more CTA on the service section")
    public void userClickViewMoreCTAOnTheServiceSection() throws InterruptedException {
        ac.clickViewMore();
        Thread.sleep(1500);
    }

    @Then("user click arrow on the service section")
    public void userClickArrowOnTheServiceSection() throws InterruptedException {
        ac.clickServiceArrow();
        Thread.sleep(1000);
    }

    @Then("user validate the landing service details page")
    public void userValidateTheLandingServiceDetailsPage() {
        ac.validateServiceDetails();
        ac.getAppointmentNumber();
    }

    @And("count the number of booked appointment")
    public void countTheNumberOfBookedAppointment() throws InterruptedException {
        ac.countingAppointments();
//        System.out.println("Booked status count: " + Variables.BRIGHT_GREEN + ac.countBookedCancelled("BOOKED") + Variables.RESET);
//        System.out.println("Cancelled status count: " + Variables.BRIGHT_GREEN + ac.countBookedCancelled("CANCELLED") + Variables.RESET);
    }


    @And("user navigates to service details page")
    public void userNavigatesToServiceDetailsPage() {
        ac.validateServiceDetails();
    }


    @Then("user validate the service details page with appointment number")
    public void userValidateTheServiceDetailsPageWithAppointmentNumber() {
        Assert.assertEquals(ac.selectSingleGuest(), ac.validatedAppointmentNumber());
    }


    @Then("user click the view details of any of the booked appointment")
    public void userClickTheViewDetailsOfAnyOfTheBookedAppointment() throws InterruptedException {
        ac.clickViewDetails();
        Thread.sleep(2000);
    }


    @Then("user search the reservation number from the list of appointments")
    public void userSearchTheReservationNumberFromTheListOfAppointments() throws AWTException {
        ac.checkAndClickViewMoreCTA();
        System.out.println("Booked appointment number: " + confirm.getAppointmentNumber());
        ac.searchTheBookedAppointment(confirm.getAppointmentNumber());
    }

    @And("check the same reservation number is able to reschedule the date and time")
    public void checkTheSameReservationNumberIsAbleToRescheduleTheDateAndTime() {
        ac.rescheduleBookedAppointment(String.valueOf(confirm.getAppointmentNumber()));
    }
}
