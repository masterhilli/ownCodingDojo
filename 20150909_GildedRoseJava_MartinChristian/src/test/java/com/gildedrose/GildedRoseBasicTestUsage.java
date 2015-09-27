package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GildedRoseBasicTestUsage{

	protected List<Item> actual;
	protected List<Item> originalItems;
	private GildedRose app;

	public GildedRoseBasicTestUsage() {
		super();
		actual = new ArrayList<>();
	}

	protected void addItem(String name, int sellInDays, int quality) {
		actual.add(new Item(name, sellInDays, quality));
	}
	
	/*
	 * GIVEN
	 */

	protected void givenAnItemOfSellInAndQuality(int sellInDays, int quality) {
		addItem(GildedRoseBoundaries.NAME_ORDINARY_ITEM, sellInDays, quality);
	
	}

	protected Object givenAnOrdinaryItem() {
		givenAnItemOfSellIn(GildedRoseBoundaries.EXAMPLE_SELLINDAY);
		return actual;
	}

	protected void givenAnItemOfSellIn(int sellIn) {
		addItem(GildedRoseBoundaries.NAME_ORDINARY_ITEM, sellIn, GildedRoseBoundaries.MINIMUM_QUALITY);
	}

	protected void givenAnItemOfQuality(int quality) {
		addItem(GildedRoseBoundaries.NAME_ORDINARY_ITEM, GildedRoseBoundaries.EXAMPLE_SELLINDAY, quality);
	}

	protected void givenAnAgedBrieOfQuality(int quality) {
		givenAnAgedBrieOfSellInDaysAndQuality(GildedRoseBoundaries.EXAMPLE_SELLINDAY, quality);
	
	}

	protected void givenAnAgedBrieOfSellInDaysAndQuality(int sellInDays, int quality) {
		addItem(GildedRoseBoundaries.NAME_AGED_BRIE, sellInDays, quality);
	}

	protected void givenASulfurasItemWithSellInDays(int sellInDays) {
		addItem(GildedRoseBoundaries.NAME_SULFURAS, sellInDays, GildedRoseBoundaries.EXAMPLE_QUALITY);
	
	}

	protected void givenASulfurasItemWithQuality(int quality) {
		addItem(GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.EXAMPLE_SELLINDAY, quality);
	
	}

	protected void givenABackstagePassWithSellInDays(int sellInDays) {
		givenABackstagePassWithSellInDaysAndQuality(sellInDays, GildedRoseBoundaries.EXAMPLE_QUALITY);
	
	}

	protected void givenABackstagePassWithSellInDaysAndQuality(int sellInDays, int quality) {
		addItem(GildedRoseBoundaries.NAME_BACKSTAGE_PASS, sellInDays, quality);
	
	}

	protected void givenAConjuredItemOfQuality(int quality) {
		givenAConjuredItemOfSellInAndQuality(GildedRoseBoundaries.EXAMPLE_SELLINDAY, quality);
	}

	protected void givenAConjuredItemOfSellInAndQuality(int sellInDays, int quality) {
		addItem(GildedRoseBoundaries.NAME_CONJURED_ITEM, sellInDays, quality);
		
	}

	/**
	 * WHEN
	 */
	protected void whenQualityIsUpdated() {
		originalItems = actual.stream().map(item -> new Item(item.name, item.sellIn, item.quality))
				.collect(Collectors.toList());
		app = new GildedRose(actual.stream().toArray(Item[]::new));
		app.updateQuality();
	}

	
	/*
	 * THEN
	 */
	protected void thenTheQualityShouldBe(int expected) {
		assertEquals(expected, app.items[0].quality);
	}

	protected void thenSellInShouldBe(int expected) {
		assertEquals(expected, app.items[0].sellIn);
	}

	protected void thenAllItemsShouldHaveBeenConsidered() {
		int identical = 0;
		Item[] originalArray = originalItems.stream().toArray(Item[]::new);
		for (int i = 0; i < originalArray.length; i++) {
			Item originalItem = originalArray[i];
			Item stockItem = app.items[i];
	
			if (originalItem.quality == stockItem.quality && originalItem.sellIn == stockItem.sellIn) {
				identical++;
			}
	
		}
		assertEquals(0, identical);
	}

}