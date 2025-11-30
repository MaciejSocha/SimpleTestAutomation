package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "login")
    private WebElement loginModal;
    @FindBy(id = "error")
    private WebElement errorMessageText;

    public void setUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean loginPageIsDisplayed() {
        waitForPageLoaded();
        return loginModal.isDisplayed() && usernameField.isDisplayed()
                && passwordField.isDisplayed() && submitButton.isDisplayed();
    }

    public boolean verifyErrorMessage(String messageText) {
        waitForElementIsDisplayed(errorMessageText);
        return errorMessageText.getText().equals(messageText);
    }
}
