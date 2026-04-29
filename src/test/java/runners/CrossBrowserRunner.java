package runners;

import core.driver.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ui.stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        }
)
public class CrossBrowserRunner extends AbstractTestNGCucumberTests {
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(@Optional("chrome") String browserName) {
        DriverFactory.setBrowserName(browserName);
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}