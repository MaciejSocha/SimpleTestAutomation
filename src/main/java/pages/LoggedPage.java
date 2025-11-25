package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedPage extends BasePage {
    private final String LOGGED_MESSAGE_SUCCESS = "Logged In Successfully";

    @FindBy(xpath = "//h1[@class='post-title']")
    private WebElement loggedInMessageText;
    @FindBy(xpath = "//p[@class='has-text-align-center']/strong")
    private WebElement welcomeText;

    public boolean isLoginSuccessfulMessageDisplayed() {
        waitForPageLoaded();
        return loggedInMessageText.isDisplayed() && loggedInMessageText.getText().equals(LOGGED_MESSAGE_SUCCESS);
    }

    public boolean welcomeTextContainsProperUsername(String username) {
        return welcomeText.getText().contains(username);
    }
}
