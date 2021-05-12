package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GitHubMainPage {

    public SelenideElement getSignIn() {
        return $(Selectors.byText("Sign in"));
    }

    public SelenideElement getSignUp() {
        return $(Selectors.byText("Sign up"));
    }
}
