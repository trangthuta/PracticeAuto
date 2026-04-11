package hooks;

import core.driver.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import utils.ScreenshotUtils;
import io.qameta.allure.Allure;

import static core.driver.DriverFactory.getDriver;

public class Hooks {
    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.setBrowser(browser);
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
