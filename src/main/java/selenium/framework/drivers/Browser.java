package selenium.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private static WebDriver DRIVER;

    public static WebDriver getDriver() {
        if (DRIVER == null) {
            DRIVER = new ChromeDriver();
        }

        return DRIVER;
    }

    public static void close() {
        DRIVER.close();
        DRIVER = null;
    }

    public static void quit() {
        DRIVER.quit();
        DRIVER = null;
    }
}
