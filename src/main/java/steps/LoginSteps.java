package steps;

import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.context.ContextKey;
import utils.context.ScenarioContext;

public class LoginSteps {
    private final ScenarioContext scenarioContext;
    private final LoginPage loginPage = new LoginPage();

    public LoginSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @When("Enter login {string} and password {string}")
    public void enterLoginAndPassword(String username, String password) {
        loginPage.waitForPageLoaded();
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.clickSubmitButton();

        scenarioContext.set(ContextKey.USERNAME, username);
    }
}
