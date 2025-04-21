package helpers;

import static java.util.UUID.randomUUID;

public class StringHelper {
    public static String getRandomBearerToken() {
        return randomUUID().toString();
    }
}
