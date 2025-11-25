package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import utils.context.ScenarioContext;

@Log4j2
public class Hooks {
    private final ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Before(value = "@chrome", order = 1000)
    public void beforeChrome() {
        AbstractDriver.createChrome();
    }

    @Before(value = "@firefox", order = 1000)
    public void beforeFirefox() {
        AbstractDriver.createFirefox();
    }

    @Before
    public void before() {
        log.info("Feature started");
    }

    @After(order = 1000)
    public void afterPrintScenarioContext() {
        log.info("Scenario Context contains:\n" + scenarioContext.toString());
    }

    @After(value = "not @no-quit", order = 900)
    public void after(Scenario scenario) {
        if (!scenario.isFailed()) {
            AbstractDriver.destroy();
            log.info("Ending, good by");
        } else log.info("Fail, not closing");
    }

    @After(value = "@no-quit", order = 900)
    public void afterNoQuit() {
        log.info("No closing driver after");
    }

}
