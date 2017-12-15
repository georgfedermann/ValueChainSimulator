package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by georg on 15/12/2017.
 */
public class SimpleStraightWorkcenterTest {

    String workcenterName = "Beautification";

    @Test
    public void nameTest() throws Exception {
        // test that the workcenter's name gets set correctly
        Workcenter workcenter = Workcenter.getSimpleDiceWorkCenter(workcenterName);
        assertEquals(workcenterName, workcenter.getName());
    }

    @Test
    public void capacityTest() throws Exception {
        // test that the workcenter's capacity strategy gets set correctly
        Workcenter workcenter = Workcenter.getSimpleDiceWorkCenter(workcenterName);
        assertTrue(workcenter.getWorkcenterCapacity() instanceof DiceStrategyCapacity);
    }

    @Test
    public void setSourceShelfTest() throws Exception {

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

}