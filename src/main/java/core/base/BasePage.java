package core.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;


public class BasePage {
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;

    public BasePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
        element.sendKeys(text);
    }

    public void enter() {
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void verifyDisplayElementHasText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println(element.getText());
        Assert.assertTrue(element.isDisplayed(), "Element không hiển thị");

    }

    public static String removeQuote(String input) {
        if (input == null || input.length() < 2) return input;

        if (input.startsWith("\"") && input.endsWith("\"")) {
            return input.substring(1, input.length() - 1);
        }

        return input;
    }


}
