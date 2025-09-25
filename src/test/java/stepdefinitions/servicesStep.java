package stepdefinitions;

import ConstantVariables.Variables;
import DriverFactory.DriverFactory;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ServiceListingPage;
import pages.Services;
import utils.ConfigReader;


public class servicesStep {
    WebDriver driver = DriverFactory.getDriver();
    ServiceListingPage service = new ServiceListingPage(DriverFactory.getDriver());

    @When("User hit the service listing of las-vegas location")
    public void userHitTheServiceListingOfLasVegasLocation() {
        String base = ConfigReader.get("baseUrl");
        String las = ConfigReader.get("las-vegas");
        driver.get(base + las);
    }

    @When("User lands on service listing page")
    public void user_lands_on_service_listing_page() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("Service Landing: " + Variables.BLUE + service.servicePage() + Variables.RESET);
        service.validateHeader();
    }

    @Then("validate user can able to click all the pillar name")
    public void validate_user_can_able_to_click_all_the_pillar_name() throws InterruptedException {
//        service.pillarName();
        Thread.sleep(1000);
    }

    @When("user select the service from Body Treatment category")
    public void user_select_the_service_from_body_treatment_category() throws InterruptedException {
        Thread.sleep(1000);
        service.selectPillarName("Spa & Beauty");
        Thread.sleep(1000);
        service.selectAnyCategory("Body Treatments");
        service.setSelectService("Coconut Nourish Cocoon");
        Thread.sleep(1500);
    }

    @When("user select any service from any category")
    public void user_select_any_service_from_any_category() throws InterruptedException {
        service.selectPillarName("Spa & Beauty");
        Thread.sleep(1000);
        service.setSelectService("Reiki");
        Thread.sleep(2000);
    }

    @When("User navigate to service details page")
    public void user_navigate_to_service_details_page() throws InterruptedException {
        Thread.sleep(1500);
        service.selectedCategoryService();
        System.out.println("Service Details page: " + Variables.BRIGHT_GREEN + service.validateServiceDetailsPage() + Variables.RESET);
    }

    @Then("user clicks the category text and redirects to service listing page")
    public void user_clicks_the_category_text_and_redirects_to_service_listing_page() throws InterruptedException {
        service.clickCategory();
        Thread.sleep(1000);
        Assert.assertTrue(service.validateRedirectServicePage());
    }

    @Then("user select the duration")
    public void user_select_the_duration_and_clicks_add_to_cart_cta() throws InterruptedException {
        service.selectDuration();
        Thread.sleep(1000);
    }

    @And("user clicks Add to cart CTA")
    public void UserClicksAddToCartCTA() throws InterruptedException {
        Thread.sleep(2000);
        service.addToCart();
        Thread.sleep(1000);
    }

    @Then("validate the mini cart popup modal is displayed with success message")
    public void validate_the_mini_cart_popup_modal_is_displayed_with_success_message() throws InterruptedException {
//       service.validateMiniCart();
        String success = service.validSuccessMsg();
        System.out.println("Success message: " + Variables.BLUE + success + Variables.RESET);
    }


    @Then("user select the service from one category")
    public void user_select_the_service_from_one_category() throws InterruptedException {
        Thread.sleep(1500);
        service.selectAnyCategory("Massage");
        service.selectAnyService("Deep Tissue Massage");
    }

    @Then("user select the service from another category for guest two")
    public void user_select_the_service_from_another_category_for_guest_two() throws InterruptedException {
        Thread.sleep(1500);
        service.selectAnyCategory("Massage");
        service.selectAnyService("Aromatherapy Massage");
    }

    @When("user select the one category from any pillar")
    public void userSelectTheOneCategoryFromAnyPillar() throws InterruptedException {
        service.selectAnyCategory("Massage");
    }

    @Then("user select the service from selected category")
    public void userSelectTheServiceFromSelectedCategory() throws InterruptedException {
        service.selectAnyService("Prenatal Massage");
    }

    @And("user redirects to service listing page")
    public void userRedirectsToServiceListingPage() {
        service.validateHeader();
        System.out.println("Service Landing: " + Variables.BLUE + service.servicePage() + Variables.RESET);
        Assert.assertTrue(service.validateServicePage());
    }

    @And("user hover to Add to cart CTA")
    public void userHoverToAddToCartCTA() {
        service.hover();
    }

    @When("user can add three services to the cart")
    public void userCanAddThreeServicesToTheCart() throws InterruptedException {
        service.thirdService("Fitness & Movement", "Fitness Services", "Private Fitness Training");
    }

    @And("user redirect to service details page with Save changes CTA")
    public void userRedirectToServiceDetailsPageWithSaveChangesCTA() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Landing on Edit service details page: " + Variables.BRIGHT_GREEN + service.validateEditService() + Variables.RESET);
    }

    @And("user clicks the Save changes CTA")
    public void userClicksTheSaveChangesCTA() throws InterruptedException {
        service.clickSaveCTA();
        Thread.sleep(1500);
    }

    @Then("user change the gender preference")
    public void userChangeTheGenderPreference() throws InterruptedException {
        service.changeGender("Female");
        Thread.sleep(1000);
        service.selectServiceProvider(3);
        Thread.sleep(1000);
    }

    @Then("user select the duration and add-ons")
    public void userSelectTheDurationAndAddOns() {
        service.zoomOut("%80");
        service.addOns(1);
    }

    @Then("user select the service from any category")
    public void userSelectTheServiceFromAnyCategory() throws InterruptedException {
        service.selectCategoryPills("Eastern Therapies");
        Thread.sleep(2000);
        service.selectAnyService("Ashiatsu Massage");
    }

    @Then("user select the service from any category with Addons")
    public void userSelectTheServiceFromAnyCategoryWithAddons() throws InterruptedException {
        service.selectCategoryPills("Massage");
        Thread.sleep(2000);
        service.selectAnyService("Deep Tissue Massage");
        Thread.sleep(1000);
    }

    @Then("user select the duration, addons and clicks Add to Cart CTA")
    public void userSelectTheDurationAddonsAndClicksAddToCartCTA() throws InterruptedException {
        service.addToCart();
        service.addOns(1);
        Thread.sleep(2000);
    }

    @Then("user select the addons and clicks Continue CTA")
    public void userSelectTheAddonsAndClicksContinueCTA() throws InterruptedException {
        service.addOns(1);
        service.clickContinueCTA();
        Thread.sleep(2000);
    }

    @Then("user select the addons and clicks Continue CTA for third guest")
    public void userSelectTheAddonsAndClicksContinueCTAForThirdGuest() throws InterruptedException {
        service.addOns(2);
        Thread.sleep(1000);
        service.clickContinueCTA();
        Thread.sleep(2000);
    }

    @Then("user selects the male gender preference")
    public void userSelectsTheGenderPreference() {
        service.selectGender("Male");
    }

    @Then("user clicks confirm preferences CTA")
    public void userClicksConfirmPreferencesCTA() throws InterruptedException {
        service.clickConfirm();
        Thread.sleep(2000);
    }

    @Then("user change only gender preference")
    public void userChangeOnlyGenderPreference() {
        service.selectGender("Female");
    }

    @When("user select the pillar name to select the category for guest two")
    public void userSelectThePillarNameToSelectTheCategoryForGuestTwo() {
        service.selectPillarName("Spa & Beauty");
    }

    @And("user selects the female gender preference")
    public void userSelectsTheFemaleGenderPreference() {
        service.selectGender("Female");
    }

    @When("user select the pillar name to select the category for guest three")
    public void userSelectThePillarNameToSelectTheCategoryForGuestThree() {
        service.selectPillarName("Spa & Beauty");
    }

    @And("user select the service from another category for guest three")
    public void userSelectTheServiceFromAnotherCategoryForGuestThree() throws InterruptedException {
        service.selectCategoryPills("Facial Treatments");
        service.selectAnyService("Collagen Lifting Facial");
    }

    @When("user select the pillar name to select the category for the selected guest service deleted")
    public void userSelectThePillarNameToSelectTheCategoryForTheSelectedGuestServiceDeleted() {
        service.selectPillarName("Spa & Beauty");
    }

    @And("user select the service from another category for guest with deleted service")
    public void userSelectTheServiceFromAnotherCategoryForGuestWithDeletedService() throws InterruptedException {
        service.selectCategoryPills("Eastern Therapies");
        service.selectAnyService("Thai Massage");
    }

    @Then("user select the duration from the Guest Two")
    public void userSelectTheDurationFromTheGuestTwo() throws InterruptedException {
        Thread.sleep(1000);
//        service.selectDuration();
        service.durationSelection(2);
    }

    @Then("user select the duration from the page")
    public void userSelectTheDurationFromThePage() throws InterruptedException {
        Thread.sleep(1000);
        service.selectDuration();
    }

    @And("user clicks the guest dropdown of Add to cart CTA")
    public void userClicksTheGuestDropdownOfAddToCartCTA() throws InterruptedException {
        Thread.sleep(2000);
        service.clickGuestDropDown();

    }

    @And("select the guest to add the service for guest three")
    public void selectTheGuestToAddTheServiceForGuestThree() throws InterruptedException {
        Thread.sleep(1000);
        service.selectGuest("Guest 3");
        Thread.sleep(1500);
    }

    @And("select the guest to add the service for guest two")
    public void selectTheGuestToAddTheServiceForGuestTwo() throws InterruptedException {
        Thread.sleep(1000);
        service.selectGuest("Guest 2");
        Thread.sleep(1500);
    }


    @When("user select the service from another category")
    public void userSelectTheServiceFromAnotherCategory() throws InterruptedException {
        service.selectCategoryPills("Massage");
        service.selectAnyService("Birthday Celebration Massage");
    }

    @And("user click continue CTA to select select the gender")
    public void userClickContinueCTAToSelectSelectTheGender() throws InterruptedException {
        service.clickContinueCTA();
        Thread.sleep(1000);
    }

    @When("user select the service to the cart page")
    public void userSelectTheServiceToTheCartPage() throws InterruptedException {
        service.selectAnyCategory("Eastern Therapies");
        service.selectAnyService("Ashiatsu Massage");
    }

    @When("user select the pillar name to select the category")
    public void userSelectThePillarNameToSelectTheCategory() {
        service.selectPillarName("Spa & Beauty");
    }


    @And("user clicks any one service from the similar services section for the guest three")
    public void userClicksAnyOneServiceFromTheSimilarServicesSectionForTheGuestThree() throws InterruptedException {
//        Thread.sleep(1500);
        service.selectSimilarService(3);
        Thread.sleep(1000);
    }

    @And("user clicks any one service from the similar services section for the guest two")
    public void userClicksAnyOneServiceFromTheSimilarServicesSectionForTheGuestTwo() throws InterruptedException {
        service.selectSimilarService(2);
        Thread.sleep(1000);
    }

    @When("user select the service from any category for the guest one")
    public void userSelectTheServiceFromAnyCategoryForTheGuestOne() throws InterruptedException {
        service.selectAnyCategory("Ayurvedic Treatments");
    }


    @Then("user select the addons from the modal")
    public void userSelectTheAddonsFromTheModal() {
        service.addOns(2);
    }

    @Then("user select the duration and clicks Add to Cart CTA")
    public void userSelectTheDurationAndClicksAddToCartCTA() throws InterruptedException {
        service.selectDuration();
        Thread.sleep(1000);
        service.addToCart();
        Thread.sleep(1000);
    }

    @And("user select the service to the cart page without gender flow")
    public void userSelectTheServiceToTheCartPageWithoutGenderFlow() throws InterruptedException {
        service.selectAnyCategory("Makeup");
        service.selectAnyService("Eyes Only");

    }

    @And("user select the service from another category for guest two without gender preference")
    public void userSelectTheServiceFromAnotherCategoryForGuestTwoWithoutGenderPreference() throws InterruptedException {
        service.selectAnyCategory("Facial Treatments");
        service.selectAnyService("Collagen Lifting Facial");
    }

    @And("user select the service from another category for guest three without gender preference")
    public void userSelectTheServiceFromAnotherCategoryForGuestThreeWithoutGenderPreference() throws InterruptedException {
        service.selectAnyCategory("Barber");
        service.selectAnyService("Barber Beard Trim and Shave");
    }

    @Then("User navigate to service details page for three")
    public void userNavigateToServiceDetailsPageForThree() throws InterruptedException {
        Thread.sleep(1500);
        service.selectedCategoryService();
        System.out.println("Service Details page: " + Variables.BRIGHT_GREEN + service.validateServiceDetailsPage() + Variables.RESET);

    }

    @Then("user select the duration from the page for three")
    public void userSelectTheDurationFromThePageForThree() throws InterruptedException {
        service.selectDuration();
        Thread.sleep(1000);
    }
}
