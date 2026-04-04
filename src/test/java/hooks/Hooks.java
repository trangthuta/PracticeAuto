package hooks;

import core.driver.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ScreenshotUtils;
import io.qameta.allure.Allure;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        ScreenshotUtils.takeScreenshot(scenario);
        DriverFactory.quit();
    }
}
