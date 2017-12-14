package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * Work gets released to a value chain.
 * Work gets processed inside the value chain.
 * Created by georg on 14/12/2017.
 */
public interface Work {

    String getType();

    String getUuid();

    static Work createWork(String type) {
        return new SimpleWork(type);
    }

}
