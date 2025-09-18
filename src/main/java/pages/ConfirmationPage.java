package pages;

import ConstantVariables.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ConfirmationPage {
    private final By guestName = By.xpath("(//p[@class='styles_text__yOTBc'])[2]");
    private final By service = By.linkText("Services");
    private final By serviceHistory = By.xpath("//h1[@class='styles_pageTitle__mBK6f']");
    public String appointmentNumber;
    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public byte[] guestDetails() {
        List<WebElement> guestDetails = driver.findElements(By.xpath("//div[@class='styles_guestDetailsContainer__X5b7b']/div[2]/div/div"));
        System.out.println(Variables.BRIGHT_BLUE + "Guest details in Confirmation page: " + Variables.RESET);
        for (WebElement guest : guestDetails) {
            String guestDetail = guest.getText();
            System.out.println(Variables.CYAN + guestDetail + Variables.RESET);
        }
        return null;
    }

    public List<String> newConfirmationDateTime() {
        List<WebElement> confirmationTimes = driver.findElements(By.xpath("//span[@class='styles_userInfo__67n1V']"));
        List<String> timeValue = new ArrayList<>();
        for (WebElement confirmTime : confirmationTimes) {
            timeValue.add(confirmTime.getText());
        }
        return timeValue;
    }

    public void clickServiceOption() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(guestName).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(service));
        Thread.sleep(1000);
        driver.findElement(service).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(serviceHistory));
    }

    public String fetchAppointmentNumber() {
        String appointmentName = driver.findElement(By.xpath("//div[@class='styles_text__Jm81F']")).getText();
        String appointmentNum = null;
        if (appointmentName.equals("Reservation number") || appointmentName.equals("Confirmation number")) {
            appointmentNum = driver.findElement(By.xpath("//div[@class='styles_num__Gy4aa']")).getText();
            System.out.println(appointmentName + ":" + appointmentNum);
        }
        appointmentNumber = appointmentNum;
        return appointmentNumber;
    }

    public String getAppointmentNumber() {
        String bookedAppointment = appointmentNumber;
        return bookedAppointment;
    }
}
