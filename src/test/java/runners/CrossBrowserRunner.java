package runners;

import core.driver.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ui.stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        }
)
public class CrossBrowserRunner extends AbstractTestNGCucumberTests {
    public static String browser;

    @Parameters("browser")
    @BeforeClass
    public void setupBrowser(@Optional("chrome")String browserName) {
        browser = browserName;
        DriverFactory.setBrowserName(browser);
    }


}