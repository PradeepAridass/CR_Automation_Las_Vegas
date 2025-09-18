package ConstantVariables;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MethodsReusable {
    WebDriver driver;

    public MethodsReusable(WebDriver driver) {
        this.driver = driver;
    }

    public void Waits(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
