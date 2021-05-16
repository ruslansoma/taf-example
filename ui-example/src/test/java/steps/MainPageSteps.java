package steps;

import com.codeborne.selenide.Selenide;
import config.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GitHubMainPage;

/**
 * The type Main page steps.
 */
public class MainPageSteps {
    private final GitHubMainPage mainPage;

    /**
     * Instantiates a new Main page steps.
     */
    public MainPageSteps() {
        mainPage = new GitHubMainPage();
    }

    /**
     * Click login button.
     */
    @When("user click Sign in button")
    public void clickLoginButton() {
        mainPage.getSignIn().click();
    }

    /**
     * Open main page.
     */
    @Given("user opens Github main page")
    public void openMainPage() {
        Selenide.open(TestConfig.GITHUB_URL);
    }
}
