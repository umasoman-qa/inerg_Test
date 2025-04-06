Feature: Covid-9 tracker

  Scenario: View covid data and line chart for Kerala
    Given I am on the covid Tracker page
    When I have selected "Kerala" from the dropdown
    Then the covid details for "Kerala" should be displayed
    And the line chart should be visible
    And each point on the line chart should display a value
