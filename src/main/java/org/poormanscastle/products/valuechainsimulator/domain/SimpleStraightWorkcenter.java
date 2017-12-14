package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * A simple straight work center pulls work from the source shelf according
 * to its capacity, processes it, and pushes it into the destination shelf.
 * Created by georg on 14/12/2017.
 */
class SimpleStraightWorkcenter implements Workcenter {
    
    private WorkcenterCapacity workcenterCapacity;
    
    private Shelf sourceShelf;
    private Shelf destinationShelf;

    public SimpleStraightWorkcenter() {
    }

    @Override
    public void setSourceShelf(Shelf sourceShelf) {
        
    }

    @Override
    public void setDestinationShelf(Shelf destinationShelf) {

    }
    
}
