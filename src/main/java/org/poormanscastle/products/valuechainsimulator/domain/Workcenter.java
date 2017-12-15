package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * A work center exists within a value chain.
 * A work center performs a given set of tasks on a piece of work passing through the value chain.
 * Created by georg on 14/12/2017.
 */
public interface Workcenter {

    Shelf setSourceShelf(Shelf sourceShelf);

    Shelf setDestinationShelf(Shelf destinationShelf);
    
    static Workcenter getSimpleDiceWorkCenter(String name){
        return new SimpleStraightWorkcenter(name, 
                WorkcenterCapacity.create6SidedDiceStrategyyCapacity());
    }

}
