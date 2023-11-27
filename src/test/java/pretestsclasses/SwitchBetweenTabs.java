package pretestsclasses;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SwitchBetweenTabs {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    @BeforeClass
    public void preconditions() {
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void switchToNewTab(){
        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.clear();
        city.sendKeys("Jerusalem");
        city.sendKeys(Keys.TAB);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://ilcarro.web.app/let-car-work");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String windowHandleCarWork = driver.getWindowHandle();


    }
}
/*
public static void main(String[] args) throws InterruptedException {

        Architecture x = Architecture.getCurrent();
        System.out.println(x);

        ChromeDriverInfo chInfo = new ChromeDriverInfo();
        System.out.println(chInfo.getDisplayName());
        System.out.println(chInfo.getCanonicalCapabilities());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sel(driver, wait);





    private static void email_byClass(WebDriver driver, WebDriverWait wait){
//        <input type="email" placeholder="name@email.com" name="email" class="Input_input___ME0t">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        WebElement email_field = driver.findElement(By.className( "Input_input___ME0t"));
        email_field.clear();
        email_field.sendKeys("pexels@sher.biz");




            WebElement password_field = driver.findElement(By.name("password"));
            password_field.clear();
            password_field.sendKeys("123456");


        WebElement sign_in = driver.findElement(By.cssSelector("span.Button_text__mn5Ou"));
        sign_in.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

    }

    private static void login(WebDriver driver, WebDriverWait wait){
        driver.navigate().to("https://www.pexels.com/login");
        wait.until(ExpectedConditions.titleIs("Login to Pexels"));
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        String windowHandleLogin = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        System.out.println(windowHandleLogin);
        String windowTitleLogin = driver.getTitle();
        System.out.println(windowTitleLogin);
    }

    private static String getPage(WebDriver driver, WebDriverWait wait){
        String pageSource = driver.getPageSource();
        return pageSource;
    }
}

 */
