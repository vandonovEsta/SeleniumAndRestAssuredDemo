package selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.WebElementUtils.waitForSeconds;

public class CartPage extends BasePage {

    @FindBy(xpath = "//ul[@class = 'item_list']/li")
    private static List<WebElement> cartProducts;

    public CartPage() throws IOException {
        init();
    }

    private String getProductName(WebElement row) {
        return row.findElement(By.xpath(".//div[@class = 'row stagger_piece']//div[contains(@class, 'text font_magnetik')]")).getText();
    }

    private String getProductPrice(WebElement row) {
        return row.findElement(By.xpath(".//div[@class = 'row stagger_piece']//div[contains(@class, 'text price font_magnetik')]")).getText();
    }

    private void deleteProduct(WebElement row) {
        row.findElement(By.xpath(".//div[@class = 'delete']")).click();
    }

    public List<String> getCartProductNames() throws InterruptedException {
        waitForSeconds(3);
        List<String> names = new ArrayList<>();
        for (WebElement row :
                cartProducts) {
            names.add(getProductName(row));
        }

        return names;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
