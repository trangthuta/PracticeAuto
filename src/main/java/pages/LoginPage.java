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


    @FindBy(id = "standard-basic")
    private WebElement email;

    @FindBy(id = "standard-password-input")
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

    @FindBy(className = "errorMessage")
    private List<WebElement> listValidateMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterDataLogin(String user, String pass) {
        System.out.println(user + "   " + pass);
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
        verifyDisplayElement(mainPage);
    }

    public void displayFailMsg() {
//        System.out.println(listValidateMsg.size() + "----------------");
//        if (listValidateMsg.isEmpty()) {
//            System.out.println("+++++++++++");
//            Assert.fail("Danh sách thông báo lỗi rỗng, không có element để verify!");
//        }

        for (WebElement e : listValidateMsg) {
            verifyDisplayElement(e);

        }
    }


}
