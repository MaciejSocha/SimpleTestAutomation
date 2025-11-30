package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        Assertions.assertTrue(loggedPage.isLoginSuccessfulMessageDisplayed(),
                "Successful login message not displayed");
    }

    @Then("Displayed login matches entered login")
    public void displayedLoginMatchesEntered() {
        String userLogin = scenarioContext.get(ContextKey.USERNAME);
        Assertions.assertTrue(loggedPage.welcomeTextContainsProperUsername(userLogin.trim()),
                "Displayed username is different that entered one");
    }

    @When("Click Logout button")
    public void clickLogoutButton() {
        loggedPage.clickLogoutButton();
    }
}
