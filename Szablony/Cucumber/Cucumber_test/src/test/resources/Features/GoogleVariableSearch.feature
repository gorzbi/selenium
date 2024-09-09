@variable
Feature: Google variable search

// gdy jakiś krok jest taki sam dla wszystkich scenario można umieścić w background
  Background:
    Given Google start

  @first
  Scenario Outline: Search for city
// jeśli w kroku jest więcej niż 1 parametr należy oddzielać ","
    And Search <city>,<inne city>,<jeszcze inne city>
    When Get search list info
    And Click first Google search result link
    Then Get url info
    Examples:
      | city  | inne city |jeszczce inne ciy|
      | Sopot | xx        |xx               |
      | Łeba  |  yy       |yyyy             |

  @third
  Scenario Outline: Search for country

    And Search <country>
    When Get search list info
    And Click first Google search result link
    Then Get url info
    Examples:
      | country |  |
      | Polska  |  |
      | Włochy  |  |
