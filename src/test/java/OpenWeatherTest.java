import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import java.time.Duration;

public class OpenWeatherTest extends BaseTest {

    @Test
    public void testGuideLink () {
        final String EXPECTED_RESULT_LINK = "https://openweathermap.org/guide";
        final String EXPECTED_RESULT_TITLE = "OpenWeatherMap API guide - " +
                "OpenWeatherMap";

        WebElement guideLink = new WebDriverWait(getDriver(),Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                        "#first-level-nav a[href='/guide']")));
        guideLink.click();

        Assert.assertEquals(getDriver().getCurrentUrl(),EXPECTED_RESULT_LINK);
        Assert.assertEquals(getDriver().findElement(By.className("body-orange")).getAttribute("baseURI")
                ,EXPECTED_RESULT_LINK);
        Assert.assertEquals(getDriver().getTitle(),EXPECTED_RESULT_TITLE);
    }

    @Test
    public void testSwitchToFTemperature() {
        final String EXPECTED_RESULT = "°F";

        getDriver().findElement(By.cssSelector("div.switch-container>div:last" +
                "-of-type")).click();
        String currentTem = getDriver().findElement(By.cssSelector("span.heading")).getText();
        String feelsLikeTemp = getDriver().findElement(By.cssSelector("div + " +
                        "div.bold")).getText();
        String dewPoint = getDriver().findElement(By.cssSelector("ul[class" +
                        "^=\"weather-items\"]>li:nth-of-type(4)")).getText();

        Assert.assertTrue(currentTem.contains(EXPECTED_RESULT));
        Assert.assertTrue(feelsLikeTemp.contains(EXPECTED_RESULT));
        Assert.assertTrue(dewPoint.contains(EXPECTED_RESULT));
    }

    @Test
    public void testSwitchToCTemperature() {
        final String EXPECTED_RESULT = "°C";

        getDriver().findElement(By.cssSelector("div.switch-container>div" +
                ":nth-of-type(2)")).click();
        String currentTem = getDriver().findElement(By.cssSelector("span.heading")).getText();
        String feelsLikeTemp = getDriver().findElement(By.cssSelector("div + " +
                "div.bold")).getText();
        String dewPoint = getDriver().findElement(By.cssSelector("ul[class" +
                "^=\"weather-items\"]>li:nth-of-type(4)")).getText();

        Assert.assertTrue(currentTem.contains(EXPECTED_RESULT));
        Assert.assertTrue(feelsLikeTemp.contains(EXPECTED_RESULT));
        Assert.assertTrue(dewPoint.contains(EXPECTED_RESULT));
    }
}
