package com.gildedrose;

import java.util.ArrayList;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GildedRoseCucumberTestSteps extends GildedRoseBasicTestUsage{
	
	@Before
	public void setUp (){
		actual = new ArrayList<>();
	}
	
	@Given ("an item with the name '(.+)', with days to sell in of (-?\\d+), with the quality of (\\d+)")
	public void givenAnItemWithSellInAndQuality(final String name, final  int sellInDays, final int quality) {
		addItem(name, sellInDays, quality);
	}

	@When ("the quality is updated")
	public void whenQualityIsUpdated() {
		super.whenQualityIsUpdated();
	}
	
	@Then ("the quality should be (\\d+)")
	public void thenTheQualityShouldBe(final int quality) {
		super.thenTheQualityShouldBe(quality);
	}
	
	@Then ("the day to sell the item in should be (-?\\d+)")
	public void thenSellInShouldBe(final int sellInDays) {
		super.thenSellInShouldBe(sellInDays);
	}
	
}
