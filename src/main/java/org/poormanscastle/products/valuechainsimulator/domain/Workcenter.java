package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * A work center exists within a value chain.
 * A work center performs a given set of tasks on a piece of work passing through the value chain.
 * Created by georg on 14/12/2017.
 */
public interface Workcenter {

    void setSourceShelf(Shelf sourceShelf);

    void setDestinationShelf(Shelf destinationShelf);

}
