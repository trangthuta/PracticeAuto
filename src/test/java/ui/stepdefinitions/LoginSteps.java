package ui.stepdefinitions;

import io.cucumber.java.en.*;
import ui.pages.LoginPage;
import core.driver.DriverFactory;
import utils.HandleOutlineData;

public class LoginSteps {

    LoginPage page = new LoginPage(DriverFactory.getDriver());

    @Given("mở trang login")
    public void open() {
    }

    @And("thực hiện đăng nhập bằng {string}")
    public void loginWithAction(String action) {
        if (action.equals("enter")) {
            page.enterToLogin();
        } else {
            page.clickToLogin();
        }
    }

    @When("^nhập email (.+) và password (.+)$")
    public void inputData(String username, String password) {
        username = HandleOutlineData.normalizeInput(username);
        password = HandleOutlineData.normalizeInput(password);
        page.enterDataLogin(username, password);
    }

    @Then("login {string}")
    public void login(String state) {
        if (state.equals("thành công")) {
            page.success();
        } else {
            page.fail();
        }
    }
}
