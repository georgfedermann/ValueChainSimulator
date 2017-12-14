package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Created by georg on 14/12/2017.
 */
public class SimpleStraightShelfTest {

    String workType = "match sticks";

    @Test
    public void getLoadPushNextTest() throws Exception {
        Shelf patient = new SimpleStraightShelf();
        List<Work> workList = new LinkedList<>();
        for (int c = 0; c < 10; c++) {
            Work work = Work.createWork(workType);
            workList.add(work);
            assertEquals(c, patient.getLoad());
            patient.push(work);
        }
        for (int c = 9; c >= 0; c--) {
            Work work = patient.next();
            assertEquals(c, patient.getLoad());
            assertEquals(workList.get(9 - c).getUuid(), work.getUuid());
        }
    }
}