package helpers;

import constants.TestConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesHelper {
    private final String configLocation;
    private final Properties prop;
    private final FileInputStream input;

    public PropertiesHelper(String configLocation) throws IOException {
        this.configLocation = Objects.requireNonNullElse(configLocation, TestConstants.SELENIUM_CONFIG_LOCATION);

        prop = new Properties();
        input = new FileInputStream(this.configLocation);
        prop.load(input);
    }

    public PropertiesHelper() throws IOException {
        this(null);
    }

    public String readProperty(String propName) throws IOException {
        if (input != null) {
            prop.load(input);
            if (prop.getProperty(propName) != null) {
                return prop.getProperty(propName);
            } else {
                return "No such property " + propName;
            }
        } else {
            throw new FileNotFoundException("properties file " + configLocation + " is missing.");
        }
    }
}
