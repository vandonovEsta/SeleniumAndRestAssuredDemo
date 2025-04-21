package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.framework.drivers.Browser;

import java.time.Duration;
import java.util.List;

public class WebElementUtils {

    private static final int WAIT_IN_SECONDS = 10;
    private static WebDriverWait _wait;

    private static void initWait() {
        _wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(WAIT_IN_SECONDS));
    }

    public static WebElement waitUntilElementIsDisplayed(WebElement element) {
        initWait();
        _wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitUntilElementIsDisplayed(String locator) {
        initWait();
        return _wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static List<WebElement> waitUntilElementsAreDisplayed(List<WebElement> list) {
        initWait();
        return _wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public static void waitUntilListHasElements(String locator) {
        _wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(locator), 0));
    }

    public static void waitUntilElementsAreVisible(List<WebElement> elements) {
        _wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitUntilElementIsNotPresent(WebElement element) {
        _wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUntilUrlContains(String text) {
        _wait.until(ExpectedConditions.urlContains(text));
    }

    //For troubleshooting only
    public static void waitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
