package ui.pages;

import core.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {


    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement passw;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(id = "tc_aside_menu")
    private WebElement menuMainPage;


    @FindBy(xpath = "//span[text()='invalid Credentials']")
    private WebElement messError;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterDataLogin(String user, String pass) {
        sendKeys(email, user);
        sendKeys(passw, pass);

    }

    public void clickToLogin() {
        click(loginButton);

    }

    public void enterToLogin() {
        enter();
    }

    public void success() {
        verifyDisplayed(menuMainPage);
    }

    public void fail() {
        verifyDisplayed(messError);
    }




}
