# Project 3: Turing Machine Simulator

* Author: Jayce Lowry and Chase Stombaugh
* Class: CS361 Section 1
* Semester: Spring 2025

---

## Overview

This program simulates deterministic Turing Machines. The simulator 
reads an encoded input file describing the Turing Machine and an input string, 
then models the TM's execution on a bi-infinite tape. The simulator outputs 
the contents of all tape cells visited during the computation.

The Turing Machine follows the standard formal definition with:
* A finite set of states Q
* A tape alphabet Γ including a reserved blank symbol '0'
* An input alphabet Σ = {1, 2, ..., m}, excluding '0'
* A deterministic transition function δ
* A designated start state q₀ = 0
* A halting (accepting) state qₙ = n - 1

The TM processes transitions encoded in the input file and halts once the 
accepting state is reached.

---

## Reflection

### Jayce

Our approach to implementing the Turing Machine mainly just involved identifying the 
components required for the program which are logically distinct enough to write classes for.
We knew that we would need classes to represent the machine itself and its states, so
that's what we started with. One of the most important things a Turing Machine needs to 
do is maintain a tape data structure, so we designed a class for that too. We briefly considered 
combining the tape functionality with other classes, but looking back I think this
would have been a big mistake. Having a separate tape class made writing the algorithm 
for running the machine so much simpler than I'd expected. The same can be said for the
Turing Machine's transitions - we wrote a class containing transition edge information
(read, write, move), which made that data easier to store and retrieve.

For the simulator itself, it just made sense to do the actual file parsing in another class. 
I think this helped to make the main driver class more self-contained, and more clearly
define how it uses the `tm` package. Starting out by writing interfaces for the core pieces
of functionality for the program gave the project a well-defined structure, to the point that
I'm very surprised how similar the initial skeleton/outline for `TMSimulator` ended up being
to the final version. Taking a modular approach also made test-driven development easier because
it gave us smaller units to be able to test. I had hoped we had more time to do additional integration
testing on different input files, but having high confidence that the components of the program
work properly via unit testing (especially the tape) leaves me optimistic that the program 
as a whole works.

### Chase

My main role during this was to do the TMParser class as well as the TMSimulator 
class. However, Jayce got on a roll and ended up doing the TMSimulator class, much
to my surprise. The TMParser class went pretty smoothly, as it was really just figuring 
out the format of the strings. If we hadn't gone over it in lecture, then I think this 
would have been a good bit more challenging. The interface that Jayce had created 
definitely helped with this, as it allowed me to better visualize what was going on 
and needed from the class. One of the tricky parts however was trying to associate 
each line in the transition section with the correct (state, symbol) pair using the 
line number math. 

Then it was also important to pay close attention to the alphabet versus the tape 
symbols. The blank symbol '0' isn't a part of the input alphabet but it is a part 
of the tape alphabet. Then there was the issue of discovering and implementing the 
edge cases. Then it came to integrating it into TMSimulator. I was supposed to do 
this, but as previously stated, Jayce beat me to this part. He really was the carry 
behind this project. I did not get to contribute nearly as much as I wanted this time. 

This project did help me with getting a little more comfortable with parsing structured 
input since that has always been a weakpoint of mine. Handling exceptions hasn't been 
too bad but I think this project helped there as well. Then when being given a more 
open-ended interface, I feel like I performed fairly well compared to how I thought 
I would. I wasn't a fan of how empty the project description felt but Jayce carried 
that once again by going through and creating basically an outline oh what was to be 
needed. 

---

## Included Files
- `TMSimulator.java` - Main driver class for running the simulation.
- `tm/TMParserInterface.java` - Interface for the file parser.
- `tm/TMParser.java` - The file parser implementation.
- `tm/TMInterface.java` - Interface for the Turing Machine.
- `tm/TMTapeInterface.java` - Interface for the Turing Machine's tape.
- `tm/TM.java` - The Turing Machine implementation.
- `tm/TMState.java` - Represents a state in the Turing Machine.
- `tm/TMTape.java` - The Tape implementation.
- `tm/Direction.java` - An enum representing movement directions for the tape's read/write head.
- `README.md` - This file.

---

## Compiling and Using

### Compiling
To compile the `TMSimulator`, navigate to the 
project's root directory and run:

```shell
$ javac TMSimulator.java
```

This will compile the main driver class and all its necessary 
dependencies in the `tm` package.

### Running

To run the Turing Machine simulator on an encoded TM input file, use the command:

```shell
$ java TMSimulator <filename>
```
Where `<filename>` is the name of a text file containing an encoding of a deterministic
Turing Machine.

When the program is finished running, results will be output to the console.

---

## Sources used

https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html - Used for reading input files
Course notes and examples - guidance on TM structure and simulation