package org.poormanscastle.products.valuechainsimulator.domain;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by georg on 14/12/2017.
 */
public class DiceStrategyCapacityTest {

    Logger logger = Logger.getLogger(DiceStrategyCapacity.class);

    @Test
    public void getCurrentCapacity() throws Exception {
        WorkcenterCapacity probe = WorkcenterCapacity.create6SidedDiceStrategyyCapacity();
        assertTrue(probe instanceof DiceStrategyCapacity);
        boolean[] bucket = new boolean[6];
        int counter = 0;
        while (!(bucket[0] && bucket[1] && bucket[2] && bucket[3] && bucket[4] && bucket[5])) {
            int capacity = probe.getCurrentCapacity();
            bucket[capacity - 1] = true; // this checks whether 1 <= capacity <= 5 :-)
            assertTrue(1 <= capacity && capacity <= 6);
            if (counter++ > 1000) {
                String errMsg = StringUtils.join("In 1000 throws not all numbers between 1 and 6 were hit by a 6 sided dice!: 1: ",
                        bucket[0], "; 2: ", bucket[1], "; 3: ", bucket[2], "; 4: ", bucket[3],
                        "; 5: ", bucket[4], "; 6: ", bucket[5], " - curious!");
                throw new RuntimeException(errMsg);
            }
        }
        logger.info(StringUtils.join("All buckets were filled after ", counter, " throws of the dice."));

    }

    @Test
    public void toStringTest() throws Exception {
        Field[] fields = DiceStrategyCapacity.class.getDeclaredFields();
        String toString = WorkcenterCapacity.create6SidedDiceStrategyyCapacity().toString();
        for (Field field : fields) {
            if ("__cobertura_counters".equals(field.getName())) {
                continue;
            }
            assertTrue(StringUtils.join("toString() is missing field ", field.getName()),
                    toString.contains(field.getName()));
        }
    }

}