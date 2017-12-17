package org.poormanscastle.products.valuechainsimulator.domain;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * This is a simple version of a value chain consisting of one line
 * of work centers.
 * Created by georg on 14/12/2017.
 */
class SimpleStraightValuechain implements Valuechain {

    private final Shelf releasedWorkShelf;

    private final Shelf finishedWorkShelf;

    @Override
    public Shelf getReleasedWorkShelf() {
        return releasedWorkShelf;
    }

    @Override
    public Shelf getFinishedWorkShelf() {
        return finishedWorkShelf;
    }

    @Override
    public void addWorkCenter(Workcenter workcenter) {
        checkNotNull(releasedWorkShelf);
        checkNotNull(finishedWorkShelf);
        checkState(releasedWorkShelf.getPushWorkcenter() == null);
        checkState(finishedWorkShelf.getPullWorkcenter() == null);
        checkNotNull(workcenter);
        if (releasedWorkShelf.getPullWorkcenter() == null) {
            checkState(finishedWorkShelf.getPushWorkcenter() == null);
            finishedWorkShelf.setPushWorkcenter(workcenter);
            workcenter.setSourceShelf(releasedWorkShelf);
        } else {
            checkNotNull(finishedWorkShelf.getPushWorkcenter());
            Workcenter oldPushWorkcenter = finishedWorkShelf.getPushWorkcenter();
            Shelf newBufferShelf = Shelf.createSimpleStraightShelf();
            newBufferShelf.setPushWorkcenter(oldPushWorkcenter);
            workcenter.setSourceShelf(newBufferShelf);
            finishedWorkShelf.setPushWorkcenter(workcenter);
        }
    }

    public SimpleStraightValuechain(Shelf releasedWorkShelf, Shelf finishedWorkShelf) {
        checkNotNull(releasedWorkShelf);
        checkNotNull(finishedWorkShelf);
        this.releasedWorkShelf = releasedWorkShelf;
        this.finishedWorkShelf = finishedWorkShelf;
    }

    @Override
    public int getLength() {
        if (releasedWorkShelf.getPullWorkcenter() == null) {
            checkState(finishedWorkShelf.getPushWorkcenter() == null);
            return 0;
        } else {
            checkNotNull(finishedWorkShelf.getPushWorkcenter());
            int length = 0;
            Shelf shelf = releasedWorkShelf;
            while (shelf != finishedWorkShelf) {
                shelf = shelf.getPullWorkcenter().getDestinationShelf();
                length++;
            }
            return length;
        }
    }

    @Override
    public String toString() {
        return "SimpleStraightValuechain{" +
                "releasedWorkShelf=" + releasedWorkShelf +
                ", finishedWorkShelf=" + finishedWorkShelf +
                '}';
    }

}
