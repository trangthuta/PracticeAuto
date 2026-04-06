package core.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
//        driver.set(new ChromeDriver());
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver.set(new ChromeDriver());
//        } else {
//            driver.set(new EdgeDriver());
//        }

//        ------
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");

        driver.set(new ChromeDriver(chromeOptions));
//        -------------------------------------------------

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit() {
        driver.get().quit();
        driver.remove();
    }
}
