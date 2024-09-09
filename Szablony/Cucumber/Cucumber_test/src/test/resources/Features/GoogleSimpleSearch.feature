Feature: Google simple search

  Background:
    Given Google start

  @first
  Scenario: Search for Soflab
  
    And Soflab search
    When Get search list info
    And Soflab click link
    Then Get Soflab url info


  @second
  Scenario: Search for Gdynia

    And Gdynia search
    When Get search list info
    And Gdynia click link
    Then Get Gdynia url info
