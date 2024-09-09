Feature: Wrong search

  @first
  Scenario: Wrong search for Soflab

    Given Google start
    And Soflab search
    When Get search list info
    And Soflab click link
    Then Get x url info


  @wrong
  Scenario: Wrong search for Gdynia

    Given Google start
    And Gdynia search
    When Get search list info
    And Gdynia click link
    Then Get x url info