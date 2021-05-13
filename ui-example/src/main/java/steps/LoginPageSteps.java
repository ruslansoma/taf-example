package steps;

import com.codeborne.selenide.Condition;
import pages.GitHubLoginPage;

/**
 * The type Login page steps.
 */
public class LoginPageSteps {
    private final GitHubLoginPage loginPage = new GitHubLoginPage();

    /**
     * Fill credentials and login.
     *
     * @param login    the login
     * @param password the password
     */
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
    public void verifyErrorMessage(String errorMessage) {
        loginPage.getErrorMessage().should(Condition.text(errorMessage));
    }
}
