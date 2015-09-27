package com.gildedrose;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseParameterizedSellInDaysTest extends GildedRoseBasicTestUsage {
	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, 1, GildedRoseBoundaries.EXAMPLE_QUALITY, 0 },
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, 0, GildedRoseBoundaries.EXAMPLE_QUALITY, GildedRoseBoundaries.PAST_SELLIN_DAYS },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.PAST_SELLIN_DAYS,GildedRoseBoundaries.EXAMPLE_QUALITY, -2 },
				{ GildedRoseBoundaries.NAME_SULFURAS, 1, GildedRoseBoundaries.EXAMPLE_QUALITY, 1 },
				{ GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.PAST_SELLIN_DAYS, GildedRoseBoundaries.EXAMPLE_QUALITY, GildedRoseBoundaries.PAST_SELLIN_DAYS },
				{ GildedRoseBoundaries.NAME_SULFURAS, 0, GildedRoseBoundaries.EXAMPLE_QUALITY, 0 },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 1, GildedRoseBoundaries.MAXIMUM_QUALITY-1, 0 },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 0, GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.PAST_SELLIN_DAYS },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, GildedRoseBoundaries.PAST_SELLIN_DAYS, GildedRoseBoundaries.MAXIMUM_QUALITY-1, GildedRoseBoundaries.PAST_SELLIN_DAYS - 1 } });
	};
	
	private int expectedSellInDay;
	
	public GildedRoseParameterizedSellInDaysTest(final String name, final int sellInDay, final int quality, final int expectedSellInDay) {
		super();
		addItem(name, sellInDay, quality);
		this.expectedSellInDay = expectedSellInDay;
	}
	
	@Test
	public void testIfSellInDaysWhereUpdated(){
		// given Method is already done through constructor
		whenQualityIsUpdated();
		thenSellInShouldBe(expectedSellInDay);
	}
	
}