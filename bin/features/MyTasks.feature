Feature: Create Task

  @low
  Scenario: Verify the message displayed on My Task page
    Given User logged in to the ToDo application with "username" and "password"
    When User navigates to MyTasks page
    Then message "Hey Sedhu, this is your todo list for today:" should be displayed
