package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import core.driver.DriverFactory;


import static core.base.BasePage.removeQuote;
import static core.driver.DriverFactory.getDriver;

public class LoginSteps {

    LoginPage page = new LoginPage(DriverFactory.getDriver());


    @Given("mở trang login")
    public void open() {
        getDriver().get("https://learn-writing-english.vercel.app/");

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

    @Then("hệ thống tự động navigate đến Trang chính khi đăng nhập thành công")
    public void navigateToMainPage() {
        page.success();

    }


    @When("nhập email {string} và password {string}")
    public void nhậpEmailVàPassword(String username, String password) {
        System.out.println(username.length());
        page.enterDataLogin(username, password);

    }


    @Then("hiển thị thông báo {string}")
    public void validateMsg(String message) {
        page.displayFailMsg();
    }
}
