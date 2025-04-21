package selenium.framework.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static utils.WebElementUtils.waitUntilElementIsDisplayed;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//div[label[contains(text(), 'Full Name')]]//input")
    private WebElement nameInput;
    @FindBy(xpath = "//div[label[contains(text(), 'Email')]]//input")
    private WebElement email;
    @FindBy(xpath = "//div[label[contains(text(), 'Phone Number')]]//input")
    private WebElement phoneNumber;
    @FindBy(xpath = "//div[label[contains(text(), 'Message')]]//textarea")
    private WebElement message;

    private final Faker faker = Faker.instance();

    //We don't press send on production!!!!!
//    @FindBy(xpath = "")
//    private WebElement sendButton;

    private final String topicTabXpath = "//ul[@class = 'select_topic_list']/li[span[contains(text(), '%s')]]";

    public ContactPage() throws IOException {
        init();
    }

    public void chooseTopic(String topic) {
        waitUntilElementIsDisplayed(String.format(topicTabXpath, topic));
        driver.findElement(By.xpath(String.format(topicTabXpath, topic))).click();
    }

    public void fillContactForm() {
        sendTextToInputField(waitUntilElementIsDisplayed(nameInput), faker.name().name());
        sendTextToInputField(waitUntilElementIsDisplayed(email), faker.internet().emailAddress());
        sendTextToInputField(waitUntilElementIsDisplayed(phoneNumber), faker.phoneNumber().cellPhone());
        sendTextToInputField(waitUntilElementIsDisplayed(message), faker.backToTheFuture().quote());
    }

    public void clickSendButton() {
        //We don't press send on production!!!!!
    }

    public void messageWasSentSuccessfully() throws InterruptedException {
        wait(3);
    }
}
