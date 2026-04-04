package utils;

import core.driver.DriverFactory;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import io.qameta.allure.Allure;


public class ScreenshotUtils {
//    public static byte[] take(){
//        return ((TakesScreenshot)DriverFactory.getDriver())
//                .getScreenshotAs(OutputType.BYTES);
//    }

    public static void takeScreenshot(Scenario scenario) {
       if (scenario.isFailed()){
           byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                   .getScreenshotAs(OutputType.BYTES);

           Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
       }
    }
}
