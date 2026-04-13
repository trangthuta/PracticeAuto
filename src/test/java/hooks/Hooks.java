package hooks;

import core.driver.DriverFactory;
import io.cucumber.java.*;
import utils.ScreenshotUtils;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver()
                .get("https://rawal-admin.themes-coder.net/admin/login");
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
