package runners;

import core.driver.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ui.stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        }
)
public class TestUiRunner extends AbstractTestNGCucumberTests {
    public static String browser;

    @Parameters("browser")
    @BeforeClass
    public void setupBrowser(@Optional("chrome")String browserName) {
        browser = browserName;
        DriverFactory.setBrowserName(browser);
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}




