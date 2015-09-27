package com.gildedrose;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GildedRoseParameterizedQualityTest extends GildedRoseBasicTestUsage {
	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, GildedRoseBoundaries.EXAMPLE_SELLINDAY, 2, 1 },
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, GildedRoseBoundaries.EXAMPLE_SELLINDAY, GildedRoseBoundaries.MINIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, 1, GildedRoseBoundaries.EXAMPLE_QUALITY, 21 },
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.EXAMPLE_QUALITY, 20 },
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MINIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, GildedRoseBoundaries.PAST_SELLIN_DAYS, 1,
						GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_ORDINARY_ITEM, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.EXAMPLE_QUALITY, 20 },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.EXAMPLE_QUALITY, 24 },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MINIMUM_QUALITY, 2 },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MAXIMUM_QUALITY - 1, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.EXAMPLE_SELLINDAY,
						GildedRoseBoundaries.EXAMPLE_QUALITY, 23 },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.EXAMPLE_SELLINDAY,
						GildedRoseBoundaries.MINIMUM_QUALITY, 1 },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.EXAMPLE_SELLINDAY,
						GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.EXAMPLE_SELLINDAY,
						GildedRoseBoundaries.MAXIMUM_QUALITY - 1, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_AGED_BRIE, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MAXIMUM_QUALITY - 1, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, 1, GildedRoseBoundaries.MAXIMUM_QUALITY,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, 1, GildedRoseBoundaries.EXAMPLE_QUALITY,
						GildedRoseBoundaries.EXAMPLE_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.EXAMPLE_QUALITY, GildedRoseBoundaries.EXAMPLE_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.EXAMPLE_QUALITY, GildedRoseBoundaries.EXAMPLE_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, 1, GildedRoseBoundaries.MINIMUM_QUALITY,
						GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MINIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_SULFURAS, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MINIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 11, GildedRoseBoundaries.MINIMUM_QUALITY, 1 },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 11, GildedRoseBoundaries.MAXIMUM_QUALITY - 1,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 11, GildedRoseBoundaries.MAXIMUM_QUALITY,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 10, GildedRoseBoundaries.MINIMUM_QUALITY, 2 },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 10, GildedRoseBoundaries.MAXIMUM_QUALITY - 1,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 10, GildedRoseBoundaries.MAXIMUM_QUALITY,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 6, GildedRoseBoundaries.MINIMUM_QUALITY, 2 },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 6, GildedRoseBoundaries.MAXIMUM_QUALITY - 1,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 6, GildedRoseBoundaries.MAXIMUM_QUALITY,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 5, GildedRoseBoundaries.MINIMUM_QUALITY, 3 },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 5, GildedRoseBoundaries.MAXIMUM_QUALITY - 1,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 5, GildedRoseBoundaries.MAXIMUM_QUALITY - 2,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 5, GildedRoseBoundaries.MAXIMUM_QUALITY - 3,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, 5, GildedRoseBoundaries.MAXIMUM_QUALITY,
						GildedRoseBoundaries.MAXIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MINIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MAXIMUM_QUALITY - 1, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, GildedRoseBoundaries.ON_SELL_IN_DAY,
						GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MINIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MAXIMUM_QUALITY - 1, GildedRoseBoundaries.MINIMUM_QUALITY },
				{ GildedRoseBoundaries.NAME_BACKSTAGE_PASS, GildedRoseBoundaries.PAST_SELLIN_DAYS,
						GildedRoseBoundaries.MAXIMUM_QUALITY, GildedRoseBoundaries.MINIMUM_QUALITY } });
	};

	private int expectedQuality;

	public GildedRoseParameterizedQualityTest(final String name, final int sellInDay, final int quality,
			final int expectedQuality) {
		super();
		addItem(name, sellInDay, quality);
		this.expectedQuality = expectedQuality;
	}

	@Test
	public void testIfSellInDaysWhereUpdated() {
		// given Method is already done through constructor
		whenQualityIsUpdated();
		thenTheQualityShouldBe(expectedQuality);
	}
}