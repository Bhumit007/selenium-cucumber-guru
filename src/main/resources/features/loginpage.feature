Feature: Guru99 Demo Website Testing

  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
#    Given user is on manager home page
#    When user clicks on new customer
#    And verify all required fields and error messages
#    Then user adds customer details
#    And verify added customer details
#    When user clicks on edit customer
#    Then user is on edit customer page
#    And user enters customer id
#    Then user clicks on submit button
#    And user edits the customer details
#    When user clicks on delete customer
#    Then user is on delete customer page
#    And user enters customer id for deletion
#    Then user clicks on submit button for deletion
#    When user clicks on logout button
#    Then verify login page
    And close the browser

    Examples:
      | username   | password |
      | mngr574780 | esAzehy  |
