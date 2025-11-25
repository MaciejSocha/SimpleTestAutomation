package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractDriver;

import java.time.Duration;

public class BasePage extends AbstractDriver {
    private final long WAIT_TIMEOUT = 15;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void openGivenUrl(String url) {
        getDriver().manage().window().maximize();
        getDriver().get(url);
        waitForPageLoaded();
    }

    public void waitForPageLoaded() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIMEOUT)).until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;

            // 1. Document Ready
            String ready = (String) js.executeScript("return document.readyState");
            if (!"complete".equals(ready)) return false;

            // 2. jQuery
            Boolean jqueryDone = (Boolean) js.executeScript(
                    "return window.jQuery ? jQuery.active == 0 : true");
            if (!jqueryDone) return false;

            // 3. XHR/Fetch
            Long xhr = (Long) js.executeScript("return window.activeRequests || 0");
            return xhr == 0;
        });
    }
}
