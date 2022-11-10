package runner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = BaseUtils.createDriver();
        driver.get("https://openweathermap.org/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
