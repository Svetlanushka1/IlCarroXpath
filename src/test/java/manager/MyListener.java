package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DatesUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MyListener implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);
    public MyListener(){

        super();
    }
/*
    @Override
    public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.beforeImplicitlyWait(timeouts, duration);
    }

    @Override
    public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
        WebDriverListener.super.afterImplicitlyWait(timeouts, duration);
        logger.info("afterImplicitlyWait" + timeouts + "   " + duration);
    }

    private void takeScreenshot(TakesScreenshot takeScreenshot, String name) {
        try {
            File tmp = takeScreenshot.getScreenshotAs(OutputType.FILE);
            File screenshot = new File(name);
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
    }

    @Override
    public void beforeDeleteAllCookies(WebDriver.Options options) {
        WebDriverListener.super.beforeDeleteAllCookies(options);
    }

    @Override
    public void afterDeleteAllCookies(WebDriver.Options options) {
        WebDriverListener.super.afterDeleteAllCookies(options);
    }





*/
     /*  public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("we got an exception: " + throwable.toString());
        logger.error("with the message: " + throwable.getMessage());
        String name = "src/test/screenshots/screenshot-" + DatesUtils.getDateString() + ".png";
        takeScreenshot((TakesScreenshot)driver, name);
        logger.info("see screenshot: " + name);
    }*/
}
