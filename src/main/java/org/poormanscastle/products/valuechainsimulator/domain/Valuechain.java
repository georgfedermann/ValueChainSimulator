package org.poormanscastle.products.valuechainsimulator.domain;

/**
 * Work gets released to a value chain.
 * Work gets processed inside the value chain.
 * A value chain consists of several work centers where work gets processed,
 * Between each two work centers, and at the very beginning of the value chain, and at the very end of the value chain there is one shelf respectively to store work between two work centers.
 * While work is in a work center, it is being processed.
 * While work is on the shelf, it is waiting.
 * While work is in the value chain, it is work in process.
 * Work leaving the value chain adds to throughput.
 * Created by georg on 13/12/2017.
 */
public interface Valuechain {
    
    void addWorkCenter(Workcenter workcenter);
    
    public static Valuechain createSimpleStraightValueChain(int numberOfWorkcenters){
        return null;
    }
    
}
