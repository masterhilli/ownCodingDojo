package com.christmas.delivery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhillbrand on 12/13/2015.
 */
public class Sleigh {
    List<Present> presents = new ArrayList<>();


    public void Receive(Present present) {
        presents.add(present);
    }

    public int getPresentCount() {
        return presents.size();
    }
}
