package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * This is a simple version of a value chain consisting of one line
 * of work centers.
 * Created by georg on 14/12/2017.
 */
class SimpleStraightValuechain implements Valuechain {

    private final Shelf releasedWork;

    private final Shelf processedWork;

    @Override
    public void addWorkCenter(Workcenter workcenter) {

    }

    public SimpleStraightValuechain(Shelf releasedWork, Shelf processedWork) {
        this.releasedWork = releasedWork;
        this.processedWork = processedWork;
    }
}
