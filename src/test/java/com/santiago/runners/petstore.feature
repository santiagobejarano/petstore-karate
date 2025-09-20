Feature: PetStore API Tests

  Background:
    * url 'https://petstore.swagger.io/v2'
    * def petId = 987654321
    * def petName = 'Firulais'

  Scenario: Add a new pet to the store
    Given path 'pet'
    And request read('classpath:data/new-pet.json')
    When method post
    Then status 200
    And match response.id == petId
    And match response.name == petName
    And match response.status == 'available'

  Scenario: Get the pet by ID
    Given path 'pet', petId
    When method get
    Then status 200
    And match response.id == petId
    And match response.name == petName

  Scenario: Update the pet name and status to sold
    * def updatedPet =
      """
      {
    "id": '#(petId)',
    "category": { "id": 1, "name": "Dogs" },
    "name": "FirulaisUpdated",
    "photoUrls": ["https://example.com/firulais.png"],
    "tags": [{ "id": 1, "name": "cute" }],
    "status": "sold"
    }
    """
    Given path 'pet'
    And request updatedPet
    When method put
    Then status 200
    And match response.name == 'FirulaisUpdated'
    And match response.status == 'sold'

  Scenario: Get pets by status
    Given path 'pet/findByStatus'
    And param status = 'sold'
    When method get
    Then status 200
    * def result = response
    * match result contains { id: '#(petId)', name: 'FirulaisUpdated', status: 'sold' }

