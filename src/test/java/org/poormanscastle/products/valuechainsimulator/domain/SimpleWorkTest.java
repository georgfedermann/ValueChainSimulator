package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertEquals;

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
    
}