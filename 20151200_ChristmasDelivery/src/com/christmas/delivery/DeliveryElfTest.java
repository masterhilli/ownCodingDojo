package com.christmas.delivery;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mhillbrand on 12/13/2015.
 */
public class DeliveryElfTest {
    private DeliveryElf deliveryElf;
    private ToyMachine toyMachine;
    private Present[] presents = {new Present(), new Present()};
    @Before
    public void SetUp () {
        toyMachine = new ToyMachine();
        deliveryElf = new DeliveryElf(toyMachine);
    }

    @Test
    public void TestElfReceivingOnePresent() {

        deliveryElf.ReceivePresent(presents[0]);

        assertEquals(presents[0], deliveryElf.GetPresent());
    }

    @Test
    public void TestElfReceivingTwoPresentsReturnsStillFirstPresentHolding() {
        deliveryElf.ReceivePresent(presents[0]);
        deliveryElf.ReceivePresent(presents[1]);

        assertEquals(presents[0], deliveryElf.GetPresent());
    }

    @Test
    public void TestElfReceivesAPresentAndPutsItOnSleightReturnsElfHasNoPresent() {
        deliveryElf.ReceivePresent(presents[0]);
        deliveryElf.PackPresentOn(new Sleigh());

        assertEquals(null, deliveryElf.GetPresent());
    }

    @Test
    public void TestIsElfHoldingPresentReturnsTrue() {
        deliveryElf.ReceivePresent(presents[0]);

        assertTrue(deliveryElf.IsHoldingPresent());
    }


    @Test
    public void TestIsElfHoldingPresentReturnsFalse() {
        assertFalse(deliveryElf.IsHoldingPresent());
    }

}