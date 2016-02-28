package com.christmas.delivery;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mhillbrand on 12/13/2015.
 */
public class ToyMachineTest {

    @Test
    public void TestGivesPresentToReturnsElfHasPresent() {
        ToyMachine toyMachine = new ToyMachine();
        DeliveryElf deliveryElf = new DeliveryElf(toyMachine);

        toyMachine.GivesPresentTo(deliveryElf);

        assertTrue(deliveryElf.IsHoldingPresent());
    }

}