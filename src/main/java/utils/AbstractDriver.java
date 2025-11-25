package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Log4j2
public abstract class AbstractDriver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            log.warn("Created default WD! Probably you don't want it");
        }
        return driver;
    }

    static void createChrome(){
        driver = new ChromeDriver();
        log.info("Created chromedriver");
    }

    static void createFirefox(){
        driver = new FirefoxDriver();
        log.info("Created firefox driver");
    }

    static void destroy() {
        if (driver != null) {
            log.info("Quitting driver");
            driver.quit();
        } else {
            log.warn("driver not initialized, nothing to quit");
        }
    }
}
