package pages;

import ConstantVariables.Variables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CancelFlow {
    private final By keepButton = By.xpath("//button[contains(text(),'keep')]");
    private final By cancelAppointmentButton = By.xpath("//button[contains(text(),'Yes')]");
    private final By loadMoreButton = By.xpath("//button[contains(text(),'LOAD MORE')]");
    public WebDriver driver;
    public String appointment;

    public CancelFlow(WebDriver driver) {
        this.driver = driver;
        this.appointment = fetchAppointmentForCancellation();
    }

    // Fetch first appointment number for cancellation
    public String fetchAppointmentForCancellation() {
        try {
            WebElement appointmentNumber = driver.findElement(
                    By.xpath("//div[.//span[text()='BOOKED']]//span[@class='styles_bookingInfo__2Zbv8' and not(contains(text(),','))]")
            );
            System.out.println("📌 Appointment Number: " + appointmentNumber.getText());
            return appointmentNumber.getText();
        } catch (NoSuchElementException e) {
            System.out.println("No BOOKED appointment found: " + e.getMessage());
            return null;
        }
    }

    public void clickKeepButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(keepButton)).click();
    }

    public void clickCancelButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cancelAppointmentButton)).click();
    }

    public void validateCancelPopup() {
        boolean keepAppointmentFound = false;

        while (!keepAppointmentFound) {
            try {
                WebElement popup = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-body']")));

                List<WebElement> keepAppointmentButton = popup.findElements(By.xpath("//button[contains(text(),'keep')]"));
                if (!keepAppointmentButton.isEmpty()) {
                    System.out.println("✅ Keep Appointment CTA is available.");
                    keepAppointmentFound = true;
                } else {
                    System.out.println("❌ Keep Appointment CTA not found. Clicking OK...");
                    popup.findElement(By.xpath(".//button[contains(text(),'Ok')]")).click();
                    Thread.sleep(1000);
                }
            } catch (TimeoutException e) {
                System.out.println("No more cancel popups found.");
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Handle Load More button if visible
    private void handleLoadMoreOptimized() {
        while (true) {
            try {
                WebElement loadMore = new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.elementToBeClickable(loadMoreButton));
                loadMore.click();
                System.out.println("👉 Clicked 'Load More'");
            } catch (TimeoutException e) {
                System.out.println("✅ No more 'Load More' button visible.");
                break;
            }
        }
    }

    // Handle Cancel popup quickly, returns true if Keep clicked
    private boolean handleCancelPopupFast() {
        while (true) {
            try {
                WebElement popup = new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-body']")));

                List<WebElement> keepBtn = popup.findElements(By.xpath(".//button[contains(text(), 'keep')]"));
                if (!keepBtn.isEmpty()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", keepBtn.get(0));
                    System.out.println("✅ Keep Appointment clicked");
                    return true;
                }

                // Click OK if Keep not found
                WebElement okBtn = popup.findElement(By.xpath(".//button[contains(text(),'Ok')]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn);

            } catch (TimeoutException e) {
                return false;
            }
        }
    }

    public void validateSameAppointment() {
        WebElement appointmentNumber = driver.findElement(By.xpath("//div[.//span[text()='BOOKED']]//span[@class='styles_bookingInfo__2Zbv8' and not(contains(text(),','))]"));
        String actualNumber = appointmentNumber.getText();
        System.out.println("Appointment number after selected the decision:" + actualNumber);
        if (appointment.equals(actualNumber)) {
            System.out.println("Selected appointment number is available.");
        } else {
            System.out.println("Selected appointment number is removed.");
        }
    }

    public void validateAndClickCancelButton() {
        // Locate all booked status pills
        List<WebElement> bookedStatuses = driver.findElements(By.xpath("//div[@class='style_pill__0mq1_ style_success__13XZB']//span[contains(text(),'BOOKED')]"));
        for (WebElement status : bookedStatuses) {
            try {
                // Find the menu icon relative to the current BOOKED status
                WebElement bookedContains = status.findElement(By.xpath("./ancestor::div[contains(@class,'styles_bookingContainer__mPDdT')]"));
                WebElement menuIcon = bookedContains.findElement(By.xpath(".//div[2]//div[2]//*[name()='svg']"));
                menuIcon.click();
                System.out.println(Variables.BLUE + "Menu icon clicked for a BOOKED status." + Variables.RESET); // Wait briefly to allow dropdown to appear (optional: use explicit wait) Thread.sleep(500); // Check if Reschedule option exists in the dropdown
                List<WebElement> cancelOptions = driver.findElements(By.xpath("//p[@class='styles_cancelColor__zA84p' and text()='Cancel']"));
                if (!cancelOptions.isEmpty()) {
                    cancelOptions.get(0).click();
                    System.out.println(Variables.GREEN + "Cancel option clicked." + Variables.RESET);
                    break;
                    // Stop looping after the first successful Reschedule click
                } else {
                    System.out.println(Variables.RED + "Cancel option is unabled to click for this BOOKED status." + Variables.RESET);
                }
            } catch (Exception e) {
                System.out.println(Variables.RED + "Error processing a BOOKED status: " + e.getMessage() + Variables.RESET);

            }
        }
    }

    // Main method to process all booked appointments
    public void processBookedAppointments() {
        handleLoadMoreOptimized();

        List<WebElement> bookedRows = driver.findElements(By.xpath(
                "//div[contains(@class,'style_pill__0mq1_ style_success__13XZB')]//span[contains(text(),'BOOKED')]"));

        System.out.println("📌 Total booked appointments: " + bookedRows.size());

        for (int i = 0; i < bookedRows.size(); i++) {
            try {
                WebElement bookedRow = driver.findElements(By.xpath(
                                "//div[contains(@class,'style_pill__0mq1_ style_success__13XZB')]//span[contains(text(),'BOOKED')]"))
                        .get(i);

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookedRow);

                WebElement menuIcon = bookedRow.findElement(By.xpath(
                        "./ancestor::div[contains(@class,'styles_appointmentEditButton__d0Irt')]//div//*[name()='svg']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuIcon);
                System.out.println("👉 Menu icon clicked");

                WebElement cancelCTA = new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Cancel')]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelCTA);
                System.out.println("👉 Cancel CTA clicked");

                boolean keepClicked = handleCancelPopupFast();
                if (keepClicked) {
                    System.out.println("🎯 Keep Appointment clicked. Exiting processing.");
                    break;
                }

            } catch (StaleElementReferenceException e) {
                System.out.println("⚠️ Stale element, retrying booked row " + i);
                i--;
            } catch (Exception e) {
                System.out.println("⚠️ Error processing booked row: " + e.getMessage());
            }
        }
    }


}