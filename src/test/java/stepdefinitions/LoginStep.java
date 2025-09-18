package stepdefinitions;

import ConstantVariables.Variables;
import DriverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ConfigReader;


public class LoginStep {
    public WebDriver driver = DriverFactory.getDriver();
    //Constructor
    LoginPage login = new LoginPage(DriverFactory.getDriver());

    @Given("Hit the Canyon Ranch staging URL")
    public void hit_the_canyon_ranch_staging_url() {
        String base = ConfigReader.get("baseUrl");
        //Method overloading
        driver.get(base);
    }

    @When("Hit the login {string} url")
    public void hit_the_login_url(String endpoint) throws InterruptedException {
        String url = ConfigReader.get("baseUrl");
        driver.get(url + endpoint);
    }


    @Then("user enter the registered mobile number {string}")
    public void user_enter_the_registered_mobile_number(String mobile) throws InterruptedException {
        login.mobileNumber(mobile);


    }

    @When("user clicks get verification code CTA")
    public void user_clicks_get_verification_code_cta() throws InterruptedException {
        login.getCodeButton();
    }

    @Then("user enter the verification code {string}")
    public void user_enter_the_verification_code(String code) throws InterruptedException {
        login.verificationCode(code);
//        String captchaToken = "03AFcWeA7R7oJ9sGZuIKk0JD-IqaRrAyYSI3C_7xXkoRRichMYrS6LWT7jn-q9xFcmJUKC3_w8O8yFMroIWFs9VwfbG4Pzfb0ywbWZDu3JxC8s8znkzetuW8Dc1C4_4MQ6Cmn2YbZVJDKzaStdPMGOco4GHN21-HiYMkXn5ceSY4fY9Lu8bZXjdXwmmietHwaDpeQ7fwUPApoOVjVDY36fpEg_6t8FX8QLT95teEw7rOTcXXom9H4C9S5qsoO2_8PZzOxn4GRGATWpMDnP6YCPW0hE98PB13u7I8xkcdorRu77wUPItmpzWgU8UpukZlKux845xZbEiHQQ55nMJWhpsUL1aaNt1yjPAs2e-rj8ALtVagKU3wEi68a1Gs0UlWvJ4okObHLLMXWz0B7wQ8UhexwcLw8RWVN8g-ZMnTtnr0_hUltWR-JQ1yLpbslXYK-xSm12HJ8MQziPp2PKuXO4I71ZJdBZVHYhnRUF2a-DzQDg51CIsDMN_commiNTysQ84N39JXzkrabSaQuYm5UbinZ364VbTy47zgO_vTlJxAMOc_EZ0LAUIc9OA4yzU2HuqU_xs03HPU5Jxy1QZ3LAWEPBVRoTZ235SjC1cJJ6ixRCpWECx6hS__wtmkPHe3QvS5X0HONRRp2472lWh2sYHDtPaM_UMeFDCVKTO_d1c2Jes_8-TZyxn66ObiXHswAERWihQL5sUK0rTn3mvU_mhVaCZ7_swEwMeFAuBv2c-etO-qSxnDN78_x2BeMbORaw-lm6ccgYaqQnfFUH9roIgiTy3lYmtiqix-Wx-R_lZhP0nd9JN2UUYLBJIIME6VIvAFmR6QD48bJkDPcECmkp1Q9vQ5djiChL4-jgeNTvHtrrDljzHcklgvh6IlssUauG8ZeDEwCVbq6o9AtUCIC2-eWs9MNRHAI5b_cFw-PJM9tDgyNSIFEmv8ULvIqgUP7LUHW-UJmaew55nH0JBjN-yrJeXs9hZe1seQdoVoGX3kiRtkacwQYSoDg0_qVxTzQtV_u7XX0NTZ1mZ0ZBmhlmOYWG69LUUQsAw9N4aRUt7j_STc1vWbB4h1emvnaGAH_ugwex5sEyDqdnm8ezg-AdVJW23Hp2BB32p_ZPGuSVSo7NFVyFIgnKJCRiR9AJVsXBsZKam8H7rB6vZ6EUjeaq4mMQeoSYWzdlbKkCy58O9gFE6Rlp6tfGLjlPi8BjEK8g-qMJbiP32oX7ev77uyd8urD3a0OTGTvGD6tHZaM_gBtmrdr1oA7gALonzq7bhlHqRrnZaE034a_xrUrXbFGEW_jAhaW2lHN8EfqSja-9qF1GRSwrmM7D9vFxTwHjtYGvgS9IGCe0vZRcdD35vR77HimccAX9bFK5Djy-itsl8XZQrKpcQGnhQwjobcN9osbP8WDAAdjck-YVCY1GA9q5eExKMKEajf5l-QAsIUDhkQetRxFCIfKC-ndW_bBgRFl0vTfO38vemN4JjUTMp0yWFdQSVvP5ijAftcKlAE0Xw1zde7RTHOCCh4c";  // Use the full token
//        login.injectCaptchaToken(captchaToken);
        login.loginButton();
    }

    @Then("user lands on account landing page")
    public void user_lands_on_account_landing_page() throws InterruptedException {
        System.out.println("Landing of account page: " + Variables.BLUE + login.verifyAccountLandingPage() + Variables.RESET);
        Thread.sleep(2000);
    }

    @And("user clicks the Account CTA")
    public void userClicksTheAccountCTA() throws InterruptedException {
        login.clickAccountCTA();
        Thread.sleep(1500);
        login.clickSignIn();
        Thread.sleep(1500);
    }

    @Then("user navigates to login page")
    public void userNavigatesToLoginPage() {
        System.out.println(Variables.BRIGHT_CYAN + "Login url validation: " + Variables.RESET + driver.getCurrentUrl());
    }

    @And("user clicks the sign-in or register CTA")
    public void userClicksTheSigninOrRegisterCTA() throws InterruptedException {
        login.clickRegisterOrSignIn();
    }

    @Then("user enter the registered number {string} from login page")
    public void userEnterTheRegisteredNumberFromLoginPage(String mobile) {
        login.countryCode();
        login.mobileNumber(mobile);
    }

    @When("User hit the login url")
    public void userHitTheLoginUrl() {
        String base = ConfigReader.get("baseUrl");
        String login = ConfigReader.get("login");
        driver.get(base + login);
//        driver.get("login");
    }

    @When("user lands on login page")
    public void userLandsOnLoginPage() {
        if (login.validateLoginPage().contains("/login")) {
            System.out.println("Landing on Login page");
        } else {
            System.out.println("Error on login page");
        }

    }

    @And("user clicks get verify code CTA in login page")
    public void userClicksGetVerifyCodeCTAInLoginPage() {
        login.getCodeButton();
    }
}
