package runners;

import core.driver.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
//        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestUiRunner extends AbstractTestNGCucumberTests {
//    @Parameters("browser")
//    @BeforeClass
//    public void setUp(String browser) {
//    }
}




