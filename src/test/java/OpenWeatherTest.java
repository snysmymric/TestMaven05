import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;

public class OpenWeatherTest extends BaseTest {

    @Test
    public void testGuidelink () {
        String expectedResultLink = "https://openweathermap.org/guide";
        String expectedResultTitle = "OpenWeatherMap API guide - " +
                "OpenWeatherMap";

        WebElement guideLink = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                        "#first-level-nav a[href='/guide']")));
        guideLink.click();

        Assert.assertEquals(getDriver().getCurrentUrl(),expectedResultLink);
        Assert.assertEquals(getDriver().getTitle(),expectedResultTitle);
    }

    @Test
    public void testSwitchToFTemperature() {
        String expectedResult = "°F";

        getDriver().findElement(By.cssSelector("div.switch-container>div:last" +
                "-of-type")).click();
        String currentTem = getDriver().findElement(By.cssSelector("span.heading")).getText();
        String feelsLikeTemp = getDriver().findElement(By.cssSelector("div + " +
                        "div.bold")).getText();
        String dewPoint = getDriver().findElement(By.cssSelector("ul[class" +
                        "^=\"weather-items\"]>li:nth-of-type(4)")).getText();

        Assert.assertTrue(currentTem.contains(expectedResult));
        Assert.assertTrue(feelsLikeTemp.contains(expectedResult));
        Assert.assertTrue(dewPoint.contains(expectedResult));
    }

    @Test
    public void testSwitchToCTemperature() {
        String expectedResult = "°C";

        getDriver().findElement(By.cssSelector("div.switch-container>div" +
                ":nth-of-type(2)")).click();
        String currentTem = getDriver().findElement(By.cssSelector("span.heading")).getText();
        String feelsLikeTemp = getDriver().findElement(By.cssSelector("div + " +
                "div.bold")).getText();
        String dewPoint = getDriver().findElement(By.cssSelector("ul[class" +
                "^=\"weather-items\"]>li:nth-of-type(4)")).getText();

        Assert.assertTrue(currentTem.contains(expectedResult));
        Assert.assertTrue(feelsLikeTemp.contains(expectedResult));
        Assert.assertTrue(dewPoint.contains(expectedResult));
    }
}
