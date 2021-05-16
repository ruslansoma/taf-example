package util;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Cucumber global listener.
 */
public final class CucumberGlobalListener implements ConcurrentEventListener {
    private final static Logger LOGGER = LogManager.getLogger(CucumberGlobalListener.class);

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, setup);
        publisher.registerHandlerFor(TestRunFinished.class, teardown);
    }

    private final EventHandler<TestRunStarted> setup = event -> {
        LOGGER.info("Configuring selenide");
        Configuration.headless = true;
        Configuration.browserSize = "1920x1200";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    };

    private final EventHandler<TestRunFinished> teardown = event -> {
        LOGGER.info("Clear up selenide listeners");
        SelenideLogger.removeAllListeners();
    };
}
