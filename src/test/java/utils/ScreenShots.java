//package utils;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ScreenShots {
//    public static void takeScreenshot(WebDriver driver, String scenarioName) {
//        String timestamp = new SimpleDateFormat("dd-mm-yyyy_HHmmss").format(new Date());
//        String fileName = scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File dest = new File("target/Screenshots/" + fileName);
//
//        try {
//            FileUtils.copyFile(src, dest);
//            System.out.println("Screenshot saved to: " + dest.getAbsolutePath());
//        } catch (IOException e) {
//            System.out.println("Screenshot saving failed: " + e.getMessage());
//        }
//    }
//}
package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShots {

    /**
     * Takes a screenshot and saves it to the specified directory.
     *
     * @param driver       The WebDriver instance.
     * @param scenarioName The name of the failed scenario.
     */
    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HHmmss").format(new Date());
        String fileName = scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";

        try {
            // Ensure directory exists
            File screenshotDir = new File("target/Screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Capture and save screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotDir, fileName);
            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved for failed scenario: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
