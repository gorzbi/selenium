Feature: Wrong search

  Background:
    Given Google start

  @first
  Scenario: Wrong search for Soflab

    And Soflab search
    When Get search list info
    And Soflab click link
    Then Get x url info


  @wrong
  Scenario: Wrong search for Gdynia

    And Gdynia search
    When Get search list info
    And Gdynia click link
    Then Get x url info
