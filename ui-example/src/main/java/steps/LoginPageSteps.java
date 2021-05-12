package steps;

import com.codeborne.selenide.Condition;
import pages.GitHubLoginPage;

public class LoginPageSteps {
    private final GitHubLoginPage loginPage = new GitHubLoginPage();

    public void fillCredentialsAndLogin(String login, String password) {
        loginPage.getLoginField().setValue(login);
        loginPage.getPasswordField().setValue(password);
        loginPage.getSignInButton().click();
    }

    public void verifyErrorMessage(String errorMessage) {
        loginPage.getErrorMessage().should(Condition.text(errorMessage));
    }
}
