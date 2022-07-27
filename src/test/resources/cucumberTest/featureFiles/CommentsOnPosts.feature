Feature: Verify a user should be able see existing comments and make comments on a post
  Background: Endpoint Configuration is done
    Given I have a service to make a comment on a post

  @positive
  Scenario: Call /comments end point and check response code
    When I request list of existing comments
    Then The returned status code is 200

  @positive
  Scenario Outline: Verify the /comment api response
    When I filter the comments api response with postId "<postId>" and id "<id>"
    Then Comments api response for the respective postId "<postId>" and id "<id>" should be returned
    Then Comments api response "json" schema should match with specification format
    Then Comments api response should have name as "<name>"
    Then Comments api response should have email as "<email>"
    Then Comments api response should have body as "<body>"
    Examples:
      | postId | id | name                                                   | email                    | body                                                                                                                                                                        |
      | 1      | 1  | id labore ex et quam laborum                           | Eliseo@gardner.biz       | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium                     |
      | 2      | 6  | et fugit eligendi deleniti quidem qui sint nihil autem | Presley.Mueller@myrl.com | doloribus at sed quis culpa deserunt consectetur qui praesentium\naccusamus fugiat dicta\nvoluptatem rerum ut voluptate autem\nvoluptatem repellendus aspernatur dolorem in |

  @positive
  Scenario Outline: Make comments on post
    When I post a comment on postId <postId> and body "<body>"
    Then The returned status code is 201
    Then The response should include postId <postId> and body "<body>"
    Examples:
      | postId | body                        |
      | 1      | This is a test comment body |

  @negative
  Scenario Outline: To test deleting a existing comment of a post
    When Trying to delete the existing comment with postId "<postId>" and id "<id>"
    Then The returned status code is 404
    Examples:
      | postId | id |
      | 1      | 1  |

