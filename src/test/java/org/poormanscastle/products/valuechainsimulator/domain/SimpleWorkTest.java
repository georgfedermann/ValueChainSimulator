package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by georg on 14/12/2017.
 */
public class SimpleWorkTest {
    @Test
    public void getTypeTest() throws Exception {
        String type = "match stick";
        Work probe = Work.createWork(type);
        assertEquals(type, probe.getType());
    }

    @Test
    public void getUuidTest() throws Exception {
        Work probe = Work.createWork("bubble gum");
        assertEquals(36, probe.getUuid().length());
    }

    @Test
    public void toStringTest() throws Exception {
        Field[] fields = SimpleWork.class.getDeclaredFields();
        String toString = Work.createWork("matchbox").toString();
        for (Field field : fields) {
            if ("__cobertura_counters".equals(field.getName())) {
                continue;
            }
            assertTrue(StringUtils.join("toString() is missing field ", field.getName()),
                    toString.contains(field.getName()));
        }
    }

}