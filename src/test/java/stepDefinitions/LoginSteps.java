package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import core.driver.DriverFactory;
import utils.HandleOutlineData;

public class LoginSteps {

    LoginPage page = new LoginPage(DriverFactory.getDriver());


    @Given("mở trang login")
    public void open() {
    }

    //        @When("nhập email {string} và password {string}")
//    @When("^nhập email \"?(.*?)\"? và password \"?(.*?)\"?$")
//    public void enterData(String username, String password) throws InterruptedException {
//        System.out.println("--------------------------------ok");
//        System.out.println("u dài " + username.length() + "-------------, P dài : " + password.length());
//        page.enterDataLogin(username, password);
//        Thread.sleep(30000);
//    }


    @And("thực hiện đăng nhập bằng {string}")
    public void loginWithAction(String action) {
        if (action.equals("enter")) {
            page.enterToLogin();
        } else {
            page.clickToLogin();
        }
    }

//    @Then("hệ thống tự động navigate đến Trang chính khi đăng nhập thành công")
//    public void navigateToMainPage() {
//        page.success();
//
//    }


    @When("^nhập email (.+) và password (.+)$")
    public void nhậpEmailVàPassword(String username, String password) {
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


//    @Then("hiển thị thông báo {string}")
//    public void validateMsg(String message) {
//        page.displayFailMsg();
//    }
}
