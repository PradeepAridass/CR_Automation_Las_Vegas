package pages;

import ConstantVariables.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    private final By signupCheckout = By.xpath("//div[@class='styles_titleContainer__V5WvZ']");
    private final By toggleLogin = By.xpath("//div[@class='styles_segment__ESIar']");
    private final By mobileInput = By.xpath("//input['znyup']");
    private final By codeInput = By.xpath("//input[@class='styles_input__0ougC']");
    private final By checkout = By.xpath("//button[contains(text(),'Verify & Continue')]");
    private final By landingCheckout = By.xpath("//div[@class='styles_title___gMp4']");
    private final By popupModal = By.xpath("//div[@class='styles_formcontainer___OOvL']");
    private final By book = By.xpath("//button[@class='styles_button__YaZn_ styles_primary__EzVYn styles_base__Wg2dz styles_fill__nunXW']");
    private final By confirmNo = By.xpath("//div[@class='styles_numberContainer__Bo4QZ']//following::div[@class='styles_num__Gy4aa']");
    private final By reservationNo = By.xpath("//div[@class='styles_numberContainer__Bo4QZ']/div[2]");
    private final By calendarNext = By.xpath("//button[@aria-label='Next']");
    private final By updateCTA = By.xpath("//div[@class='styles_ctaButtons__1_QmJ']/button[2]");
    private final By primaryToggleCTA = By.xpath("./ancestor::div[contains(@class,'styles_sectionTitle')]//div[contains(@class,'styles_toggleButton')]");
    WebDriver driver;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public void landingSignup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupCheckout));
        driver.findElement(signupCheckout).isDisplayed();
    }

    public boolean validateCheckoutSignUp() {
        return driver.findElement(signupCheckout).isDisplayed();
    }

    public void clickLogin() {
        driver.findElement(toggleLogin).click();
    }


    public void enterMobile(String mobile) {
        driver.findElement(By.xpath("//div[@class='selected-flag']")).click();
        driver.findElement(By.xpath("//ul[@class='country-list styles_listDropdown__STNLF']//following::span[text()='United States']")).click();
        driver.findElement(mobileInput).sendKeys(mobile);
    }

    public void clickGetCode() {
        WebElement clicks = driver.findElement(By.xpath("//button[@class='styles_button__YaZn_ styles_primary__EzVYn styles_base__Wg2dz styles_buttonStyle__C8AaT']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(clicks));
        clicks.click();
    }

    public void enterCode(String code) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(codeInput));
        driver.findElement(codeInput).sendKeys(code);
    }

    public void clickContinue() {
        driver.findElement(checkout).click();
    }

    public boolean validateCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(landingCheckout));
        return driver.findElement(landingCheckout).isDisplayed();
    }

    public String getCheckout() {
        return driver.findElement(landingCheckout).getText();
    }

    public void validateGuestDetails() {
        WebElement guestDetails = driver.findElement(By.xpath("//div[@class='styles_guestDetails__2wnp2']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated((By) guestDetails));
    }

    public String validatePopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupModal));
        return driver.findElement(popupModal).getText();
    }

    public String validatePaymentCard() {
        WebElement paymentInfo = driver.findElement(By.xpath("//div[contains(text(),'Payment information')]"));
        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@class='styles_radio__aIbFk']"));
//        System.out.println("Listed of payment card added: "+radioButton.size());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) radioButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", paymentInfo);
        if (!radioButton.get(0).isSelected()) {
            radioButton.get(0).click();
        } else {
            return driver.findElement(By.xpath("//div[@class='styles_num__Zr0SX']")).getText();
        }
        return null;
    }

    public void clickBook() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(book));
        WebElement bookCTA = driver.findElement(book);
        if (bookCTA.isEnabled()) {
            System.out.println(Variables.BRIGHT_GREEN + "Book CTA is enabled" + Variables.RESET);
            bookCTA.click();
        } else {
            System.out.println(Variables.BRIGHT_RED + "Book CTA is not enabled" + Variables.RESET);
        }
    }

    public void validateConfirmPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(reservationNo));
        String status = driver.getCurrentUrl();
        if (status.contains("/checkout")) {
            System.out.println("Booking status: " + Variables.BRIGHT_GREEN + "true" + Variables.RESET);
        }
    }

    public void validateFailureMsg() {
        WebElement msg = driver.findElement(By.xpath("//div[@class='styles_heading2__r5BAq']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated((By) msg));
        String message = msg.getText();
        System.out.println("Booking msg: " + Variables.BRIGHT_RED + message + Variables.RESET);
    }

    public String getConfirmNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmNo));
        return driver.findElement(confirmNo).getText();
    }

    public void GuestDetailsFillingForGuestTwo() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Guest 2 information']"));
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Test");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("GuestTwo");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@class='form-control styles_inputDropdown__cK8VL']")).sendKeys("8789787889");
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='styles_iconCaret__q1AeI']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//ul/li[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testtwo@yopmail.com");
        Thread.sleep(500);
    }

    public void GuestDetailsFillingForGuestThree() throws InterruptedException {
//        WebElement guest3 = driver.findElement(By.xpath("//span[contains(text(),'Guest 3 information')]"));
        WebElement guest3 = driver.findElement(By.xpath("//span[contains(text(),'Guest 3 information')]/parent::div/parent::div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", guest3);
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Test");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("GuestThree");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@class='form-control styles_inputDropdown__cK8VL']")).sendKeys("7683323903");
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='styles_iconCaret__q1AeI']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//ul/li[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testthree@yopmail.com");
        Thread.sleep(500);
    }

    public void GuestDetailsFillingForGuestFour(int guestCount) {
        driver.findElement(By.xpath("//span[text()='Guest " + guestCount + " information']"));
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("GuestFour");
        driver.findElement(By.xpath("//input[@class='form-control styles_inputDropdown__cK8VL']")).sendKeys("9834237880");
        driver.findElement(By.xpath("//div[@class='styles_iconCaret__q1AeI']")).click();
        driver.findElement(By.xpath("//ul/li[3]")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testfour@yopmail.com");
        WebElement saveDetails = driver.findElement(By.xpath("//span[text()='Guest " + guestCount + " information']//following::button[" + guestCount + "]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(saveDetails));
        saveDetails.click();
        System.out.println(Variables.GREEN + "Saved Guest 4 information's" + Variables.RESET);
    }

    public void SaveGuestInfo(int guestCount) {
        WebElement guest = driver.findElement(By.xpath("//span[text()='Guest " + guestCount + " information']//following::button[" + (guestCount + 1) + "]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(guest));
        guest.click();
    }

    public void clickSaveGuestTwoInfo() {
        driver.findElement(By.xpath("(//button[text()='SAVE GUEST INFO'])[1]")).click();
        System.out.println(Variables.GREEN + "Saved Guest 2 information's" + Variables.RESET);
    }

    public void clickSaveGuestThreeInfo() {
        driver.findElement(By.xpath("//button[text()='SAVE GUEST INFO']")).click();
        System.out.println(Variables.GREEN + "Saved Guest 3 information's" + Variables.RESET);
    }

    public void SaveGuestOneInfo() {
        WebElement guest = driver.findElement(By.xpath("//span[text()='Guest 1 information']//following::button[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(guest));
        guest.click();
    }

    public void getReservationNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(reservationNo));
        System.out.println("Reservation Number: " + Variables.BRIGHT_GREEN + driver.findElement(reservationNo).getText() + Variables.RESET);
    }

    public void validateAppointmentDetails() {
        System.out.println("Appointment Details: /n");
        String appointmentStatus = driver.findElement(By.xpath("//div[@class='styles_textSmall__Rtrep']")).getText();
        System.out.println("Appointment Status: " + Variables.BRIGHT_GREEN + appointmentStatus + Variables.RESET);
        List<WebElement> confirmNumbers = driver.findElements(By.xpath("//span[@class='styles_appointmentNumber__n13z_']"));
        for (int i = 1; i <= confirmNumbers.size(); i++) {
            System.out.println("Confirmation Number of Guest " + i + ": " + Variables.BRIGHT_BLUE + confirmNumbers.get(i).getText() + Variables.RESET);
        }
    }

    public void clickEditCTA(int guestNo) {
        driver.findElement(By.xpath("//span[text()='Guest " + guestNo + " information']/parent::div/parent::div/button")).click();
    }

    public void clickRemoveGuestCTA() {
        driver.findElement(By.xpath("//button[text()='REMOVE GUEST']")).click();
    }

    // New date selection
    public void selectDate(int daysFromToday) {
        try {
            // Locators
            By calendarLocator = By.xpath("//div[@class='react-calendar react-calendar dateSelected']");
            By errorMessageLocator = By.xpath("//*[text()='Please select a new date or change your preferences.']");
            By errorMessageTimeSlot = By.xpath("//*[text()='No availability on']");

            // Get initial target date
            LocalDate targetDate = LocalDate.now().plusDays(daysFromToday);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

            while (true) {
                String formattedDate = targetDate.format(formatter);
                System.out.println(Variables.CYAN + "Trying to select date: " + Variables.RESET + Variables.PURPLE + formattedDate + Variables.RESET);

                // Click the date in the calendar
                driver.findElement(By.xpath("//abbr[@aria-label='" + formattedDate + "']")).click();

                // Check if error message is displayed
                if (driver.findElements(errorMessageLocator).isEmpty() && driver.findElements(errorMessageTimeSlot).isEmpty()) {
                    // No error → success
                    System.out.println(Variables.BRIGHT_GREEN + "Date selected successfully: " + formattedDate + Variables.RESET);
                    break;
                } else {
                    // Error → move to next day (no month change)
                    System.out.println(Variables.YELLOW + "Timeslot unavailable for " + formattedDate + ". Trying next date..." + Variables.RESET);
                    targetDate = targetDate.plusDays(1);
                }

                // Safety check: calendar must still be visible
                if (driver.findElements(calendarLocator).isEmpty()) {
                    throw new RuntimeException("Calendar not found. Unable to proceed.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error selecting date: " + e.getMessage());
        }
    }

    public void clickTimeslot(int time) {
        driver.findElement(By.xpath(String.format("(//input[@name='slot'])[%d]", time))).click();
    }

    public void clickUpdateCTA() {
        driver.findElement(updateCTA).click();
    }

    public void validateDateAndTimeslot() {
        String selectedDateTime = driver.findElement(By.xpath("//div[@class='styles_dateItem__S31hj']")).getText();
        System.out.println("New selected date and time: " + Variables.CYAN + selectedDateTime + Variables.RESET);
    }

    public void validateSavedGuestInfo() {
        List<WebElement> editButtons = driver.findElements(By.xpath("//div[@class='styles_titleAndEdit__y68eg']/button"));
        for (int i = 0; i < editButtons.size(); i++) {
            System.out.println(Variables.BLUE + "Guest " + (i + 1) + " is saved." + Variables.RESET + Variables.GREEN + editButtons.get(i).isDisplayed() + Variables.RESET);
        }
    }

    public void clickYesCTA() {
        WebElement yesButton = driver.findElement(By.xpath("//button[text()='YES']"));
        yesButton.click();
    }

    public void selectSingleTimeSlot(int singleTime) {
        List<WebElement> timeslots = driver.findElements(By.xpath("//div[@class='styles_pill__brCvP']/span"));
        if (singleTime < timeslots.size() && singleTime >= 1) {
            switch (singleTime) {
                case 1, 2, 3:
                    driver.findElement(By.xpath("(//div[@class='styles_pill__brCvP']/span)[" + singleTime + "]")).click();
                    break;
            }
        }
    }

    public byte[] GuestName() {
        List<WebElement> guest = driver.findElements(By.xpath("//div[@class='styles_guestDetailsContainer__X5b7b']/div[2]/div/div"));
        System.out.println(Variables.BRIGHT_BLUE + "Guest Details in Checkout: " + Variables.RESET);
        for (WebElement guestName : guest) {
            String details = guestName.getText();
            System.out.println(Variables.CYAN + details + Variables.RESET);
        }
        return null;
    }

    public void clickToggleButton(int guest) {
        WebElement guestNumber = driver.findElement(By.xpath("//span[text()='Guest " + guest + " information']"));
        guestNumber.findElement(primaryToggleCTA).click();
    }

//    public List<String> newScheduleDateTime() {
//        List<WebElement> newTimes = driver.findElements(By.xpath("//span[@class='styles_userInfo__67n1V']"));
//        List<String> newTime = new ArrayList<>();
//        for (WebElement time : newTimes) {
//            newTime.add(time.getText());
//        }
//        return newTime;
//    }


}