@regressions
Feature: API Testing | Rijksmuseum API

  @test-01
  Scenario: Retrieve all collections
    * GET all collections
    * the api response  status code should be 200
    * response body for collections is correct

  @test-06
  Scenario: Retrieve collections with invalid API key
    * GET all collections with invalid API key
    * the api response  status code should be 401
    * the response should contain an error message Invalid key

  @test-02
  Scenario: Retrieve collection details
    * GET all collections
    * retrieve one collection from the list
    * GET the collection details from the collection
    * the api response  status code should be 200
    * response body for collection details is correct

  @test-03
  Scenario: Try to retrieve collection details for an invalid object number
    * set an invalid object number
    * GET the collection details from the collection
    * the api response  status code should be 403

  @test-04
  Scenario: Retrieve collection image
    * GET all collections
    * retrieve one collection from the list
    * GET the collection image from the collection retrieved
    * the api response  status code should be 200
    * response body for collection image is correct

  @test-05
  Scenario:Try to retrieve collection image for an invalid object number
    * set an invalid object number
    * GET the collection image from the collection retrieved
    * the api response  status code should be 403
