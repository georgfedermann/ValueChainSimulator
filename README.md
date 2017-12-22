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

### Work
There is work.  
Work has a type. Like match, car, wheel, etc.  
Work has an uuid to distinguish multiple pieces of works of the same type.  
Work gets released to a value chain.  
Work gets processed in work centers within the value chain.  
The smallest amount of work is a unit of work.  
### Work center
Each work center performs a step in creating the product of the value chain.  
A work center is where work gets processed.  
A work center has a name.  
A work center has a capacity.  
### Shelf
A shelf is a place where work in process can be stored when it is not being processed in a work center. For a definition of work in compare "States of work" below.  
### Value chain
A value chain has a name.  
A value chain has a shelf to store released work.  
A value chain has a shelf to store finished work.  
A value chain consists of a series of one|zero (?) or more work centers.  
Before and after each work center, there is a shelf to store work in process.
### Turn strategy
A value chain has a turn strategy.
A turn represents a step in time in which a work center can process work. In a turn a work center will fetch a number of items according to its capacity from its source shelf, process it and hand it over to its destination shelf. This concept does not support procedures yet where a work center might take more than one turn to process work.  
A value chain can be triggered to process a turn. There are two possible strategies how a value chain might process a turn: The value chain's work centers are triggered sequentially, so each work center gets a chance to process work processed by preceding work centers in the same turn. Or the other strategy: all work centers are triggered at the same time, thus each work center can only process work that was processed by the preceding work center in an earlier turn. Thus, a value chain has a strategy to process turns -> a turn strategy.
A work center can be triggered to process a turn. A work center is capable of processing an integer number of work per turn.  
### Work center capacity
A capacity is more or less a strategy that defines how much work a work center can process at a given step.  
It takes each work center a configurable time to perform its tasks.  
Between each two work centers, and at the very beginning of the value chain, and at the very end of the value chain there is one shelf respectively to store work between two work centers.  
### States of work
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



