package ui.pages;

import core.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.driver.DriverFactory.getDriver;


public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement passw;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "error-button")
    private WebElement messError;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String user, String pass) {
        sendKeys(username, user);
        sendKeys(passw, pass);
        click(loginButton);
        return new HomePage(getDriver());
    }
}
