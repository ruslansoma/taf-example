import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import util.PropertyParameters;

import java.util.Collections;

/**
 * The type Base exchange rate test.
 */
public class BaseExchangeRateTest {
    private static String API_KEY = PropertyParameters.getInstance().get("api.key");
    private static String BASE_URL = PropertyParameters.getInstance().get("base.uri");

    /**
     * Sets up.
     */
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = String.format(BASE_URL, API_KEY);
        RestAssured.filters(Collections.singletonList(new AllureRestAssured()));
    }
}
