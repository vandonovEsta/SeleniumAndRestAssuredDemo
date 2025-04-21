package selenium.framework.pages;

import constants.TestConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static utils.WebElementUtils.waitUntilElementIsDisplayed;
import static utils.WebElementUtils.waitUntilUrlContains;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text() , 'Satellites')]")
    private static WebElement satellites;

    @FindBy(xpath = "//a[contains(text() , 'Communication')]")
    private static WebElement communication;

    @FindBy(xpath = "//a[contains(text() , 'Antennas')]")
    private static WebElement antennas;

    //There is a typo in the xml computers is with lowerCase despite naming convention of other fields
    @FindBy(xpath = "//a[contains(text() , 'Onboard computers')]")
    private static WebElement onboardComputers;

    @FindBy(xpath = "//a[contains(text() , 'Power Modules')]")
    private static WebElement powerModules;

    @FindBy(xpath = "//a[contains(text() , 'Solar Panels')]")
    private static WebElement solarPanels;

    @FindBy(xpath = "//a[contains(text() , 'Structures')]")
    private static WebElement structures;

    @FindBy(xpath = "//a[contains(text() , 'Lab Equipment')]")
    private static WebElement labEquipment;

    //There is a typo in the xml modules is with lowerCase despite naming convention of other fields
    @FindBy(xpath = "//a[contains(text() , 'Custom modules')]")
    private WebElement customModules;

    //For some reason only this element has different structure than the rest
    @FindBy(xpath = "//a//div[contains(@class, 'menu_title')][contains(text() , 'All Products')]")
    private WebElement allProducts;

    @FindBy(xpath = "//a[contains(@class, 'button')][span[contains(text(), 'Contact')]]")
    private WebElement contactButton;

    public HomePage() throws IOException {
        init();
    }

    public void openProductsList() {
        waitUntilElementIsDisplayed(satellitesLink).click();
    }

    public ProductsPage goToSatellitesList() throws IOException {
        waitUntilElementIsDisplayed(satellites).click();
        return new ProductsPage();
    }

    public SpaceServicePage goToSpaceServicePage() throws IOException {
        waitUntilElementIsDisplayed(spaceServiceLink).click();
        waitUntilUrlContains(TestConstants.SPACE_SERVICE_URL_PATH);
        return new SpaceServicePage();
    }

    public CareersPage goToCareersPage() throws IOException {
        waitUntilElementIsDisplayed(careersLink).click();
        waitUntilUrlContains(TestConstants.CAREERS_URL_PATH);
        return new CareersPage();
    }

    public ContactPage clickContactButton() throws IOException {
        waitUntilElementIsDisplayed(contactButton).click();
        return new ContactPage();
    }
}
