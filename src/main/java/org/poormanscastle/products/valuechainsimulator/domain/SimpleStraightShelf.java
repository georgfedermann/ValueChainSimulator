package org.poormanscastle.products.valuechainsimulator.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by georg on 14/12/2017.
 */
public class SimpleStraightShelf implements Shelf {

    private final List<Work> waitingWork = new LinkedList<>();

    /**
     * the workcenter which pushes work to this shelf.
     */
    private Workcenter pushWorkcenter;

    /**
     * the workcenter which pulls work from this shelf.
     */
    private Workcenter pullWorkcenter;

    @Override
    public int getLoad() {
        return waitingWork.size();
    }

    /**
     * implements the FIFO algorithm.
     *
     * @return a piece of work if there is any, null otherwise.
     */
    @Override
    public Work next() {
        if (waitingWork.size() > 0) {
            return waitingWork.remove(0);
        } else {
            return null;
        }
    }

    @Override
    public void push(Work work) {
        waitingWork.add(work);
    }

    @Override
    public Workcenter setPushWorkcenter(Workcenter workcenter) {
        this.pushWorkcenter = workcenter;
        workcenter.setDestinationShelf(this);
        return workcenter;
    }

    @Override
    public Workcenter setPullWorkcenter(Workcenter workcenter) {
        this.pullWorkcenter = workcenter;
        return workcenter;
    }

    @Override
    public Workcenter getPushWorkcenter() {
        return pushWorkcenter;
    }

    @Override
    public Workcenter getPullWorkcenter() {
        return pullWorkcenter;
    }
}
