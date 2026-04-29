package core.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;


import java.time.Duration;


public class BasePage {
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;

    public BasePage(WebDriver driver) {
        int timeout =Integer.parseInt(ConfigReader.get("timeout"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void enter() {
        actions.sendKeys(Keys.ENTER).perform();
    }

    public boolean isDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }


}
