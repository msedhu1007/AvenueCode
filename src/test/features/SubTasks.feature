Feature: Create Sub Task

  @subtask
  Scenario Outline: Verify that the Sub tasks can be added
    Given User logged in to the ToDo application with "msedhu@gmail.com" and "avenuecode"
    When User navigates to MyTasks page
    And User creates a task "<Task Name>"
    And User navigates to "<Task Name>" SubTasks page
    And User creates a SubTask "<Sub Task Name>" with "<Due Date>"
    Then SubTask "<Sub Task Name>" should be created

    Examples: 
      | Task Name | Sub Task Name | Due Date |
      | Task1     | Sub Task1     | 1/5/2018 |

  @subtask
  Scenario Outline: Verify that the Sub tasks can be added
    Given User logged in to the ToDo application with "msedhu@gmail.com" and "avenuecode"
    When User navigates to MyTasks page
    And User creates a task "<Task Name>"
    And User navigates to "<Task Name>" SubTasks page
    And User creates a SubTask "<Sub Task Name>" with "<Due Date>"
    Then SubTask "<Sub Task Name>" should not be created

    Examples: 
      | Task Name | Sub Task Name                                                                                                                                                                                                                                               | Due Date |
      | Task2     | 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890a | 6/4/2018 |
