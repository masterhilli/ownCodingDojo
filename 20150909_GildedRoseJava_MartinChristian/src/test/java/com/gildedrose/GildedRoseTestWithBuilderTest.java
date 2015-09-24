package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class GildedRoseTestWithBuilderTest {
	Builder builder = null;
	
	@Before
	public void setUp() {
		builder = null;
	}
	
	@Test
	public void updateQualityReducesQualityBy1WithinSellInDate () {
		givenAnOrdinaryItem().andWithQuality(10).inStock();
		whenUpdateQuality();
		thenTheQualityIs(9);
	}

	@Test
	public void updateQualityReducesSellInDateBy1() {
		givenAnOrdinaryItem().andWithSellIn(34).inStock();
		whenUpdateQuality();
		thenTheSellInIs(33);
	}	

	private Builder givenAnOrdinaryItem() {
		if (builder == null) {
			builder = new OrdinaryItemBuilder();
		}
		return builder;
	}
	
	private void whenUpdateQuality() {
		GildedRose app = new GildedRose(builder.getItems());
		app.updateQuality();
		builder.setActual(app.items);
	}
	
	private void thenTheQualityIs(int expectedQuality) {
		assertEquals(expectedQuality, builder.getActual(0).quality);
	}
	
	private void thenTheSellInIs(int expectedSellIn) {
		assertEquals(expectedSellIn, builder.getActual(0).sellIn);
		
	}
}

class Builder extends GildedRoseBoundaries {
	Item actualItem = null;
	List<Item> stock = new ArrayList<> ();
	List<Item> updateStock = new ArrayList<> ();
	
	protected Builder () {
		// overridden constructor, so that Builder can not be created
	}
	
	public Builder andWithQuality(int quality) {
		actualItem.quality = quality;
		return this;
	}
	
	public Builder andWithSellIn(int sellIn) {
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
			actualItem = new Item(NAME_ORDINARY_ITEM, EXAMPLE_SELLINDAY , EXAMPLE_QUALITY);
		}
	}
}

class AgedBrieBuilder extends Builder {
	public AgedBrieBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_AGED_BRIE, EXAMPLE_SELLINDAY , EXAMPLE_QUALITY);
		}
	}
}

class SulfurasBuilder extends Builder {
	public SulfurasBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_SULFURAS, EXAMPLE_SELLINDAY , EXAMPLE_QUALITY);
		}
	}
}

class BackstagePassBuilder extends Builder {
	public BackstagePassBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_BACKSTAGE_PASS, EXAMPLE_SELLINDAY , EXAMPLE_QUALITY);
		}
	}
}

class ConjuredBuilder extends Builder {
	public ConjuredBuilder() {
		if (actualItem == null) {
			actualItem = new Item(NAME_CONJURED_ITEM, EXAMPLE_SELLINDAY , EXAMPLE_QUALITY);
		}
	}
}
