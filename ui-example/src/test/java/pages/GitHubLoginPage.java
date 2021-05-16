package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The type Git hub login page.
 */
public class GitHubLoginPage {
    /**
     * Gets login field.
     *
     * @return the login field
     */
    public SelenideElement getLoginField() {
        return $("#login_field");
    }

    /**
     * Gets password field.
     *
     * @return the password field
     */
    public SelenideElement getPasswordField() {
        return $("#password");
    }

    /**
     * Gets sign in button.
     *
     * @return the sign in button
     */
    public SelenideElement getSignInButton() {
        return $("[type='submit']");
    }

    /**
     * Gets error message.
     *
     * @return the error message
     */
    public SelenideElement getErrorMessage() {
        return $("#js-flash-container");
    }
}
