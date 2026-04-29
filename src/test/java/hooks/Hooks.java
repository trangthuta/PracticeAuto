package hooks;

import core.driver.DriverFactory;
import io.cucumber.java.*;
import utils.ConfigReader;
import utils.ScreenshotUtils;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver()
                .get(ConfigReader.get("baseUrl"));
        DriverFactory.getDriver()
                .manage()
                .window()
                .maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        ScreenshotUtils.takeScreenshot(scenario);
        DriverFactory.quit();
    }
}