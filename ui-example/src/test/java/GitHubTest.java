import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GitHubMainPage;
import steps.LoginPageSteps;

public class GitHubTest {
    private final static Logger LOGGER = LogManager.getLogger(GitHubTest.class);

    private final GitHubMainPage mainPage = new GitHubMainPage();
    private final LoginPageSteps loginPageSteps = new LoginPageSteps();

    @BeforeAll
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1200";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Test
    @Description
    public void verifyUserCantLoginWithInvalidCredentials() {
        LOGGER.error("Verify user cant login with invalid credentials. Started.");

        Selenide.open("");
        mainPage.getSignIn().click();
        loginPageSteps.fillCredentialsAndLogin("login", "password");
        loginPageSteps.verifyErrorMessage("Incorrect username or password.");

        LOGGER.error("Verify user cant login with invalid credentials. Finished.");
    }
}
