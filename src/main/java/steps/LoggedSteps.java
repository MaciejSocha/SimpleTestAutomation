package steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoggedPage;
import utils.context.ContextKey;
import utils.context.ScenarioContext;

public class LoggedSteps {
    private final ScenarioContext scenarioContext;
    private final LoggedPage loggedPage = new LoggedPage();

    public LoggedSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Then("User is successfully logged in")
    public void userIsSuccessfullyLogged() {
        Assertions.assertTrue(loggedPage.isLoginSuccessfulMessageDisplayed());
    }

    @Then("Displayed login matches entered login")
    public void displayedLoginMatchesEntered() {
        String userLogin = scenarioContext.get(ContextKey.USERNAME);
        Assertions.assertTrue(loggedPage.welcomeTextContainsProperUsername(userLogin.trim()));
    }
}
