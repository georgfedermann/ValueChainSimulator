package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Created by georg on 15/12/2017.
 */
public class SimpleStraightWorkcenterTest {
    @Test
    public void setSourceShelf() throws Exception {

        // Released work shelf => Beautify work center => Finished work shelf

        Workcenter workcenter = Workcenter.getSimpleDiceWorkCenter("Beautify");
        Shelf releasedWorkShelf = Shelf.getSimpleStraightShelf();
        Shelf finishedWorkShelf = Shelf.getSimpleStraightShelf();

        finishedWorkShelf.setPushWorkcenter(workcenter);
        workcenter.setSourceShelf(releasedWorkShelf);

        assertNull(finishedWorkShelf.getPullWorkcenter());
        assertEquals(workcenter, finishedWorkShelf.getPushWorkcenter());
        assertEquals(finishedWorkShelf, workcenter.getDestinationShelf());
        assertEquals(releasedWorkShelf, workcenter.getSourceShelf());
        assertEquals(workcenter, releasedWorkShelf.getPullWorkcenter());
        assertNull(releasedWorkShelf.getPushWorkcenter());
    }

    @Test
    public void setDestinationShelf() throws Exception {

    }

}