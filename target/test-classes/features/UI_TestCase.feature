#Author: Vikas Sangwan


Feature: Test Alpha Sense Search Feature

 Background:
    Given I am on Alpha Sense Document page

  @AlphaSense @UI @TC_001
  Scenario: Search Keyword and verify highlighted statement in last answer
		When I search for additional keyword "AlphaSense"
		And I click on the last found result
		Then I should see the chosen statement is highligted in the document viewer
