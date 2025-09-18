package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Services {

    private final By confirmPreference = By.xpath("//button[@class='styles_button__YaZn_ styles_primary__EzVYn styles_base__Wg2dz styles_fill__nunXW styles_buttonStyles__Noh8y']");
    private final By addToCart = By.xpath("//button[@class='styles_button__YaZn_ styles_primary__EzVYn styles_base__Wg2dz styles_fill__nunXW styles_btnStyles__YLMhV']");
    private final By guestDropdown = By.xpath("//button[@class='styles_button__YaZn_ styles_primary__EzVYn styles_base__Wg2dz styles_chevronButton__IFGf6']");
    protected WebDriver driver;

    public Services(WebDriver driver) {
        this.driver = driver;
    }

    public void selectService(String category, String service, String guest) {
        List<WebElement> massageServices = driver.findElements(By.xpath("//h2[text()='" + category + "']/parent::div/parent::div/div[2]/a/p"));
        System.out.println("List of services under the " + category + " category: ");
        System.out.println(massageServices.size());
        for (WebElement massageService : massageServices) {
            System.out.println(massageService.getText());
        }
        if (service.equals("Aromatherapy Massage") || service.equals("Magnesium Massage")) {
            if (!driver.findElement(guestDropdown).isDisplayed()) {
                driver.findElement(addToCart).click();
                genderSelction("Male");
                driver.findElement(confirmPreference).click();
            } else {
                driver.findElement(guestDropdown).click();
                if (guest.equals("Guest 1")) {
                    guestSelection(guest);
                } else if (guest.equals("Guest 2")) {
                    guestSelection(guest);
                } else {
                    guestSelection("Guest 3");
                }
            }
        }
//        else if (service.equals("")) {
//
//        }
    }

    public void genderSelction(String gender) {
        WebElement selection = driver.findElement(By.xpath("//div[contains(text(),'%s')]" + gender));
        selection.click();
    }

    public void guestSelection(String guest) {
        driver.findElement(By.xpath("//span[text()='%s']" + guest)).click();
    }

}
