package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GitHubLoginPage;

/**
 * The type Login page steps.
 */
public class LoginPageSteps {
    private final GitHubLoginPage loginPage;

    /**
     * Instantiates a new Login page steps.
     */
    public LoginPageSteps() {
        loginPage = new GitHubLoginPage();
    }

    /**
     * Fill credentials and login.
     *
     * @param login    the login
     * @param password the password
     */
    @When("user logins with {string} and {string}")
    public void fillCredentialsAndLogin(String login, String password) {
        loginPage.getLoginField().setValue(login);
        loginPage.getPasswordField().setValue(password);
        loginPage.getSignInButton().click();
    }

    /**
     * Verify error message.
     *
     * @param errorMessage the error message
     */
    @Then("user sees error message {string}")
    public void verifyErrorMessage(String errorMessage) {
        loginPage.getErrorMessage().should(Condition.text(errorMessage));
    }
}
