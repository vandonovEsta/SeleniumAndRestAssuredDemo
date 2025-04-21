package selenium.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CareersPage extends BasePage {

    @FindBy(xpath = "//a[span[contains(text(), 'Open Positions')]]")
    private static WebElement careersButton;

    public CareersPage() throws IOException {
        init();
    }

    public boolean isCareerButtonDisplayed() {
        return careersButton.isDisplayed();
    }

}
