Feature: Executing Login Related Test Cases

  @Login_Scenarios #Reference for the test cases
  Scenario Outline: Login into the Application With Different Credentials
    Given Open the Application
    And Enter the UserName "<UserName>"
    And Enter the Password "<Password>"
    Then Click on Login Button

    Examples:
      | UserName | Password    |
      | admin    | admin123    |
      | student  | student123  |
      | student  | Password123 |

