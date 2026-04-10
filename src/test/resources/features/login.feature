Feature: Login

  Scenario Outline: Kiểm tra chức năng login

    Given mở trang login
    When nhập email "<username>" và password "<password>"
    And thực hiện đăng nhập bằng "<action>"
    Then login "<expect>"

    Examples:
      | username                 | password          | action | expect   |
#      | admin@email.com                             | 123               | click  | thành công |
#      | owner@email.com                             | 123               | enter  | thành công |
#      | "         owner@email.com                 " | "  123"           | enter  | thành công |
#      |                                             |                   | click  | thất bại   |
#      |                                             |                   | enter  | thất bại   |
#      | "                      "                    | "               " | click  | thất bại   |
      | "                      " | "               " | enter  | thất bại |






#  Background:
#    Given mở trang login
#
#  Scenario Outline:Login thất bại do validation input
#    When nhập email "<username>" và password "<password>"
#    And thực hiện đăng nhập bằng "<action>"
#    Then hiển thị thông báo "<message>"
#    Examples:
#      | username             | password   | action | message                          |
#
#      # ===== EMPTY =====
#      |                      |            | enter  | Không được để trống!             |
#      |                      |            | click  | Không được để trống!             |
#      | test@gmail.com       |            | enter  | Không được để trống!             |
#      | test@gmail.com       |            | click  | Không được để trống!             |
#      |                      | 12345678   | enter  | Không được để trống!             |
#      |                      | 12345678   | click  | Không được để trống!             |
#
#      # ===== EMAIL FORMAT INVALID =====
#      | test@@gmail.com      | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | test..abc@gmail.com  | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | .test@gmail.com      | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | test.@gmail.com      | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | test gmail@gmail.com | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | test@gmail           | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | @gmail.com           | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | test!@gmail.com      | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | test#abc@gmail.com   | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | TEST@GMAIL.COM       | 12345678   | enter  | Định dạng email không hợp lệ!    |
#      | test@@gmail.com      | 123        | enter  | Định dạng email không hợp lệ!    |
#
#      | test@@gmail.com      | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | test..abc@gmail.com  | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | .test@gmail.com      | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | test.@gmail.com      | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | test gmail@gmail.com | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | test@gmail           | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | @gmail.com           | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | test!@gmail.com      | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | test#abc@gmail.com   | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | TEST@GMAIL.COM       | 12345678   | click  | Định dạng email không hợp lệ!    |
#      | test@@gmail.com      | 123        | click  | Định dạng email không hợp lệ!    |
#
#      # ===== PASSWORD BOUNDARY (<8) =====
#      | test@gmail.com       | 1234567    | enter  | Mật khẩu phải tối thiểu 8 ký tự! |
#      | test_user@gmail.com  | 123        | enter  | Mật khẩu phải tối thiểu 8 ký tự! |
#      | test-user@gmail.com  | 123        | enter  | Mật khẩu phải tối thiểu 8 ký tự! |
#
#      | test@gmail.com       | 123        | click  | Mật khẩu phải tối thiểu 8 ký tự! |
#      | test_user@gmail.com  | 123        | click  | Mật khẩu phải tối thiểu 8 ký tự! |
#      | test-user@gmail.com  | 123        | click  | Mật khẩu phải tối thiểu 8 ký tự! |

#  Scenario Outline: Login không thành công với tài khoản đúng format nhưng chưa đuợc đăng ký
#
#  Scenario Outline: Login với dữ liệu chứa khoảng trắng

#  Scenario Outline: Login thành công
#    When nhập email "<username>" và password "<password>"
#    And thực hiện đăng nhập bằng "<action>"
#    Then hệ thống tự động navigate đến Trang chính khi đăng nhập thành công
#
#    Examples:
#      | username          | password | action |
#      | testapp@gmail.com | 12345678 | enter  |
#      | testapp@gmail.com | 12345678 | click  |

#  mvn test -Dtest=TestRunner
#  mvn clean test
#  allure serve allure-results
