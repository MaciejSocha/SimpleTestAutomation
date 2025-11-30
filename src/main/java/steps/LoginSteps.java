package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utils.context.ContextKey;
import utils.context.ScenarioContext;

public class LoginSteps {
    private final ScenarioContext scenarioContext;
    private final LoginPage loginPage = new LoginPage();

    public LoginSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @When("Enter login {string} and password {string} and click login button")
    public void enterLoginAndPassword(String username, String password) {
        loginPage.waitForPageLoaded();
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.clickSubmitButton();

        scenarioContext.set(ContextKey.USERNAME, username);
    }

    @Then("Login page is displayed")
    public void loginPageIsDisplayed() {
        Assertions.assertTrue(loginPage.loginPageIsDisplayed(), "Login page is not displayed properly");
    }

    @Then("Verify that error message is {string}")
    public void verifyErrorMessageDisplayedAsGivenText(String errorText) {
        Assertions.assertTrue(loginPage.verifyErrorMessage(errorText));
    }
}
