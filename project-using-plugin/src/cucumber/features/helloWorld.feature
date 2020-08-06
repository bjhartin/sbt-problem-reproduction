# See https://cucumber.io/docs/gherkin/reference/ for syntax help
Feature: "The Service"

  Scenario: "Handles a request"
    Given The service is running
    When A request arrives
    Then A response is sent
