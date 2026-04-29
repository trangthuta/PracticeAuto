package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();


    public static void setBrowserName(String browser) {
        browserName.set(browser);
    }

    public static String getBrowserName() {
        return browserName.get();
    }


    public static void initDriver() {
        String browser = browserName.get(); //xml
        if (System.getProperty("browser") != null){
            browser = System.getProperty("browser") ;
        }
        System.out.println("Thread: " + Thread.currentThread().getId()
                + " | Browser: " + browser);
        switch (browser == null ? "" : browser.toLowerCase()) {

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                driver.set(new ChromeDriver());
        }

    }


    public static WebDriver getDriver() {
        return driver.get();
    }


    public static void quit() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}