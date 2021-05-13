import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import pages.GitHubMainPage;
import steps.LoginPageSteps;

/**
 * The type Git hub test.
 */
public class GitHubTest {
    private final static Logger LOGGER = LogManager.getLogger(GitHubTest.class);

    private final GitHubMainPage mainPage = new GitHubMainPage();
    private final LoginPageSteps loginPageSteps = new LoginPageSteps();

    /**
     * Verify user cant login with invalid credentials.
     */
    @Test
    @Description("Verify user cant login with invalid credentials")
    public void verifyUserCantLoginWithInvalidCredentials() {
        LOGGER.info("Verify user cant login with invalid credentials. Started.");

        Selenide.open("");
        WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(1900, 1200));

        mainPage.getSignIn().click();
        loginPageSteps.fillCredentialsAndLogin("login", "password");
        loginPageSteps.verifyErrorMessage("Incorrect username or password.");

        LOGGER.info("Verify user cant login with invalid credentials. Passed.");
    }

    /**
     * Sets up.
     */
    @BeforeAll
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
        Configuration.headless = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    /**
     * Clean up.
     */
    @AfterAll
    public static void cleanUp() {
        SelenideLogger.removeAllListeners();
    }
}
