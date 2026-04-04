package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import core.driver.DriverFactory;


import static core.driver.DriverFactory.getDriver;

public class LoginSteps {

    LoginPage page = new LoginPage(DriverFactory.getDriver());

//    @Given("open login page")
//    public void open() {
//        getDriver().get("https://learn-writing-english.vercel.app/");
//    }

//    @When("login valid")
//    public void valid()  {
//        page.login("testapp@gmail.com", "12345678");
//    }
//
//    @When("login invalid")
//    public void invalid() {
//        page.login("testapp@@gmail.com", "12345679");
//
//    }
//
//    @Then("success")
//    public void success() {
//        page.success();
//    }
//
//    @Then("fail")
//    public void fail() {
//        page.fail();
//    }

    @Given("mở trang login")
    public void open() {
        getDriver().get("https://learn-writing-english.vercel.app/");

    }

    @When("nhập email {string} và password {string}")
    public void enterData(String username, String password) {
        page.enterDataLogin(username, password);


    }

    @And("thực hiện đăng nhập bằng {string}")
    public void loginWithAction(String action) {
        if (action.equals("enter")) {
            page.enterToLogin();
        } else {
            page.clickToLogin();
        }
    }

    @Then("hệ thống tự động navigate đến Trang chính khi đăng nhập thành công")
    public void navigateToMainPage() {
        page.success();

    }

    @Then("hệ thống tự động báo lỗi dưới textbox tương ứng khi sai format")
    public void validateMsg() {
        page.displayFailMsg();
    }
}
