@login
Feature: Login

  Scenario Outline: Successful login using valid username and password
    When I login with "<username>" and "<password>"
    Then I should see status code as 200
    And I should get valid response with Authorization and success message as "<message>"
    Examples:
      | username | password | message                 |
      | jsmith   | demo1234 | jsmith is now logged in |

  Scenario Outline: Un successful login using invalid username and password
    When I login with "<username>" and "<password>"
    Then I should see status code as 400
    And I should get error response with message as "<message>"
    Examples:
      | username | password | message                                                                 |
      | jsmith1  | demo1234 | We're sorry, but this username or password was not found in our system. |