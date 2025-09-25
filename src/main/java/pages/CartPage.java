package pages;

import ConstantVariables.Variables;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class CartPage {
    private final By cart = By.xpath("//span[@class='styles_cartCount__jm2G8']");
    private final By calendarNext = By.xpath("//button[@aria-label='Next']//*[name()='svg']");
    //    private final By cartIcon = By.xpath("//div[@class='styles_miniCartContainer__CZzRX']//a[@class='styles_iconContainer__PTqaK']//*[name()='svg']");
    private final By cartIcon = By.xpath("(//a[@class='styles_iconContainer__PTqaK'])[2]");
    private final By CartCTA = By.xpath("//button[text()='continue browsing']");
    private final By checkoutCTA = By.xpath("//button[text()='Continue to Checkout']");
    private final By addMoreCTA = By.xpath("//a[contains(.,'ADD MORE')]");
    private final By groupTimeSlots = By.xpath("//div[@class='style_slots__iWWx3']");//style_slots__Q0wz8
    private final By editCTA = By.xpath("//div[@class='styles_cartEdit__7lFcU']//following::span[text()='EDIT']");
    private final By pencilIcon = By.cssSelector("body > div.legacy-wrapper.theme-club > div.catalog-wrapper > div.styles_container__l3TX8 > div.styles_cartContainer__7NvLP > div:nth-child(2) > div > div > div > div.styles_desktopCartItems___KGUw > div.styles_desktopCartPrice__TlYwH > div > svg.svg-inline--fa.fa-pen.fa-xs");
    //div:nth-child(1) >div.styles_desktopCartItems___KGUw > div.styles_desktopCartPrice__TlYwH > div > svg.svg-inline--fa.fa-pen.fa-xs
    private final By deleteIcon = By.cssSelector("body > div.legacy-wrapper.theme-club > div.catalog-wrapper > div.styles_container__l3TX8 > div.styles_cartContainer__7NvLP > div:nth-child(2) > div > div > div:nth-child(2) > div.styles_desktopCartItems___KGUw > div.styles_desktopCartPrice__TlYwH > div > svg.svg-inline--fa.fa-trash.fa-xs");
    //    private final By updateMsg = By.xpath("/div/div/div/div/span");
    private final By cartCount = By.xpath("//span[@class='styles_cartBadge___Ie_9']");
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


//    public void removePopupWindow(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal__cross")));
//
//        WebElement close = modal.findElement(By.xpath("//button[@aria-label='Close']"));
//        close.click();
//    }

    public void clickViewCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'VIEW CART')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartButton);
    }


    public String validateCart() {
        return driver.findElement(cart).getText();

    }

//    public void selectDate(){
//        // Get the current date
//        LocalDate currentDate = LocalDate.now();
//          if(currentDate.getDayOfMonth()>=28){
//              driver.findElement(calendarNext).click();
//          }
//        // Add 3 days to the current date
//        LocalDate targetDate = currentDate.plusDays(3);
//        // Get the current month and day
//        String month = targetDate.getMonth().toString(); // Current month as string
//        int dayOfMonth = targetDate.getDayOfMonth();    // Target day
//        // Optional: Format the date for display
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
//        String formattedDate = targetDate.format(formatter);
//        // Print the results
//        System.out.println("Current Date: " +Variables.BLUE+currentDate+Variables.RESET);
//        System.out.println("Target Date (+3 days): " +Variables.BLUE+formattedDate+Variables.RESET);
//        System.out.println("Current Month: " +Variables.BRIGHT_GREEN+month+Variables.RESET);
//        System.out.println("Selected Day: " +Variables.BRIGHT_GREEN+dayOfMonth+Variables.RESET);
//        driver.findElement(By.xpath("//abbr[@aria-label='"+formattedDate+"']")).click();
//    }//selectDate

    public void clickNextMonth() {
        driver.findElement(calendarNext).click();
        System.out.println("Moved to next month based on date logic.");
    }

    public void selectDate(int date) {
        try {
            // Check if the calendar element is present
            By calendarLocator = By.xpath("//div[@class='style_calenderH__PcoyL']");
            By errorMessageLocator = By.partialLinkText("//*[text()='Please select a new date or change your preferences.']");
            By noAvailabilityLocator = By.partialLinkText("//span[text()='No availability']");
            // Get the current date
            LocalDate currentDate = LocalDate.now();
            LocalDate targetDate = currentDate.plusDays(date);
            // Get formatted date for target
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            String formattedDate = targetDate.format(formatter);

            // Try selecting the date
            System.out.println(Variables.CYAN + "Trying to select date: " + Variables.RESET + Variables.PURPLE + formattedDate + Variables.RESET);
            driver.findElement(By.xpath("//abbr[@aria-label='" + formattedDate + "']")).click();

            // Check for the error message
            if (driver.findElements(errorMessageLocator).isEmpty()) {
                // No error message, proceed to select time slot
                System.out.println(Variables.BRIGHT_CYAN + "Date selected successfully: " + Variables.RESET + Variables.BRIGHT_GREEN + formattedDate + Variables.RESET);
//                    String timeSlotXpath = String.format("//span[@class='styles_pillText__FN_o6'][%d]" 1);
//                    driver.findElement(By.xpath(timeSlotXpath)).click();
//                    System.out.println("Time slot selected successfully.");
            } else if (!driver.findElements(noAvailabilityLocator).isEmpty()) {
                String errormsg = driver.findElement(By.xpath("//span[@class='style_text__qKsiA']")).getText();
                // Error message displayed, move to the next date
                System.out.println("Error message detected. Selecting the next date.");
                targetDate = targetDate.plusDays(1);
                if (targetDate.getDayOfMonth() == 1) {
                    driver.findElement(calendarNext).click(); // Move to the next month
                }
            } else {
                String errormsg = driver.findElement(By.xpath("//span[@class='style_text__qKsiA']")).getText();
                // Error message displayed, move to the next date
                System.out.println("Error message detected with no availability. Selecting the next date.");
                targetDate = targetDate.plusDays(1);
                if (targetDate.getDayOfMonth() == 1) {
                    driver.findElement(calendarNext).click(); // Move to the next month
                }
            }

            // Check if calendar is available
            if (driver.findElements(calendarLocator).isEmpty()) {
                throw new RuntimeException("Calendar locator not found. Unable to proceed.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public void clickBrowseCTA() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartCTA));
        driver.findElement(CartCTA).click();
    }

    public void clickTimeslot(int time) {
        WebElement timeSlot = driver.findElement(By.xpath(String.format("(//span[@class='styles_pillText__FN_o6'])[%d]", time)));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) timeSlot));
        timeSlot.click();
    }

    public void validateTimeslot() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(groupTimeSlots));
        if (driver.findElement(groupTimeSlots).isDisplayed()) {
            System.out.println(Variables.BRIGHT_GREEN + "Time slots is available" + Variables.RESET);
        } else {
            System.out.println(Variables.RED + "No available timeslots for the selected state" + Variables.RESET);
        }
    }

    public void clickCheckout() {
        driver.findElement(checkoutCTA).click();
    }

    public void validateCheckoutCTA() {
        WebElement checkout = driver.findElement(checkoutCTA);
        if (checkout.isEnabled()) {
            System.out.println(Variables.BRIGHT_GREEN + "Checkout CTA is enabled!" + Variables.RESET);
        } else {
            System.out.println(Variables.BRIGHT_RED + "Checkout CTA is disabled! and add the service to empty guest cart" + Variables.RESET);

        }
    }

    public void clickGroupTimeslot(int time) {
        List<WebElement> timeSlots = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println("Number of group timeslots: " + Variables.CYAN + timeSlots.size() + Variables.RESET);
        if (time >= 2 && time < timeSlots.size()) {
            WebElement groupTime = driver.findElement(By.xpath("(//input[@type='radio'])[%d]" + time));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) groupTime));
            groupTime.click();
            String selectedTime = driver.findElement(By.xpath("(//h2[@class='style_selectedHeader__6YU_h'])[%d]" + time)).getText();
            System.out.println("Selected time slot: " + Variables.BLUE + selectedTime + Variables.RESET);
        } else {
            WebElement groupTime = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOf(groupTime));
            groupTime.click();
            String selectedTime = driver.findElement(By.xpath("(//h2[@class='style_selectedHeader__6YU_h'])[1]")).getText();
            System.out.println("Selected time slot: " + Variables.BLUE + selectedTime + Variables.RESET);
        }
    }

    public void clickAddMore() {
        driver.findElement(addMoreCTA).click();
    }


    public void clickEditCTA() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(editCTA));
        driver.findElement(editCTA).click();
    }

    public void clickPencilIcon() {
        driver.findElement(pencilIcon).click();
    }

    public String validateUpdateMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement updateMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Service successfully updated !')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", updateMsg);
        return updateMsg.getText();
    }

    public void cartCount() throws InterruptedException {
//        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Cart count: " + Variables.BRIGHT_GREEN + driver.findElement(cartCount).getText() + Variables.RESET);
    }

    public void deleteService() {
        driver.findElement(deleteIcon).click();
    }

    public void validateDeletedMsg() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement deleteMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Service has been removed from your cart.')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteMsg);
            System.out.println("Validated the deletion: " + Variables.BLUE + deleteMsg.getText() + Variables.RESET);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clickAddNewGuestCTA() {
        WebElement addNewGuest = driver.findElement(By.xpath("//button[text()='Add new guest.']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addNewGuest));
        addNewGuest.click();
    }

    public boolean validateGuestEmptyCart() {
        return driver.findElement(By.xpath("//div[@class='style_noServices__HFmvS']")).isDisplayed();
    }

    public void clickAddService() {
        WebElement addService = driver.findElement(By.linkText("ADD SERVICE"));
        addService.click();
    }

    public void groupTimeSlotsExpansion() {
        driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[1]/*[name()='svg'][1]")).click();
    }

    public void getTimeSlotDetails() {
        List<WebElement> guestDetails = driver.findElements(By.xpath("//div[@class='style_guestSection__83vbn']"));
        for (int i = 0; i < guestDetails.size(); i++) {
            System.out.println("Guest " + (i + 1) + ":" + Variables.BLUE + guestDetails.get(i).getText() + Variables.RESET);
        }
    }

    public void clickEdit(int index) {
        driver.findElement(By.xpath("(//button[text()='Edit'])[" + index + "]")).click();
    }

    public void clickEditPencilIcon() {
        driver.findElement(By.xpath("(//div[@class='style_serviceActions___feKh']//*[name()='svg'])[1]")).click();
    }

    public void clickEditDeleteIcon() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class='style_serviceActions___feKh']//*[name()='svg'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='YES']")).click();
        Thread.sleep(2000);
    }

    public void clickMoreNewGuest(int newGuestCount) {
        WebElement newGuest = driver.findElement(By.xpath("//button[text()='ADD NEW GUEST']"));
        if (newGuest.isEnabled()) {
            for (int i = 0; i < newGuestCount; i++) {
                newGuest.click();
            }
        }
    }

    public void validateDeleteMessage() {
        String errorMsg = driver.findElement(By.xpath("//div[@class='styles_headerContent__f9GDo']")).getText();
        System.out.println(Variables.RED + errorMsg + Variables.RESET);
    }

    public void clickRemoveGuestCTA() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='REMOVE GUEST']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='YES']")).click();
        Thread.sleep(2000);

    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }

    public void deleteCartServices() {
//        if(!driver.findElement(CartCTA).isDisplayed()){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String cartValue = driver.findElement(cartCount).getText();
        WebElement editButton = driver.findElement(By.xpath("//div[@class='styles_editCart__NknpI']"));
        int cartNo = Integer.parseInt(cartValue);
        Boolean edit = editButton.isDisplayed();
        if (cartNo > 0) {
            if (edit.equals(true)) {
                wait.until(ExpectedConditions.elementToBeClickable(editButton));
                editButton.click();
                List<WebElement> carts = driver.findElements(By.xpath("//div[@class='styles_cartListContainer__vLV4E']"));
                List<WebElement> deleteIcon = driver.findElements(By.xpath("//div[1]/div[2]/div[1]/*[name()='svg'][2]"));
                for (int i = 0; i < carts.size(); i++) {
                    deleteIcon.get((i + 1)).click();
                }
                clickBrowseCTA();
            }
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(CartCTA));
            clickBrowseCTA();
        }
    }
}

