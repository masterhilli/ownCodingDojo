Feature: Update the quality for items
  The quality of an item is updated after every day. There are special items, where the quality is updated differently

  Scenario: Update the quality of an ordinary item
    Given an item with the name 'Ordinary item', with days to sell in of 22, with the quality of 2
    When the quality is updated
    Then the quality should be 1

    
    # afterwards we make a scenario outline
 #    If there are many examples, this becomes tedious. We can simplify it with a Scenario Outline:
 #
 #Scenario Outline: feeding a suckler cow
 #  Given the cow weighs <weight> kg
 #  When we calculate the feeding requirements
 #  Then the energy should be <energy> MJ
 #  And the protein should be <protein> kg
 #
 #  Examples:
     #| weight | energy | protein |
     #|    450 |  26500 |     215 |
     #|    500 |  29500 |     245 |
     #|    575 |  31500 |     255 |
     #|    600 |  37000 |     305 |
   