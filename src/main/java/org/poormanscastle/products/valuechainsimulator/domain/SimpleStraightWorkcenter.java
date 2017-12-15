package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * A simple straight work center pulls work from the source shelf according
 * to its capacity, processes it, and pushes it into the destination shelf.
 * Created by georg on 14/12/2017.
 */
class SimpleStraightWorkcenter implements Workcenter {

    private WorkcenterCapacity workcenterCapacity;

    private String name;

    private Shelf sourceShelf;
    private Shelf destinationShelf;

    public SimpleStraightWorkcenter(String name, WorkcenterCapacity workcenterCapacity) {
        this.name = name;
        this.workcenterCapacity = workcenterCapacity;
    }

    @Override
    public Shelf setSourceShelf(Shelf sourceShelf) {
        this.sourceShelf = sourceShelf;
        sourceShelf.setPullWorkcenter(this);
        return sourceShelf;
    }

    @Override
    public Shelf getSourceShelf() {
        return sourceShelf;
    }

    @Override
    public Shelf getDestinationShelf() {
        return destinationShelf;
    }

    @Override
    public Shelf setDestinationShelf(Shelf destinationShelf) {
        this.destinationShelf = destinationShelf;
        return destinationShelf;
    }

}
