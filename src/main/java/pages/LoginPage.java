package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    static WebDriver driver;

    private final By mobileField = By.xpath("//div/div/div/input");
    private final By getCode = By.xpath("//button[contains(text(),'Get verification code')]");
    private final By enterCode = By.xpath("//input[@class='styles_input__0ougC']");
    private final By login = By.xpath("//button[text()='Verify & Continue']");
    private final By account = By.xpath("//div[@class='layout_innerContainer__D48xN']");
    private final By accountCTA = By.xpath("(//p[@class='styles_text__yOTBc'][normalize-space()='Account'])[2]");
    private final By signIn = By.xpath("//a[contains(normalize-space(),'SIGN IN')]");
    private final By signInRegister = By.xpath("//a[contains(normalize-space(),'sign in or register')]");

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
    }

    public void mobileNumber(String mobile) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement countryFlag = driver.findElement(By.xpath("//div[@class='selected-flag']"));
        wait.until(ExpectedConditions.elementToBeClickable(countryFlag));
        countryFlag.click();
        driver.findElement(By.xpath("//span[text()='United States']")).click();
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void getCodeButton() {
        driver.findElement(getCode).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterCode));
    }

    public void verificationCode(String code) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterCode));
        driver.findElement(enterCode).sendKeys(code);

    }

    public void loginButton() {
        driver.findElement(login).click();
    }

    public boolean verifyAccountLandingPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(account));
        return driver.getCurrentUrl().contains("/account");
    }

    public void injectCaptchaToken(String token) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Reveal and inject token
        js.executeScript("document.getElementById('g-recaptcha-response').style.display='block';");
        js.executeScript("document.getElementById('g-recaptcha-response').value='" + token + "';");

        // Optional: add hidden input manually if reCAPTCHA element is missing
        js.executeScript("if(!document.getElementById('g-recaptcha-response')) {" +
                "var input = document.createElement('textarea');" +
                "input.id = 'g-recaptcha-response';" +
                "input.name = 'g-recaptcha-response';" +
                "input.style='display:block';" +
                "input.value = '" + token + "';" +
                "document.body.appendChild(input);" +
                "}");
    }

    public void clickAccountCTA() {
        driver.findElement(accountCTA).click();
    }

    public void clickSignIn() {
        driver.findElement(signIn).click();
    }

    public void clickRegisterOrSignIn() throws InterruptedException {
        driver.findElement(signInRegister).click();
        Thread.sleep(1000);
    }

    public void countryCode() {
        driver.findElement(By.xpath("//div[@class='selected-flag']")).click();
        driver.findElement(By.xpath("//li[@data-flag-key='flag_no_201']")).click();
    }

    public String validateLoginPage() {
        return driver.getCurrentUrl();
    }

}
