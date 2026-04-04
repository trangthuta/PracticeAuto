Feature: Login

  Background:
    Given mở trang login

  Scenario Outline: Login không thành công với tkhoan sai format
    When nhập email "<username>" và password "<password>"
    And thực hiện đăng nhập bằng "<action>"
    Then hệ thống tự động báo lỗi dưới textbox tương ứng khi sai format

    Examples:
      | username            | password  | action |
      | testapp@@@gmail.com | 12345678  | enter  |
      | testapp@gmail.com   | 1234      | click  |
      | testapp@gmail.com   | 123456789 | click  |
      | testapp@gmail.com   | 12345678  | click  |

  #  Scenario Outline: Login thành công
#    Given mở trang login
#    When nhập email "<username>" và password "<password>"
#    And thực hiện đăng nhập bằng "<action>"
#    Then hệ thống tự động navigate đến Trang chính khi đăng nhập thành công
#
#    Examples:
#      | username          | password  | action |
#      | testapp@gmail.com | 12345678  | enter  |
#      | testapp@gmail.com | 12345678  | click  |

#  mvn test -Dtest=TestRunner
#  mvn clean test
#  allure serve allure-results
