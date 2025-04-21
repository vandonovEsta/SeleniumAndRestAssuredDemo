package selenium.framework.pages;

import helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.framework.drivers.Browser;

import java.io.IOException;

import static utils.WebElementUtils.waitForSeconds;

public class BasePage {
    @FindBy(xpath = "//div[@class = 'nav']/a[@data-text='Space Service']")
    protected static WebElement spaceServiceLink;
    //This is a <div/> instead of <a/>?
    @FindBy(xpath = "//div[@class = 'nav']/div[@data-text='Satellites']")
    protected static WebElement satellitesLink;
    @FindBy(xpath = "//div[@class = 'nav']/a[@data-text='Careers']")
    protected static WebElement careersLink;
    protected WebDriver driver = Browser.getDriver();
    protected PropertiesHelper propHelper = new PropertiesHelper();


    public BasePage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        if (driver == null) {
            driver = Browser.getDriver();
            //todo set window size/maximize; set headless if not run on developer machine
        }
    }

    protected void init() {
        PageFactory.initElements(driver, this);
    }

    public void close() {
        Browser.close();
        driver = null;
    }

    public void quit() {
        Browser.close();
        driver = null;
    }

    //TODO: not a fan of this. Fix if time... maybe implement singleton for PropertiesHelper?
    public HomePage navigateToHomePage() throws IOException {
        driver.navigate().to(propHelper.readProperty("websiteUrl"));
        return new HomePage();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    //For troubleshooting only
    public void wait(int seconds) throws InterruptedException {
        waitForSeconds(seconds);
    }

    protected void sendTextToInputField(WebElement inputField, String text) {
        inputField.clear();
        inputField.sendKeys(text);
    }
}
