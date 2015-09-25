package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class GildedRoseWithDescribtiveUnitTest extends GildedRoseBoundaries {
	protected List<Item> actual;
	private List<Item> originalItems;

	private GildedRose app;

	@Before
	public void setUp() {
		actual = new ArrayList<>();
		originalItems = new ArrayList<>();
	}

	/*
	 * Testcases for ordinary item, where days >0, so not quality degrades twice
	 * as fast!
	 */

	@Test
	public void updatetQualityReducesQualityValueForOrdinaryItemBy1IfWithinSellIn() {
		givenAnItemOfQuality(2);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(1);
	} 

	@Test
	public void itemQualityStaysAtNoQualityIfWithInSellInDays() {
		givenAnItemOfQuality(MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	} 

	@Test
	public void ordinaryItemPastSellInDayWithoutQualityStaysWithoutQuality() {
		givenAnItemOfSellInAndQuality(PAST_SELLIN_DAYS, MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	}

	@Test
	public void updateQualityReducesQualityValueOfOrdinaryItemBy1AfterLastSellInDay() {
		givenAnItemOfSellInAndQuality(1, 5);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(4);
	} 

	@Test
	public void updateQualityReducesSellInValueForOrdinaryItemBy1() {
		givenAnItemOfSellIn(1);
		whenQualityIsUpdated();
		thenSellInShouldBe(0);
	} 

	@Test
	public void updateQualityReducesSellInValueForOrdinaryItemBy1AfterLastSellInDay() {
		givenAnItemOfSellIn(0);
		whenQualityIsUpdated();
		thenSellInShouldBe(PAST_SELLIN_DAYS);
	}  

	@Test
	public void updateQualityConsidersAllItemsInStore() {
		givenAnOrdinaryItem();
		givenAnOrdinaryItem();
		whenQualityIsUpdated();
		thenAllItemsShouldHaveBeenConsidered();
	}

	/*
	 * If sellIn days reached, quality reduces twice as fast
	 */

	@Test
	public void updateQualityReducesQualityTwiceAsFastWhenPastSellIn() {
		givenAnItemOfSellInAndQuality(0, 5);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(3);
	}  

	@Test
	public void ordinaryItemPastSellInDayWithLittleQualityDegradesToNoQuality() {
		givenAnItemOfSellInAndQuality(PAST_SELLIN_DAYS, 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	} 

	/*
	 * "Aged Brie" actually increases in Quality the older it gets
	 */
	@Test
	public void updateQualityForAgedBriePastSellInDaysIncreasesQualityTwiceAsFast() {
		givenAnAgedBrieOfSellInDaysAndQuality(0, 5);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(7);
	} 

	@Test
	public void updateQualityForAgedBriePastSellInDaysAndNoQualityIncreasesQualityTwiceAsFast() {
		givenAnAgedBrieOfSellInDaysAndQuality(0, MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(2);
	} 

	@Test
	public void updateQualityForAgedBrieWithSellInDaysIncreasesQualityBy1() {
		givenAnAgedBrieOfSellInDaysAndQuality(5, 5);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(6);
	} 

	@Test
	public void updateQualityForAgedBrieWithSellInDaysAndNoQualityIncreasesQualityBy1() {
		givenAnAgedBrieOfSellInDaysAndQuality(5, MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(1);
	}  

	/*
	 * The Quality of an item is never more than 50
	 */

	@Test
	public void updateQualityForAgedBrieWithQualityOf50StaysAt50() {
		givenAnAgedBrieOfQuality(MAXIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForAgedBrieWithQualityOf49Willbe50() {
		givenAnAgedBrieOfQuality(MAXIMUM_QUALITY - 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForAgedBrieWithSellInDaysPastandQualityOf49Willbe50() {
		givenAnAgedBrieOfSellInDaysAndQuality(PAST_SELLIN_DAYS, MAXIMUM_QUALITY - 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}

	/*
	 * "Sulfuras", being a legendary item, never has to be sold or decreases in
	 * Quality
	 */

	@Test
	public void updateQualityforSulfurasWithSellInDaysReducesSellInDayBy1() {
		givenASulfurasItemWithSellInDays(EXAMPLE_SELLINDAY);
		whenQualityIsUpdated();
		thenSellInShouldBe(EXAMPLE_SELLINDAY);
	} 

	@Test
	public void updateQualityforSulfurasWithNoSellInDaysLeftReducesSellInDaysBy1() {
		givenASulfurasItemWithSellInDays(0);
		whenQualityIsUpdated();
		thenSellInShouldBe(0);
	} 

	@Test
	public void updateQualityforSulfurasWithSellInDaysPastReducesSellInDaysBy1() {
		givenASulfurasItemWithSellInDays(-5);
		whenQualityIsUpdated();
		thenSellInShouldBe(-5);
	} 

	@Test
	public void updateQualityforSulfurasWithMaxQualityKeepsMaxQuality() {
		givenASulfurasItemWithQuality(MAXIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityforSulfurasWithQualityOf10KeepsQuality() {
		givenASulfurasItemWithQuality(EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY);
	}

	@Test
	public void updateQualityforSulfurasWithNoQualityKeepsNoQuality() {
		givenASulfurasItemWithQuality(MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	}

	/*
	 * "Backstage passes", like aged brie, increases in Quality as it's SellIn
	 * value approaches; Quality increases by 2 when there are 10 days or less
	 * and by 3 when there are 5 days or less but Quality drops to 0 after the
	 * concert
	 */

	@Test
	public void updateQualityForABackstagePassWhereLongPeriodToSellInDaysIncreasesQualityBy1() {
		givenABackstagePassWithSellInDays(EXAMPLE_SELLINDAY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY + 1);
	}

	@Test
	public void updateQualityForABackstagePassWhereMediumPeriodToSellInDaysIncreasesQualityBy2() {
		givenABackstagePassWithSellInDays(10);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY + 2);
	}

	@Test
	public void updateQualityForABackstagePassWhereMediumPeriodToSellInDaysAndAlmostMaxQualIncreasesQualityToMaxQuality() {
		givenABackstagePassWithSellInDaysAndQuality(10, MAXIMUM_QUALITY - 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForABackstagePassWhereBreakToShortPeriodToSellInDaysIncreasesQualityBy2() {
		givenABackstagePassWithSellInDays(5 + 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY + 2);
	}

	@Test
	public void updateQualityForABackstagePassWhereShortPeriodToSellInDaysIncreasesQualityBy2() {
		givenABackstagePassWithSellInDays(5);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY + 3);
	}

	@Test
	public void updateQualityForABackstagePassWithSellInDay0ReturnsNoQuality() {
		givenABackstagePassWithSellInDays(0);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(0);
	}

	@Test
	public void updateQualityForABackstagePassWhereShortPeriodToSellInDaysAndAlmostMaxQualityIncreasesQualityToMaxQuality() {
		givenABackstagePassWithSellInDaysAndQuality(5, MAXIMUM_QUALITY - 2);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForABackstagePassWithSellInDayPastReturnsNoQuality() {
		givenABackstagePassWithSellInDaysAndQuality(-1, MAXIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(0);
	}

	/*
	 * Testcases for "Conjured" items degrade in Quality twice as fast as normal
	 * items
	 */

	@Ignore
	@Test
	public void updatetQualityForConjuredReducesQualityValueForOrdinaryItemBy1IfWithinSellIn() {
		givenAConjuredItemOfQuality(EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY-2);
	}


	@Ignore
	@Test
	public void conjuredItemPastSellInDayWithoutQualityStaysWithoutQuality() {
		givenAConjuredItemOfSellInAndQuality(PAST_SELLIN_DAYS, MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	}

	@Ignore
	@Test
	public void updateQualityForConjuredReducesQualityValueOfOrdinaryItemBy1AfterLastSellInDay() {
		givenAConjuredItemOfSellInAndQuality(1, EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY-2);
	}

	/*
	 * If sellIn days reached, quality reduces twice as fast -- "Conjured" items
	 * degrade in Quality twice as fast as normal items
	 */

	@Ignore
	@Test
	public void updateQualityForConjuredReducesQualityTwiceAsFastWhenPastSellIn() {
		givenAConjuredItemOfSellInAndQuality(0, EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(EXAMPLE_QUALITY-4);
	}
	
	@Ignore
	@Test
	public void conjuredItemPastSellInDayWithLittleQualityDegradesToNoQuality() {
		givenAConjuredItemOfSellInAndQuality(PAST_SELLIN_DAYS, 3);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	}


	/*
	 * Helper methods for a better description.
	 */
	protected void addItem(String name, int sellInDays, int quality) {
		actual.add(new Item(name, sellInDays, quality));
	}

	/*
	 * GIVEN
	 */

	protected void givenAnItemOfSellInAndQuality(int sellInDays, int quality) {
		addItem(NAME_ORDINARY_ITEM, sellInDays, quality);

	}

	protected void givenAnOrdinaryItem() {
		givenAnItemOfSellIn(EXAMPLE_SELLINDAY);
	}

	protected void givenAnItemOfSellIn(int sellIn) {
		addItem(NAME_ORDINARY_ITEM, sellIn, MINIMUM_QUALITY);
	}

	protected void givenAnItemOfQuality(int quality) {
		addItem(NAME_ORDINARY_ITEM, EXAMPLE_SELLINDAY, quality);
	}

	protected void givenAnAgedBrieOfQuality(int quality) {
		givenAnAgedBrieOfSellInDaysAndQuality(EXAMPLE_SELLINDAY, quality);

	}

	protected void givenAnAgedBrieOfSellInDaysAndQuality(int sellInDays, int quality) {
		addItem(NAME_AGED_BRIE, sellInDays, quality);
	}

	protected void givenASulfurasItemWithSellInDays(int sellInDays) {
		addItem(NAME_SULFURAS, sellInDays, EXAMPLE_QUALITY);

	}

	protected void givenASulfurasItemWithQuality(int quality) {
		addItem(NAME_SULFURAS, EXAMPLE_SELLINDAY, quality);

	}

	protected void givenABackstagePassWithSellInDays(int sellInDays) {
		givenABackstagePassWithSellInDaysAndQuality(sellInDays, EXAMPLE_QUALITY);

	}

	protected void givenABackstagePassWithSellInDaysAndQuality(int sellInDays, int quality) {
		addItem(NAME_BACKSTAGE_PASS, sellInDays, quality);

	}

	protected void givenAConjuredItemOfQuality(int quality) {
		givenAConjuredItemOfSellInAndQuality(EXAMPLE_SELLINDAY, quality);
	}
	
	protected void givenAConjuredItemOfSellInAndQuality(int sellInDays, int quality) {
		addItem(NAME_CONJURED_ITEM, sellInDays, quality);
		
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

	protected void thenTheQualityShouldBe(int expected) {
		assertEquals(expected, app.items[0].quality);
	}

	protected void thenSellInShouldBe(int expected) {
		assertEquals(expected, app.items[0].sellIn);
	}

	private void thenAllItemsShouldHaveBeenConsidered() {
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
