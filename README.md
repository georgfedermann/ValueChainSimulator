# ValueChainSimulator
This is a simulator that helps understand the impact of various KPIs on the throughput of a value chain.

This project is inspired by the match stick game as described in Eliyahu Goldratt's book *The Goal*.
The simulator will start out in a pretty simple fashion to allow early results and gaining of a first understanding.
Later on, the requirements might get refined or extended when a better understanding for the theory of constraints
has been achieved.

A value chain describes the whole process to fabricate a given product within an organisation.

A value chain consists of zero or more work centers. Each of the work centers accepts input from the upstream
work centers, processes it in some specific way and hands the result on to downstream work centers. Clearly, the
first work center will recieve raw material or products delivered by a supplier. The last work center will release
its products to customers or a kind of warehouse.

## System Description

There is work.  
Work gets released to a value chain.  
Work gets processed inside the value chain.  
The smallest amount of work is a unit of work.  
A value chain consists of a series of one|zero or more work centers. 
A work center is where work gets processed.  
It takes each work center a configurable time to perform its tasks.  
Between each two work centers, and at the very beginning of the value chain, and at the very end of the value chain there is one shelf respectively to store work between two work centers.  
While work is in a work center, it is being processed.  
While work is on the shelf, it is waiting.  
While work is in the value chain, it is work in process.  
Work leaving the value chain adds to throughput.  
Work inside the value chain adds to inventory.  

A (simple) model of a value chain as supported by this early version of the simulator might look like this:  
Released Work (Shelf) -> Work Center 1 -> Shelf -> Work Center 2 -> Shelf -> Work Center 3 -> processed work (Shelf)

The simulator does not simulate the interfaces to the supplier at the start of the value chain or to the 
customer at the end of the value chain.

The simulator will only simulate one simple value chain consisting of a linear, non-circular chain of work centers.

The value chain consists of 0 or more work centers. Each work center performs a step in creating the product
of the value chain.


It can be configured if a given work center takes a constant time each time it performs its tasks or whether there
is a random variation in the execution time.

An arbitrary amount of work centers can be added to the value chain.

A configurable amount of work is available at the start of the value chain.

The simulator displays a measure of work in process.

The simulator calculates the current cash flow, capital bound in inventory, revenue through sales, and production cost in form of labour cost. Thus, the price of the raw material and the price of the end product can be configured, as well as the wage / production cost of each work center. It will be interesting to see how quickly the organization behind the value chain will go broke.

## To be implemented later
Instead of a configurable amount of work being available at the start of the value chain, work can be released manually to the value chain => In an attempt to optimize throughput.

The sequence of work centers within the value chain can be altered.

Multiple intersecting value chains can be configured to produce more complex products and simulate more complex value chains.



