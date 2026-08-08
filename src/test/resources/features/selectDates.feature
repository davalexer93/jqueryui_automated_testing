Feature: Datepicker selection of specific dates


  Scenario Outline: Select a specific date in the datepicker
    Given Alex opens the jqueryUI page
    When Alex clicks on the datepicker
    Then Alex selects the date "<year>", "<month>", "<day>"

    Examples:
      | year | month | day |
      | 2017 | Apr   | 3   |
      | 2022 | Jun   | 4   |
      | 2024 | Apr   | 20  |
