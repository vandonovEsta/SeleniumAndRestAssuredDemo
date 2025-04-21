package selenium.stepdefinitions;

import constants.TestConstants;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import selenium.framework.pages.*;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WebsiteBaseSteps {

    protected BasePage page = new BasePage();
    protected HomePage homePage;
    protected ProductsPage productsPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected SpaceServicePage spaceServicePage;
    protected CareersPage careersPage;
    protected ContactPage contactPage;


    public WebsiteBaseSteps() throws IOException {
    }

    @ParameterType(".*")
    public String productType(String productType) {
        return productType;
    }

    @ParameterType(".*")
    public String productName(String productName) {
        return productName;
    }

    @Before
    public void init() {
        page.open();

        //todo: handle cookie popup
    }


    @After
    public void tearDown() {
        page.close();
    }

    @AfterAll
    public void finalTearDown() {
        page.quit();
    }

    @Given("We navigate to Endurosat website")
    public void we_navigate_to() throws IOException {
        homePage = page.navigateToHomePage();
    }

    @When("We open the products list")
    public void we_open_the_products_list() throws IOException {
        homePage.openProductsList();
    }

    @When("Choose satellites")
    public void choose_satellites() throws IOException {
        productsPage = homePage.goToSatellitesList();
    }

    @Then("Page should contain the right title")
    public void page_should_contain_the_right_title() {
        assertAll(
                () -> assertTrue(productsPage.satelliteTitleIsDisplayed(), "satellite title was not displayed!"),
                () -> assertTrue(productsPage.satelliteSubtitleIsDisplayed(), "satellite subtitle was not displayed!")
        );
    }

    @Then("Pricing should be correct")
    public void pricing_should_be_correct() {
        Map<String, String> expectedPrices = productsPage.getAllSatelliteNamesAndPrices();
        assertEquals(TestConstants.expectedSatellites, expectedPrices);
    }

    @When("From {productType} choose {productName} product")
    public void open_a_product(String productType, String productName) throws IOException {
        productPage = productsPage.clickOnProductByTypeAndName(productType, productName);
    }

    @When("Choose Add product to cart")
    public void choose_add_product_to_cart() {
        productPage.addToCart();
    }

    @Then("Review My List button should open the cart page")
    public void review_my_list_button_should_open_the_cart_page() throws IOException {
        cartPage = productPage.reviewMyList();
        assertEquals("https://www.endurosat.com/cart/", cartPage.getCurrentUrl());
    }

    @Then("Cart should contain {productName} product")
    public void cart_content_should_be_correct(String productName) throws InterruptedException {
        assertTrue(cartPage.getCartProductNames().contains(productName), "Product was not in cart");
    }

    @When("We click on Space Service link")
    public void we_click_on_space_service_link() throws IOException {
        spaceServicePage = homePage.goToSpaceServicePage();
    }

    @Then("The Space Service page should load")
    public void the_space_service_page_should_load() {

        assertEquals(TestConstants.SPACE_SERVICE_TITLE, spaceServicePage.getTitle());
    }

    @When("We Click on Careers")
    public void we_click_on_careers() throws IOException {
        careersPage = homePage.goToCareersPage();
    }

    @Then("The Careers page should load")
    public void the_careers_page_should_load() {
        assertEquals(TestConstants.CAREERS_TITLE, careersPage.getTitle());
    }

    @Then("Open Positions Button Should be visible")
    public void open_positions_button_should_be_visible() {
        assertTrue(careersPage.isCareerButtonDisplayed(), "Expected career button to be visible");
    }

    @When("We Click on Contact button")
    public void we_click_on_contact_button() throws IOException {
        contactPage = homePage.clickContactButton();
    }

    @When("Select from topics {word}")
    public void select_from_topics_support(String word) {
        contactPage.chooseTopic(word);
    }

    @When("Fill the form")
    public void fill_the_form() {
        contactPage.fillContactForm();
    }

    @When("Click Send")
    public void click_send() {
        contactPage.clickSendButton();
    }

    @Then("We should see confirmation that message was sent successfully")
    public void we_should_see_confirmation_that_message_was_sent_successfully() throws InterruptedException {
        contactPage.messageWasSentSuccessfully();
    }
}
