package core.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;


public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        System.out.println(browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");

            driver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        }

//        ------
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--guest");
//
//        driver.set(new ChromeDriver(chromeOptions));
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
