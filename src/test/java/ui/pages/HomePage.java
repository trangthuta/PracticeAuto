package ui.pages;

import core.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(id = "root")
    private WebElement homePage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() {
        return isDisplayed(homePage);
    }
}
