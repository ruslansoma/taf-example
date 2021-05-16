package util;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Hooks.
 */
public final class Hooks {
    private final static Logger LOGGER = LogManager.getLogger(Hooks.class);

    /**
     * After scenario.
     */
    @After
    public void afterScenario() {
        LOGGER.info("Clear up browser cookies.");
        Selenide.clearBrowserCookies();
    }
}
