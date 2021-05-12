package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GitHubLoginPage {
    public SelenideElement getLoginField() {
        return $("#login_field");
    }

    public SelenideElement getPasswordField() {
        return $("#password");
    }

    public SelenideElement getSignInButton() {
        return $("[type='submit']");
    }

    public SelenideElement getErrorMessage() {
        return $("#js-flash-container");
    }
}
