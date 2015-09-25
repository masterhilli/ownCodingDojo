package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class GildedRoseTestWithBuilderTest extends GildedRoseBoundaries {
	Builder builder = null;

	@Before
	public void setUp() {
		builder = null;
	}

	// testcases for changes in sell in day
	@Test
	public void updateQualityOfOrdinaryItemReducesSellInDayBy1() {
		givenAnOrdinaryItem().withSellIn(EXAMPLE_SELLINDAY).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(EXAMPLE_SELLINDAY - 1);
	}

	@Test
	public void updateQualityOfOrdinaryItemOnSellInDayReducesSellInBy1() {
		givenAnOrdinaryItem().withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(-1);
	}

	@Test
	public void updateQualityOfOrdinaryItemPastSellInDaysReducesSellInDayBy1() {
		givenAnAgedBrie().withSellIn(-1).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(-2);
	}
	
	@Test
	public void updateQualityOfSulfurasItemWithSellInDaysKeepsSellInDays() {
		givenASulfurasItem().withSellIn(EXAMPLE_SELLINDAY).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(EXAMPLE_SELLINDAY);
	}
	
	@Test
	public void updateQualityOfSulfurasItemOnSellInDayKeepsSellInDays() {
		givenASulfurasItem().withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(0);
	}
	
	@Test
	public void updateQualityOfSulfurasItemPastSellInDaysKeepsSellInDays() {
		givenASulfurasItem().withSellIn(-1).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(-1);
	}
	
	@Test
	public void updateQualityOfBackstagePassWithSellInDaysReducesSellInDayBy1() {
		givenAnAgedBrie().withSellIn(EXAMPLE_SELLINDAY).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(EXAMPLE_SELLINDAY-1);
	}
	
	@Test
	public void updateQualityOfBackstagePassOnSellInDayReducesSellInDayBy1() {
		givenAnAgedBrie().withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(-1);
	}
	
	@Test
	public void updateQualityOfBackstagePassPastSellInDaysReducesSellInDayBy1() {
		givenAnAgedBrie().withSellIn(-1).inStock();
		whenUpdateQuality();
		thenTheSellInDayShouldBe(-2);
	}
	
	
	// test cases for checkin the quality

	@Test
	public void updateQualityOfOrdinaryItemWithQualityWithInSellInDaysReducesQualityBy1() {
		givenAnOrdinaryItem().withQuality(EXAMPLE_QUALITY).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(EXAMPLE_QUALITY-1);
	}
	
	@Test
	public void updateQualityOfOrdinaryItemWithNoQualityWithInSellInDaysStillHasNoQuality() {
		givenAnOrdinaryItem().withQuality(MINIMUM_QUALITY).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	}
	
	@Test
	public void updateQualityOfOrdinaryItemWithQualityWithBeforeSellInDayReducesQualityBy1() {
		givenAnOrdinaryItem().withQuality(EXAMPLE_QUALITY).withSellIn(1).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(EXAMPLE_QUALITY-1);
	}
	
	@Test
	public void updateQualityOfOrdinaryItemWithQualityOnSellInDayReducesQualityBy2() {
		givenAnOrdinaryItem().withQuality(EXAMPLE_QUALITY).withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(EXAMPLE_QUALITY-2);
	}
	
	@Test
	public void updateQualityOfOrdinaryItemWithQualityPastSellInDayReducesQualityBy2() {
		givenAnOrdinaryItem().withQuality(EXAMPLE_QUALITY).withSellIn(-2).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(EXAMPLE_QUALITY-2);
	}
	
	@Test
	public void updateQualityOfOrdinaryItemWithLowestQualityPastSellInDayReducesQualityToMimumQuality() {
		givenAnOrdinaryItem().withQuality(1).withSellIn(-2).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	}
	
	@Test
	public void updateQualityOfOrdinaryItemWithNoQualityPastSellInDayStillHasNoQuality() {
		givenAnOrdinaryItem().withQuality(MINIMUM_QUALITY).withSellIn(-2).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MINIMUM_QUALITY);
	}
	
	

//    | 'Aged Brie'                                 | 0         | 22      | 24              |
	@Test
	public void updateQualityOfAgedBrieWithQualityOnSellInDayStillIncreasesQualityBy2() {
		givenAnAgedBrie().withQuality(EXAMPLE_QUALITY).withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(EXAMPLE_QUALITY+2);
	}
//    | 'Aged Brie'                                 | 0         | 0       | 2               |
	@Test
	public void updateQualityOfAgedBrieNoQualityOnSellInDayStillIncreasesQualityBy2() {
		givenAnAgedBrie().withQuality(0).withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(2);
	}
//    | 'Aged Brie'                                 | 0         | 50      | 50              |
	@Test
	public void updateQualityOfAgedBrieWithMaximumQualityOnSellInDayStillHasMaximumQuality() {
		givenAnAgedBrie().withQuality(MAXIMUM_QUALITY).withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}
//    | 'Aged Brie'                                 | 0         | 49      | 50              |
	@Test
	public void updateQualityOfAgedBrieWithAlmostMaximumQualityOnSellInDayIncreasesToMaximumQuality() {
		givenAnAgedBrie().withQuality(MAXIMUM_QUALITY-1).withSellIn(0).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}
//    | 'Aged Brie'                                 | 22        | 22      | 23              |
	@Test
	public void updateQualityOfAgedBrieWithQualityWithSellInDaysIncreasesQualityBy1() {
		givenAnAgedBrie().withQuality(EXAMPLE_QUALITY).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(EXAMPLE_QUALITY+1);
	}
//    | 'Aged Brie'                                 | 22        | 0       | 1               |
	@Test
	public void updateQualityOfAgedBrieWithNoQualityWithSellInDaysIncreasesQualityBy1() {
		givenAnAgedBrie().withQuality(0).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(1);
	}
//    | 'Aged Brie'                                 | 22        | 50      | 50              |
	@Test
	public void updateQualityOfAgedBrieWithMaximumQualityWithSellInDaysStillHasMaximumQuality() {
		givenAnAgedBrie().withQuality(MAXIMUM_QUALITY).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}
//    | 'Aged Brie'                                 | 22        | 49      | 50              |
	@Test
	public void updateQualityOfAgedBrieWithAlmostMaximumQualityWithSellInDaysIncreasesToMaximumQuality() {
		givenAnAgedBrie().withQuality(MAXIMUM_QUALITY-1).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}
//    | 'Aged Brie'                                 | -1        | 50      | 50              |
	@Test
	public void updateQualityOfAgedBrieWithMaximumQualityPastSellInDayStillHasMaximumQuality() {
		givenAnAgedBrie().withQuality(MAXIMUM_QUALITY).withSellIn(-1).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}
//    | 'Aged Brie'                                 | -1        | 49      | 50              |
	@Test
	public void updateQualityOfAgedBrieWithAlmostMaximumQualityPastSellInDayIncreasesToMaximumQuality() {
		givenAnAgedBrie().withQuality(MAXIMUM_QUALITY-1).withSellIn(-1).inStock();
		whenUpdateQuality();
		thenTheQualityShouldBe(MAXIMUM_QUALITY);
	}
	
	
// helper methods
	private Builder givenAnOrdinaryItem() {
		builder = new OrdinaryItemBuilder();
		return builder;
	}

	private Builder givenAnAgedBrie() {
		builder = new AgedBrieBuilder();
		return builder;
	}
	
	private Builder givenASulfurasItem() {
		builder = new SulfurasBuilder();
		return builder;
	}
	
	private Builder givenBackstagePass() {
		builder = new BackstagePassBuilder();
		return builder;
	}

	private void whenUpdateQuality() {
		GildedRose app = new GildedRose(builder.getItems());
		app.updateQuality();
		builder.setActual(app.items);
	}

	private void thenTheQualityShouldBe(int expectedQuality) {
		assertEquals(expectedQuality, builder.getActual(0).quality);
	}

	private void thenTheSellInDayShouldBe(int expectedSellIn) {
		assertEquals(expectedSellIn, builder.getActual(0).sellIn);

	}
}

class Builder extends GildedRoseBoundaries {
	Item actualItem = null;
	List<Item> stock = new ArrayList<>();
	List<Item> updateStock = new ArrayList<>();

	protected Builder() {
		// overridden constructor, so that Builder can not be created
	}

	public Builder withQuality(int quality) {
		actualItem.quality = quality;
		return this;
	}

	public Builder withSellIn(int sellIn) {
		actualItem.sellIn = sellIn;
		return this;
	}

	public Item getActual(int index) {
		return updateStock.get(index);
	}

	public void setActual(Item[] items) {
		Stream.of(items).forEach(updateStock::add);

	}

	public void inStock() {
		stock.add(actualItem);
		actualItem = null;
	}

	public Item[] getItems() {
		return stock.stream().toArray(Item[]::new);
	}
}

class OrdinaryItemBuilder extends Builder {
	public OrdinaryItemBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_ORDINARY_ITEM, EXAMPLE_SELLINDAY, EXAMPLE_QUALITY);
		}
	}
}

class AgedBrieBuilder extends Builder {
	public AgedBrieBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_AGED_BRIE, EXAMPLE_SELLINDAY, EXAMPLE_QUALITY);
		}
	}
}

class SulfurasBuilder extends Builder {
	public SulfurasBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_SULFURAS, EXAMPLE_SELLINDAY, EXAMPLE_QUALITY);
		}
	}
}

class BackstagePassBuilder extends Builder {
	public BackstagePassBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_BACKSTAGE_PASS, EXAMPLE_SELLINDAY, EXAMPLE_QUALITY);
		}
	}
}

class ConjuredBuilder extends Builder {
	public ConjuredBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_CONJURED_ITEM, EXAMPLE_SELLINDAY, EXAMPLE_QUALITY);
		}
	}
}
