package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * A work center has a capacity.
 * A capacity is more or less a strategy that defines how much work a work
 * center can process at a given step.
 * Created by georg on 14/12/2017.
 */
public interface WorkcenterCapacity {
    
    int getCurrentCapacity();
    
    static WorkcenterCapacity create6SidedDiceStrategyyCapacity(){
        return new DiceStrategyCapacity(6);
    }
    
}
