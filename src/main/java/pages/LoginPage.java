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


//    @FindBy(id = "standard-basic")
    @FindBy(id = "_r_0_")
    private WebElement email;

//    @FindBy(id = "standard-password-input")
    @FindBy(id = "_r_1_")
    private WebElement passw;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    private WebElement button;

    @FindBy(xpath = "(//p[@class='errorMessage'])[1]")
    private WebElement validEmail;

    @FindBy(xpath = "(//p[@class='errorMessage'])[2]")
    private WebElement validPass;

    @FindBy(className = "form")
    private WebElement mainPage;

    @FindBy(xpath = "//div[@role='alert'] ")
    private WebElement messLoginFailed;

    @FindBy(xpath = "(//p[@class='errorMessage'])[1]")
    private WebElement errorValidateUsername;

    @FindBy(xpath = "(//p[@class='errorMessage'])[2]")
    private WebElement errorValidatePassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterDataLogin(String user, String pass) {
        System.out.println(user + "   " + pass);
        System.out.println(user.length() + "   " + pass.length());
        sendKeys(email, user);
        sendKeys(passw, pass);

    }

    public void clickToLogin() {
        click(button);

    }

    public void enterToLogin() {
        enter();
    }

    public void success() {
        verifyDisplayElementHasText(mainPage);
    }

    public void displayFailMsg() {
        getWait().until(ExpectedConditions.visibilityOf(errorValidateUsername));
        getWait().until(ExpectedConditions.visibilityOf(errorValidatePassword));
        Boolean isError;
        if (errorValidateUsername.getText().trim().isEmpty() && errorValidatePassword.getText().trim().isEmpty()) {
            isError = false;
        } else {
            isError = true;
            System.out.println(errorValidatePassword.getText() + " | " + errorValidateUsername.getText());        }
        Assert.assertTrue(isError);
    }


}
