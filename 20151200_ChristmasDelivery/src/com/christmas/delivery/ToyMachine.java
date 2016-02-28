package com.christmas.delivery;

/**
 * Created by mhillbrand on 12/13/2015.
 */
public class ToyMachine {
    DeliveryElf deliveryElf;
    boolean isAvailableToReceive;

    ToyMachine() {
        deliveryElf = new DeliveryElf(this);
        isAvailableToReceive = true;
    }
    public void GivesPresentTo(DeliveryElf elf) {
        if (this.isAvailableToReceive) {
            elf.ReceivePresent(this.Produce());
            this.isAvailableToReceive = false;
        }
    }

    private Present Produce() {
        return new Present();
    }

    protected void AvailableToReceiveAgain() {
        this.isAvailableToReceive = true;
    }

}
