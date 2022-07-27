Feature: Verify a user should be able make posts
  Background: Endpoint Configuration is done
    Given I have a service to make a post

  @positive
  Scenario: When Admin user want to check all the posts then all posts should be returned
    When the admin user check for all the existing posts
    Then returned status code is 200
    Then more then one user's posts should be in response data

  @positive
  Scenario: Check the existing posts with userId and verify response code
    When the user check the posts with userId "1"
    Then returned status code is 200
    Then the response "json" schema should match with specification
    Then all the posts made by the user with userId "1" should be returned

  @positive
  Scenario Outline: User should be able to make posts
    When the user create a post with userId <userId>, title "<title>" and body "<body>"
    Then returned status code is 201
    Then The response should have userId <userId>, title "<title>" and body "<body>"
      Examples:
        | userId | title                    | body                     |
        | 10     | This is a test post body | This is a test post body |