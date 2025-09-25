package stepdefinitions;

import DriverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CancelFlow;

public class CancelSteps {

    CancelFlow cancel = new CancelFlow(DriverFactory.getDriver());

    @When("user check and click the first cancel button on the menu icon")
    public void userCheckAndClickTheFirstCancelButtonOnTheMenuIcon() {
//        cancel.fetchAppointmentForCancellation();
        cancel.validateAndClickCancelButton();

    }

    @And("user clicks the keep appointment CTA")
    public void userClicksTheKeepAppointmentCTA() {
        cancel.clickKeepButton();
        cancel.validateSameAppointment();
    }

    @When("user check and click the second cancel button on the menu icon")
    public void userCheckAndClickTheSecondCancelButtonOnTheMenuIcon() {
        cancel.processBookedAppointments();
    }
}
