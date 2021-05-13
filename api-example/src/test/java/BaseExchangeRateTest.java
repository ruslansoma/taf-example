import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import util.PropertyParameters;

/**
 * The type Base exchange rate test.
 */
public class BaseExchangeRateTest {
    private static String API_KEY = System.getProperty("qa.api.key");
    private static String BASE_URL = PropertyParameters.getInstance().get("base.uri");

    /**
     * Sets up.
     */
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = String.format(BASE_URL, API_KEY);
    }
    /**
     * Gets request spec.
     *
     * @return the request spec
     */
    protected RequestSpecification getRequestSpec() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.log(LogDetail.ALL);
        builder.setContentType(ContentType.JSON);
        builder.setAccept(ContentType.JSON);
        return builder.build();
    }
}
