Feature: Google simple search

  @first
  Scenario: Search for Soflab

    Given Google start
    And Soflab search
    When Get search list info
    And Soflab click link
    Then Get Soflab url info


  @second
  Scenario: Search for Gdynia

    Given Google start
    And Gdynia search
    When Get search list info
    And Gdynia click link
    Then Get Gdynia url info