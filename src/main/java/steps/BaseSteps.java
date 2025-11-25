package steps;

import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import pages.BasePage;

@Log4j2
public class BaseSteps {
    private final BasePage basePage = new BasePage();

    @Given("Open page {string}")
    public void openPage(String url) {
        log.info("Opening url: " + url);
        basePage.openGivenUrl(url);
    }
}
