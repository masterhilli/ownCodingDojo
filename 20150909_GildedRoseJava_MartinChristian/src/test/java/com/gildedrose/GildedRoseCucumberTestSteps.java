package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.Format;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GildedRoseCucumberTestSteps extends GildedRoseWithDescribtiveUnitTest{
//	protected List<Item> actual = new ArrayList<>();
	
	@Before
	public void setUp (){
		actual = new ArrayList<>();
	}
	
	@Given ("an item with the name '(.+)', with days to sell in of (\\d+), with the quality of (\\d+)")
	public void givenAnItemWithSellInAndQuality(final String name, final  int sellInDays, final int quality) {
		addItem(name, sellInDays, quality);
	}
	
	@When ("the quality is updated")
	public void whenQualityIsUpdated() {
		super.whenQualityIsUpdated();
	}
	
	@Then ("the quality should be (\\d+)")
	public void then(final int quality) {
		super.thenTheQualityShouldBe(quality);
	}
	
}
