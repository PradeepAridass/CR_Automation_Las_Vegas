package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failedScenarios/failedCases.txt", // path of failed scenarios
        glue = {"stepdefinitions", "hooks"}, // same glue as main runner
        plugin = {
                "pretty",
                "json:target/CucumberReport/FailedScenariosReport.json",
                "html:target/CucumberReport/FailedScenariosReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedScenarios/failedAgain.txt" // to capture if failures happen again
        },
        monochrome = true
)
public class failedRunner {
}
