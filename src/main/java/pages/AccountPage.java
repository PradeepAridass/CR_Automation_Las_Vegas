package pages;

import ConstantVariables.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


public class AccountPage {
    private final By servicesButton = By.linkText("Services");
    private final By viewMore = By.xpath("//a[@class='styles_link__lhbWw']/div");
    private final By serviceArrow = By.xpath("//div[@class='styles_rightArrow__sUyNa']//span//*[name()='svg']");
    private final By servicePage = By.xpath("//h1[@class='styles_pageTitle__mBK6f']");
    private final By viewMoreCTA = By.xpath("//button[@class='styles_showMore__rtEqv']");
    private final By appointmentTitle = By.xpath("//p[@class='styles_confirmation__cMIUs']");
    private final By appointmentNo = By.xpath("//span[@class='styles_confirmationNumber__Z4soT']");
    private final By countAppointment = By.xpath("//div[@class='styles_container__lG2Nw']");

    WebDriver driver;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickServiceOption() {
        driver.findElement(servicesButton).click();
    }

    public void clickViewMore() {
        driver.findElement(viewMore).click();
    }

    public void clickServiceArrow() {
        driver.findElement(serviceArrow).click();
    }

    public String validateServicePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(servicePage));
        return driver.findElement(servicePage).getText();
    }

    public void validateServiceDetails() {
        String validate = driver.findElement(By.xpath("//div[@class='styles_linkContainer__fVE4m']")).getText();
        System.out.print(validate);
    }

    public void getAppointmentNumber() {
        String appointTitle = driver.findElement(appointmentTitle).getText();
        String number = driver.findElement(appointmentNo).getText();
        if (appointTitle.equals("RESERVATION NUMBER")) {
            System.out.println(Variables.CYAN + "Multi Guest Booking" + Variables.RESET);
            System.out.println("Reservation number: " + Variables.GREEN + number + Variables.RESET);
        } else {
            System.out.println(Variables.CYAN + "Single Guest Booking" + Variables.RESET);
            System.out.println("Confirmation number: " + Variables.GREEN + number + Variables.RESET);

        }
    }

//    public void countingAppointments() {
//        List<WebElement> button = driver.findElements(viewMoreCTA);
//        if (!button.isEmpty() && button.get(0).isDisplayed()) {
//            driver.findElement(viewMoreCTA).click();
//            List<WebElement> count = driver.findElements(countAppointment);
//            System.out.println("Number of Booked Appointments: " + Variables.BLUE + count.size() + Variables.RESET);
//        } else {
//            List<WebElement> count = driver.findElements(countAppointment);
//            System.out.println("Number of Booked Appointments: " + Variables.BLUE + count.size() + Variables.RESET);
//        }
//    }

    public void countingAppointments() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 1: Get initial appointments
        List<WebElement> initialAppointments = driver.findElements(countAppointment);

        int bookedCount = 0;
        int cancelledCount = 0;

        int limit = Math.min(3, initialAppointments.size());

        // Step 2: Count first 3 appointments
        for (int i = 0; i < limit; i++) {
            String statusText = initialAppointments.get(i).getText().toLowerCase();
            if (statusText.contains("booked")) {
                bookedCount++;
            } else if (statusText.contains("cancelled")) {
                cancelledCount++;
            }
        }

        // Step 3: Check and click "View More" if visible
        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(viewMoreCTA));
            List<WebElement> viewMoreButton = driver.findElements(viewMoreCTA);
            if (!viewMoreButton.isEmpty() && viewMoreButton.get(0).isDisplayed()) {
                driver.findElement(viewMoreCTA).click();

                // Step 4: Wait for new appointments to load
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(countAppointment, initialAppointments.size()));

                // Step 5: Fetch updated appointment list
                List<WebElement> allAppointments = driver.findElements(countAppointment);

                for (int i = 3; i < allAppointments.size(); i++) {
                    String statusText = allAppointments.get(i).getText().toLowerCase();
                    if (statusText.contains("booked")) {
                        bookedCount++;
                    } else if (statusText.contains("cancelled")) {
                        cancelledCount++;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            // "View More" not found, do nothing
            System.out.println(Variables.RED + "View more CTA is not found." + Variables.RESET);
        }

        int totalCount = bookedCount + cancelledCount;

        // Final output
        System.out.println("Booked Appointments: " + Variables.BLUE + bookedCount + Variables.RESET);
        System.out.println("Cancelled Appointments: " + Variables.BLUE + cancelledCount + Variables.RESET);
        System.out.println("Total Appointments: " + Variables.BLUE + totalCount + Variables.RESET);
    }


    public int countBookedCancelled(String pill) {
        List<WebElement> pills = driver.findElements(By.xpath("//div[@class='styles_bookingAction__IlxuW']//following::span[text()='" + pill + "']"));
        return pills.size();
    }

    public String validatedPills() {
        List<WebElement> pills = driver.findElements(By.xpath("//div[@class='styles_bookingAction__IlxuW']//following::span"));
        String pillName = null;
        for (WebElement pill : pills) {
            pillName = pill.getText();
        }
        return pillName;
    }

    public String selectSingleGuest() {
        List<WebElement> appointments = driver.findElements(By.xpath("(//span[@class='styles_bookingInfo__2Zbv8'])[3]"));
        String num = null;
        for (int i = 1; i <= appointments.size(); i++) {
            num = String.valueOf(driver.findElement(By.xpath("(//div[@class='styles_bookingDetails___9ULC']//span[@class='styles_bookingInfo__2Zbv8'])[3]")).getText());
            System.out.println(Variables.BLUE + num + Variables.RESET);
            if (!num.isEmpty() && num.matches("\\d+")) { // Check if text is only digits
                if (validatedPills().equals("BOOKED")) {
                    WebElement viewDetailsButton = driver.findElement(By.xpath("//div[@class='styles_viewButton__kXRIq']/span"));
                    viewDetailsButton.click();
                    break; // Assuming you only want to click the first valid one
                }
            }
        }
        return num;
    }

    public String validatedAppointmentNumber() {
        return driver.findElement(appointmentNo).getText();
    }


    public void clickViewDetails() {
        List<WebElement> viewDetails = driver.findElements(By.xpath("//div[@class='styles_viewButton__kXRIq']"));
        for (WebElement viewDetail : viewDetails) {
            viewDetail.click();
            break;
        }
    }

    public void searchTheBookedAppointment(String appointment) throws AWTException {
        driver.findElement(By.xpath("//div[@class='styles_iconWithText__iAMeq']//span[text()='" + appointment + "']"));
        driver.findElement(By.xpath("//span[@class='styles_bookingInfo__2Zbv8' and text()='" + appointment + "']ancestor::div[@class='styles_bookingContainer__mPDdT']//div[@class='styles_appointmentEditButton__d0Irt']//*[name()='svg']")).click();
    }

    public void rescheduleBookedAppointment(String appointment) {
        driver.findElement(By.xpath("//button[@class='styles_dropdownItem__dgVPY']/child::p[text()='Reschedule']")).click();
    }

    public void checkAndClickViewMoreCTA() {
        WebElement button = driver.findElement(viewMoreCTA);
        if (button.isDisplayed()) {
            button.click();
        } else {
            System.out.println("View more CTA is not visible.");
        }

    }


}
