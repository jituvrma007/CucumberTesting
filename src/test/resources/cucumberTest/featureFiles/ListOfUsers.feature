Feature: Validate list of user and user details
  Background: Endpoint Configuration is done
    Given I have a service to request list of users

  @positive
  Scenario: Call /users end point and check response code
    When I request list of users
    Then The status code is 200

  @positive @negative
  Scenario Outline: Filter the response with valid and invalid UserId
    When I input a userId "<id>"
    Then I should have the response code <responseCode>
      Examples:
        | id     | responseCode |
        | 3      | 200          |
        | abc123 | 404          |

  @positive
  Scenario Outline: Verify the individual user details
    When I input a userId "<id>"
    Then The response of "json" schema should match with specification format
    Then The response should have username as "<username>"
    Then The response should have name as "<name>"
    Then The response has email as "<email>"
    Examples:
      | id | username | name          | email      |
      | 1  | Bret     | Leanne Graham | Sincere@april.biz |

  @positive
  Scenario Outline: Verify create user api functionality
    When creating new user with the provided name "<name>", username "<username>", phone "<phone>", email "<email>", website "<website>"
    Then I should have the response code 201
    Then The response should have provided name "<name>", username "<username>", phone "<phone>", email "<email>", website "<website>"
      Examples:
        | name         | username | phone           | email                         | website     |
        | White Walker | male     | 1-770-736-8031  | ironman_test@fakemail.com     | yahoo.com   |
        | Arya Stark   | female   | 91-9015-149-143 | captainarya_test@fakemail.com | google.com  |
        | Natasha      | female   | 91-888-2030-888 | spy_test@fakemail.com         | testing.com |