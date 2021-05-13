import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;

/**
 * The type Exchange rate test.
 */
public class ExchangeRateTest extends BaseExchangeRateTest {
    private final static Logger LOGGER = LogManager.getLogger(ExchangeRateTest.class);

    /**
     * Gets today exchange rate.
     */
    @Test
    public void getTodayExchangeRate() {
        LOGGER.info("Get today exchange rate and verify result field test. Started");

        RestAssured.given()
                .get("latest/USD")
                .prettyPeek()
                .then().statusCode(SC_OK)
                .assertThat().body("result", Matchers.equalTo("success"));

        LOGGER.info("Get today exchange rate and verify result field test. Passed");
    }

    /**
     * Get today exchange rate and verify scheme.
     */
    @Test
    public void getTodayExchangeRateAndValidateScheme() {
        LOGGER.info("Get today exchange rate and validate json scheme test. Started");

        RestAssured.given()
                .get("latest/USD")
                .prettyPeek()
                .then().statusCode(SC_OK)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data/all-currencies-schema.json"));

        LOGGER.info("Get today exchange rate and validate json scheme test. Passed");

    }
}
