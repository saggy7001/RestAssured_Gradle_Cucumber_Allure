@math
Feature: Add Numbers

  Scenario Outline: Add numbers
    When I add <num1> and <num2>
    Then The result should be <result>
    Examples:
      | num1 | num2 | result |
      | 1    | 1    | 2      |
      | 1    | 1    | 3      |