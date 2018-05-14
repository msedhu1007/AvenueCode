Feature: Create Task

 @mytask
  Scenario: Verify the message displayed on My Task page
    Given User logged in to the ToDo application with "msedhu@gmail.com" and "avenuecode"
    When User navigates to MyTasks page
    Then message "Hey Sedhu, this is your todo list for today:" should be displayed

  @mytask
  Scenario Outline: Verify creation of Task
    Given User logged in to the ToDo application with "msedhu@gmail.com" and "avenuecode"
    When User navigates to MyTasks page
    And User creates a task "<Task Name>"
    Then "<Task Name>" Task should not get created

    Examples: 
      | Task Name                                                                                                                                                                                                                                                   |
      | T1                                                                                                                                                                                                                                                          |
      | T                                                                                                                                                                                                                                                           |
      | 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890a |
