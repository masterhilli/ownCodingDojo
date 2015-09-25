Feature: Update the quality for items
  The quality of an item is updated after every day. There are special items, where the quality is updated differently

  Scenario Outline: Update the day to sell the item in
    Given an item with the name <name>, with days to sell in of <sellinday>, with the quality of <quality>
    When the quality is updated
    Then the day to sell the item in should be <expectedSellinDay>

    Examples: 
      | name                                        | sellinday | quality | expectedSellinDay |
      | 'Ordinary item'                             | 1         | 22      | 0                 |
      | 'Ordinary item'                             | 0         | 22      | -1                |
      | 'Aged Brie'                                 | -1        | 22      | -2                |
      | 'Sulfuras, Hand of Ragnaros'                | 1         | 22      | 1                |
      | 'Sulfuras, Hand of Ragnaros'                | -1        | 22      | -1                |
      | 'Sulfuras, Hand of Ragnaros'                | 0         | 22      | 0                |
      | 'Backstage passes to a TAFKAL80ETC concert' | 1         | 49      | 0                 |
      | 'Backstage passes to a TAFKAL80ETC concert' | 0         | 50      | -1                |
      | 'Backstage passes to a TAFKAL80ETC concert' | -1        | 49      | -2                |

  Scenario Outline: Update the quality of an ordinary item
    Given an item with the name <name>, with days to sell in of <sellinday>, with the quality of <quality>
    When the quality is updated
    Then the quality should be <expectedQuality>

    Examples: 
      | name                                        | sellinday | quality | expectedQuality |
      | 'Ordinary item'                             | 22        | 2       | 1               |
      | 'Ordinary item'                             | 22        | 0       | 0               |
      | 'Ordinary item'                             | -1        | 0       | 0               |
      | 'Ordinary item'                             | 1         | 22      | 21              |
      | 'Ordinary item'                             | 1         | 22      | 21              |
      | 'Ordinary item'                             | 0         | 22      | 20              |
      | 'Ordinary item'                             | -1        | 1       | 0               |
      | 'Aged Brie'                                 | 0         | 22      | 24              |
      | 'Aged Brie'                                 | 0         | 0       | 2               |
      | 'Aged Brie'                                 | 22        | 22      | 23              |
      | 'Aged Brie'                                 | 22        | 0       | 1               |
      | 'Aged Brie'                                 | 22        | 50      | 50              |
      | 'Aged Brie'                                 | 22        | 49      | 50              |
      | 'Aged Brie'                                 | 0         | 50      | 50              |
      | 'Aged Brie'                                 | 0         | 49      | 50              |
      | 'Aged Brie'                                 | -1        | 50      | 50              |
      | 'Aged Brie'                                 | -1        | 49      | 50              |
      | 'Sulfuras, Hand of Ragnaros'                | 1         | 50      | 50              |
      | 'Sulfuras, Hand of Ragnaros'                | 0         | 50      | 50              |
      | 'Sulfuras, Hand of Ragnaros'                | -1        | 50      | 50              |
      | 'Sulfuras, Hand of Ragnaros'                | 1         | 22      | 22              |
      | 'Sulfuras, Hand of Ragnaros'                | 0         | 22      | 22              |
      | 'Sulfuras, Hand of Ragnaros'                | -1        | 22      | 22              |
      | 'Sulfuras, Hand of Ragnaros'                | 1         | 0       | 0               |
      | 'Sulfuras, Hand of Ragnaros'                | 0         | 0       | 0               |
      | 'Sulfuras, Hand of Ragnaros'                | -1        | 0       | 0               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 11        | 0       | 1               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 11        | 49      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 11        | 50      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 10        | 0       | 2               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 10        | 49      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 10        | 50      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 6         | 0       | 2               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 6         | 49      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 6         | 50      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 5         | 0       | 3               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 5         | 49      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 5         | 48      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 5         | 47      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 5         | 50      | 50              |
      | 'Backstage passes to a TAFKAL80ETC concert' | 0         | 0       | 0               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 0         | 48      | 0               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 0         | 49      | 0               |
      | 'Backstage passes to a TAFKAL80ETC concert' | 0         | 50      | 0               |
      | 'Backstage passes to a TAFKAL80ETC concert' | -1        | 0       | 0               |
      | 'Backstage passes to a TAFKAL80ETC concert' | -1        | 49      | 0               |
      | 'Backstage passes to a TAFKAL80ETC concert' | -1        | 50      | 0               |
