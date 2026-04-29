Feature: Login

  @regression
  Scenario Outline: Kiểm tra chức năng login

    Given mở trang login
    When người dùng thực hiện đăng nhập với username "<username>" và password "<password>"
    Then hệ thống hiển thị kết quả "<expect>"

    Examples:
      | username      | password     | expect     |
      | standard_user | secret_sauce | thành công |

