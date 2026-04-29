Feature: Login

  @regression
  Scenario Outline: Kiểm tra chức năng login

    Given mở trang login
    When nhập email "<username>" và password "<password>"
    And người dùng thực hiện đăng nhập
    Then hệ thống hiển thị kết quả "<expect>"

    Examples:
      | username      | password     | expect     |
      | standard_user | secret_sauce | thành công |

