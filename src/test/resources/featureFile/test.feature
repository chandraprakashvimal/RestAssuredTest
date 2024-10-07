Feature: test api flow
  
  @test
  Scenario: call api and fetch data
    Given Set host of api
    When Call the api endpoint
    Then Validate the api response
    Then Fetch the state name