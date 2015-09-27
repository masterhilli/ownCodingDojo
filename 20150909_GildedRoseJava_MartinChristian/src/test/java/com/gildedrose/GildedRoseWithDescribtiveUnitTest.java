package com.gildedrose;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseWithDescribtiveUnitTest extends GildedRoseBasicTestUsage {
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
		givenAnItemOfQuality(GildedRoseBoundaries.MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MINIMUM_QUALITY);
	} 

	@Test
	public void ordinaryItemPastSellInDayWithoutQualityStaysWithoutQuality() {
		givenAnItemOfSellInAndQuality(GildedRoseBoundaries.PAST_SELLIN_DAYS, GildedRoseBoundaries.MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MINIMUM_QUALITY);
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
		thenSellInShouldBe(GildedRoseBoundaries.PAST_SELLIN_DAYS);
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
		givenAnItemOfSellInAndQuality(GildedRoseBoundaries.PAST_SELLIN_DAYS, 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MINIMUM_QUALITY);
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
		givenAnAgedBrieOfSellInDaysAndQuality(0, GildedRoseBoundaries.MINIMUM_QUALITY);
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
		givenAnAgedBrieOfSellInDaysAndQuality(5, GildedRoseBoundaries.MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(1);
	}  

	/*
	 * The Quality of an item is never more than 50
	 */

	@Test
	public void updateQualityForAgedBrieWithQualityOf50StaysAt50() {
		givenAnAgedBrieOfQuality(GildedRoseBoundaries.MAXIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForAgedBrieWithQualityOf49Willbe50() {
		givenAnAgedBrieOfQuality(GildedRoseBoundaries.MAXIMUM_QUALITY - 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForAgedBrieWithSellInDaysPastandQualityOf49Willbe50() {
		givenAnAgedBrieOfSellInDaysAndQuality(GildedRoseBoundaries.PAST_SELLIN_DAYS, GildedRoseBoundaries.MAXIMUM_QUALITY - 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MAXIMUM_QUALITY);
	}

	/*
	 * "Sulfuras", being a legendary item, never has to be sold or decreases in
	 * Quality
	 */

	@Test
	public void updateQualityforSulfurasWithSellInDaysReducesSellInDayBy1() {
		givenASulfurasItemWithSellInDays(GildedRoseBoundaries.EXAMPLE_SELLINDAY);
		whenQualityIsUpdated();
		thenSellInShouldBe(GildedRoseBoundaries.EXAMPLE_SELLINDAY);
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
		givenASulfurasItemWithQuality(GildedRoseBoundaries.MAXIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityforSulfurasWithQualityOf10KeepsQuality() {
		givenASulfurasItemWithQuality(GildedRoseBoundaries.EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY);
	}

	@Test
	public void updateQualityforSulfurasWithNoQualityKeepsNoQuality() {
		givenASulfurasItemWithQuality(GildedRoseBoundaries.MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MINIMUM_QUALITY);
	}

	/*
	 * "Backstage passes", like aged brie, increases in Quality as it's SellIn
	 * value approaches; Quality increases by 2 when there are 10 days or less
	 * and by 3 when there are 5 days or less but Quality drops to 0 after the
	 * concert
	 */

	@Test
	public void updateQualityForABackstagePassWhereLongPeriodToSellInDaysIncreasesQualityBy1() {
		givenABackstagePassWithSellInDays(GildedRoseBoundaries.EXAMPLE_SELLINDAY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY + 1);
	}

	@Test
	public void updateQualityForABackstagePassWhereMediumPeriodToSellInDaysIncreasesQualityBy2() {
		givenABackstagePassWithSellInDays(10);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY + 2);
	}

	@Test
	public void updateQualityForABackstagePassWhereMediumPeriodToSellInDaysAndAlmostMaxQualIncreasesQualityToMaxQuality() {
		givenABackstagePassWithSellInDaysAndQuality(10, GildedRoseBoundaries.MAXIMUM_QUALITY - 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForABackstagePassWhereBreakToShortPeriodToSellInDaysIncreasesQualityBy2() {
		givenABackstagePassWithSellInDays(5 + 1);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY + 2);
	}

	@Test
	public void updateQualityForABackstagePassWhereShortPeriodToSellInDaysIncreasesQualityBy2() {
		givenABackstagePassWithSellInDays(5);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY + 3);
	}

	@Test
	public void updateQualityForABackstagePassWithSellInDay0ReturnsNoQuality() {
		givenABackstagePassWithSellInDays(0);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(0);
	}

	@Test
	public void updateQualityForABackstagePassWhereShortPeriodToSellInDaysAndAlmostMaxQualityIncreasesQualityToMaxQuality() {
		givenABackstagePassWithSellInDaysAndQuality(5, GildedRoseBoundaries.MAXIMUM_QUALITY - 2);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MAXIMUM_QUALITY);
	}

	@Test
	public void updateQualityForABackstagePassWithSellInDayPastReturnsNoQuality() {
		givenABackstagePassWithSellInDaysAndQuality(-1, GildedRoseBoundaries.MAXIMUM_QUALITY);
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
		givenAConjuredItemOfQuality(GildedRoseBoundaries.EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY-2);
	}


	@Ignore
	@Test
	public void conjuredItemPastSellInDayWithoutQualityStaysWithoutQuality() {
		givenAConjuredItemOfSellInAndQuality(GildedRoseBoundaries.PAST_SELLIN_DAYS, GildedRoseBoundaries.MINIMUM_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MINIMUM_QUALITY);
	}

	@Ignore
	@Test
	public void updateQualityForConjuredReducesQualityValueOfOrdinaryItemBy1AfterLastSellInDay() {
		givenAConjuredItemOfSellInAndQuality(1, GildedRoseBoundaries.EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY-2);
	}

	/*
	 * If sellIn days reached, quality reduces twice as fast -- "Conjured" items
	 * degrade in Quality twice as fast as normal items
	 */

	@Ignore
	@Test
	public void updateQualityForConjuredReducesQualityTwiceAsFastWhenPastSellIn() {
		givenAConjuredItemOfSellInAndQuality(0, GildedRoseBoundaries.EXAMPLE_QUALITY);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.EXAMPLE_QUALITY-4);
	}
	
	@Ignore
	@Test
	public void conjuredItemPastSellInDayWithLittleQualityDegradesToNoQuality() {
		givenAConjuredItemOfSellInAndQuality(GildedRoseBoundaries.PAST_SELLIN_DAYS, 3);
		whenQualityIsUpdated();
		thenTheQualityShouldBe(GildedRoseBoundaries.MINIMUM_QUALITY);
	}
}
