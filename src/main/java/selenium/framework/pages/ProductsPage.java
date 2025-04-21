package selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.WebElementUtils.waitUntilElementIsDisplayed;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h2//div[contains(text(), 'Satellites')]")
    private static WebElement satellitesTitle;

    @FindBy(xpath = "//div[contains(@class, 'small_text')][contains(text(), 'Remarkable satellites')]")
    private static WebElement satellitesSubtitle;

    @FindBy(xpath = "//section[.//h2//div[contains(text(), 'Satellites')]]//div[@class = 'table']/a")
    private static List<WebElement> satellitesTable;

    public ProductsPage() throws IOException {
        init();
    }

    private String getSatelliteType(WebElement tableRow) {
        //I really didn't want to use this locator but there is nothing else to latch on to for this element
        return tableRow.findElement(By.xpath("./div[1]")).getText();
    }

    private String getSatellitePrice(WebElement tableRow) {
        //I really didn't want to use this locator but there is nothing else to latch on to for this element
        return tableRow.findElement(By.xpath("./div[2]")).getText();
    }

    public Map<String, String> getAllSatelliteNamesAndPrices() {
        waitUntilElementIsDisplayed(satellitesTitle);

        Map<String, String> satellites = new HashMap<>();
        for (WebElement row :
                satellitesTable) {
            satellites.put(getSatelliteType(row), getSatellitePrice(row));
        }

        return satellites;
    }

    private WebElement getProductRowByTypeAndName(String productType, String productName) {
        String xpath = String.format("//section[.//h2//div[contains(text(), '%1$s')]]//div[@class = 'table']/a//div[contains(text(), '%2$s')]",
                productType, productName);

        return waitUntilElementIsDisplayed(xpath);
    }

    public ProductPage clickOnProductByTypeAndName(String productType, String productName) throws IOException {
        getProductRowByTypeAndName(productType, productName).click();

        return new ProductPage();
    }

    public boolean satelliteTitleIsDisplayed() {
        return waitUntilElementIsDisplayed(satellitesTitle).isDisplayed();
    }

    public boolean satelliteSubtitleIsDisplayed() {
        return waitUntilElementIsDisplayed(satellitesSubtitle).isDisplayed();
    }
}
