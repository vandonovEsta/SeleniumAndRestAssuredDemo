package constants;

import java.util.HashMap;
import java.util.Map;

public class TestConstants {
    public static final String RESTASSURED_CONFIG_LOCATION = "src/main/java/restassured/resources/config.properties";
    public static final String SELENIUM_CONFIG_LOCATION = "src/main/java/selenium/framework/resources/config.properties";


    //Usually we get the expected values from the database, documentation or another source
    // but for this demo I will just use a constant and hope that prices don't change for a few days
    public static final Map<String, String> expectedSatellites = new HashMap<>() {{
        put("ENDURANCE", "€ 1,500,000");
        put("8U CubeSat", "€ 424,000");
        put("6U CubeSat", "€ 388,000");
        put("12U CubeSat", "€ 612,000");
        put("1U CubeSat", "€ 67,000");
        put("16U CubeSat", "€ 639,000");
        put("3U CubeSat", "€ 308,000");
    }};

    public static final String SPACE_SERVICE_TITLE = "Space is closer than you think with our Space Service | EnduroSat";
    public static final String CAREERS_TITLE = "Careers | Browse Open Positions and Join our EnduroSat Team";
    public static final String SPACE_SERVICE_URL_PATH = "space-service/";
    public static final String CAREERS_URL_PATH = "careers/";

}

