@variable
Feature: Google variable search

  @first
  Scenario Outline: Search for city

    Given Google start
    And Search <city>
    When Get search list info
    And Click first Google search result link
    Then Get url info
    Examples:
      | city  |  |
      | Sopot |  |
      | Łeba  |  |

  @third
  Scenario Outline: Search for country

    Given Google start
    And Search <country>
    When Get search list info
    And Click first Google search result link
    Then Get url info
    Examples:
      | country |  |
      | Polska  |  |
      | Włochy  |  |