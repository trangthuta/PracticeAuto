package ui.stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import core.driver.DriverFactory;
import utils.HandleOutlineData;
import org.apache.logging.log4j.Logger;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    HomePage homePage;
    private static final Logger log = LogManager.getLogger(LoginSteps.class);

    @Given("mở trang login")
    public void open() {
    }

    @When("người dùng thực hiện đăng nhập với username {string} và password {string}")
    public void login(String username, String password) {
        username = HandleOutlineData.normalizeInput(username);
        password = HandleOutlineData.normalizeInput(password);
        homePage = loginPage.login(username, password);
    }

    @Then("hệ thống hiển thị kết quả {string}")
    public void resultLogin(String msgError) {
        switch (msgError.toLowerCase()) {
            case "thành công":
                Assert.assertTrue(homePage.isHomePageDisplayed());
                break;
            case "thất bại":
                Assert.assertFalse(homePage.isHomePageDisplayed());
                break;
            default:
                Assert.fail("Không có case nào khớp với kết quả : " + msgError);
                break;
        }
    }
}
