Feature: Update the quality for items
  The quality of an item is updated after every day. There are special items, where the quality is updated differently

 Scenario: Update the day to sell the item in
    Given an item with the name 'Ordinary Item', with days to sell in of 22, with the quality of 22
    When the quality is updated
    Then the day to sell the item in should be 21

  Scenario Outline: Update the quality of an ordinary item
    Given an item with the name <name>, with days to sell in of <sellinday>, with the quality of <quality>
    When the quality is updated
    Then the quality should be <expectedQuality>

    Examples: 
      | name            | sellinday | quality | expectedQuality |
      | 'Ordinary item' | 22        | 2       | 1               |
      | 'Ordinary item' | 22        | 0       | 0               |
      | 'Ordinary item' | -1        | 0       | 0               |
      | 'Ordinary item' | 1         | 22      | 21              |
      | 'Ordinary item' | 1         | 22      | 21              |
