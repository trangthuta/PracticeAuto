package hooks;

import core.driver.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import utils.ScreenshotUtils;
import io.qameta.allure.Allure;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        ScreenshotUtils.takeScreenshot(scenario);
        DriverFactory.quit();
    }
}
