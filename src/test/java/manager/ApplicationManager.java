package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.ConfigProperties;


import java.io.File;
import java.time.Duration;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //    EventFiringWebDriver driver; // 1. change for get listener
    WebDriver driver;
    UserHelper userHelper;
    CarHelper carHelper;
    static String browser;


    public ApplicationManager() {
        browser = System.getProperty("browser", Browser.CHROME.browserName());
        //browser = System.getProperty("browser", BrowserType.CHROME);
        logger.info(browser);

    }
    public void init() {

        logger.warn(browser);
        logger.warn(Browser.CHROME.browserName());
        logger.warn(Browser.FIREFOX.browserName());

        if (browser.equals(Browser.CHROME.browserName())) {
            ChromeOptions options = new ChromeOptions();//new options
            //options.addArguments("--headless=new");//new object of chromeDriver
            WebDriver original = new ChromeDriver(options);//made decoration up on the driver
            WebDriverListener listener = new WDListener();
            driver = new EventFiringDecorator(listener).decorate(original);//driver from chrome
            logger.warn(browser);
        } else if (browser.equals(Browser.FIREFOX.browserName())) {

            FirefoxOptions options = new FirefoxOptions();
            FirefoxBinary binary = new FirefoxBinary(new File("/opt/firefox/firefox"));
            FirefoxProfile profile = new FirefoxProfile();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
            logger.warn(browser);
        }


//        driver = new EventFiringWebDriver(new ChromeDriver()); // 2. change for get listener
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        driver = new EventFiringWebDriver(new ChromeDriver(options)); // 2. change for get listener

        driver.navigate().to(ConfigProperties.getProperty("url"));// no use hard code, use value from config file
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigProperties
                .getProperty("implicitlyWait"))));
//        driver.register(new WDListener()); // 3.  change for get listener

        userHelper = new UserHelper(driver);
        carHelper = new CarHelper(driver);
        logger.info("navigated according url value in config file");
    }

    public UserHelper getUserHelper() {

        return userHelper;
    }
    public CarHelper getCarHelper(){
        return carHelper;
    }

    public void tearDown() {
        driver.quit();
    }

    public void navigateToMainPage() {
        driver.navigate().to(ConfigProperties.getProperty("url"));
    }

    public boolean isPageUrlHome(){
        String urlCurrent = driver.getCurrentUrl();
        System.out.println(urlCurrent + "--------- url");
        return urlCurrent.equals(ConfigProperties.getProperty("url"));
    }


    public void isAppLaunch(String url) {
    }
}