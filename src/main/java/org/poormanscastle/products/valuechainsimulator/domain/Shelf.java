package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * A shelf stores inventory between two work centers or at the end or at the
 * beginning of the value chain.
 * Created by georg on 14/12/2017.
 */
public interface Shelf {

    /**
     * how much work items are waiting on this shelf.
     *
     * @return integer number of work items waiting on this shelf.
     */
    int getLoad();

    /**
     * remove the next waiting work item from the shelf and hand it over
     * to the caller. The shelf itself decides the strategy how to pick
     * the next work item for now. LIFO, FIFO. No priority strategy is being
     * implemented for now.
     *
     * @return the next Work item waiting on this shelf.
     */
    Work next();

    void push(Work work);

    public static Shelf getSimpleStraightShelf() {
        return new SimpleStraightShelf();
    }

}
