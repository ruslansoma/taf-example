package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The type Git hub main page.
 */
public class GitHubMainPage {
    /**
     * Gets sign in.
     *
     * @return the sign in
     */
    public SelenideElement getSignIn() {
        return $(Selectors.byText("Sign in"));
    }
}
