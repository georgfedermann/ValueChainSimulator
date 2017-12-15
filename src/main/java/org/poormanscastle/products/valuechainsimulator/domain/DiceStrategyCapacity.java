package org.poormanscastle.products.valuechainsimulator.domain;

import java.util.concurrent.ThreadLocalRandom;

/**
 * this Workcenter capacity implementation simulates the throw of an n sided die
 * to generate a workload the respective work center is capable of processing on
 * a given turn.
 * Created by georg on 14/12/2017.
 */
class DiceStrategyCapacity implements WorkcenterCapacity {

    /**
     * what is the number of faces of the die which this capacity
     * shall use to generate a capacity value.
     */
    private final int numberOfFaces;

    DiceStrategyCapacity(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    @Override
    public int getCurrentCapacity() {
        return ThreadLocalRandom.current().nextInt(1, numberOfFaces + 1);
    }

    @Override
    public String toString() {
        return "DiceStrategyCapacity{" +
                "numberOfFaces=" + numberOfFaces +
                '}';
    }
    
}
