package pretestsclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitUntilElementsAppearance {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    @BeforeClass
    public void preconditions() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("start site");
    }

    @AfterClass
    public void postCondition() {
       // driver.quit();
    }

    @Test
    public void waitUntilElAppearance() {

        wait.until(ExpectedConditions.titleIs("Search"));
        wait.until(ExpectedConditions.titleContains("Search")); // case sensitive
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='city']")));
    }
}
