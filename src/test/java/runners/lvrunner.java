package runners;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.io.File;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@Regression",
//        tags = "@M",
//        tags = "@failed",
        plugin = {"pretty",
                "json:target/CucumberReport/CanyonRanch.json",
                "html:target/CucumberReport/CanyonRanch.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true

)
public class lvrunner {
    public static void tSearDown() {
        File reportOutputDirectory = new File("target/CRReport");
        List<String> jsonFiles = List.of("target/CucumberReport/cucumber.json");

        Configuration config = new Configuration(reportOutputDirectory, "Canyon Ranch");
        config.setBuildNumber("1.0");
        config.addClassifications("Platform", "Windows");
        config.addClassifications("Browser", "Chrome");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }
}
