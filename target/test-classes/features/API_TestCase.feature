#Author: Vikas Sangwan


Feature: Test Alpha Sense API end points

	Background:
  	Given I set the base URI
    
  @API @AlphaSense @TC_001
  Scenario: User is able to search document using additional keyword
    When I send the API request to get search results for additional keyword as "AlphaSense"
    Then I should get the response status as 200

  @API @AlphaSense @TC_002
  Scenario: User is able to get correct number of results in the document
    When I send the API request to get search results for additional keyword as "AlphaSense"
    And I should get  "searchResults.originalStatementCount" as "17" in response body   
    
    
  @API @AlphaSense @TC_003
  Scenario: User gets required number of objects for each response
    When I send the API request to get search results for additional keyword as "AlphaSense"
    Then I should get 17 "searchResults.statements" objects in the response 
    
  @API @AlphaSense @TC_004 @fail
   Scenario: User is able to search document using additional keyword
    When I send the API request to get search results for additional keyword as "AlphaSense"
    Then I should get the response status as 2001