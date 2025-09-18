package pages;


import ConstantVariables.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ServiceListingPage {
    private final By serviceListing = By.xpath("//h1[@class='styles_headerTitle__jm82n']");
    private final By selectCategory = By.xpath("//a[@class='styles_pillarLink__RXLR_']");
    private final By addCart = By.xpath("//button[@class='styles_button__YaZn_ styles_primary__EzVYn styles_base__Wg2dz styles_fill__nunXW styles_btnStyles__YLMhV']");
    private final By header = By.xpath("//div[@class='styles_content__DmC62']");
    private final By success = By.xpath("//span[contains(text(),'Service successfully added!')]");
    private final By confirmPreference = By.xpath("//div[4]/div/button");
    private final By saveChangesCTA = By.xpath("//div/div[5]/div/button");
    private final By guestDropDown = By.xpath("//div[5]/div/button[2]");
    WebDriver driver;

    public ServiceListingPage(WebDriver driver) {
//        super(driver);
        this.driver = driver;
    }


    public void validateHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    public String servicePage() {
        return driver.findElement(serviceListing).getText();
    }

    public boolean validateServicePage() {
        return driver.findElement(serviceListing).isDisplayed();
    }

    public boolean validateRedirectServicePage() {
        return driver.findElement(By.xpath("//div[@class='styles_stickyContainer__tkI25']")).isDisplayed();
    }
//    public void pillarName(String input){
//        List<WebElement> elements = driver.findElements(servicePillar);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the pillar index to select and see the services with categories: ");
//        int index =sc.nextInt();  // replace with your array value or variable
//        if(index < elements.size()) {
//            WebElement selectedElement = elements.get(index);
//            selectedElement.click(); // or any other action
//            String pillName = selectedElement.getText();
//            System.out.println("Selected Pillar Name: " + pillName);
//        }
//    }

//    public void pillarSpaBeauty(){
//        driver.findElement(By.xpath("//p[text()='Spa & Beauty']/)")).click();
//        String pillName = driver.findElement(selectedPillarName).getText();
//        System.out.println("Selected Pillar Name: "+Variables.BLUE +pillName +Variables.RESET);
//
//    }

    public void selectPillarName(String pillar) {
        WebElement pillarName = driver.findElement(By.xpath("//div[@class='styles_container__2zJ8R']//h2[contains(text(),'" + pillar + "')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(pillarName));
        pillarName.click();
    }


//    public void pillarName(String input) {
//        // Use XPath to locate the element by its text
//        WebElement pillar = driver.findElement(By.xpath("//div[@class='styles_container__2zJ8R']//p"));
//        List<WebElement> elements = driver.findElements(By.xpath(String.valueOf(pillar)));
//        System.out.println(elements);
//        for (int i = 0; i < elements.size(); i++) {
//        if(elements.get(i).getText().equals("Spa & Beauty") && input.equals("Spa & Beauty")) {
////        if (!pillar.isSelected()) {
////            // Selecting the first matching element
////            WebElement selectedElement = elements.get(0);
////            selectedElement.click(); // Perform click or other desired action
////
////            String pillName = selectedElement.getText();
////            System.out.println("Selected Pillar Name: " + Variables.BLUE + pillName+ Variables.RESET);
////        } else {
////            System.out.println("Selected Pillar Name: " + input);
////        }
//            System.out.println("Selected Pillar Name: " + input);
//        }else {
//            elements.get(i).click();
//            System.out.println("Selected Pillar Name: " + input);
//        }
//        }
//    }

    public void setSelectService(String service) {
        driver.findElement(By.xpath("//p[text()='" + service + "']")).click();
    }

//    public void setSelectService(){
//        List<WebElement> categoryName = driver.findElements(selectedPillarName);
//        String s = driver.findElement(pillarName).getText();
//        for(WebElement cat : categoryName) {
//            if (cat.getText() == s) {
//                driver.findElement(selectService).click();
//            } else {
//                driver.findElement(By.xpath("//p[text()='Spa & Beauty']/following::a[@href='?pillar=Spa+%26+Beauty']")).click();
//            }
//        }
//    }

    public void selectedCategoryService() {
        String category = driver.findElement(By.xpath("//a[@class='styles_pillarLink__RXLR_']")).getText();
        System.out.println("Selected Category: " + Variables.BLUE + category + Variables.RESET);
        String service = driver.findElement(By.xpath("//div[@class='styles_titleContainer__fF06L']/div/h1")).getText();
        System.out.println("Selected Service: " + Variables.BLUE + service + Variables.RESET);
    }

    public boolean validateServiceDetailsPage() {
        return driver.findElement(By.xpath("//div[@class='styles_detailsContainer___cTHm']")).isDisplayed();
    }

    public void clickCategory() {
        driver.findElement(selectCategory).click();
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addCart));
        driver.findElement(addCart).click();
    }

    public void durationSelection(int duration) {
        List<WebElement> minButton = driver.findElements(By.xpath("//div[@class='styles_durationFrame__UDsb0']/div/div"));
        System.out.println(Variables.BLUE + "Available duration button: " + Variables.RESET + Variables.PURPLE + minButton + Variables.RESET);
        if (minButton.size() > 1 && duration < minButton.size()) {
            minButton.get(duration).click();
        } else {
            minButton.get(1).click();
        }
    }

    public void selectDuration() {
        WebElement selected = driver.findElement(By.xpath("//div[@class='styles_chip__9p647 styles_clicked__WxyJK']"));
        if (!selected.isSelected()) {
            selected.click();
            System.out.println("Selected Duration: " + Variables.BLUE + selected.getText() + Variables.RESET);
        } else {
            System.out.println("Selected Duration: " + Variables.BLUE + selected.getText() + Variables.RESET);
        }
    }

    public void addOns(int checkBox) {
        List<WebElement> select = driver.findElements(By.xpath("//input[@class='styles_checkbox__AjPJP']"));
        System.out.println("Addons Available list: " + Variables.BRIGHT_GREEN + select.size() + Variables.RESET);
        System.out.println("Addons to be select: " + Variables.BLUE + 2 + Variables.RESET);
        if (checkBox >= 1) {
            if (checkBox < select.size() && checkBox == 3) {
                select.get(0).click();
                select.get(2).click();
            } else if (checkBox < select.size() && checkBox == 2) {
                select.get(0).click();
                select.get(1).click();
            } else {
                select.get(0).click();
            }
        } else {
            System.out.println(Variables.RED + "No addons available." + Variables.RESET);
        }
    }

    public void clickContinueCTA() {
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
    }


    public void zoomOut(String percent) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='%s';", percent);
    }
//    public void validateMiniCart(){
//        driver.findElement(By.xpath("styles_popup__hQuIx")).isDisplayed();
//    }

    public String validSuccessMsg() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElement(success).getText();
//       return driver.findElement(By.xpath("/div/div/div[1]/div/span")).getText();
    }


    public void selectAnyService(String service) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='" + service + "']")).click();
        Thread.sleep(2000);
    }

    public void selectAnyCategory(String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement selectCategory = driver.findElement(By.xpath("//a[text()='" + category + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectCategory));
        selectCategory.click();
    }

    public void selectCategoryPills(String category) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.linkText(category)).click();
    }

    public void selectGender(String gender) {
        WebElement selectedGender = driver.findElement(By.xpath("//div[text()='" + gender + "']"));
        selectedGender.click();
        System.out.println("Selected Gender: " + Variables.BLUE + selectedGender.getText() + Variables.RESET);
    }

    public void clickConfirm() {
        driver.findElement(confirmPreference).click();
    }

    public void selectServiceProvider(int index) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='radio'])[" + index + "]")).click();
        String provider = driver.findElement(By.xpath("(//input[@type='radio']//following::div[@class='styles_text__sj3I8'])[" + index + "]")).getText();
        System.out.println("Selected service provider: " + Variables.BLUE + provider + Variables.RESET);
    }


    public void hover() {
        WebElement element = driver.findElement(By.xpath("//div[@class='styles_buttonWrapper__5acrY']"));
        Actions ac = new Actions(driver);
        ac.moveToElement(element).perform();
    }

    public void thirdService(String pillar, String category, String service) throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='styles_pillarLink__n4gx1']//following::p[text()='" + pillar + "']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='" + service + "']")).click();
        Thread.sleep(1000);
        System.out.println("Selected Category: " + Variables.BLUE + service + Variables.RESET);
    }

    public boolean validateEditService() {
        return driver.findElement(saveChangesCTA).isDisplayed();
    }

    public void clickSaveCTA() {
        driver.findElement(saveChangesCTA).click();
    }

    public void changeGender(String gender) {
        WebElement selectedGender = driver.findElement(By.xpath("//div[text()='" + gender + "']"));
        selectedGender.click();
        System.out.println("Selected Gender: " + Variables.BLUE + selectedGender.getText() + Variables.RESET);
    }

    public void clickGuestDropDown() {
        driver.findElement(guestDropDown).click();
    }

    public void selectGuest(String guest) {
        List<WebElement> guests = driver.findElements(By.xpath("//div[@class='styles_guestRow__clB6x']"));
        for (WebElement element : guests) {
            String guestName = element.getText();
            if (guestName.equals(guest)) {
                element.click();
                System.out.println("Selected Guest: " + Variables.BLUE + guestName + Variables.RESET);
            }
        }
    }

    public void selectSimilarService(int service) throws InterruptedException {
        WebElement similarService = driver.findElement(By.xpath("//p[text()='Similar services you might like']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", similarService);
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//div[@class='style_mobileCard__C5W_o']/p)[" + service + "]")).click();
    }

}
