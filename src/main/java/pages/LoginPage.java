package pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;


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
        verifyDisplayElementHasText(menuMainPage);
    }

    public void fail() {
        verifyDisplayElementHasText(messError);
    }

//    public void displayFailMsg() {
//        getWait().until(ExpectedConditions.visibilityOf(errorValidateUsername));
//        getWait().until(ExpectedConditions.visibilityOf(errorValidatePassword));
//        Boolean isError;
//        if (errorValidateUsername.getText().trim().isEmpty() && errorValidatePassword.getText().trim().isEmpty()) {
//            isError = false;
//        } else {
//            isError = true;
//            System.out.println(errorValidatePassword.getText() + " | " + errorValidateUsername.getText());
//        }
//        Assert.assertTrue(isError);
//    }


}
