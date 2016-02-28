package com.christmas.delivery;

/**
 * Created by mhillbrand on 12/13/2015.
 */
public class DeliveryElf {

    protected Present present;
    private ToyMachine toyMachine;

    public DeliveryElf(ToyMachine toyMachine) {
        this.toyMachine = toyMachine;
    }

    public void ReceivePresent(Present present) {
        if (this.present == null)
            this.present = present;
    }

    public final Present GetPresent() {return this.present;}

    public void PackPresentOn(Sleigh sleigh) {
        sleigh.Receive(this.present);
        this.present = null;
        toyMachine.AvailableToReceiveAgain();

    }

    public boolean IsHoldingPresent() {
        return present != null;
    }



}
