package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by georg on 14/12/2017.
 */
public class SimpleStraightShelfTest {

    String workType = "match sticks";

    @Test
    public void getLoadPushNextTest() throws Exception {
        Shelf probe = Shelf.createSimpleStraightShelf();
        assertNull(probe.next());
        List<Work> workList = new LinkedList<>();
        for (int c = 0; c < 10; c++) {
            Work work = Work.createWork(workType);
            workList.add(work);
            assertEquals(c, probe.getLoad());
            probe.push(work);
        }
        for (int c = 9; c >= 0; c--) {
            Work work = probe.next();
            assertEquals(c, probe.getLoad());
            assertEquals(workList.get(9 - c).getUuid(), work.getUuid());
        }
    }

    @Test
    public void toStringTest() throws Exception {
        Field[] fields = SimpleStraightShelf.class.getDeclaredFields();
        String toString = Shelf.createSimpleStraightShelf().toString();
        for (Field field : fields) {
            if ("__cobertura_counters".equals(field.getName())) {
                continue;
            }
            assertTrue(StringUtils.join("toString() is missing field ", field.getName()), toString.contains(field.getName()));
        }
    }

}