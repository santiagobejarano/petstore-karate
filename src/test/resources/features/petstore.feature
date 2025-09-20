Feature: Pet Store API Tests

  Background:
    * url 'https://petstore.swagger.io/v2'

  Scenario: Get pet by valid ID
    Given path 'pet', 10
    When method get
    Then status 200

  Scenario: Create a new pet
    Given path 'pet'
    And request
    """
    {
      "id": 12345,
      "category": {
        "id": 1,
        "name": "Dogs"
      },
      "name": "TestDog",
      "photoUrls": ["string"],
      "tags": [
        {
          "id": 1,
          "name": "friendly"
        }
      ],
      "status": "available"
    }
    """
    When method post
    Then status 200
    And match response.name == 'TestDog'
    And match response.id == 12345

  Scenario: Update pet information
    Given path 'pet'
    And request
    """
    {
      "id": 12345,
      "category": {
        "id": 1,
        "name": "Dogs"
      },
      "name": "UpdatedTestDog",
      "photoUrls": ["string"],
      "tags": [
        {
          "id": 1,
          "name": "friendly"
        }
      ],
      "status": "sold"
    }
    """
    When method put
    Then status 200
    And match response.name == 'UpdatedTestDog'
    And match response.status == 'sold'

  Scenario: Delete pet
    Given path 'pet', 12345
    When method delete
    Then status 200
