Feature: Pierwszy Cucumber Test

@tagnazwa
  Scenario: szukanie osób

    Given kontekst Szybka Wyszukiwarka Osob
    When sprawdzam bledne wyszukiwanie
    And zmieniam kontekst
    And sprawdzam wyszukiwanie
    Then wyszukuje po zleceniu