package hooks;

import DriverFactory.DriverFactory;
import Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ScreenShots;


public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }


    @After
    public void tearDown(Scenario scenario) {
        driver = DriverFactory.getDriver();

        // Take screenshot if scenario failed
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            ScreenShots.takeScreenshot(driver, scenario.getName());
            // Optional: attach to Cucumber report
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }
        DriverFactory.quitDriver();
    }
}


