package selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static utils.WebElementUtils.waitUntilElementIsDisplayed;
import static utils.WebElementUtils.waitUntilElementIsNotPresent;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'container_1'][.//h1//div[contains(text(), 'ENDURANCE')]]//div[@class = 'button section_button font_magnetik text_uppercase stagger_piece  modal_picker'][@data-modal = 'add_to_cart_modal']")
    private static WebElement addToCartButton;

    @FindBy(id = "productAddToCartButton")
    private static WebElement confirmAddToCartButton;

    @FindBy(xpath = "//a[@data-text = 'Review my list']")
    private static WebElement reviewMyListButton;

    public ProductPage() throws IOException {
        init();
    }

    public void addToCart() {
        waitUntilElementIsDisplayed(addToCartButton).click();
        waitUntilElementIsDisplayed(confirmAddToCartButton).click();
    }

    public CartPage reviewMyList() throws IOException {
        waitUntilElementIsDisplayed(reviewMyListButton).click();
        waitUntilElementIsNotPresent(reviewMyListButton);
        return new CartPage();
    }
}
