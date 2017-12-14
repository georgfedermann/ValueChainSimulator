package org.poormanscastle.products.valuechainsimulator.domain;

import java.util.UUID;

/**
 * Created by georg on 14/12/2017.
 */
class SimpleWork implements Work {

    private String type;
    private String uuid;

    public SimpleWork(String type) {
        this.type = type;
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "SimpleWork{" +
                "type='" + type + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
