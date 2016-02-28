package com.christmas.delivery;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mhillbrand on 12/13/2015.
 */
public class SleighTest {

    @Test
    public void TestReceiveReturnsArrayHasOneMore() {
        DeliveryElf deliveryElf = new DeliveryElf(new ToyMachine());
        Sleigh sleigh = new Sleigh();
        deliveryElf.ReceivePresent(new Present());
        deliveryElf.PackPresentOn(sleigh);

        assertEquals(1, sleigh.getPresentCount());
    }

}