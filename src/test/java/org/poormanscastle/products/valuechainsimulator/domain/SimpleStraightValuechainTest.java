package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by georg on 15/12/2017.
 */
public class SimpleStraightValuechainTest {

    @Test
    public void addWorkCenterTest() throws Exception {
        Shelf releasedWorkShelf = Shelf.createSimpleStraightShelf(),
                finishedWorkShelf = Shelf.createSimpleStraightShelf();
        Valuechain valuechain = new SimpleStraightValuechain(releasedWorkShelf, finishedWorkShelf);
        Workcenter workcenter1 = Workcenter.getSimpleDiceWorkCenter("Beautify");
        Workcenter workcenter2 = Workcenter.getSimpleDiceWorkCenter("Wrap package");
        Workcenter workcenter3 = Workcenter.getSimpleDiceWorkCenter("Attach price tag");

        assertEquals(0, valuechain.getLength());

        valuechain.addWorkCenter(workcenter1);
        assertNull(valuechain.getReleasedWorkShelf().getPushWorkcenter());
        assertEquals(workcenter1, valuechain.getReleasedWorkShelf().getPullWorkcenter());
        assertEquals(valuechain.getReleasedWorkShelf(), workcenter1.getSourceShelf());
        assertEquals(valuechain.getFinishedWorkShelf(), workcenter1.getDestinationShelf());
        assertEquals(workcenter1, valuechain.getFinishedWorkShelf().getPushWorkcenter());
        assertNull(valuechain.getFinishedWorkShelf().getPullWorkcenter());

        assertEquals(1, valuechain.getLength());

        valuechain.addWorkCenter(workcenter2);
        assertNull(valuechain.getReleasedWorkShelf().getPushWorkcenter());
        assertEquals(workcenter1, valuechain.getReleasedWorkShelf().getPullWorkcenter());
        assertEquals(workcenter2, valuechain.getFinishedWorkShelf().getPushWorkcenter());
        assertEquals(workcenter1, valuechain.getFinishedWorkShelf().getPushWorkcenter().getSourceShelf().getPushWorkcenter());
        assertEquals(workcenter2, valuechain.getReleasedWorkShelf().getPullWorkcenter().getDestinationShelf().getPullWorkcenter());
        assertEquals(finishedWorkShelf, valuechain.getReleasedWorkShelf().getPullWorkcenter().getDestinationShelf().getPullWorkcenter().getDestinationShelf());
        assertEquals(releasedWorkShelf, valuechain.getFinishedWorkShelf().getPushWorkcenter().getSourceShelf().getPushWorkcenter().getSourceShelf());
        assertNull(valuechain.getFinishedWorkShelf().getPullWorkcenter());

        assertEquals(2, valuechain.getLength());

        valuechain.addWorkCenter(workcenter3);
        assertEquals(3, valuechain.getLength());
    }

    @Test
    public void toStringTest() throws Exception {
        Field[] fields = SimpleStraightValuechain.class.getDeclaredFields();
        String toString = new SimpleStraightValuechain(
                Shelf.createSimpleStraightShelf(), Shelf.createSimpleStraightShelf()).toString();
        for (Field field : fields) {
            if ("__cobertura_counters".equals(field.getName())) {
                continue;
            }
            assertTrue(StringUtils.join("toString() is missing field ", field.getName()),
                    toString.contains(field.getName()));
        }
    }

}