Feature: Validation placse Api's

  @AddPlace 
  Scenario Outline: Add a place
    Given Add place Payload with "<name>" "<address>"
    When User calls "addPlaceApi" with "post" http request
    Then The api call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify that "<name>" place has been created by "getPlaceApi"

    Examples: 
      | name        | address            |
      | lone1 house | world cross center |

  #  	| lones house     | Sea cross center|
  @delPlace @regression
  Scenario: Delete a place
    Given Delete place payload
    When User calls "delPlaceApi" with "post" http request
    Then The api call got success with status code 200
    And "status" in response body is "OK"
