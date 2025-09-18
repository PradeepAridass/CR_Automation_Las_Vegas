package pages;

import ConstantVariables.Variables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;

public class ReschedulePage {
    private final By rescheduleTitle = By.xpath("//h1[@class='styles_text__zy1Gd']");
    private final By currentSchedule = By.xpath("//div[@class='styles_dateItem__S31hj']");
    private final By rescheduleCTA = By.xpath("//span[@class='styles_bookCta__v4iBp']");
    private final By confirmationPage = By.xpath("//div[@class='styles_titleSub__aGoFM']");
    private final By singleTimeSlots = By.xpath("//div[@class='styles_container__9WHFl']");
    private final By groupTimeSlots = By.xpath("//div[@class='style_slots__iWWx3']");//style_slots__Q0wz8
    private final By updateCTA = By.xpath("(//button[@class='styles_button__YaZn_ styles_primary__EzVYn styles_base__Wg2dz styles_ctaBtns__deaVs'])[1]");
    WebDriver driver;


    public ReschedulePage(WebDriver driver) {
        this.driver = driver;
    }

//    public void validateAndClickFirstAvailableReschedule() {
//        // Locate all booked status pills
//        List<WebElement> bookedStatuses = driver.findElements(
//                By.xpath("//div[@class='style_pill__0mq1_ style_success__13XZB']//span[contains(text(),'BOOKED')]"));
//        List<WebElement> locations = driver.findElements(By.xpath("(//span[@class='styles_bookingInfo__2Zbv8'])"));
//
//        boolean rescheduleClicked = false;
//        for (WebElement location : locations) {
//            if (Objects.equals(location.getText(), "Las Vegas, NV")) {//Fort Worth, TX
//                System.out.println("Selected Location: " + location.getText());
//                for (WebElement status : bookedStatuses) {
//                    try {
//                        // Find the menu icon relative to the current BOOKED status
//                        WebElement bookedContains = status.findElement(
//                                By.xpath("./ancestor::div[contains(@class,'styles_bookingContainer__mPDdT')]"));
//                        WebElement menuIcon = bookedContains.findElement(By.xpath(".//div[2]//div[2]//*[name()='svg']"));
//                        menuIcon.click();
//                        System.out.println(Variables.BLUE + "Menu icon clicked for a BOOKED status." + Variables.RESET);
//
//                        // Wait briefly to allow dropdown to appear (optional: use explicit wait)
//                        Thread.sleep(500);
//
//                        // Check if Reschedule option exists in the dropdown
//                        List<WebElement> rescheduleOptions = driver.findElements(
//                                By.xpath("//p[@class='styles_rescheduleColor__4Jhwl' and text()='Reschedule']"));
//
//                        if (!rescheduleOptions.isEmpty()) {
//                            rescheduleOptions.get(0).click();
//                            System.out.println(Variables.GREEN + "Reschedule option clicked." + Variables.RESET);
//                            rescheduleClicked = true;
//                            break; // Stop looping after the first successful Reschedule click
//                        } else {
//                            System.out.println(Variables.RED + "Reschedule option not found for this BOOKED status. Moving to next." + Variables.RESET);
//                        }
//
//                    } catch (Exception e) {
//                        System.out.println(Variables.RED + "Error processing a BOOKED status: " + e.getMessage() + Variables.RESET);
//                    }
//                }
//            } else {
//                System.out.println(Variables.RED + "Location is not available." + Variables.RESET);
//            }
//        }
//
//        if (!rescheduleClicked) {
//            System.out.println(Variables.RED + "No Reschedule option found for any BOOKED status." + Variables.RESET);
//        }
//    }

    public void validateAndClickRescheduleForLocation(String locationName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean rescheduleClicked = false;

        if (locationName == null || locationName.trim().isEmpty()) {
            System.out.println(Variables.RED + "❌ Location name cannot be null or empty." + Variables.RESET);
            return;
        }

        // locator for all booking containers
        By bookingContainersLocator = By.xpath("//div[contains(@class,'styles_bookingContainer__mPDdT')]");
        List<WebElement> bookingContainers = driver.findElements(bookingContainersLocator);

        for (int i = 0; i < bookingContainers.size(); i++) {
            try {
                // re-fetch container each iteration
                WebElement booking = driver.findElements(bookingContainersLocator).get(i);

                // find location
                WebElement locationEl = booking.findElement(
                        By.xpath(".//span[contains(@class,'styles_bookingInfo__2Zbv8')]"));
                String locText = locationEl.getText().trim();
                System.out.println(Variables.BLUE + "Location found: " + Variables.RESET + Variables.CYAN + locText + Variables.RESET);

                // check location match
                if (!locText.toLowerCase().contains(locationName.toLowerCase())) {
                    continue; // skip if location doesn't match
                }

                // find status
                WebElement statusEl = booking.findElement(
                        By.xpath(".//div[contains(@class,'style_pill__0mq1_')]/span"));
                String statusText = statusEl.getText().trim();
                System.out.println(Variables.BLUE + "Status found: " + Variables.RESET + Variables.PURPLE + statusText + Variables.RESET);

                if (!"BOOKED".equalsIgnoreCase(statusText)) {
                    System.out.println(Variables.RED + "Skipping " + locText + " → status not BOOKED." + Variables.RESET);
                    continue; // skip if not BOOKED
                }

                // click menu (three dots)
                WebElement menuIcon = booking.findElement(
                        By.xpath(".//div[contains(@class,'styles_ellipsis__i6zbD')]"));
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", menuIcon);
                Thread.sleep(300);

                wait.until(ExpectedConditions.elementToBeClickable(menuIcon)).click();
                System.out.println(Variables.BLUE + "Menu clicked for " + locText + Variables.RESET);

                // look for reschedule option
                List<WebElement> rescheduleOptions = driver.findElements(
                        By.xpath("//p[@class='styles_rescheduleColor__4Jhwl' and normalize-space(text())='Reschedule']"));

                if (!rescheduleOptions.isEmpty()) {
                    wait.until(ExpectedConditions.elementToBeClickable(rescheduleOptions.get(0))).click();
                    System.out.println(Variables.GREEN + "✅ Reschedule clicked for " + locText + Variables.RESET);
                    rescheduleClicked = true;
                    break; // stop loop after first successful reschedule
                } else {
                    System.out.println(Variables.YELLOW + "⚠ Reschedule not available for " + locText + Variables.RESET);
                }

            } catch (StaleElementReferenceException sere) {
                System.out.println(Variables.RED + "Stale element at index " + i + " → retry next. " + sere.getMessage() + Variables.RESET);
            } catch (NoSuchElementException nse) {
                System.out.println(Variables.RED + "Expected element missing in booking index " + i + ": " + nse.getMessage() + Variables.RESET);
            } catch (Exception e) {
                System.out.println(Variables.RED + "Error at booking index " + i + ": " + e.getMessage() + Variables.RESET);
            }
        }

        if (!rescheduleClicked) {
            System.out.println(Variables.RED + "❌ No Reschedule option found for any BOOKED appointment at location: "
                    + locationName + Variables.RESET);
        }
    }


    public void selectNewScheduleDate(int additionalDays) {
        try {
            // Locators
            By calendarLocator = By.xpath("//div[@class='style_calenderH__PcoyL']");
            By errorMessageLocator = By.xpath("//*[text()='Please select a new date or change your preferences.']");
            By noAvailabilityLocator = By.xpath("//span[text()='No availability on ']");
            By currentScheduleDates = By.xpath("//div[@class='styles_dateItem__S31hj']/span[1]");
            By calendarNext = By.xpath("//button[@aria-label='Next']"); // Update locator if different

            // Get current schedule from UI and parse it
            String dateText = driver.findElement(currentScheduleDates).getText().trim();
            if (!dateText.matches(".*\\d{4}$")) {
                dateText += " 2025"; // Append year if not present
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
            LocalDate currentScheduleDate = LocalDate.parse(dateText, formatter);


            // Calculate target date (current schedule + additionalDays)
            System.out.println(Variables.BLUE + "Current schedule date: " + Variables.RESET + Variables.CYAN + currentScheduleDate + Variables.RESET);
            LocalDate targetDate = currentScheduleDate.plusDays(additionalDays);
            System.out.println(Variables.BRIGHT_BLUE + "Target Date: " + Variables.RESET + Variables.BRIGHT_CYAN + targetDate + Variables.RESET);
            String formattedDate = targetDate.format(formatter);

            System.out.println(Variables.CYAN + "Trying to select date: " + Variables.RESET + Variables.PURPLE + formattedDate + Variables.RESET);

            // Click on the target date in calendar
            driver.findElement(By.xpath("//abbr[@aria-label='" + formattedDate + "']")).click();

            // Check for errors
            if (driver.findElements(errorMessageLocator).isEmpty()) {
                System.out.println(Variables.BRIGHT_CYAN + "Date selected successfully: " + Variables.RESET + Variables.BRIGHT_GREEN + formattedDate + Variables.RESET);
            } else if (!driver.findElements(noAvailabilityLocator).isEmpty()) {
                System.out.println("No availability for " + formattedDate + ". Trying next date.");
                targetDate = targetDate.plusDays(1);
                if (targetDate.getDayOfMonth() == 1) {
                    driver.findElement(calendarNext).click();
                }
            } else {
                System.out.println("Error message detected for " + formattedDate + ". Trying next date.");
                targetDate = targetDate.plusDays(1);
                if (targetDate.getDayOfMonth() == 1) {
                    driver.findElement(calendarNext).click();
                }
            }

            // Ensure calendar is present
            if (driver.findElements(calendarLocator).isEmpty()) {
                throw new RuntimeException("Calendar locator not found. Unable to proceed.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public String validateReschedulePage() {
        String landingPage = "";
        try {
            WebElement page = driver.findElement(rescheduleTitle);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(rescheduleTitle));
            landingPage = page.getText();
        } catch (Exception e) {
            landingPage = e.getMessage();
            System.out.println("Exception message: " + landingPage);
        }
        return landingPage;
    }

    public String fetchCurrentSchedule() {
        return driver.findElement(currentSchedule).getText();
    }

    public void clickRescheduleButton() {
        WebElement button = driver.findElement(rescheduleCTA);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    public boolean validateConfirmationPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmationPage));
        return driver.findElement(confirmationPage).isDisplayed();
    }

    public void timeSlot(int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Check if single slots are present
            if (isElementVisible(singleTimeSlots, wait)) {
                List<WebElement> singleTime = driver.findElements(By.xpath("//span[@class='styles_pillText__FN_o6']"));
                System.out.println(Variables.BLUE + "Number of single timeslots: " + Variables.RESET + Variables.GREEN + singleTime.size() + Variables.RESET);

                int index = (time >= 1 && time <= singleTime.size()) ? time : 1; // Ensure index is within range
                WebElement timeSingle = singleTime.get(index - 1); // List is 0-based
                wait.until(ExpectedConditions.elementToBeClickable(timeSingle)).click();

                String selectedTime = timeSingle.getText();
                System.out.println(Variables.BRIGHT_PURPLE + "Selected time slot: " + Variables.RESET + Variables.BRIGHT_BLUE + selectedTime + Variables.RESET);

            }
            // Else check for group slots
            else if (isElementVisible(groupTimeSlots, wait)) {
                List<WebElement> groupSlots = driver.findElements(By.xpath("//input[@type='radio']"));
                System.out.println("Number of group timeslots: " + Variables.CYAN + groupSlots.size() + Variables.RESET);

                int index = (time >= 1 && time <= groupSlots.size()) ? time : 1;
                WebElement groupTime = groupSlots.get(index - 1);
                wait.until(ExpectedConditions.elementToBeClickable(groupTime)).click();

                // Get selected header text safely
                List<WebElement> selectedHeaders = driver.findElements(By.xpath("//h2[@class='style_selectedHeader__6YU_h']"));
                if (!selectedHeaders.isEmpty()) {
                    System.out.println("Selected time slot: " + Variables.BLUE + selectedHeaders.get(0).getText() + Variables.RESET);
                }
            } else {
                System.out.println(Variables.RED + "No available time slots found." + Variables.RESET);
            }

        } catch (Exception e) {
            System.out.println(Variables.RED + "Error selecting time slot: " + e.getMessage() + Variables.RESET);
        }
    }

    // Helper method to check if element is visible within timeout
    private boolean isElementVisible(By locator, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void clickUpdateButton() {
        WebElement updateButton = driver.findElement(updateCTA);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(updateButton));
        updateButton.click();
    }

    public List<String> newRescheduletiming() {
        List<WebElement> timings = driver.findElements(By.xpath("//span[@class='styles_userInfo__67n1V']"));
        List<String> text = new ArrayList<>();
        for (WebElement time : timings) {
            text.add(time.getText());
        }
        return text;
    }

    public void validateRescheduleUrlWithLocation() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("las-vegas")) {
            System.out.println(Variables.GREEN + "Landing on Las Vegas Reschedule page." + Variables.RESET);
        } else {
            System.out.println(Variables.RED + "Landing on different location reschedule page." + Variables.RESET);
        }
    }

}
